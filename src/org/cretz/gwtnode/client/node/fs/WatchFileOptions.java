package org.cretz.gwtnode.client.node.fs;

import com.google.gwt.core.client.JavaScriptObject;

public class WatchFileOptions extends JavaScriptObject {

    public static native WatchFileOptions create() /*-{
        return { };
    }-*/;
    
    public static native WatchFileOptions create(
            boolean persistent, int interval) /*-{
        return { 'persistent' : persistent, 'interval' : interval };
    }-*/;
    
    protected WatchFileOptions() {
    }

    public final native boolean isPersistent() /*-{
        return this.persistent;
    }-*/;
    
    public final native void setPersistent(boolean persistent) /*-{
        this.persistent = persistent;
    }-*/;
    
    public final native int getInterval() /*-{
        return this.interval;
    }-*/;

    public final native void setInterval(int interval) /*-{
        this.interval = interval;
    }-*/;
}
