package org.cretz.gwtnode.client.node.fs;

import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;

public abstract class PathFsEventHandler extends JavaScriptFunctionWrapper {

    @Override
    public void call(Object... arguments) {
        Error error = arguments.length > 0 ? ((Error) arguments[0]) : null;
        String resolvedPath = arguments.length > 1 ? ((String) arguments[1]) : null;
        onEvent(error, resolvedPath);
    }

    public abstract void onEvent(Error error, String resolvedPath);
}
