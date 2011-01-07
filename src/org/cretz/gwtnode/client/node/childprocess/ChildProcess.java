package org.cretz.gwtnode.client.node.childprocess;

import org.cretz.gwtnode.client.JavaScriptFunction;
import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;
import org.cretz.gwtnode.client.node.Global;
import org.cretz.gwtnode.client.node.NodeJsModule;

import com.google.gwt.core.client.JsArrayString;

public class ChildProcess extends NodeJsModule {

    private static ChildProcess instance;
    
    public static ChildProcess get() {
        if (instance == null) {
            instance = Global.get().require("child_process");
        }
        return instance;
    }
    
    protected ChildProcess() {
    }

    public final native Child spawn(String command) /*-{
        return this.spawn(command);
    }-*/;

    public final native Child spawn(String command, JsArrayString args) /*-{
        return this.spawn(command, args);
    }-*/;

    public final native Child spawn(String command, JsArrayString args, ChildSpawnOptions options) /*-{
        return this.spawn(command, args, options);
    }-*/;
    
    public final Child exec(String command, JavaScriptFunctionWrapper callback) {
        return exec(command, callback.getNativeFunction());
    }
    
    public final Child exec(String command, ExecEventHandler callback) {
        return exec(command, callback.getNativeFunction());
    }
    
    public final native Child exec(String command, JavaScriptFunction callback) /*-{
        this.exec(command, callback);
    }-*/;
    
    public final Child exec(String command, ChildExecOptions options, 
            JavaScriptFunctionWrapper callback) {
        return exec(command, options, callback.getNativeFunction());
    }
    
    public final Child exec(String command, ChildExecOptions options, ExecEventHandler callback) {
        return exec(command, options, callback.getNativeFunction());
    }
    
    public final native Child exec(String command, ChildExecOptions options, 
            JavaScriptFunction callback) /*-{
        this.exec(command, options, callback);
    }-*/;
    
    public abstract static class ExecEventHandler extends JavaScriptFunctionWrapper {
        @Override
        public void call(Object... arguments) {
            onEvent((Error) arguments[0], (String) arguments[1], (String) arguments[2]);
        }
        
        protected abstract void onEvent(Error error, String stdout, String stderr);
    }
}
