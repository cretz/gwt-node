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
package org.gwtnode.client.node.fs;

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
