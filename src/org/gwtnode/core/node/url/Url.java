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
package org.gwtnode.core.node.url;

import org.gwtnode.core.node.Global;
import org.gwtnode.core.node.NodeJsModule;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.6/api/url.html">url</a>
 * module.
 *
 * @author Chad Retz
 */
public class Url extends JavaScriptObject implements NodeJsModule {

    private static Url instance;
    
    public static Url get() {
        if (instance == null) {
            instance = Global.get().require("url");
        }
        return instance;
    }
    
    protected Url() {
    }
    
    public final native ParsedUrl parse(String url) /*-{
        return this.parse(url);
    }-*/;
    
    public final native ParsedUrl parse(String url, boolean parseQueryString) /*-{
        return this.parse(url, parseQueryString);
    }-*/;
    
    public final native ParsedUrl parse(String url, boolean parseQueryString, 
            boolean slashesDenoteHost) /*-{
        return this.parse(url, parseQueryString, slashesDenoteHost);
    }-*/;
    
    public final native String format(ParsedUrl urlObj) /*-{
        return this.format(urlObj);
    }-*/;
    
    public final native String resolve(ParsedUrl from, ParsedUrl to) /*-{
        return this.resolve(from, to);
    }-*/;
}
