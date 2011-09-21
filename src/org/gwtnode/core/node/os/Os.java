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
package org.gwtnode.core.node.os;

import org.gwtnode.core.JsonStringObjectMap;
import org.gwtnode.core.node.Global;
import org.gwtnode.core.node.NodeJsModule;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.6/api/os.html">os</a>
 * module.
 * 
 * @author Chad Retz
 */
public class Os extends JavaScriptObject implements NodeJsModule {

    private static Os instance;
    
    public static Os get() {
        if (instance == null) {
            instance = Global.get().require("os");
        }
        return instance;
    }
    
    protected Os() {
    }

    public final native String hostname() /*-{
        return this.hostname();
    }-*/;

    public final native String type() /*-{
        return this.type();
    }-*/;

    public final native String platform() /*-{
        return this.platform();
    }-*/;

    public final native String arch() /*-{
        return this.arch();
    }-*/;

    public final native String release() /*-{
        return this.release();
    }-*/;

    public final native double uptime() /*-{
        return this.uptime();
    }-*/;

    public final native JsArrayNumber loadavg() /*-{
        return this.loadavg();
    }-*/;

    public final native double totalmem() /*-{
        return this.totalmem();
    }-*/;

    public final native double freemem() /*-{
        return this.freemem();
    }-*/;

    public final native JsArray<Cpu> cpus() /*-{
        return this.cpus();
    }-*/;
    
    public final JsonStringObjectMap<JsArray<NetworkInterfaceAddress>> getNetworkInterfacesMap() {
        return new JsonStringObjectMap<JsArray<NetworkInterfaceAddress>>(getNetworkInterfaces());
    }
    
    public final native JavaScriptObject getNetworkInterfaces() /*-{
        return this.getNetworkInterfaces();
    }-*/;
}
