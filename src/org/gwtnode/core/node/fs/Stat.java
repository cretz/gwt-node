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
package org.gwtnode.core.node.fs;

import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.meta.GwtNodeProperty;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Chad Retz
 */
@GwtNodeObject("Stats")
public class Stat extends JavaScriptObject {

    protected Stat() {
    }
    
    @GwtNodeProperty
    public final native int dev() /*-{
        return this.dev;
    }-*/;

    @GwtNodeProperty
    public final native int ino() /*-{
        return this.ino;
    }-*/;

    @GwtNodeProperty
    public final native int mode() /*-{
        return this.mode;
    }-*/;

    @GwtNodeProperty
    public final native int nlink() /*-{
        return this.nlink;
    }-*/;

    @GwtNodeProperty
    public final native int uid() /*-{
        return this.uid;
    }-*/;

    @GwtNodeProperty
    public final native int gid() /*-{
        return this.gid;
    }-*/;

    @GwtNodeProperty
    public final native int rdev() /*-{
        return this.rdev;
    }-*/;

    @GwtNodeProperty
    public final native int size() /*-{
        return this.size;
    }-*/;

    @GwtNodeProperty
    public final native int blksize() /*-{
        return this.blksize;
    }-*/;

    @GwtNodeProperty
    public final native int blocks() /*-{
        return this.blocks;
    }-*/;

    @GwtNodeProperty
    public final native String atime() /*-{
        return this.atime;
    }-*/;

    @GwtNodeProperty
    public final native String mtime() /*-{
        return this.mtime;
    }-*/;

    @GwtNodeProperty
    public final native String ctime() /*-{
        return this.ctime;
    }-*/;

    @GwtNodeProperty
    public final native boolean isFile() /*-{
        return this.isFile();
    }-*/;

    @GwtNodeProperty
    public final native boolean isDirectory() /*-{
        return this.isDirectory();
    }-*/;

    @GwtNodeProperty
    public final native boolean isBlockDevice() /*-{
        return this.isBlockDevice();
    }-*/;

    @GwtNodeProperty
    public final native boolean isCharacterDevice() /*-{
        return this.isCharacterDevice();
    }-*/;

    @GwtNodeProperty
    public final native boolean isSymbolicLink() /*-{
        return this.isSymbolicLink();
    }-*/;

    @GwtNodeProperty
    public final native boolean isFIFO() /*-{
        return this.isFIFO();
    }-*/;

    @GwtNodeProperty
    public final native boolean isSocket() /*-{
        return this.isSocket();
    }-*/;
}
