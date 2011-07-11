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

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

/**
 * @author Chad Retz
 */
public class ServerOptions extends ConnectOptions {

    public static final native ServerOptions create(
            String key, String cert, boolean requestCert, boolean rejectUnauthorized) /*-{
        return {
            'key' : key,
            'cert' : cert,
            'requestCert' : requestCert,
            'rejectUnauthorized' : rejectUnauthorized
        };
    }-*/;
    
    public static final native ServerOptions create(
            Buffer key, Buffer cert, boolean requestCert, boolean rejectUnauthorized) /*-{
        return {
            'key' : key,
            'cert' : cert,
            'requestCert' : requestCert,
            'rejectUnauthorized' : rejectUnauthorized
        };
    }-*/;
    
    public static final native ServerOptions create(
            String key, String cert, JsArrayString ca, 
            boolean requestCert, boolean rejectUnauthorized) /*-{
        return {
            'key' : key,
            'cert' : cert,
            'ca' : ca,
            'requestCert' : requestCert,
            'rejectUnauthorized' : rejectUnauthorized
        };
    }-*/;
    
    public static final native ServerOptions create(
            Buffer key, Buffer cert, JsArray<Buffer> ca, 
            boolean requestCert, boolean rejectUnauthorized) /*-{
        return {
            'key' : key,
            'cert' : cert,
            'ca' : ca,
            'requestCert' : requestCert,
            'rejectUnauthorized' : rejectUnauthorized
        };
    }-*/;
    
    protected ServerOptions() {
    }
    
    public final native boolean requestCert() /*-{
        return this.requestCert != undefined && this.requestCert;
    }-*/;
    
    public final native void requestCert(boolean requestCert) /*-{
        this.requestCert = requestCert;
    }-*/;
    
    public final native boolean rejectUnauthorized() /*-{
        return this.rejectUnauthorized != undefined && this.rejectUnauthorized;
    }-*/;
    
    public final native void rejectUnauthorized(boolean rejectUnauthorized) /*-{
        this.rejectUnauthorized = rejectUnauthorized;
    }-*/;
    
}
