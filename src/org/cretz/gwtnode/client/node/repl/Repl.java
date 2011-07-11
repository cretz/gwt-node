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
package org.cretz.gwtnode.client.node.repl;

import org.cretz.gwtnode.client.node.Global;
import org.cretz.gwtnode.client.node.NodeJsModule;
import org.cretz.gwtnode.client.node.stream.ReadableStream;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.0/api/repl.html">repl</a>
 * module.
 *
 * @author Chad Retz
 */
public class Repl extends JavaScriptObject implements NodeJsModule {

    private static Repl instance;
    
    public static Repl get() {
        if (instance == null) {
            instance = Global.get().require("repl");
        }
        return instance;
    }
    
    protected Repl() {
    }
    
    public final native ReplServer start() /*-{
        return this.start();
    }-*/;
    
    public final native ReplServer start(String prompt) /*-{
        return this.start(prompt);
    }-*/;
    
    public final native ReplServer start(String prompt, ReadableStream stream) /*-{
        return this.start(prompt, stream);
    }-*/;
}
