package org.cretz.gwtnode.client.node.fs;

import com.google.gwt.core.client.JavaScriptObject;

public class ReadStreamOptions extends JavaScriptObject {

    public static native ReadStreamOptions create() /*-{
        return { };
    }-*/;
    
    public static native ReadStreamOptions create(int start, int end) /*-{
        return { 'start' : start, 'end' : end };
    }-*/;
    
    protected ReadStreamOptions() {
    }
    
    public final native int getStart() /*-{
        return this.start;
    }-*/;
    
    public final native void setStart(int start) /*-{
        this.start = start;
    }-*/;
    
    public final native int getEnd() /*-{
        return this.end;
    }-*/;
    
    public final native void setEnd(int end) /*-{
        this.end = end;
    }-*/;
}
