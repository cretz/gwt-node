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
package org.cretz.gwtnode.client.node.tls;

import org.cretz.gwtnode.client.JavaScriptFunction;
import org.cretz.gwtnode.client.JavaScriptFunctionArguments;
import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;
import org.cretz.gwtnode.client.node.Global;
import org.cretz.gwtnode.client.node.NodeJsModule;
import org.cretz.gwtnode.client.node.event.EventEmitter;
import org.cretz.gwtnode.client.node.event.ParameterlessEventHandler;
import org.cretz.gwtnode.client.node.net.Server;
import org.cretz.gwtnode.client.node.stream.Stream;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.0/api/tls.html">TLS</a> module
 * 
 * @author Chad Retz
 */
public class Tls extends EventEmitter implements NodeJsModule {

    private static Tls instance;
    
    public static Tls get() {
        if (instance == null) {
            instance = Global.get().require("tls");
        }
        return instance;
    }
    
    protected Tls() {
    }
    
    public final void onSecureConnection(SecureConnectionEventHandler handler) {
        on("secureConnection", handler);
    }
    
    public final <T extends Stream> T connect(int port,  
            ConnectOptions options, ParameterlessEventHandler callback) {
        return this.<T>connect(port, options, callback.getNativeFunction());
    }

    public final native <T extends Stream> T connect(int port, 
            ConnectOptions options, JavaScriptFunction callback) /*-{
        return this.connect(port, options, callback);
    }-*/;
    
    public final <T extends Stream> T connect(int port, String host, 
            ConnectOptions options, ParameterlessEventHandler callback) {
        return this.<T>connect(port, host, options, callback.getNativeFunction());
    }

    public final native <T extends Stream> T connect(int port, String host, 
            ConnectOptions options, JavaScriptFunction callback) /*-{
        return this.connect(port, host, options, callback);
    }-*/;
    
    public final native Server createServer(ServerOptions options) /*-{
        return this.createServer(options);
    }-*/;
    
    public final Server createServer(ServerOptions options, 
            SecureConnectionEventHandler callback) {
        return createServer(options, callback.getNativeFunction());
    }
    
    public final Server createServer(ServerOptions options, JavaScriptFunctionWrapper callback) {
        return createServer(options, callback.getNativeFunction());
    }
    
    public final native Server createServer(ServerOptions options, JavaScriptFunction callback) /*-{
        return this.createServer(options, callback);
    }-*/;
    
    public static abstract class SecureConnectionEventHandler extends JavaScriptFunctionWrapper {

        @Override
        public final void call(JavaScriptFunctionArguments args) {
            onEvent((Stream) args.get(0));
        }
        
        protected abstract void onEvent(Stream stream);
    }
}
