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
package org.cretz.gwtnode.client.node.tty;

import org.cretz.gwtnode.client.JavaScriptUtils;
import org.cretz.gwtnode.client.node.Global;
import org.cretz.gwtnode.client.node.NodeJsModule;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayString;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.4.3/api/tty.html">tty</a>
 * module.
 * 
 * @author Chad Retz
 */
public class Tty extends JavaScriptObject implements NodeJsModule {

    private static Tty instance;
    
    public static Tty get() {
        if (instance == null) {
            instance = Global.get().require("tty");
        }
        return instance;
    }
    
    protected Tty() {
    }
    
    public final TtyProcess open(String path, String... args) {
        return open(path, JavaScriptUtils.toStringArray(args));
    }   

    public final native TtyProcess open(String path, JsArrayString args) /*-{
        var ttyProc = this.open(path, args);
        return @org.cretz.gwtnode.client.node.tty.TtyProcess::new(ILorg/cretz/gwtnode/client/node/childprocess/ChildProcess;)(
                ttyProc[0], ttyProc[1]);
    }-*/;
    
    public final native boolean isatty(int fd) /*-{
        return this.isatty(fd);
    }-*/;
    
    public final native void setRawMode(boolean mode) /*-{
        this.setRawMode(mode);
    }-*/;
    
    public final native void setWindowSize(int fd, int row, int col) /*-{
        this.setWindowSize(fd, row, col);
    }-*/;
    
    public final native JsArrayInteger getWindowSize(int fd) /*-{
        return this.getWindowSize(fd);
    }-*/;
}
