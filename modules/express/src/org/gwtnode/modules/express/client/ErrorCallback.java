package org.gwtnode.modules.express.client;

import org.gwtnode.client.JavaScriptFunction;
import org.gwtnode.client.JavaScriptFunctionArguments;
import org.gwtnode.client.JavaScriptFunctionWrapper;
import org.gwtnode.client.node.NodeJsError;

public abstract class ErrorCallback extends JavaScriptFunctionWrapper {

    @Override
    public void call(JavaScriptFunctionArguments args) {
        onError((NodeJsError) args.get(0), (Request) args.get(1), 
                (Response) args.get(2), (NextCall) args.get(3));
    }
    
    protected abstract void onError(NodeJsError error, Request request, 
            Response response, NextCall call);

    protected static class NextCall extends JavaScriptFunction {
        
        private NextCall() {
        }
        
        public final void next(NodeJsError error) {
            apply(error);
        }
    }
}
