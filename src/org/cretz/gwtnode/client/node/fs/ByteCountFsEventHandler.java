package org.cretz.gwtnode.client.node.fs;

import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;

public abstract class ByteCountFsEventHandler extends JavaScriptFunctionWrapper {

    @Override
    public void call(Object... arguments) {
        Error error = arguments.length > 0 ? ((Error) arguments[0]) : null;
        Integer byteCount = arguments.length > 1 ? ((Integer) arguments[1]) : null;
        onEvent(error, byteCount);
    }

    public abstract void onEvent(Error error, Integer byteCount);
}
