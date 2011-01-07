package org.cretz.gwtnode.client.node.fs;

import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;

import com.google.gwt.core.client.JsArrayString;

public abstract class ReaddirFsEventHandler extends JavaScriptFunctionWrapper {

    @Override
    public void call(Object... arguments) {
        Error error = arguments.length > 0 ? ((Error) arguments[0]) : null;
        JsArrayString files = arguments.length > 1 ? ((JsArrayString) arguments[1]) : null;
        onEvent(error, files);
    }

    public abstract void onEvent(Error error, JsArrayString resolvedPath);
}
