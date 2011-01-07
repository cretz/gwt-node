package org.cretz.gwtnode.client.node.childprocess;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public class ChildExecOptions extends JavaScriptObject {

    public static final native ChildExecOptions create() /*-{
        return { };
    }-*/;
    
    protected ChildExecOptions() {
    }
    
    public final native String getEncoding() /*-{
        return this.encoding;
    }-*/;
    
    public final native void setEncoding(String encoding) /*-{
        this.encoding = encoding;
    }-*/;
    
    public final native int getTimeout() /*-{
        return this.timeout;
    }-*/;
    
    public final native void setTimeout(int timeout) /*-{
        this.timeout = timeout;
    }-*/;
    
    public final native int getMaxBuffer() /*-{
        return this.maxBuffer;
    }-*/;
    
    public final native void setMaxBuffer(int maxBuffer) /*-{
        this.maxBuffer = maxBuffer
    }-*/;

    public final native String getKillSignal() /*-{
        return this.killSignal;
    }-*/;
    
    public final native void setKillSignal(String killSignal) /*-{
        this.killSignal = killSignal;
    }-*/;

    public final native String getCwd() /*-{
        return this.cwd;
    }-*/;
    
    public final native void setCwd(String cwd) /*-{
        this.cwd = cwd;
    }-*/;
    
    public final native JsArrayString getEnv() /*-{
        return this.env;
    }-*/;
    
    public final native void setEnv(JsArrayString env) /*-{
        this.env = env;
    }-*/;

}
