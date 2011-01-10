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

import org.cretz.gwtnode.client.JavaScriptFunction;
import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;
import org.cretz.gwtnode.client.node.Global;
import org.cretz.gwtnode.client.node.NodeJsModule;
import org.cretz.gwtnode.client.node.crypto.Credentials;

import com.google.gwt.core.client.JavaScriptObject;

public class Http extends JavaScriptObject implements NodeJsModule {

    private static Http instance;
    
    public static Http get() {
        if (instance == null) {
            instance = Global.get().require("http");
        }
        return instance;
    }

    protected Http() {
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
    
    public final native Client createClient(int port) /*-{
        return this.createClient(port);
    }-*/;
    
    public final native Client createClient(int port, String host) /*-{
        return this.createClient(port, host);
    }-*/;
    
    public final native Client createClient(int port, String host, boolean secure) /*-{
        return this.createClient(port, host, secure);
    }-*/;
    
    public final native Client createClient(int port, String host, 
            boolean secure, Credentials credentials) /*-{
        return this.createClient(port, host, secure, credentials);
    }-*/;
}
