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
package org.gwtnode.core.node.dns;

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.JavaScriptFunctionWrapper;
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeModule;
import org.gwtnode.core.node.Global;
import org.gwtnode.core.node.NodeJsModule;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.6/api/dns.html">dns</a>
 * module.
 * 
 * @author Chad Retz
 */
@GwtNodeModule
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

    @GwtNodeFunction
    public final void lookup(String domain, LookupEventHandler callback) {
        lookup(domain, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void lookup(String domain, JavaScriptFunctionWrapper callback) {
        lookup(domain, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void lookup(String domain, JavaScriptFunction callback) /*-{
        this.lookup(domain, callback);
    }-*/;

    @GwtNodeFunction
    public final void lookup(String domain, int family, LookupEventHandler callback) {
        lookup(domain, family, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void lookup(String domain, int family, JavaScriptFunctionWrapper callback) {
        lookup(domain, family, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void lookup(String domain, int family, JavaScriptFunction callback) /*-{
        this.lookup(domain, family, callback);
    }-*/;

    @GwtNodeFunction
    public final void resolve(String domain, ResolveEventHandler callback) {
        resolve(domain, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void resolve(String domain, JavaScriptFunctionWrapper callback) {
        resolve(domain, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void resolve(String domain, JavaScriptFunction callback) /*-{
        this.resolve(domain, callback);
    }-*/;

    @GwtNodeFunction
    public final void resolve(String domain, String rrtype, ResolveEventHandler callback) {
        resolve(domain, rrtype, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void resolve(String domain, String rrtype, JavaScriptFunctionWrapper callback) {
        resolve(domain, rrtype, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void resolve(String domain, String rrtype, JavaScriptFunction callback) /*-{
        this.resolve(domain, rrtype, callback);
    }-*/;

    @GwtNodeFunction
    public final void resolve4(String domain, ResolveStringEventHandler callback) {
        resolve4(domain, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void resolve4(String domain, JavaScriptFunctionWrapper callback) {
        resolve4(domain, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void resolve4(String domain, JavaScriptFunction callback) /*-{
        this.resolve4(domain, callback);
    }-*/;

    @GwtNodeFunction
    public final void resolve6(String domain, ResolveStringEventHandler callback) {
        resolve6(domain, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void resolve6(String domain, JavaScriptFunctionWrapper callback) {
        resolve6(domain, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void resolve6(String domain, JavaScriptFunction callback) /*-{
        this.resolve6(domain, callback);
    }-*/;

    @GwtNodeFunction
    public final void resolveMx(String domain, ResolveMxEventHandler callback) {
        resolveMx(domain, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void resolveMx(String domain, JavaScriptFunctionWrapper callback) {
        resolveMx(domain, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void resolveMx(String domain, JavaScriptFunction callback) /*-{
        this.resolveMx(domain, callback);
    }-*/;

    @GwtNodeFunction
    public final void resolveTxt(String domain, ResolveStringEventHandler callback) {
        resolveTxt(domain, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void resolveTxt(String domain, JavaScriptFunctionWrapper callback) {
        resolveTxt(domain, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void resolveTxt(String domain, JavaScriptFunction callback) /*-{
        this.resolveTxt(domain, callback);
    }-*/;

    @GwtNodeFunction
    public final void resolveSrv(String domain, ResolveSrvEventHandler callback) {
        resolveSrv(domain, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void resolveSrv(String domain, JavaScriptFunctionWrapper callback) {
        resolveSrv(domain, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void resolveSrv(String domain, JavaScriptFunction callback) /*-{
        this.resolveSrv(domain, callback);
    }-*/;

    @GwtNodeFunction
    public final void reverse(String ip, ResolveStringEventHandler callback) {
        reverse(ip, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void reverse(String ip, JavaScriptFunctionWrapper callback) {
        reverse(ip, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void reverse(String ip, JavaScriptFunction callback) /*-{
        this.reverse(ip, callback);
    }-*/;

    @GwtNodeFunction
    public final void resolveNs(String domain, ResolveStringEventHandler callback) {
        resolveNs(domain, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void resolveNs(String domain, JavaScriptFunctionWrapper callback) {
        resolveNs(domain, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void resolveNs(String domain, JavaScriptFunction callback) /*-{
        this.resolveNs(domain, callback);
    }-*/;

    @GwtNodeFunction
    public final void resolveCname(String domain, ResolveStringEventHandler callback) {
        resolveCname(domain, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void resolveCname(String domain, JavaScriptFunctionWrapper callback) {
        resolveCname(domain, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void resolveCname(String domain, JavaScriptFunction callback) /*-{
        this.resolveCname(domain, callback);
    }-*/;
}
