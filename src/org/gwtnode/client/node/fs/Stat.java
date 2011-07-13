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
package org.gwtnode.client.node.fs;

import com.google.gwt.core.client.JavaScriptObject;

public class Stat extends JavaScriptObject {

    protected Stat() {
    }
    
    public final native int dev() /*-{
        return this.dev;
    }-*/;
    
    public final native int ino() /*-{
        return this.ino;
    }-*/;
    
    public final native int mode() /*-{
        return this.mode;
    }-*/;
    
    public final native int nlink() /*-{
        return this.nlink;
    }-*/;
    
    public final native int uid() /*-{
        return this.uid;
    }-*/;
    
    public final native int gid() /*-{
        return this.gid;
    }-*/;
    
    public final native int rdev() /*-{
        return this.rdev;
    }-*/;
    
    public final native int size() /*-{
        return this.size;
    }-*/;
    
    public final native int blksize() /*-{
        return this.blksize;
    }-*/;
    
    public final native int blocks() /*-{
        return this.blocks;
    }-*/;
    
    public final native String atime() /*-{
        return this.atime;
    }-*/;
    
    public final native String mtime() /*-{
        return this.mtime;
    }-*/;
    
    public final native String ctime() /*-{
        return this.ctime;
    }-*/;
    
    public final native boolean isFile() /*-{
        return this.isFile();
    }-*/;

    public final native boolean isDirectory() /*-{
        return this.isDirectory();
    }-*/;

    public final native boolean isBlockDevice() /*-{
        return this.isBlockDevice();
    }-*/;

    public final native boolean isCharacterDevice() /*-{
        return this.isCharacterDevice();
    }-*/;

    public final native boolean isSymbolicLink() /*-{
        return this.isSymbolicLink();
    }-*/;

    public final native boolean isFIFO() /*-{
        return this.isFIFO();
    }-*/;

    public final native boolean isSocket() /*-{
        return this.isSocket();
    }-*/;
}
