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
import org.gwtnode.core.meta.GwtNodeEvent;
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.node.buffer.Buffer;
import org.gwtnode.core.node.event.EventEmitter;
import org.gwtnode.core.node.event.ParameterlessEventHandler;

/**
 * The node.js socket object
 * 
 * @author Chad Retz
 */
@GwtNodeObject
public class Socket extends EventEmitter {

    protected Socket() {
    }
    
    @GwtNodeEvent
    public final void onMessage(MessageEventHandler handler) {
        on("message", handler);
    }

    @GwtNodeEvent
    public final void onListener(ParameterlessEventHandler handler) {
        on("listener", handler);
    }

    @GwtNodeEvent
    public final void onClose(ParameterlessEventHandler handler) {
        on("close", handler);
    }

    @GwtNodeFunction
    public final native void send(Buffer buf, int offset, int length, String path) /*-{
        this.send(buf, offset, length, path);
    }-*/;

    @GwtNodeFunction
    public final void send(Buffer buf, int offset, int length,
            String path, JavaScriptFunctionWrapper callback) {
        send(buf, offset, length, path, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void send(Buffer buf, int offset, int length,
            String path, JavaScriptFunction callback) /*-{
        this.send(buf, offset, length, path, callback);
    }-*/;

    @GwtNodeFunction
    public final native void send(Buffer buf, int offset, int length, 
            int port, String address) /*-{
        this.send(buf, offset, length, port, address);
    }-*/;

    @GwtNodeFunction
    public final void send(Buffer buf, int offset, int length,
            int port, String address, JavaScriptFunctionWrapper callback) {
        send(buf, offset, length, port, address, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void send(Buffer buf, int offset, int length,
            int port, String address, JavaScriptFunction callback) /*-{
        this.send(buf, offset, length, port, address, callback);
    }-*/;

    @GwtNodeFunction
    public final native void bind(String path) /*-{
        this.bind(path);
    }-*/;

    @GwtNodeFunction
    public final native void bind(int port) /*-{
        this.bind(port);
    }-*/;

    @GwtNodeFunction
    public final native void bind(int port, String address) /*-{
        this.bind(port, address);
    }-*/;

    @GwtNodeFunction
    public final native void close() /*-{
        this.close();
    }-*/;

    @GwtNodeFunction
    public final native Address address() /*-{
        this.address();
    }-*/;

    @GwtNodeFunction
    public final native void setBroadcast(int flag) /*-{
        this.setBroadcast(flag);
    }-*/;

    @GwtNodeFunction
    public final native void setTTL(int ttl) /*-{
        this.setTTL(ttl);
    }-*/;

    @GwtNodeFunction
    public final native void setMulticastTTL(int ttl) /*-{
        this.setMulticastTTL(ttl);
    }-*/;

    @GwtNodeFunction
    public final native void setMulticastLoopback(int flag) /*-{
        this.setMulticastLoopback(flag);
    }-*/;
    
    //TODO: check the parameter types of these methods
    //  and figure out what multicastInterface represents

    @GwtNodeFunction
    public final native void addMembership(String multicastAddress) /*-{
        this.addMembership(multicastAddress);
    }-*/;

    @GwtNodeFunction
    public final native void addMembership(String multicastAddress, String multicastInterface) /*-{
        this.addMembership(multicastAddress, multicastInterface);
    }-*/;

    @GwtNodeFunction
    public final native void dropMembership(String multicastAddress) /*-{
        this.dropMembership(multicastAddress);
    }-*/;

    @GwtNodeFunction
    public final native void dropMembership(String multicastAddress, String multicastInterface) /*-{
        this.dropMembership(multicastAddress, multicastInterface);
    }-*/;
}
