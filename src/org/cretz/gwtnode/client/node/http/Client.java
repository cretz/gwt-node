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

import org.cretz.gwtnode.client.JsonStringObjectMap;
import org.cretz.gwtnode.client.node.event.EventEmitter;

import com.google.gwt.core.client.JavaScriptObject;

public class Client extends EventEmitter {

    protected Client() {
    }
    
    public final void onUpgrade(ClientUpgradeEventHandler handler) {
        on("upgrade", handler);
    }
    
    //client.request(method='GET', path, [request_headers])
    
    public final native ClientRequest request(String path) /*-{
        return this.request(path);
    }-*/;
    
    public final native ClientRequest request(String method, String path) /*-{
        return this.request(method, path);
    }-*/;
    
    public final ClientRequest request(String method, String path,
            JsonStringObjectMap<String> requestHeaders) {
        return request(method, path, requestHeaders.getNativeObject());
    }
    
    public final native ClientRequest request(String method, String path,
            JavaScriptObject requestHeaders) /*-{
        return this.request(method, path, requestHeaders);
    }-*/;
    
    public final native boolean verifyPeer() /*-{
        return this.verifyPeer();
    }-*/;
    
    public final native Certificate getPeerCertificate() /*-{
        return this.getPeerCertificate();
    }-*/;
}
