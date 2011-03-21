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
package org.cretz.gwtnode.client.node.http;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Chad Retz
 * @since 0.2.0
 */
public class HttpRequestOptions extends JavaScriptObject {
    
    public static HttpRequestOptions create() {
        return JavaScriptObject.createObject().cast();
    }

    protected HttpRequestOptions() {
    }
    
    public final native String host() /*-{
        return this.host;
    }-*/;
    
    public final native void host(String host) /*-{
        this.host = host;
    }-*/;
    
    public final native Integer port() /*-{
        return this.port;
    }-*/;
    
    public final native void port(int port) /*-{
        this.port = port;
    }-*/;
    
    public final native String path() /*-{
        return this.path;
    }-*/;
    
    public final native void path(String path) /*-{
        this.path = path;
    }-*/;
    
    public final native String method() /*-{
        return this.method;
    }-*/;
    
    public final native void method(String method) /*-{
        this.method = method;
    }-*/;
}
