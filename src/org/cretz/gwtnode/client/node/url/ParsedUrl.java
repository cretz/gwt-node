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
package org.cretz.gwtnode.client.node.url;

import org.cretz.gwtnode.client.JsonStringObjectMap;

import com.google.gwt.core.client.JavaScriptObject;

public class ParsedUrl extends JavaScriptObject {

    protected ParsedUrl() {
    }
        
    public final native String href() /*-{
        return this.href;
    }-*/;
    
    public final native String protocol() /*-{
        return this.protocol;
    }-*/;
    
    public final native String host() /*-{
        return this.host;
    }-*/;
    
    public final native String auth() /*-{
        return this.auth;
    }-*/;
    
    public final native String hostname() /*-{
        return this.hostname;
    }-*/;
    
    public final native Integer port() /*-{
        return this.port;
    }-*/;
    
    public final native String pathname() /*-{
        return this.pathname;
    }-*/;
    
    public final native String string() /*-{
        return this.string;
    }-*/;
    
    public final JsonStringObjectMap<String[]> queryMap() {
        return new JsonStringObjectMap<String[]>(query());
    }
    
    public final native JavaScriptObject query() /*-{
        return this.query;
    }-*/;
    
    public final native String queryString() /*-{
        return this.query;
    }-*/;
    
    public final native String hash() /*-{
        return this.hash;
    }-*/;
}
