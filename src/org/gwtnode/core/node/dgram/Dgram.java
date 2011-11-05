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
package org.gwtnode.core.node.dgram;

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.JavaScriptFunctionWrapper;
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeModule;
import org.gwtnode.core.node.Global;
import org.gwtnode.core.node.NodeJsModule;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.6/api/dgram.html">dgram</a>
 * module.
 * 
 * @author Chad Retz
 */
@GwtNodeModule
public class Dgram extends JavaScriptObject implements NodeJsModule {

    private static Dgram instance;
    
    public static Dgram get() {
        if (instance == null) {
            instance = Global.get().require("dgram");
        }
        return instance;
    }
    
    protected Dgram() {
    }

    @GwtNodeFunction
    public final native Socket createSocket(String type) /*-{
        return this.createSocket(type);
    }-*/;
    
    @GwtNodeFunction
    public final Socket createSocket(String type, MessageEventHandler callback) {
        return createSocket(type, callback.getNativeFunction());
    }
    
    @GwtNodeFunction
    public final Socket createSocket(String type, JavaScriptFunctionWrapper callback) {
        return createSocket(type, callback.getNativeFunction());
    }
    
    @GwtNodeFunction
    public final native Socket createSocket(String type, JavaScriptFunction callback) /*-{
        return this.createSocket(type, callback);
    }-*/;
}
