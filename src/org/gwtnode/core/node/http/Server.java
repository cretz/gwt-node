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
package org.gwtnode.core.node.http;

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.JavaScriptFunctionWrapper;
import org.gwtnode.core.node.event.ErrorEventHandler;
import org.gwtnode.core.node.event.EventEmitter;
import org.gwtnode.core.node.net.StreamEventHandler;

/**
 * @author Chad Retz
 */
public class Server extends EventEmitter {

    protected Server() {
    }
    
    public final void onRequest(ServerRequestEventHandler handler) {
        on("request", handler);
    }
    
    public final void onConnection(StreamEventHandler handler) {
        on("connection", handler);
    }

    public final void onClose(ServerCloseEventHandler handler) {
        on("close", handler);
    }

    public final void onCheckContinue(ServerRequestEventHandler handler) {
        on("checkContinue", handler);
    }
    
    public final void onUpgrade(ServerUpgradeEventHandler handler) {
        on("upgrade", handler);
    }
    
    public final void onClientError(ErrorEventHandler handler) {
        on("clientError", handler);
    }
    
    public final native void listen(int port) /*-{
        this.listen(port);
    }-*/;
    
    public final native void listen(int port, String hostname) /*-{
        this.listen(port, hostname);
    }-*/;
    
    public final void listen(int port, String hostname, JavaScriptFunctionWrapper callback) {
        listen(port, hostname, callback.getNativeFunction());
    }
    
    public final native void listen(int port, String hostname, JavaScriptFunction callback) /*-{
        this.listen(port, hostname, callback);
    }-*/;
    
    public final native void listen(String path) /*-{
        this.listen(path);
    }-*/;
    
    public final void listen(String path, JavaScriptFunctionWrapper callback) {
        listen(path, callback.getNativeFunction());
    }
    
    public final native void listen(String path, JavaScriptFunction callback) /*-{
        this.listen(path, callback);
    }-*/;
    
    public final native void close() /*-{
        this.close();
    }-*/;
    
    
}
