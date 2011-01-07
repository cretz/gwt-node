package org.cretz.gwtnode.client.node;

import org.cretz.gwtnode.client.JavaScriptFunction;
import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;
import org.cretz.gwtnode.client.node.event.ExceptionEventHandler;
import org.cretz.gwtnode.client.node.stream.ReadableStream;
import org.cretz.gwtnode.client.node.stream.WriteableStream;

import com.google.gwt.core.client.JavaScriptObject;


public class Sys extends NodeJsModule  {

    private static Sys instance;
    
    public static Sys get() {
        if (instance == null) {
            instance = Global.get().require("sys");
        }
        return instance;
    }
    
    protected Sys() {
    }
    
    public final native void print(String string) /*-{
        this.print(string);
    }-*/;
    
    public final native void debug(String string) /*-{
        this.debug(string);
    }-*/;
    
    public final native void log(String string) /*-{
        this.log(string);
    }-*/;
    
    public final native String inspect(JavaScriptObject object) /*-{
        return this.inspect(object);
    }-*/;
    
    public final native String inspect(JavaScriptObject object, boolean showHidden) /*-{
        return this.inspect(object, showHidden);
    }-*/;
    
    public final native String inspect(JavaScriptObject object, boolean showHidden, int depth) /*-{
        return this.inspect(object, showHidden, depth);
    }-*/;
    
    public final native void pump(ReadableStream readableStream, WriteableStream writeableStream) /*-{
        this.pump(readableStream, writeableStream);
    }-*/;
    
    public final void pump(ReadableStream readableStream, WriteableStream writeableStream,
            ExceptionEventHandler handler) {
        pump(readableStream, writeableStream, handler.getNativeFunction());
    }
    
    public final void pump(ReadableStream readableStream, WriteableStream writeableStream,
            JavaScriptFunctionWrapper wrapper) {
        pump(readableStream, writeableStream, wrapper.getNativeFunction());
    }
    
    public final native void pump(ReadableStream readableStream, WriteableStream writeableStream,
            JavaScriptFunction func) /*-{
        this.pump(readableStream, writeableStream, func);
    }-*/;
}
