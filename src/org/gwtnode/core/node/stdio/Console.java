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
package org.gwtnode.core.node.stdio;

import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.6/api/stdio.html#console">console</a> object
 *
 * @author Chad Retz
 */
@GwtNodeObject
public class Console extends JavaScriptObject {
    
    public static final native Console get() /*-{
        return console;
    }-*/;

    protected Console() {
    }
    
    @GwtNodeFunction
    public final native void log(String... params) /*-{
        this.log.apply(this, params);
    }-*/;
    
    @GwtNodeFunction
    public final native void info(String... params) /*-{
        this.info.apply(this, params);
    }-*/;
    
    @GwtNodeFunction
    public final native void warn(String... params) /*-{
        this.warn.apply(this, params);
    }-*/;
    
    @GwtNodeFunction
    public final native void error(String... params) /*-{
        this.error.apply(this, params);
    }-*/;
    
    @GwtNodeFunction
    public final native void dir(JavaScriptObject obj) /*-{
        this.dir(obj);
    }-*/;
    
    @GwtNodeFunction
    public final native void time(String label) /*-{
        this.time(label);
    }-*/;
    
    @GwtNodeFunction
    public final native void timeEnd(String label) /*-{
        this.timeEnd(label);
    }-*/;
    
    @GwtNodeFunction
    public final native void trace() /*-{
        this.trace();
    }-*/;
    
    @GwtNodeFunction
    public final native void assertOk() /*-{
        this.assert();
    }-*/;
}
