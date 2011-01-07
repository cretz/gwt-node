package org.cretz.gwtnode.client.node.childprocess;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayString;

public class ChildSpawnOptions extends JavaScriptObject {
    
    public static final native ChildSpawnOptions create() /*-{
        return { };
    }-*/;
    
    public static final native ChildSpawnOptions create(String cwd) /*-{
        return {
            'cwd': cwd
        };
    }-*/;
    
    public static final native ChildSpawnOptions create(String cwd, JsArrayString env) /*-{
        return {
            'cwd': cwd,
            'env': env
        };
    }-*/;
    
    public static final native ChildSpawnOptions create(String cwd, 
            JsArrayString env, JsArrayInteger customFds) /*-{
        return {
            'cwd': cwd,
            'env': env,
            'customFds': customFds
        };
    }-*/;
    
    protected ChildSpawnOptions() {
    }
    
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
    
    public final native JsArrayInteger getCustomFds() /*-{
        return this.customFds;
    }-*/;
    
    public final native void setCustomFds(JsArrayInteger customFds) /*-{
        this.customFds = customFds;
    }-*/;
}
