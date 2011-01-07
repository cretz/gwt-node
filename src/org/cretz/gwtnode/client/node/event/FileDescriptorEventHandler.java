package org.cretz.gwtnode.client.node.event;

import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;

public abstract class FileDescriptorEventHandler extends JavaScriptFunctionWrapper {

    @Override
    public void call(Object... arguments) {
        onEvent((Integer) arguments[0]);
    }

    public abstract void onEvent(int fd);
}
