/*
 * Copyright 2011 Chad Retz
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
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
