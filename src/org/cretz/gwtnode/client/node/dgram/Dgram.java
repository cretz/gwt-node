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
package org.cretz.gwtnode.client.node.dgram;

import org.cretz.gwtnode.client.JavaScriptFunction;
import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;
import org.cretz.gwtnode.client.node.Global;
import org.cretz.gwtnode.client.node.NodeJsModule;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.2.6/api.html#dgram-267">dgram</a>
 * module.
 * 
 * @author Chad Retz
 */
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
    
    public final native Socket createSocket(String type) /*-{
        return this.createSocket(type);
    }-*/;
    
    public final Socket createSocket(String type, MessageEventHandler callback) {
        return createSocket(type, callback.getNativeFunction());
    }
    
    public final Socket createSocket(String type, JavaScriptFunctionWrapper callback) {
        return createSocket(type, callback.getNativeFunction());
    }
    
    public final native Socket createSocket(String type, JavaScriptFunction callback) /*-{
        return this.createSocket(type, callback);
    }-*/;
}
