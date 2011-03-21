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
package org.cretz.gwtnode.client.node.tls;

import org.cretz.gwtnode.client.node.buffer.Buffer;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

/**
 * @author Chad Retz
 * @since 0.2.0
 */
public class ConnectOptions extends JavaScriptObject {

    @SuppressWarnings("unchecked")
    public static final <T extends ConnectOptions> T create() {
        return (T) JavaScriptObject.createObject();
    }

    public static final native <T extends ConnectOptions> T create(
            String key, String cert) /*-{
        return {
            'key' : key,
            'cert' : cert,
        };
    }-*/;
    
    public static final native <T extends ConnectOptions> T create(
            Buffer key, Buffer cert) /*-{
        return {
            'key' : key,
            'cert' : cert,
        };
    }-*/;
    
    public static final native <T extends ConnectOptions> T create(
            String key, String cert, JsArrayString ca) /*-{
        return {
            'key' : key,
            'cert' : cert,
            'ca' : ca
        };
    }-*/;
    
    public static final native <T extends ConnectOptions> T create(
            Buffer key, Buffer cert, JsArray<Buffer> ca) /*-{
        return {
            'key' : key,
            'cert' : cert,
            'ca' : ca
        };
    }-*/;
    
    protected ConnectOptions() {
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

    public final native JsArrayString caStringArray() /*-{
        return this.ca;
    }-*/;
    
    public final native void caStringArray(JsArrayString ca) /*-{
        this.ca = ca;
    }-*/;
    
    public final native JsArray<Buffer> caBufferArray() /*-{
        return this.ca;
    }-*/;
    
    public final native void caBufferArray(JsArray<Buffer> ca) /*-{
        this.ca = ca;
    }-*/;
    
}
