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
package org.gwtnode.client.node.https;

import org.gwtnode.client.node.buffer.Buffer;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Chad Retz
 */
public class CreateServerOptions extends JavaScriptObject {
    
    public static final CreateServerOptions create() {
        return (CreateServerOptions) JavaScriptObject.createObject();
    }
    
    protected CreateServerOptions() {
    }
    
    public final native String keyString() /*-{
        return this.key;
    }-*/;
    
    public final native void keyString(String key) /*-{
        this.key = key;
    }-*/;
    
    public final native Buffer keyBuffer() /*-{
        return this.key;
    }-*/;
    
    public final native void keyBuffer(Buffer key) /*-{
        this.key = key;
    }-*/;

    public final native String certString() /*-{
        return this.cert;
    }-*/;
    
    public final native void certString(String cert) /*-{
        this.cert = cert;
    }-*/;
    
    public final native Buffer certBuffer() /*-{
        return this.cert;
    }-*/;
    
    public final native void certBuffer(Buffer cert) /*-{
        this.cert = cert;
    }-*/;
}
