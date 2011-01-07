package org.cretz.gwtnode.client.node.stream;

import org.cretz.gwtnode.client.node.Buffer;
import org.cretz.gwtnode.client.node.event.ParameterlessEventHandler;

import com.google.gwt.event.shared.HandlerRegistration;

public class WriteableStream extends Stream {
    
    protected WriteableStream() {
    }
    
    public final HandlerRegistration onDrain(ParameterlessEventHandler handler) {
        return on("drain", handler);
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
    
    public final native void end(String string, String encoding) /*-{
        this.end(string, encoding);
    }-*/;
    
    public final native void end(Buffer buffer) /*-{
        this.end(buffer);
    }-*/;
}
