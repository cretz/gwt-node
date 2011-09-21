# gwt-node

Complete node.js implementation in GWT. This implementation is targeted at node.js v0.5.6
and GWT 2.4.0. Both of these versions are the latest stable versions at the time of this
writing.
  
Although the API covers all node.js modules, it has not been extensively tested yet. It is
very likely that errors exist all throughout the implementation. Please do not consider
any of this complete until the first release is made.

### Features

 - Supports GWT [JRE emulation]
 - Custom linker to limit GWT bloat
 - Simple bootstrap to easily create applications
 - Does not require browser (or browser emulation)
 - Type safe callbacks and event handling
 
### Planned Features

 - Proper JUnit emulation (will come w/ OOPHM debugger)
 - Complete test cases
 - Larger JRE emulation (i.e. java.io and java.net)
 - Better GIN support
 - Test [gwt-exporter] to see if it's possible to easily expose Java-based modules
 - OOPHM debugger support
 - Script inclusion inside module XML
 
### Limitations

 - Most of the API is still untested
 - No direct Java debugging (yet)

# Getting Started

Below explains how to build a simple "Hello World" application with gwt-node.

## Building gwt-node

In order to build gwt-node, simply run `ant build` in the main directory. This will build
a JAR file named gwt-node.jar in the build/ folder. To see the documentation, run
`ant build-docs`. This will place the javadoc in the build/docs/api folder.

## Creating Hello World

### Module XML

The first thing every gwt-node project needs (just like every GWT project) is a
[Module XML] file. It needs to inherit the `org.gwtnode.Core` module. Also,
the main entry point needs to be defined. So, assuming we choose to use the package
`examples` for our module, and `examples.helloworld` for our code, the examples/HelloWorld.gwt.xml 
file within may look like this:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<module rename-to="HelloWorld">
    <inherits name="org.gwtnode.Core" />
    <entry-point class="examples.helloworld.HelloWorld" />
    <source path="helloworld" />
</module>
```
    
All features of [Module XML] files are supported with the exception of CSS and
script inclusion.
    
### Entry Point Class

Now that the Module XML file is present, the entry point must be created. Extending 
from the `org.gwtnode.core.GwtNodeBootstrap` class in your entry point will
make command line arguments available to you and give you the ability to provide an
exit code. Using the GwtNodeBootstrap is not required, but recommended. So the simple 
HelloWorld.java class in the `examples.helloworld` package will look like:

```java
public class HelloWorld extends GwtNodeBootstrap {
    @Override
    public Integer main(String... args) {
        Process.get().stdout().write("Hello world\n");
        return 0;
    }
}
```
    
## Compiling Hello World

The compiler present with gwt-node is essentially just a wrapper around the
[GWT Compiler]. The usage (following the java invocation and classpath) is as follows:

>  `org.gwtnode.dev.Compiler [supported GWT compiler args] [-out dir] module[s]`

The [GWT Compiler Options] that are not supported are -gen, -localWorkers, -war, -deploy, 
and -extra. The -out option is the directory in which to output the compilation result. The
compilation result is usually just one JavaScript file if you are compiling an individual
module. However, if you compile multiple modules in this step, or use public assets in your
module definition, this can include more files.

### Putting It Together

Now we can compile our Hello World application. Below is a sample ANT target that will compile 
it and place it in the build folder. This assumes gwt-node.jar, gwt-user.jar, and gwt-dev.jar
are in the lib folder. It also assumes the source is in the src folder.

```xml
<target name="compile">
    <!-- remove existing -->
    <delete dir="build" /> 
    <mkdir dir="build" />
    <!-- compile -->
    <java classname="org.gwtnode.dev.Compiler" fork="true">
        <arg value="-out" />
        <arg value="build" />
        <arg value="examples.HelloWorld" />
        <classpath>
            <fileset dir="lib" includes="*.jar" />
            <pathelement path="src" />
        </classpath>
    </java>
</target>
```
    
Note that this also sets the GWT compiler style to PRETTY. This makes the code easier to read
during debugging. Now that this is complete, you can run the application by typing
`node build/HelloWorld.js`.

# Other Stuff

## The Custom Linker and GWT Core

By default, GWT uses a linker that loads the script via an iframe in a browser (a.k.a. "std").
Since we want to avoid using a browser, a custom linker has been made that will ignore browser
components. This linker is the default linker used in the Core module (known as "node").
 
Also, since we don't have a browser, we cannot inherit `com.google.gwt.user.User` like most
GWT modules do. Therefore we inherit only from `com.google.gwt.core.Core` by default. This
means many GWT features cannot be used since they need something more than the core. Read 
the next section on how to use these features.

## Using [jsdom] and [node-htmlparser]

### Module XML

After installing [jsdom] and [node-htmlparser] (I recommend [npm]), you can now use several
GWT features. There are some settings you will need in your module in order for this to work. 
At the top of your module, along with the `org.gwtnode.Core` inherits, add an 
inherits for `com.google.gwt.user.User`. 

In order to use this, we need to use the single script linker. The default iframe linker (or 
even the cross site linker) does not work with jsdom. The single script linker only allows one
permutation. GWT will perform one permutation per browser it believes it is compiling for. So
tell the module only one user agent with `<set-property name="user.agent" value="safari" />`. 
Finally, add this to the module XML to use the single script linker: `<add-linker name="sso" />`.

### Compiling

Assuming your module is HelloWorld, GWT will compile this and produce two files: clear.cache.gif
and HelloWorld.nocache.js. In order to initialize what looks like a browser, the following JS
needs to be at the top of your JS file:

```js
require('htmlparser');
document = require('jsdom').jsdom();
window = document.createWindow();
document.location = window.location;
navigator = { 'userAgent' : 'jsdom' };
```
    
If you are using ANT, the following will add this for you (and remove the unnecessary files):

```xml
<loadresource property="old.js">
    <file file="build/HelloWorld.nocache.js" />
</loadresource>
<echo file="build/HelloWorld.js"><![CDATA[
    require('htmlparser');
    document = require('jsdom').jsdom();
    window = document.createWindow();
    document.location = window.location;
    navigator = { 'userAgent' : 'jsdom' };]]>
</echo>
<echo message="${line.separator}${old.js}" append="true" file="build/HelloWorld.js" />
<delete file="build/HelloWorld.nocache.js" />
<delete file="build/clear.cache.gif" />
```

### Modules

Here is a rundown of modules whether they are known to work with gwt-node+jsnode+htmlparser:

 - HTTP - Not working. There is a same-origin-policy issue with jsdom here.
 - I18N - Working. This provides date and number formatting
 - Inject - Not working. This is the [gin] module and it is being looked into.
 - Jsonp - Not working. GWT appears to be appending this to the 'head' element in another
   window and jsdom doesn't seem to provide a default 'head' element.
 - Logging - Not working. Just not dumping to the console for some reason.
 - User - Working. Most features such as the DOM features are working. Not completely tested.
 - XML - Not working. No browser-based XML implementation in jsdom (i.e. DOMParser)
 
Many of these modules will function properly with just a little work. There are several
[node.js modules] that can be used in conjunction with either emulation or deferred binding
techniques to make this possible. Stay tuned.

## Creating Module Wrappers

Creating wrappers for other modules is very easy to do. Simply create a class that extends
[JavaScriptObject] and implements [NodeJsModule]. Then you can use [JSNI] to talk JS directly.
Take a look at the other modules that are already implemented (e.g. [Http]) to get an idea.

## Examples

There are a few examples to demonstrate a few basic ideas in gwt-node:

 - [features] - Project using [jsdom] and [node-htmlparser] that demonstrates some features
   of the native GWT modules. This is intended to show what does and doesn't work.
 - [hello-world] - Basic hello world showing a simple gwt-node setup.
 - [http-server] - Very simple HTTP server that serves anything out of its
   own directory.
 - [oophm-proxy] - Simple logging proxy to sniff GWT OOPHM traffic
 - [scimark] - Simple port of [SciMark 2.0]
 
  [JRE emulation]: http://code.google.com/webtoolkit/doc/latest/RefJreEmulation.html
  [Module XML]: http://code.google.com/webtoolkit/doc/latest/DevGuideOrganizingProjects.html#DevGuideModuleXml
  [GWT Compiler]: http://code.google.com/webtoolkit/doc/latest/DevGuideCompilingAndDebugging.html#DevGuideJavaToJavaScriptCompiler
  [GWT Compiler Options]: http://code.google.com/webtoolkit/doc/latest/DevGuideCompilingAndDebugging.html#DevGuideCompilerOptions
  [jsdom]: https://github.com/tmpvar/jsdom
  [node-htmlparser]: https://github.com/tautologistics/node-htmlparser
  [npm]: http://npmjs.org/
  [gin]: http://code.google.com/p/google-gin/
  [node.js modules]: https://github.com/ry/node/wiki/modules
  [JavaScriptObject]: http://google-web-toolkit.googlecode.com/svn/javadoc/2.1/com/google/gwt/core/client/JavaScriptObject.html
  [NodeJsModule]: https://github.com/cretz/gwt-node/blob/master/src/org/gwtnode/core/node/NodeJsModule.java
  [JSNI]: http://code.google.com/webtoolkit/doc/latest/DevGuideCodingBasicsJSNI.html
  [gwt-exporter]: http://code.google.com/p/gwt-exporter/
  [Http]: https://github.com/cretz/gwt-node/blob/master/src/org/gwtnode/core/node/http/Http.java
  [hello-world]: https://github.com/cretz/gwt-node/tree/master/examples/hello-world
  [http-server]: https://github.com/cretz/gwt-node/tree/master/examples/http-server
  [features]: https://github.com/cretz/gwt-node/tree/master/examples/features
  [oophm-proxy]: https://github.com/cretz/gwt-node/tree/master/examples/oophm-proxy
  [scimark]: https://github.com/cretz/gwt-node/tree/master/examples/scimark
  [SciMark 2.0]: http://math.nist.gov/scimark2/