package org.cretz.gwtnode.client.node.fs;

import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;
import org.cretz.gwtnode.client.node.Buffer;

public abstract class BufferFsEventHandler extends JavaScriptFunctionWrapper {

    @Override
    public void call(Object... arguments) {
        Error error = arguments.length > 0 ? ((Error) arguments[0]) : null;
        Buffer buffer = arguments.length > 1 ? ((Buffer) arguments[1]) : null;
        onEvent(error, buffer);
    }

    public abstract void onEvent(Error error, Buffer buffer);
}
