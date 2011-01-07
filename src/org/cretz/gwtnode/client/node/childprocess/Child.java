package org.cretz.gwtnode.client.node.childprocess;

import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;
import org.cretz.gwtnode.client.node.event.EventEmitter;
import org.cretz.gwtnode.client.node.stream.ReadableStream;
import org.cretz.gwtnode.client.node.stream.WriteableStream;

import com.google.gwt.event.shared.HandlerRegistration;

public class Child extends EventEmitter {

    protected Child() {
    }
    
    public final HandlerRegistration onExit(ExitEventHandler handler) {
        return on("exit", handler);
    }
    
    public final native WriteableStream stdin() /*-{
        return this.stdin;
    }-*/;
    
    public final native ReadableStream stdout() /*-{
        return this.stdout;
    }-*/;
    
    public final native ReadableStream stderr() /*-{
        return this.stderr;
    }-*/;
    
    public final native int pid() /*-{
        return this.pid;
    }-*/;
    
    public final native void kill() /*-{
        this.kill();
    }-*/;
    
    public final native void kill(String signal) /*-{
        this.kill(signal);
    }-*/;
    
    public abstract static class ExitEventHandler extends JavaScriptFunctionWrapper {
        
        @Override
        public void call(Object... arguments) {
            Integer code = null;
            String signal = null;
            if (arguments.length > 0) {
                code = (Integer) arguments[0];
                if (arguments.length > 1) {
                    signal = (String) arguments[1];
                }
            }
            onEvent(code, signal);
        }
        
        protected abstract void onEvent(Integer code, String signal);
    }
}
