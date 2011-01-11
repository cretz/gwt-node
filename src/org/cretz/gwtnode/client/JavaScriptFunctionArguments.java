package org.cretz.gwtnode.client;

import com.google.gwt.core.client.JavaScriptObject;

public class JavaScriptFunctionArguments extends JavaScriptObject {

    protected JavaScriptFunctionArguments() {
    }
    
    public final native int length() /*-{
        return this.length;
    }-*/;
    
    public final native <T> T get(int index) /*-{
        return this[index];
    }-*/;
}
