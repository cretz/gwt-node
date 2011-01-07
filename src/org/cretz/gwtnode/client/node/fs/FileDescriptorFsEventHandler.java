package org.cretz.gwtnode.client.node.fs;

import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;

public abstract class FileDescriptorFsEventHandler extends JavaScriptFunctionWrapper {

    @Override
    public void call(Object... arguments) {
        Error error = arguments.length > 0 ? ((Error) arguments[0]) : null;
        Integer fd = arguments.length > 1 ? ((Integer) arguments[1]) : null;
        onEvent(error, fd);
    }

    public abstract void onEvent(Error error, Integer fd);
}
