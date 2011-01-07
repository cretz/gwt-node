package org.cretz.gwtnode.client.node.fs;

import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;

public abstract class StringFsEventHandler extends JavaScriptFunctionWrapper {

    @Override
    public void call(Object... arguments) {
        Error error = arguments.length > 0 ? ((Error) arguments[0]) : null;
        String string = arguments.length > 1 ? ((String) arguments[1]) : null;
        onEvent(error, string);
    }

    public abstract void onEvent(Error error, String string);
}
