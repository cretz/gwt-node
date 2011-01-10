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
package org.cretz.gwtnode.client.node.net;

import org.cretz.gwtnode.client.JavaScriptFunction;
import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;
import org.cretz.gwtnode.client.node.Global;
import org.cretz.gwtnode.client.node.NodeJsModule;

import com.google.gwt.core.client.JavaScriptObject;

public class Net extends JavaScriptObject implements NodeJsModule {

    private static Net instance;
    
    public static Net get() {
        if (instance == null) {
            instance = Global.get().require("net");
        }
        return instance;
    }
    
    protected Net() {
    }
    
    public final Server createServer(StreamEventHandler connectionListener) {
        return createServer(connectionListener.getNativeFunction());
    }
    
    public final Server createServer(JavaScriptFunctionWrapper connectionListener) {
        return createServer(connectionListener.getNativeFunction());
    }
    
    public final native Server createServer(JavaScriptFunction connectionListener) /*-{
        return this.createServer(connectionListener);
    }-*/;
    
    public final native Stream createConnection(int port) /*-{
        return this.createConnection(port);
    }-*/;
    
    public final native Stream createConnection(int port, String host) /*-{
        return this.createConnection(port, host);
    }-*/;
}
