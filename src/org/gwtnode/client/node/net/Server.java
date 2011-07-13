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
package org.gwtnode.client.node.net;

import org.gwtnode.client.JavaScriptFunction;
import org.gwtnode.client.JavaScriptFunctionWrapper;
import org.gwtnode.client.node.event.EventEmitter;
import org.gwtnode.client.node.event.ParameterlessEventHandler;

public class Server extends EventEmitter {

    protected Server() {
    }
    
    public final void onConnection(StreamEventHandler handler) {
        on("connection", handler);
    }
    
    public final void onClose(ParameterlessEventHandler handler) {
        on("close", handler);
    }
    
    public final native void listen(int port) /*-{
        this.listen(port);
    }-*/;
    
    public final native void listen(int port, String host) /*-{
        this.listen(port, host);
    }-*/;
    
    public final void listen(int port, ParameterlessEventHandler callback) {
        listen(port, callback.getNativeFunction());
    }
    
    public final void listen(int port, JavaScriptFunctionWrapper callback) {
        listen(port, callback.getNativeFunction());
    }
    
    public final native void listen(int port, JavaScriptFunction callback) /*-{
        this.listen(port, callback);
    }-*/;
    
    public final void listen(int port, String host, ParameterlessEventHandler callback) {
        listen(port, host, callback.getNativeFunction());
    }
    
    public final void listen(int port, String host, JavaScriptFunctionWrapper callback) {
        listen(port, host, callback.getNativeFunction());
    }
    
    public final native void listen(int port, String host, JavaScriptFunction callback) /*-{
        this.listen(port, host, callback);
    }-*/;
    
    public final native void listen(String path) /*-{
        this.listen(path);
    }-*/;
    
    public final void listen(String path, ParameterlessEventHandler callback) {
        listen(path, callback.getNativeFunction());
    }
    
    public final void listen(String path, JavaScriptFunctionWrapper callback) {
        listen(path, callback.getNativeFunction());
    }
    
    public final native void listen(String path, JavaScriptFunction callback) /*-{
        this.listen(path, callback);
    }-*/;
    
    public final native void listenFD(int fd) /*-{
        this.listenFD(fd);
    }-*/;
    
    public final native void pause(double msecs) /*-{
        this.pause(msecs);
    }-*/;

    public final native void close() /*-{
        this.close();
    }-*/;

    public final native String address() /*-{
        return this.address();
    }-*/;
    
    public final native int maxConnections() /*-{
        return this.maxConnections;
    }-*/;
    
    public final native void maxConnections(int maxConnections) /*-{
        this.maxConnections = maxConnections;
    }-*/;
    
    public final native int connections() /*-{
        return this.connections;
    }-*/;
}
