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
package org.cretz.gwtnode.client.node.childprocess;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayString;

/**
 * Options for the spawn method in {@link ChildProcess}.
 * 
 * @author Chad Retz
 */
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
