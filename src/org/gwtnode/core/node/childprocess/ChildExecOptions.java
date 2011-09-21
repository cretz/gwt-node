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
package org.gwtnode.core.node.childprocess;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * Options object used in the exec method of the 
 * {@link ChildProcess}.
 * 
 * @author Chad Retz
 */
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
