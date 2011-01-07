package org.cretz.gwtnode.client.node.fs;

import com.google.gwt.core.client.JavaScriptObject;

public class Stat extends JavaScriptObject {

    protected Stat() {
    }
    
    public native int dev() /*-{
        return this.dev;
    }-*/;
    
    public native int ino() /*-{
        return this.ino;
    }-*/;
    
    public native int mode() /*-{
        return this.mode;
    }-*/;
    
    public native int nlink() /*-{
        return this.nlink;
    }-*/;
    
    public native int uid() /*-{
        return this.uid;
    }-*/;
    
    public native int gid() /*-{
        return this.gid;
    }-*/;
    
    public native int rdev() /*-{
        return this.rdev;
    }-*/;
    
    public native int size() /*-{
        return this.size;
    }-*/;
    
    public native int blksize() /*-{
        return this.blksize;
    }-*/;
    
    public native int blocks() /*-{
        return this.blocks;
    }-*/;
    
    public native String atime() /*-{
        return this.atime;
    }-*/;
    
    public native String mtime() /*-{
        return this.mtime;
    }-*/;
    
    public native String ctime() /*-{
        return this.ctime;
    }-*/;
    
//    * stats.isFile()
    public native boolean isFile() /*-{
        return this.isFile();
    }-*/;
//    * stats.isDirectory()
    public native boolean isDirectory() /*-{
        return this.isDirectory();
    }-*/;
//    * stats.isBlockDevice()

    public native boolean isBlockDevice() /*-{
        return this.isBlockDevice();
    }-*/;
    
//    * stats.isCharacterDevice()
    

    public native boolean isCharacterDevice() /*-{
        return this.isCharacterDevice();
    }-*/;
//    * stats.isSymbolicLink() (only valid with fs.lstat())

    public native boolean isSymbolicLink() /*-{
        return this.isSymbolicLink();
    }-*/;
//    * stats.isFIFO()

    public native boolean isFIFO() /*-{
        return this.isFIFO();
    }-*/;
//    * stats.isSocket()
    

    public native boolean isSocket() /*-{
        return this.isSocket();
    }-*/;
}
