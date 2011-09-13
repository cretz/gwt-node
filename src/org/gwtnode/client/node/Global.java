/*
 * Copyright 2011 Chad Retz
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.gwtnode.client.node;

import org.gwtnode.client.node.process.Process;
import org.gwtnode.client.node.stdio.Console;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.6/api/globals.html">global</a>
 * namespace.
 * 
 * @author Chad Retz
 */
public class Global extends JavaScriptObject {
    
    public static final native Global get() /*-{
        return global;
    }-*/;

    protected Global() {
    }
    
    public final Process process() {
        return Process.get();
    }
    
    public final Console console() {
        return Console.get();
    }
    
    public final native <T extends JavaScriptObject & NodeJsModule> T require(String name) /*-{
        return require(name);
    }-*/;
    
    public final native String requireResolve(String name) /*-{
        return require.resolve(name);
    }-*/;
    
    public final native <T extends JavaScriptObject> T requireCache() /*-{
        return require.cache;
    }-*/;
    
    /**
     * @return
     * @deprecated See <a href="https://github.com/joyent/node/issues/1348">this</a>
     */
    @Deprecated
    public final native JsArrayString requirePaths() /*-{
        return require.paths;
    }-*/;
    
    public final native String filename() /*-{
        return __filename;
    }-*/;
    
    public final native String dirname() /*-{
        return __dirname;
    }-*/;
    
    public final native <T extends JavaScriptObject & NodeJsModule> T module() /*-{
        return module;
    }-*/;
    
    public final native JavaScriptObject exports() /*-{
        return exports;
    }-*/;
}
