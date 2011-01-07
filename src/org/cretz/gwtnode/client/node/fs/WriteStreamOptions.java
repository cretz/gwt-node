package org.cretz.gwtnode.client.node.fs;

import com.google.gwt.core.client.JavaScriptObject;

public class WriteStreamOptions extends JavaScriptObject {

    public static native WriteStreamOptions create() /*-{
        return { };
    }-*/;
    
    public static native WriteStreamOptions create(String flags,
            String encoding, int mode) /*-{
        return { 
            'flags' : flags, 
            'encoding' : encoding, 
            'mode' : mode
        };
    }-*/;
    
    protected WriteStreamOptions() {
    }
    
    public final native String getFlags() /*-{
        return this.flags;
    }-*/;
    
    public final native void setFlags(String flags) /*-{
        this.flags = flags;
    }-*/;
    

    public final native String getEncoding() /*-{
        return this.encoding;
    }-*/;
    
    public final native void setEncoding(String encoding) /*-{
        this.encoding = encoding;
    }-*/;

    public final native int getMode() /*-{
        return this.mode;
    }-*/;
    
    public final native void setMode(int mode) /*-{
        this.mode = mode;
    }-*/;
    
}
