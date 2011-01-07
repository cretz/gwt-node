package org.cretz.gwtnode.client.node.event;

import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;
import org.cretz.gwtnode.client.node.NodeJsNativeException;

public abstract class ExceptionEventHandler extends JavaScriptFunctionWrapper {

    @Override
    public void call(Object... arguments) {
        onEvent((NodeJsNativeException) arguments[0]);
    }

    public abstract void onEvent(NodeJsNativeException exception);
}
