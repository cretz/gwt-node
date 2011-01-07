package org.cretz.gwtnode.client.node.event;

import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;

public abstract class ParameterlessEventHandler extends JavaScriptFunctionWrapper {

    @Override
    public void call(Object... arguments) {
        onEvent();
    }
    
    public abstract void onEvent();

}
