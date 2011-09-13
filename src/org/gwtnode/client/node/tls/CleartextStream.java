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
package org.gwtnode.client.node.tls;

import org.gwtnode.client.JsonStringObjectMap;
import org.gwtnode.client.node.buffer.Buffer;
import org.gwtnode.client.node.event.FileDescriptorEventHandler;
import org.gwtnode.client.node.event.ParameterlessEventHandler;
import org.gwtnode.client.node.event.StringOrBufferEventHandler;
import org.gwtnode.client.node.stream.PipeEventHandler;
import org.gwtnode.client.node.stream.Stream;
import org.gwtnode.client.node.stream.WriteableStream;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Chad Retz
 */
public class CleartextStream extends Stream {

    //TODO: test each function here to make sure it is implemented
    //TODO: make ReadableStream and WriteableStream interfaces instead
    //  of concrete classes so this can implement both
    
    protected CleartextStream() {
    }
    
    public final void onData(StringOrBufferEventHandler handler) {
        on("data", handler);
    }
    
    public final void onEnd(ParameterlessEventHandler handler) {
        on("end", handler);
    }
    
    public final void onFileDescriptor(FileDescriptorEventHandler handler) {
        on("fd", handler);
    }
    
    public final native boolean readable() /*-{
        return this.readable;
    }-*/;
    
    public final native void setEncoding(String encoding) /*-{
        this.setEncoding(encoding);
    }-*/;
    
    public final native void pause() /*-{
        this.pause();
    }-*/;
    
    public final native void resume() /*-{
        this.resume();
    }-*/;

    public final native void pipe(WriteableStream destination) /*-{
        this.pipe(destination);
    }-*/;
    
    public final native void pipe(WriteableStream destination, boolean end) /*-{
        this.pipe(destination, {'end' : end });
    }-*/;
    
    public final void pipe(WriteableStream destination, JsonStringObjectMap<?> map) {
        pipe(destination, map.getNativeObject());
    }
    
    public final native void pipe(WriteableStream destination, JavaScriptObject options) /*-{
        this.pipe(destination, options);
    }-*/;
    
    public final void onDrain(ParameterlessEventHandler handler) {
        on("drain", handler);
    }
    
    public final void onPipe(PipeEventHandler handler) {
        on("pipe", handler);
    }
    
    public final native boolean writeable() /*-{
        return this.writeable;
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
    
    public final native void end(String string) /*-{
        this.end(string);
    }-*/;
    
    public final native void end(String string, String encoding) /*-{
        this.end(string, encoding);
    }-*/;
    
    public final native void end(Buffer buffer) /*-{
        this.end(buffer);
    }-*/;
    
    //specific to this class...
    
    public final native boolean authorized() /*-{
        return this.authorized;
    }-*/;
    
    public final native String authorizationError() /*-{
        return this.authorizationError;
    }-*/;
    
    public final native JavaScriptObject getPeerCertificate() /*-{
        return this.getPeerCertificate();
    }-*/;
}
