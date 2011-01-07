package org.cretz.gwtnode.client.node.stream;

import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;
import org.cretz.gwtnode.client.node.Buffer;
import org.cretz.gwtnode.client.node.event.FileDescriptorEventHandler;
import org.cretz.gwtnode.client.node.event.ParameterlessEventHandler;

import com.google.gwt.event.shared.HandlerRegistration;

public class ReadableStream extends Stream {
    
    protected ReadableStream() {
    }
    
    public final HandlerRegistration onData(DataEventHandler handler) {
        return on("data", handler);
    }
    
    public final HandlerRegistration onEnd(ParameterlessEventHandler handler) {
        return on("end", handler);
    }
    
    public final HandlerRegistration onFileDescriptor(FileDescriptorEventHandler handler) {
        return on("fd", handler);
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

    public abstract static class DataEventHandler extends JavaScriptFunctionWrapper {
        
        private Buffer buffer;
        private String string;
    
        @Override
        public void call(Object... arguments) {
            if (arguments[0] instanceof String) {
                string = (String) arguments[0];
            } else {
                buffer = (Buffer) arguments[0];
            }
        }
        
        public Buffer getBuffer() {
            return buffer;
        }
        
        public String getString() {
            return string;
        }
        
        protected abstract void onEvent();
    }
}
