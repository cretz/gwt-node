package org.cretz.gwtnode.client.node.script;

import com.google.gwt.core.client.JavaScriptObject;

public class CompiledScript extends JavaScriptObject {
    
    public static native CompiledScript create(String code) /*-{
        return new Script(code);
    }-*/;
    
    public static native CompiledScript create(String code, String filename) /*-{
        return new Script(code, filename);
    }-*/;
    
    protected CompiledScript() {
    }
    
    public final native <T extends JavaScriptObject> T runInThisContext() /*-{
        return this.runInThisContext();
    }-*/;
    
    public final native <T extends JavaScriptObject> T runInNewContext(
            JavaScriptObject sandbox) /*-{
        return this.runInNewContext(sandbox);
    }-*/;
}
