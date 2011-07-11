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

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.0/api/net.html">net</a>
 * module.
 * 
 * @author Chad Retz
 */
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

    public final Server createServer(boolean allowHalfOpen,
            StreamEventHandler connectionListener) {
        return createServer(allowHalfOpen, connectionListener.getNativeFunction());
    }
    
    public final Server createServer(boolean allowHalfOpen,
            JavaScriptFunctionWrapper connectionListener) {
        return createServer(allowHalfOpen, connectionListener.getNativeFunction());
    }

    public final native Server createServer(boolean allowHalfOpen,
            JavaScriptFunction connectionListener) /*-{
        return this.createServer(allowHalfOpen, connectionListener);
    }-*/;
    
    public final native Socket createConnection(int port) /*-{
        return this.createConnection(port);
    }-*/;
    
    public final native Socket createConnection(int port, String host) /*-{
        return this.createConnection(port, host);
    }-*/;

    public final native Socket createConnection(String path) /*-{
        return this.createConnection(path);
    }-*/;
    
    //TODO: callback versions please of createConnection

    public final native int isIP(String input) /*-{
        return this.isIP(input);
    }-*/;
    
    public final native boolean isIPv4(String input) /*-{
        return this.isIPv4(input);
    }-*/;
    
    public final native boolean isIPv6(String input) /*-{
        return this.isIPv6(input);
    }-*/;
}
