package org.cretz.gwtnode.client.node.event;

import org.cretz.gwtnode.client.JavaScriptFunction;
import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.shared.HandlerRegistration;

public class EventEmitter extends JavaScriptObject {

    private static EventEmitter instance;
    
    private static final native EventEmitter getNative() /*-{
        return require('events').EventEmitter;
    }-*/;
    
    public static EventEmitter get() {
        if (instance == null) {
            instance = getNative();
        }
        return instance;
    }
    
    protected EventEmitter() {
    }
    
    public final HandlerRegistration on(final String event, 
            final JavaScriptFunctionWrapper listener) {
        on(event, listener.getNativeFunction());
        return new HandlerRegistration() {
            @Override
            public void removeHandler() {
                removeListener(event, listener);
            }
        };
    }
    
    public final native void on(String event, JavaScriptFunction func) /*-{
        this.on(event, func);
    }-*/;
    
    public final native void removeListener(String event, 
            JavaScriptFunctionWrapper listener) /*-{
        this.removeListener(event, 
            listener.@org.cretz.gwtnode.client.JavaScriptFunctionWrapper::getNativeFunction()());
    }-*/;
    
    public final native void removeListener(String event, JavaScriptFunction func) /*-{
        this.removeListener(event, func);
    }-*/;
    
    public final native void removeAllListeners(String event) /*-{
        this.removeAllListeners(event);
    }-*/;
    
    public final native JsArray<JavaScriptFunction> listeners(String event) /*-{
        return this.listeners(event);
    }-*/;
    
    public final void emit(String event, Object... arguments) {
        Object[] args = new Object[arguments.length + 1];
        args[0] = event;
        System.arraycopy(arguments, 0, args, 1, arguments.length);
        emitNative(args);
    }
    
    private final native void emitNative(Object... arguments) /*-{
        this.emit.apply(this, arguments);
    }-*/;
}
