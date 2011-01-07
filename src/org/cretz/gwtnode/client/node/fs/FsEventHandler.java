package org.cretz.gwtnode.client.node.fs;

import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;

public abstract class FsEventHandler extends JavaScriptFunctionWrapper {

    @Override
    public void call(Object... arguments) {
        onEvent(arguments.length > 0 ? ((Error) arguments[0]) : null);
    }

    public abstract void onEvent(Error error);
}
