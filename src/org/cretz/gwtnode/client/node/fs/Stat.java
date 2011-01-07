package org.cretz.gwtnode.client.node.fs;

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
    
//    * stats.isFile()
    public final native boolean isFile() /*-{
        return this.isFile();
    }-*/;
//    * stats.isDirectory()
    public final native boolean isDirectory() /*-{
        return this.isDirectory();
    }-*/;
//    * stats.isBlockDevice()

    public final native boolean isBlockDevice() /*-{
        return this.isBlockDevice();
    }-*/;
    
//    * stats.isCharacterDevice()
    

    public final native boolean isCharacterDevice() /*-{
        return this.isCharacterDevice();
    }-*/;
//    * stats.isSymbolicLink() (only valid with fs.lstat())

    public final native boolean isSymbolicLink() /*-{
        return this.isSymbolicLink();
    }-*/;
//    * stats.isFIFO()

    public final native boolean isFIFO() /*-{
        return this.isFIFO();
    }-*/;
//    * stats.isSocket()
    

    public final native boolean isSocket() /*-{
        return this.isSocket();
    }-*/;
}
