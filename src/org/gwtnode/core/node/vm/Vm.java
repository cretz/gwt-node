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
package org.gwtnode.core.node.vm;

import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeModule;
import org.gwtnode.core.node.Global;
import org.gwtnode.core.node.NodeJsModule;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.6/api/vm.html">vm</a>
 * module.
 * 
 * @author Chad Retz
 */
@GwtNodeModule
public class Vm extends JavaScriptObject implements NodeJsModule {

    private static Vm instance;
    
    public static Vm get() {
        if (instance == null) {
            instance = Global.get().require("vm");
        }
        return instance;
    }
    
    protected Vm() {
    }

    @GwtNodeFunction
    public final native <T extends JavaScriptObject> T runInThisContext(String code) /*-{
        return this.runInThisContext(code);
    }-*/;

    @GwtNodeFunction
    public final native <T extends JavaScriptObject> T runInThisContext(String code, 
            String filename) /*-{
        return this.runInThisContext(code, filename);
    }-*/;

    @GwtNodeFunction
    public final native <T extends JavaScriptObject> T runInNewContext(String code) /*-{
        return this.runInNewContext(code);
    }-*/;

    @GwtNodeFunction
    public final native <T extends JavaScriptObject> T runInNewContext(String code, 
            JavaScriptObject sandbox) /*-{
        return this.runInNewContext(code, sandbox);
    }-*/;

    @GwtNodeFunction
    public final native <T extends JavaScriptObject> T runInNewContext(String code, 
            JavaScriptObject sandbox, String filename) /*-{
        return this.runInNewContext(code, sandbox, filename);
    }-*/;

    @GwtNodeFunction
    public final native <T extends JavaScriptObject> T runInContext(String code,
            Context context) /*-{
        return this.runInContext(code, context);
    }-*/;

    @GwtNodeFunction
    public final native <T extends JavaScriptObject> T runInContext(String code,
            Context context, String filename) /*-{
        return this.runInContext(code, context, filename);
    }-*/;

    @GwtNodeFunction
    public final native Context createContext() /*-{
        return this.createContext();
    }-*/;

    @GwtNodeFunction
    public final native Context createContext(JavaScriptObject initSandbox) /*-{
        return this.createContext(initSandbox);
    }-*/;

    @GwtNodeFunction
    public static native Script createScript(String code) /*-{
        return this.createScript(code);
    }-*/;

    @GwtNodeFunction
    public static native Script createScript(String code, String filename) /*-{
        return this.createScript(code, filename);
    }-*/;
}
