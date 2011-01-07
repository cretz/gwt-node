package org.cretz.gwtnode.client.node.fs;

import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;

public abstract class WatchFileEventHandler extends JavaScriptFunctionWrapper {

    @Override
    public void call(Object... arguments) {
        Stat curr = arguments.length > 0 ? ((Stat) arguments[0]) : null;
        Stat prev = arguments.length > 1 ? ((Stat) arguments[1]) : null;
        onEvent(curr, prev);
    }

    public abstract void onEvent(Stat curr, Stat prev);
}
