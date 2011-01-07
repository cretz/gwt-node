package org.cretz.gwtnode.client.node.fs;

import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;

public abstract class StatFsEventHandler extends JavaScriptFunctionWrapper {

    @Override
    public void call(Object... arguments) {
        Error error = arguments.length > 0 ? ((Error) arguments[0]) : null;
        Stat stats = arguments.length > 1 ? ((Stat) arguments[1]) : null;
        onEvent(error, stats);
    }

    public abstract void onEvent(Error error, Stat stats);
}
