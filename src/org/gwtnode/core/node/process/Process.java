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
package org.gwtnode.core.node.process;

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.JavaScriptFunctionWrapper;
import org.gwtnode.core.meta.GwtNodeEvent;
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.meta.GwtNodeProperty;
import org.gwtnode.core.node.event.ErrorEventHandler;
import org.gwtnode.core.node.event.EventEmitter;
import org.gwtnode.core.node.event.ParameterlessEventHandler;
import org.gwtnode.core.node.stream.ReadableStream;
import org.gwtnode.core.node.stream.WritableStream;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * The node.js 
 * <a href="http://nodejs.org/docs/v0.5.6/api/process.html">process</a>
 * global object.
 * 
 * @author Chad Retz
 */
@GwtNodeObject("process")
public class Process extends EventEmitter {
    
    public static final native Process get() /*-{
        return process;
    }-*/;
    
    protected Process() {
    }
    
    @GwtNodeEvent
    public final void onExit(ParameterlessEventHandler handler) {
        on("exit", handler);
    }

    @GwtNodeEvent
    public final void onUncaughtException(ErrorEventHandler handler) {
        on("uncaughtException", handler);
    }
    
    @GwtNodeFunction("on")
    public final void onSignal(String signal, ParameterlessEventHandler handler) {
        on(signal, handler);
    }

    @GwtNodeProperty
    public final native WritableStream stdout() /*-{
        return this.stdout;
    }-*/;

    @GwtNodeProperty
    public final native WritableStream stderr() /*-{
        return this.stderr;
    }-*/;

    @GwtNodeProperty
    public final native ReadableStream stdin() /*-{
        return this.stdin;
    }-*/;
    
    @GwtNodeProperty
    public final native JsArrayString argv() /*-{
        return this.argv;
    }-*/;

    @GwtNodeProperty
    public final native String execPath() /*-{
        return this.execPath;
    }-*/;

    @GwtNodeFunction
    public final native void chdir(String dir) /*-{
        this.chdir(dir);
    }-*/;

    @GwtNodeFunction
    public final native String cwd() /*-{
        return this.cwd();
    }-*/;

    @GwtNodeFunction
    public final native JsArrayString env() /*-{
        return this.env;
    }-*/;

    @GwtNodeFunction
    public final native void exit() /*-{
        process.exit();
    }-*/;

    @GwtNodeFunction
    public final native void exit(int code) /*-{
        process.exit(code);
    }-*/;

    @GwtNodeFunction
    public final native int getgid() /*-{
        return process.getgid();
    }-*/;

    @GwtNodeFunction
    public final native void setgid(int id) /*-{
        process.setgid(id);
    }-*/;

    @GwtNodeFunction
    public final native void setgid(String id) /*-{
        process.setgid(id);
    }-*/;

    @GwtNodeFunction
    public final native int getuid() /*-{
        return process.getuid();
    }-*/;

    @GwtNodeFunction
    public final native void setuid(int id) /*-{
        process.setuid(id);
    }-*/;

    @GwtNodeFunction
    public final native void setuid(String id) /*-{
        process.setuid(id);
    }-*/;

    @GwtNodeProperty
    public final native String version() /*-{
        return process.version;
    }-*/;
    
    @GwtNodeProperty
    public final native JavaScriptObject versions() /*-{
        return process.versions;
    }-*/;
    
    @GwtNodeProperty
    public final native String installPrefix() /*-{
        return process.installPrefix;
    }-*/;

    @GwtNodeFunction
    public final native void kill(int pid) /*-{
        process.kill(pid);
    }-*/;

    @GwtNodeFunction
    public final native void kill(int pid, String signal) /*-{
        process.kill(pid, signal);
    }-*/;

    @GwtNodeProperty
    public final native int pid() /*-{
        return process.pid;
    }-*/;

    @GwtNodeProperty
    public final native String title() /*-{
        return process.title;
    }-*/;

    @GwtNodeProperty
    public final native void title(String title) /*-{
        process.title = title;
    }-*/;

    @GwtNodeProperty
    public final native String arch() /*-{
        return process.arch;
    }-*/;

    @GwtNodeProperty
    public final native String platform() /*-{
        return process.platform;
    }-*/;

    @GwtNodeFunction
    public final native MemoryUsage memoryUsage() /*-{
        return process.memoryUsage();
    }-*/;

    @GwtNodeFunction
    public final void nextTick(ParameterlessEventHandler handler) {
        nextTick(handler.getNativeFunction());
    }
    
    @GwtNodeFunction
    public final void nextTick(JavaScriptFunctionWrapper wrapper) {
        nextTick(wrapper.getNativeFunction());
    }
    
    @GwtNodeFunction
    public final native void nextTick(JavaScriptFunction func) /*-{
        process.nextTick(func);
    }-*/;
    
    @GwtNodeFunction
    public final native int umask() /*-{
        return process.umask();
    }-*/;

    @GwtNodeFunction
    public final native int umask(int mask) /*-{
        return process.umask(mask);
    }-*/;

    //TODO: should return a double?
    @GwtNodeFunction
    public final native int uptime() /*-{
        return process.uptime();
    }-*/;
}
