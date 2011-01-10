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

import org.cretz.gwtnode.client.node.buffer.Buffer;
import org.cretz.gwtnode.client.node.crypto.Credentials;
import org.cretz.gwtnode.client.node.event.BooleanEventHandler;
import org.cretz.gwtnode.client.node.event.EventEmitter;
import org.cretz.gwtnode.client.node.event.ErrorEventHandler;
import org.cretz.gwtnode.client.node.event.ParameterlessEventHandler;
import org.cretz.gwtnode.client.node.event.StringOrBufferEventHandler;
import org.cretz.gwtnode.client.node.http.Certificate;

public class Stream extends EventEmitter {

    protected Stream() {
    }
    
    public final void onConnect(ParameterlessEventHandler handler) {
        on("connect", handler);
    }
    
    public final void onSecure(ParameterlessEventHandler handler) {
        on("secure", handler);
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
    
    public final void onError(BooleanEventHandler handler) {
        on("close", handler);
    }
    
    public final native void connect(int port) /*-{
        this.connect(port);
    }-*/;
    
    public final native void connect(int port, String host) /*-{
        this.connect(port, host);
    }-*/;
    
    public final native String remoteAddress() /*-{
        return this.remoteAddress;
    }-*/;
    
    public final native String readyState() /*-{
        return this.readyState;
    }-*/;
    
    public final native void setEncoding() /*-{
        this.setEncoding();
    }-*/;
    
    public final native void setEncoding(String encoding) /*-{
        this.setEncoding(encoding);
    }-*/;
    
    public final native void setSecure(Credentials credentials) /*-{
        this.setSecure(credentials);
    }-*/;
    
    public final native boolean verifyPeer() /*-{
        return this.verifyPeer();
    }-*/;
    
    public final native Certificate getPeerCertificate() /*-{
        return this.getPeerCertificate();
    }-*/;

    public final native boolean write(String string) /*-{
        return this.write(string);
    }-*/;
    
    public final native boolean write(String string, String encoding) /*-{
        return this.write(string, encoding);
    }-*/;
    
    public final native boolean write(String string, String encoding, int fd) /*-{
        return this.write(string, encoding, fd);
    }-*/;
    
    public final native boolean write(Buffer buffer) /*-{
        return this.write(buffer);
    }-*/;
    
    public final native void end() /*-{
        this.end();
    }-*/;
    
    public final native void end(String string, String encoding) /*-{
        this.end(string, encoding);
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
}
