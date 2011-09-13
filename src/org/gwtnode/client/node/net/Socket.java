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
import org.gwtnode.client.node.buffer.Buffer;
import org.gwtnode.client.node.event.BooleanEventHandler;
import org.gwtnode.client.node.event.ErrorEventHandler;
import org.gwtnode.client.node.event.EventEmitter;
import org.gwtnode.client.node.event.ParameterlessEventHandler;
import org.gwtnode.client.node.event.StringOrBufferEventHandler;

/**
 * @author Chad Retz
 */
public class Socket extends EventEmitter {

    public static final native Socket create() /*-{
        return new net.Socket();
    }-*/;
    
    public static final native Socket create(SocketOptions options) /*-{
        return new net.Socket(options);
    }-*/;
    
    protected Socket() {
    }
    
    public final void onConnect(ParameterlessEventHandler handler) {
        on("connect", handler);
    }
    
    public final void onData(StringOrBufferEventHandler handler) {
        on("data", handler);
    }
    
    public final void onEnd(ParameterlessEventHandler handler) {
        on("end", handler);
    }
    
    public final void onTimeout(ParameterlessEventHandler handler) {
        on("timeout", handler);
    }
    
    public final void onDrain(ParameterlessEventHandler handler) {
        on("drain", handler);
    }
    
    public final void onError(ErrorEventHandler handler) {
        on("error", handler);
    }
    
    public final void onClose(BooleanEventHandler handler) {
        on("close", handler);
    }
    
    public final native void connect(int port) /*-{
        this.connect(port);
    }-*/;
    
    public final void connect(int port, ParameterlessEventHandler callback) {
        connect(port, callback.getNativeFunction());
    }
    
    public final void connect(int port, JavaScriptFunctionWrapper callback) {
        connect(port, callback.getNativeFunction());
    }
    
    public final native void connect(int port, JavaScriptFunction callback) /*-{
        this.connect(port, callback);
    }-*/;
    
    public final native void connect(int port, String host) /*-{
        this.connect(port, host);
    }-*/;
    
    public final void connect(int port, String host, ParameterlessEventHandler callback) {
        connect(port, host, callback.getNativeFunction());
    }
    
    public final void connect(int port, String host, JavaScriptFunctionWrapper callback) {
        connect(port, host, callback.getNativeFunction());
    }
    
    public final native void connect(int port, String host, JavaScriptFunction callback) /*-{
        this.connect(port, host, callback);
    }-*/;
    
    public final native double bufferSize() /*-{
        return this.bufferSize;
    }-*/;
    
    public final native void setEncoding() /*-{
        this.setEncoding();
    }-*/;
    
    public final native void setEncoding(String encoding) /*-{
        this.setEncoding(encoding);
    }-*/;
    
    public final native boolean verifyPeer() /*-{
        return this.verifyPeer();
    }-*/;

    public final native boolean write(String string) /*-{
        return this.write(string);
    }-*/;
    
    public final boolean write(String string, ParameterlessEventHandler callback) {
        return write(string, callback.getNativeFunction());
    }
    
    public final boolean write(String string, JavaScriptFunctionWrapper callback) {
        return write(string, callback.getNativeFunction());
    }

    public final native boolean write(String string, JavaScriptFunction callback) /*-{
        return this.write(string, callback);
    }-*/;
    
    public final native boolean write(String string, String encoding) /*-{
        return this.write(string, encoding);
    }-*/;
    
    public final boolean write(String string, String encoding, ParameterlessEventHandler callback) {
        return write(string, encoding, callback.getNativeFunction());
    }
    
    public final boolean write(String string, String encoding, JavaScriptFunctionWrapper callback) {
        return write(string, encoding, callback.getNativeFunction());
    }

    public final native boolean write(String string, String encoding, JavaScriptFunction callback) /*-{
        return this.write(string, encoding, callback);
    }-*/;
    
    public final native boolean write(Buffer buffer) /*-{
        return this.write(buffer);
    }-*/;
    
    public final boolean write(Buffer buffer, ParameterlessEventHandler callback) {
        return write(buffer, callback.getNativeFunction());
    }
    
    public final boolean write(Buffer buffer, JavaScriptFunctionWrapper callback) {
        return write(buffer, callback.getNativeFunction());
    }

    public final native boolean write(Buffer buffer, JavaScriptFunction callback) /*-{
        return this.write(buffer, callback);
    }-*/;
    
    public final native boolean write(String string, String encoding, int fd) /*-{
        return this.write(string, encoding, fd);
    }-*/;
    
    public final boolean write(String string, String encoding, 
            int fd, ParameterlessEventHandler callback) {
        return write(string, encoding, fd, callback.getNativeFunction());
    }
    
    public final boolean write(String string, String encoding, int fd,
            JavaScriptFunctionWrapper callback) {
        return write(string, encoding, fd, callback.getNativeFunction());
    }

    public final native boolean write(String string, String encoding, int fd, 
            JavaScriptFunction callback) /*-{
        return this.write(string, encoding, fd, callback);
    }-*/;
    
    public final native void end() /*-{
        this.end();
    }-*/;
    
    public final native void end(String data, String encoding) /*-{
        this.end(data, encoding);
    }-*/;
    
    public final native void end(Buffer buffer) /*-{
        this.end(buffer);
    }-*/;
    
    public final native void destroy() /*-{
        this.destroy();
    }-*/;
    
    public final native void pause() /*-{
        this.pause();
    }-*/;
    
    public final native void resume() /*-{
        this.resume();
    }-*/;
    
    public final native void setTimeout(int timeout) /*-{
        this.setTimeout(timeout);
    }-*/;
    
    public final void setTimeout(int timeout, ParameterlessEventHandler callback) {
        setTimeout(timeout, callback.getNativeFunction());
    }
    
    public final void setTimeout(int timeout, JavaScriptFunctionWrapper callback) {
        setTimeout(timeout, callback.getNativeFunction());
    }
    
    public final native void setTimeout(int timeout, JavaScriptFunction callback) /*-{
        this.setTimeout(timeout, callback);
    }-*/;
    
    public final native void setNoDelay() /*-{
        this.setNoDelay();
    }-*/;
    
    public final native void setNoDelay(boolean noDelay) /*-{
        this.setNoDelay(noDelay);
    }-*/;
    
    public final native void setKeepAlive() /*-{
        this.setKeepAlive();
    }-*/;
    
    public final native void setKeepAlive(boolean enable) /*-{
        this.setKeepAlive(enable);
    }-*/;
    
    public final native void setKeepAlive(boolean enable, int initialDelay) /*-{
        this.setKeepAlive(enable, initialDelay);
    }-*/;
    
    public final native Address address() /*-{
        return this.address();
    }-*/;
    
    public final native String remoteAddress() /*-{
        return this.remoteAddress;
    }-*/;
    
    public final native int remotePort() /*-{
        return this.remotePort;
    }-*/;
    
    public final native int bytesRead() /*-{
        return this.bytesRead;
    }-*/;
    
    public final native int bytesWritten() /*-{
        return this.bytesWritten;
    }-*/;
}
