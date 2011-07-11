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
import org.cretz.gwtnode.client.node.buffer.Buffer;
import org.cretz.gwtnode.client.node.event.EventEmitter;
import org.cretz.gwtnode.client.node.event.ParameterlessEventHandler;

/**
 * The node.js socket object
 * 
 * @author Chad Retz
 */
public class Socket extends EventEmitter {

    protected Socket() {
    }
    
    public final void onMessage(MessageEventHandler handler) {
        on("message", handler);
    }
    
    public final void onListening(ParameterlessEventHandler handler) {
        on("listener", handler);
    }

    public final void onClose(ParameterlessEventHandler handler) {
        on("close", handler);
    }

    public final native void send(Buffer buf, int offset, int length, String path) /*-{
        this.send(buf, offset, length, path);
    }-*/;
    
    public final void send(Buffer buf, int offset, int length,
            String path, JavaScriptFunctionWrapper callback) {
        send(buf, offset, length, path, callback.getNativeFunction());
    }
    
    public final native void send(Buffer buf, int offset, int length,
            String path, JavaScriptFunction callback) /*-{
        this.send(buf, offset, length, path, callback);
    }-*/;

    public final native void send(Buffer buf, int offset, int length, 
            int port, String address) /*-{
        this.send(buf, offset, length, port, address);
    }-*/;
    
    public final void send(Buffer buf, int offset, int length,
            int port, String address, JavaScriptFunctionWrapper callback) {
        send(buf, offset, length, port, address, callback.getNativeFunction());
    }
    
    public final native void send(Buffer buf, int offset, int length,
            int port, String address, JavaScriptFunction callback) /*-{
        this.send(buf, offset, length, port, address, callback);
    }-*/;
    
    public final native void bind(String path) /*-{
        this.bind(path);
    }-*/;
    
    public final native void bind(int port) /*-{
        this.bind(port);
    }-*/;
    
    public final native void bind(int port, String address) /*-{
        this.bind(port, address);
    }-*/;
    
    public final native void close() /*-{
        this.close();
    }-*/;
    
    public final native Address address() /*-{
        this.address();
    }-*/;
    
    public final native void setBroadcast(int flag) /*-{
        this.setBroadcast(flag);
    }-*/;
    
    public final native void setTTL(int ttl) /*-{
        this.setTTL(ttl);
    }-*/;
    
    public final native void setMulticastTTL(int ttl) /*-{
        this.setMulticastTTL(ttl);
    }-*/;
    
    public final native void setMulticastLoopback(int flag) /*-{
        this.setMulticastLoopback(flag);
    }-*/;
    
    //TODO: check the parameter types of these methods
    //  and figure out what multicastInterface represents

    public final native void addMembership(String multicastAddress) /*-{
        this.addMembership(multicastAddress);
    }-*/;

    public final native void addMembership(String multicastAddress, String multicastInterface) /*-{
        this.addMembership(multicastAddress, multicastInterface);
    }-*/;
    
    public final native void dropMembership(String multicastAddress) /*-{
        this.dropMembership(multicastAddress);
    }-*/;
    
    public final native void dropMembership(String multicastAddress, String multicastInterface) /*-{
        this.dropMembership(multicastAddress, multicastInterface);
    }-*/;
}
