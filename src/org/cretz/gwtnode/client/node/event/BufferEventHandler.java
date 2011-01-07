package org.cretz.gwtnode.client.node.event;

import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;
import org.cretz.gwtnode.client.node.Buffer;

public abstract class BufferEventHandler extends JavaScriptFunctionWrapper {

    @Override
    public final void call(Object... arguments) {
        onEvent((Buffer) arguments[0]);
    }
    
    protected abstract void onEvent(Buffer buffer);
}
