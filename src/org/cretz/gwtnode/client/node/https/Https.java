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
package org.cretz.gwtnode.client.node.https;

import org.cretz.gwtnode.client.JavaScriptFunction;
import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;
import org.cretz.gwtnode.client.node.Global;
import org.cretz.gwtnode.client.node.NodeJsModule;
import org.cretz.gwtnode.client.node.http.ClientRequest;
import org.cretz.gwtnode.client.node.http.ClientResponseEventHandler;
import org.cretz.gwtnode.client.node.http.HttpRequestOptions;
import org.cretz.gwtnode.client.node.http.Server;
import org.cretz.gwtnode.client.node.http.ServerRequestEventHandler;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.4.3/api/https.html">https</a>
 * module.
 * 
 * @author Chad Retz
 */
public class Https extends JavaScriptObject implements NodeJsModule {

    private static Https instance;
    
    public static Https get() {
        if (instance == null) {
            instance = Global.get().require("https");
        }
        return instance;
    }

    protected Https() {
    }
    
    public final Server createServer(JavaScriptFunctionWrapper requestListener) {
        return createServer(requestListener.getNativeFunction());
    }
    
    public final Server createServer(ServerRequestEventHandler requestListener) {
        return createServer(requestListener.getNativeFunction());
    }
    
    public final native Server createServer(JavaScriptFunction requestListener) /*-{
        return this.createServer(requestListener);
    }-*/;

    public final ClientRequest request(HttpRequestOptions options, 
            ClientResponseEventHandler callback) {
        return request(options, callback.getNativeFunction());
    }
    
    public final ClientRequest request(HttpRequestOptions options, 
            JavaScriptFunctionWrapper callback) {
        return request(options, callback.getNativeFunction());
    }
    
    public final native ClientRequest request(HttpRequestOptions options,
            JavaScriptFunction callback) /*-{
        return this.request(options, callback);
    }-*/;

    public final ClientRequest get(HttpRequestOptions options, 
            ClientResponseEventHandler callback) {
        return get(options, callback.getNativeFunction());
    }
    
    public final ClientRequest get(HttpRequestOptions options, 
            JavaScriptFunctionWrapper callback) {
        return get(options, callback.getNativeFunction());
    }
    
    public final native ClientRequest get(HttpRequestOptions options,
            JavaScriptFunction callback) /*-{
        return this.get(options, callback);
    }-*/;
}
