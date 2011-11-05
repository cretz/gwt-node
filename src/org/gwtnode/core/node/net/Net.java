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
package org.gwtnode.core.node.net;

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.JavaScriptFunctionWrapper;
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeModule;
import org.gwtnode.core.node.Global;
import org.gwtnode.core.node.NodeJsModule;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.6/api/net.html">net</a>
 * module.
 * 
 * @author Chad Retz
 */
@GwtNodeModule
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
    
    @GwtNodeFunction
    public final Server createServer(StreamEventHandler connectionListener) {
        return createServer(connectionListener.getNativeFunction());
    }

    @GwtNodeFunction
    public final Server createServer(JavaScriptFunctionWrapper connectionListener) {
        return createServer(connectionListener.getNativeFunction());
    }

    @GwtNodeFunction
    public final native Server createServer(JavaScriptFunction connectionListener) /*-{
        return this.createServer(connectionListener);
    }-*/;

    @GwtNodeFunction
    public final Server createServer(boolean allowHalfOpen,
            StreamEventHandler connectionListener) {
        return createServer(allowHalfOpen, connectionListener.getNativeFunction());
    }

    @GwtNodeFunction
    public final Server createServer(boolean allowHalfOpen,
            JavaScriptFunctionWrapper connectionListener) {
        return createServer(allowHalfOpen, connectionListener.getNativeFunction());
    }

    @GwtNodeFunction
    public final native Server createServer(boolean allowHalfOpen,
            JavaScriptFunction connectionListener) /*-{
        return this.createServer(allowHalfOpen, connectionListener);
    }-*/;

    @GwtNodeFunction
    public final native Socket createConnection(int port) /*-{
        return this.createConnection(port);
    }-*/;

    @GwtNodeFunction
    public final native Socket createConnection(int port, String host) /*-{
        return this.createConnection(port, host);
    }-*/;

    @GwtNodeFunction
    public final native Socket createConnection(String path) /*-{
        return this.createConnection(path);
    }-*/;
    
    //TODO: callback versions please of createConnection

    @GwtNodeFunction
    public final native int isIP(String input) /*-{
        return this.isIP(input);
    }-*/;

    @GwtNodeFunction
    public final native boolean isIPv4(String input) /*-{
        return this.isIPv4(input);
    }-*/;

    @GwtNodeFunction
    public final native boolean isIPv6(String input) /*-{
        return this.isIPv6(input);
    }-*/;
    
    //package private...
    
    final native Socket createSocket() /*-{
        return new this.Socket();
    }-*/;
    
    final native Socket createSocket(SocketOptions options) /*-{
        return new this.Socket(options);
    }-*/;
}
