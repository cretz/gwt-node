package org.cretz.gwtnode.client.node.stream;

import org.cretz.gwtnode.client.node.event.EventEmitter;
import org.cretz.gwtnode.client.node.event.ExceptionEventHandler;
import org.cretz.gwtnode.client.node.event.ParameterlessEventHandler;

import com.google.gwt.event.shared.HandlerRegistration;

public class Stream extends EventEmitter {

    protected Stream() {
    }
    
    public final HandlerRegistration onError(ExceptionEventHandler handler) {
        return on("error", handler);
    }
    
    public final HandlerRegistration onClose(ParameterlessEventHandler handler) {
        return on("close", handler);
    }
    
    public final native void destroy() /*-{
        this.destroy();
    }-*/;
}
