package org.cretz.gwtnode.client.node.script;

import com.google.gwt.core.client.JavaScriptObject;

public class Script extends JavaScriptObject {
    
    private static Script instance;
    
    public static Script get() {
        if (instance == null) {
            instance = getNative();
        }
        return instance;
    }
    
    private static native Script getNative() /*-{
        return process.bindings('evals').Script;
    }-*/;
    
    protected Script() {
    }
    
    public final native <T extends JavaScriptObject> T runInThisContext(String code) /*-{
        return this.runInThisContext(code);
    }-*/;
    
    public final native <T extends JavaScriptObject> T runInThisContext(String code, 
            String filename) /*-{
        return this.runInThisContext(code, filename);
    }-*/;
    
    public final native <T extends JavaScriptObject> T runInNewContext(String code) /*-{
        return this.runInNewContext(code);
    }-*/;
    
    public final native <T extends JavaScriptObject> T runInNewContext(String code, 
            JavaScriptObject sandbox) /*-{
        return this.runInNewContext(code, sandbox);
    }-*/;
    
    public final native <T extends JavaScriptObject> T runInNewContext(String code, 
            JavaScriptObject sandbox, String filename) /*-{
        return this.runInNewContext(code, sandbox, filename);
    }-*/;
}
