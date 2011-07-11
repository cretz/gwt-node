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
package org.cretz.gwtnode.client.node.childprocess;

import org.cretz.gwtnode.client.JavaScriptFunction;
import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;
import org.cretz.gwtnode.client.node.Global;
import org.cretz.gwtnode.client.node.NodeJsModule;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.0/api/child_processes.html">Child Process</a>
 * module.
 * 
 * @author Chad Retz
 */
public class ChildProcess extends JavaScriptObject implements NodeJsModule {

    private static ChildProcess instance;
    
    public static ChildProcess get() {
        if (instance == null) {
            instance = Global.get().require("child_process");
        }
        return instance;
    }
    
    protected ChildProcess() {
    }

    public final native Child spawn(String command) /*-{
        return this.spawn(command);
    }-*/;

    public final native Child spawn(String command, JsArrayString args) /*-{
        return this.spawn(command, args);
    }-*/;

    public final native Child spawn(String command, JsArrayString args, ChildSpawnOptions options) /*-{
        return this.spawn(command, args, options);
    }-*/;
    
    public final Child exec(String command, JavaScriptFunctionWrapper callback) {
        return exec(command, callback.getNativeFunction());
    }
    
    public final Child exec(String command, ExecEventHandler callback) {
        return exec(command, callback.getNativeFunction());
    }
    
    public final native Child exec(String command, JavaScriptFunction callback) /*-{
        this.exec(command, callback);
    }-*/;
    
    public final Child exec(String command, ChildExecOptions options, 
            JavaScriptFunctionWrapper callback) {
        return exec(command, options, callback.getNativeFunction());
    }
    
    public final Child exec(String command, ChildExecOptions options, ExecEventHandler callback) {
        return exec(command, options, callback.getNativeFunction());
    }
    
    public final native Child exec(String command, ChildExecOptions options, 
            JavaScriptFunction callback) /*-{
        this.exec(command, options, callback);
    }-*/;
    
    //TODO: fork
}
