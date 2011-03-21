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
package org.cretz.gwtnode.client.node.dns;

import org.cretz.gwtnode.client.JavaScriptFunction;
import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;
import org.cretz.gwtnode.client.node.Global;
import org.cretz.gwtnode.client.node.NodeJsModule;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.4.3/api/dns.html">dns</a>
 * module.
 * 
 * @author Chad Retz
 */
public class Dns extends JavaScriptObject implements NodeJsModule {

    private static Dns instance;
    
    public static Dns get() {
        if (instance == null) {
            instance = Global.get().require("dns");
        }
        return instance;
    }
    
    protected Dns() {
    }
    
    public final void lookup(String domain, LookupEventHandler callback) {
        lookup(domain, callback.getNativeFunction());
    }
    
    public final void lookup(String domain, JavaScriptFunctionWrapper callback) {
        lookup(domain, callback.getNativeFunction());
    }
    
    public final native void lookup(String domain, JavaScriptFunction callback) /*-{
        this.lookup(domain, callback);
    }-*/;
    
    public final void lookup(String domain, int family, LookupEventHandler callback) {
        lookup(domain, family, callback.getNativeFunction());
    }
    
    public final void lookup(String domain, int family, JavaScriptFunctionWrapper callback) {
        lookup(domain, family, callback.getNativeFunction());
    }
    
    public final native void lookup(String domain, int family, JavaScriptFunction callback) /*-{
        this.lookup(domain, family, callback);
    }-*/;
    
    public final void resolve(String domain, ResolveEventHandler callback) {
        resolve(domain, callback.getNativeFunction());
    }
    
    public final void resolve(String domain, JavaScriptFunctionWrapper callback) {
        resolve(domain, callback.getNativeFunction());
    }
    
    public final native void resolve(String domain, JavaScriptFunction callback) /*-{
        this.resolve(domain, callback);
    }-*/;
    
    public final void resolve(String domain, String rrtype, ResolveEventHandler callback) {
        resolve(domain, rrtype, callback.getNativeFunction());
    }
    
    public final void resolve(String domain, String rrtype, JavaScriptFunctionWrapper callback) {
        resolve(domain, rrtype, callback.getNativeFunction());
    }
    
    public final native void resolve(String domain, String rrtype, JavaScriptFunction callback) /*-{
        this.resolve(domain, rrtype, callback);
    }-*/;
    
    public final void resolve4(String domain, ResolveStringEventHandler callback) {
        resolve4(domain, callback.getNativeFunction());
    }
    
    public final void resolve4(String domain, JavaScriptFunctionWrapper callback) {
        resolve4(domain, callback.getNativeFunction());
    }
    
    public final native void resolve4(String domain, JavaScriptFunction callback) /*-{
        this.resolve4(domain, callback);
    }-*/;
    
    public final void resolve6(String domain, ResolveStringEventHandler callback) {
        resolve6(domain, callback.getNativeFunction());
    }
    
    public final void resolve6(String domain, JavaScriptFunctionWrapper callback) {
        resolve6(domain, callback.getNativeFunction());
    }
    
    public final native void resolve6(String domain, JavaScriptFunction callback) /*-{
        this.resolve6(domain, callback);
    }-*/;
    
    public final void resolveMx(String domain, ResolveMxEventHandler callback) {
        resolveMx(domain, callback.getNativeFunction());
    }
    
    public final void resolveMx(String domain, JavaScriptFunctionWrapper callback) {
        resolveMx(domain, callback.getNativeFunction());
    }
    
    public final native void resolveMx(String domain, JavaScriptFunction callback) /*-{
        this.resolveMx(domain, callback);
    }-*/;
    
    public final void resolveTxt(String domain, ResolveStringEventHandler callback) {
        resolveTxt(domain, callback.getNativeFunction());
    }
    
    public final void resolveTxt(String domain, JavaScriptFunctionWrapper callback) {
        resolveTxt(domain, callback.getNativeFunction());
    }
    
    public final native void resolveTxt(String domain, JavaScriptFunction callback) /*-{
        this.resolveTxt(domain, callback);
    }-*/;
    
    public final void resolveSrv(String domain, ResolveSrvEventHandler callback) {
        resolveSrv(domain, callback.getNativeFunction());
    }
    
    public final void resolveSrv(String domain, JavaScriptFunctionWrapper callback) {
        resolveSrv(domain, callback.getNativeFunction());
    }
    
    public final native void resolveSrv(String domain, JavaScriptFunction callback) /*-{
        this.resolveSrv(domain, callback);
    }-*/;
    
    public final void reverse(String ip, ResolveStringEventHandler callback) {
        reverse(ip, callback.getNativeFunction());
    }
    
    public final void reverse(String ip, JavaScriptFunctionWrapper callback) {
        reverse(ip, callback.getNativeFunction());
    }
    
    public final native void reverse(String ip, JavaScriptFunction callback) /*-{
        this.reverse(ip, callback);
    }-*/;
}
