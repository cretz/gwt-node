package org.cretz.gwtnode.client.node.event;

import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;

public abstract class StringEventHandler extends JavaScriptFunctionWrapper {

    @Override
    public final void call(Object... arguments) {
        onEvent((String) arguments[0]);
    }
    
    protected abstract void onEvent(String string);
}
