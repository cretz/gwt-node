package org.cretz.gwtnode.client.node.fs;

import org.cretz.gwtnode.client.JavaScriptFunction;
import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;
import org.cretz.gwtnode.client.node.Buffer;
import org.cretz.gwtnode.client.node.Global;
import org.cretz.gwtnode.client.node.NodeJsModule;
import org.cretz.gwtnode.client.node.stream.ReadableStream;
import org.cretz.gwtnode.client.node.stream.WriteableStream;

import com.google.gwt.core.client.JsArrayString;

public class Fs extends NodeJsModule {

    private static Fs instance;
    
    public static Fs get() {
        if (instance == null) {
            instance = Global.get().require("fs");
        }
        return instance;
    }
    
    protected Fs() {
    }
    
    public final native void rename(String path1, String path2) /*-{
        this.rename(path1, path2);
    }-*/;
    
    public final void rename(String path1, String path2, 
            JavaScriptFunctionWrapper callback) {
        rename(path1, path2, callback.getNativeFunction());
    }
    
    public final void rename(String path1, String path2, 
            FsEventHandler callback) {
        rename(path1, path2, callback.getNativeFunction());
    }
    
    public final native void rename(String path1, String path2, 
            JavaScriptFunction callback) /*-{
        this.rename(path1, path2, callback);
    }-*/;
    
    public final native void renameSync(String path1, String path2) /*-{
        this.renameSync(path1, path2);
    }-*/;

    public final native void truncate(int fd, int len) /*-{
        this.truncate(fd, len);
    }-*/;
    
    public final void truncate(int fd, int len, 
            JavaScriptFunctionWrapper callback) {
        truncate(fd, len, callback.getNativeFunction());
    }
    
    public final void truncate(int fd, int len, 
            FsEventHandler callback) {
        truncate(fd, len, callback.getNativeFunction());
    }
    
    public final native void truncate(int fd, int len, 
            JavaScriptFunction callback) /*-{
        this.chmod(fd, len, callback);
    }-*/;
    
    public final native void truncateSync(int fd, int len) /*-{
        this.chmodSync(fd, len);
    }-*/;

    public final native void chmod(String path, int mode) /*-{
        this.chmod(path, mode);
    }-*/;
    
    public final void chmod(String path, int mode, 
            JavaScriptFunctionWrapper callback) {
        chmod(path, mode, callback.getNativeFunction());
    }
    
    public final void chmod(String path, int mode, 
            FsEventHandler callback) {
        chmod(path, mode, callback.getNativeFunction());
    }
    
    public final native void chmod(String path, int mode, 
            JavaScriptFunction callback) /*-{
        this.chmod(path, mode, callback);
    }-*/;
    
    public final native void chmodSync(String path, int mode) /*-{
        this.chmodSync(path, mode);
    }-*/;
    
    public final native void stat(String path) /*-{
        this.stat(path);
    }-*/;
    
    public final void stat(String path, JavaScriptFunctionWrapper callback) {
        stat(path, callback.getNativeFunction());
    }
    
    public final void stat(String path, StatFsEventHandler callback) {
        stat(path, callback.getNativeFunction());
    }
    
    public final native void stat(String path, JavaScriptFunction callback) /*-{
        this.stat(path, callback);
    }-*/;
    
    public final native void lstat(String path) /*-{
        this.lstat(path);
    }-*/;
    
    public final void lstat(String path, JavaScriptFunctionWrapper callback) {
        lstat(path, callback.getNativeFunction());
    }
    
    public final void lstat(String path, StatFsEventHandler callback) {
        lstat(path, callback.getNativeFunction());
    }
    
    public final native void lstat(String path, JavaScriptFunction callback) /*-{
        this.lstat(path, callback);
    }-*/;

    public final native void fstat(int fd) /*-{
        this.fstat(fd);
    }-*/;
    
    public final void fstat(int fd, JavaScriptFunctionWrapper callback) {
        fstat(fd, callback.getNativeFunction());
    }
    
    public final void fstat(int fd, StatFsEventHandler callback) {
        fstat(fd, callback.getNativeFunction());
    }
    
    public final native void fstat(int fd, JavaScriptFunction callback) /*-{
        this.fstat(fd, callback);
    }-*/;
    
    public final native Stat statSync(String path) /*-{
        return this.statSync(path);
    }-*/;
    
    public final native Stat lstatSync(String path) /*-{
        return this.lstatSync(path);
    }-*/;
    
    public final native Stat fstatSync(int fd) /*-{
        return this.fstatSync(fd);
    }-*/;
    
    public final native void link(String srcpath, String dstpath) /*-{
        this.link(srcpath, dstpath);
    }-*/;

    public final void link(String srcpath, String dstpath, 
            JavaScriptFunctionWrapper callback) {
        link(srcpath, dstpath, callback.getNativeFunction());
    }
    
    public final void link(String srcpath, String dstpath, 
            FsEventHandler callback) {
        link(srcpath, dstpath, callback.getNativeFunction());
    }
    
    public final native void link(String srcpath, String dstpath,
            JavaScriptFunction callback) /*-{
        this.link(srcpath, dstpath, callback);
    }-*/;
    
    public final native void linkSync(String srcpath, String dstpath) /*-{
        this.linkSync(srcpath, dstpath);
    }-*/;
    
    public final native void symlink(String linkdata, String path) /*-{
        this.symlink(linkdata, path);
    }-*/;

    public final void symlink(String linkdata, String path, 
            JavaScriptFunctionWrapper callback) {
        symlink(linkdata, path, callback.getNativeFunction());
    }
    
    public final void symlink(String linkdata, String path, 
            FsEventHandler callback) {
        symlink(linkdata, path, callback.getNativeFunction());
    }
    
    public final native void symlink(String linkdata, String path,
            JavaScriptFunction callback) /*-{
        this.symlink(linkdata, path, callback);
    }-*/;
    
    public final native void symlinkSync(String linkdata, String path) /*-{
        this.symlinkSync(linkdata, path);
    }-*/;
    
    public final native void readlink(String path) /*-{
        this.readlink(path);
    }-*/;

    public final void readlink(String path, JavaScriptFunctionWrapper callback) {
        readlink(path, callback.getNativeFunction());
    }
    
    public final void readlink(String path, PathFsEventHandler callback) {
        readlink(path, callback.getNativeFunction());
    }
    
    public final native void readlink(String path, JavaScriptFunction callback) /*-{
        this.readlink(path, callback);
    }-*/;
    
    public final native String readlinkSync(String path) /*-{
        return this.readlinkSync(path);
    }-*/;
    
    public final native void realpath(String path) /*-{
        this.realpath(path);
    }-*/;

    public final void realpath(String path, JavaScriptFunctionWrapper callback) {
        realpath(path, callback.getNativeFunction());
    }
    
    public final void realpath(String path, PathFsEventHandler callback) {
        realpath(path, callback.getNativeFunction());
    }
    
    public final native void realpath(String path, JavaScriptFunction callback) /*-{
        this.realpath(path, callback);
    }-*/;
    
    public final native String realpathSync(String path) /*-{
        return this.realpathSync(path);
    }-*/;

    public final native void unlink(String path) /*-{
        this.unlink(path);
    }-*/;

    public final void unlink(String path, JavaScriptFunctionWrapper callback) {
        unlink(path, callback.getNativeFunction());
    }
    
    public final void unlink(String path, FsEventHandler callback) {
        unlink(path, callback.getNativeFunction());
    }
    
    public final native void unlink(String path, JavaScriptFunction callback) /*-{
        this.unlink(path, callback);
    }-*/;
    
    public final native void unlinkSync(String path) /*-{
        this.unlinkSync(path);
    }-*/;
    
    public final native void rmdir(String path) /*-{
        this.rmdir(path);
    }-*/;

    public final void rmdir(String path, JavaScriptFunctionWrapper callback) {
        rmdir(path, callback.getNativeFunction());
    }
    
    public final void rmdir(String path, FsEventHandler callback) {
        rmdir(path, callback.getNativeFunction());
    }
    
    public final native void rmdir(String path, JavaScriptFunction callback) /*-{
        this.rmdir(path, callback);
    }-*/;
    
    public final native void rmdirSync(String path) /*-{
        this.rmdirSync(path);
    }-*/;

    public final native void mkdir(String path, int mode) /*-{
        this.mkdir(path, mode);
    }-*/;

    public final void mkdir(String path, int mode, JavaScriptFunctionWrapper callback) {
        mkdir(path, mode, callback.getNativeFunction());
    }
    
    public final void mkdir(String path, int mode, PathFsEventHandler callback) {
        mkdir(path, mode, callback.getNativeFunction());
    }
    
    public final native void mkdir(String path, int mode, JavaScriptFunction callback) /*-{
        this.mkdir(path, mode, callback);
    }-*/;
    
    public final native void mkdirSync(String path, int mode) /*-{
        this.mkdirSync(path, mode);
    }-*/;

    public final native void readdir(String path) /*-{
        this.readdir(path);
    }-*/;

    public final void readdir(String path, JavaScriptFunctionWrapper callback) {
        readdir(path, callback.getNativeFunction());
    }
    
    public final void readdir(String path, ReaddirFsEventHandler callback) {
        readdir(path, callback.getNativeFunction());
    }
    
    public final native void readdir(String path, JavaScriptFunction callback) /*-{
        this.readdir(path, callback);
    }-*/;
    
    public final native JsArrayString readdirSync(String path) /*-{
        return this.readdirSync(path);
    }-*/;

    public final native void close(int fd) /*-{
        this.close(fd);
    }-*/;

    public final void close(int fd, JavaScriptFunctionWrapper callback) {
        close(fd, callback.getNativeFunction());
    }
    
    public final void close(int fd, FsEventHandler callback) {
        close(fd, callback.getNativeFunction());
    }
    
    public final native void close(int fd, JavaScriptFunction callback) /*-{
        this.close(fd, callback);
    }-*/;
    
    public final native void closeSync(int fd) /*-{
        this.closeSync(fd);
    }-*/;
    
    public final native void open(String path, String flags, int mode) /*-{
        this.open(path, flags, mode);
    }-*/;

    public final void open(String path, String flags, int mode,
            JavaScriptFunctionWrapper callback) {
        open(path, flags, mode, callback.getNativeFunction());
    }

    public final void open(String path, String flags, int mode,
            FileDescriptorFsEventHandler callback) {
        open(path, flags, mode, callback.getNativeFunction());
    }

    public final native void open(String path, String flags, int mode,
            JavaScriptFunction callback) /*-{
        this.open(path, flags, mode, callback);
    }-*/;
    
    public final native int openSync(String path, String flags, int mode) /*-{
        return this.openSync(path, flags, mode);
    }-*/;

    public final native void open(String path, String flags) /*-{
        this.open(path, flags);
    }-*/;

    public final void open(String path, String flags,
            JavaScriptFunctionWrapper callback) {
        open(path, flags, callback.getNativeFunction());
    }

    public final void open(String path, String flags,
            FileDescriptorFsEventHandler callback) {
        open(path, flags, callback.getNativeFunction());
    }

    public final native void open(String path, String flags,
            JavaScriptFunction callback) /*-{
        this.open(path, flags, callback);
    }-*/;
    
    public final native int openSync(String path, String flags) /*-{
        return this.openSync(path, flags);
    }-*/;
    
    public final native void write(int fd, Buffer buffer, int offset,
            int length, Integer position) /*-{
        this.write(fd, buffer, offset, length, position);
    }-*/;

    public final void write(int fd, Buffer buffer, int offset,
            int length, Integer position, JavaScriptFunctionWrapper callback) {
        write(fd, buffer, offset, length, position, callback.getNativeFunction());
    }
    
    public final void write(int fd, Buffer buffer, int offset,
            int length, Integer position, ByteCountFsEventHandler callback) {
        write(fd, buffer, offset, length, position, callback.getNativeFunction());
    }
    
    public final native void write(int fd, Buffer buffer, int offset,
            int length, Integer position, JavaScriptFunction callback) /*-{
        this.write(fd, buffer, offset, length, position, callback);
    }-*/;

    public final native int writeSync(int fd, Buffer buffer, int offset,
            int length, Integer position) /*-{
        return this.writeSync(fd, buffer, offset, length, position);
    }-*/;
    
    public final native int writeSync(int fd, String string, Integer position) /*-{
        return this.writeSync(fd, string, position);
    }-*/;
    
    public final native int writeSync(int fd, String string, 
            Integer position, String encoding) /*-{
        return this.writeSync(fd, string, position, encoding);
    }-*/;

    public final native void read(int fd, Buffer buffer, int offset,
            int length, Integer position) /*-{
        this.read(fd, buffer, offset, length, position);
    }-*/;

    public final void read(int fd, Buffer buffer, int offset,
            int length, Integer position, JavaScriptFunctionWrapper callback) {
        read(fd, buffer, offset, length, position, callback.getNativeFunction());
    }
    
    public final void read(int fd, Buffer buffer, int offset,
            int length, Integer position, ByteCountFsEventHandler callback) {
        read(fd, buffer, offset, length, position, callback.getNativeFunction());
    }
    
    public final native void read(int fd, Buffer buffer, int offset,
            int length, Integer position, JavaScriptFunction callback) /*-{
        this.read(fd, buffer, offset, length, position, callback);
    }-*/;

    public final native Buffer readSync(int fd, Buffer buffer, int offset,
            int length, Integer position) /*-{
        return this.readSync(fd, buffer, offset, length, position);
    }-*/;
    
    public final native String readSync(int fd, int length, 
            Integer position, String encoding) /*-{
        return this.readSync(fd, length, position, encoding);
    }-*/;

    public final native void readFile(String filename, String encoding) /*-{
        this.readFile(filename, encoding);
    }-*/;
    
    public final void readFile(String filename, String encoding,
            JavaScriptFunctionWrapper callback) {
        readFile(filename, encoding, callback.getNativeFunction());
    }

    public final void readFile(String filename, String encoding,
            StringFsEventHandler callback) {
        readFile(filename, encoding, callback.getNativeFunction());
    }
    
    public final native void readFile(String filename, String encoding,
            JavaScriptFunction callback) /*-{
        this.readFile(filename, encoding, callback);
    }-*/;
    
    public final native String readFileSync(String filename, String encoding) /*-{
        return this.readFileSync(filename, encoding);
    }-*/;

    public final native void readFile(String filename) /*-{
        this.readFile(filename);
    }-*/;
    
    public final void readFile(String filename,
            JavaScriptFunctionWrapper callback) {
        readFile(filename, callback.getNativeFunction());
    }

    public final void readFile(String filename,
            BufferFsEventHandler callback) {
        readFile(filename, callback.getNativeFunction());
    }
    
    public final native void readFile(String filename,
            JavaScriptFunction callback) /*-{
        this.readFile(filename, callback);
    }-*/;
    
    public final native Buffer readFileSync(String filename) /*-{
        return this.readFileSync(filename);
    }-*/;

    public final native void writeFile(String filename, String data,
            String encoding) /*-{
        this.writeFile(filename, data, encoding);
    }-*/;
    
    public final void writeFile(String filename, String data, String encoding,
            JavaScriptFunctionWrapper callback) {
        writeFile(filename, data, encoding, callback.getNativeFunction());
    }
    
    public final void writeFile(String filename, String data, String encoding,
            FsEventHandler callback) {
        writeFile(filename, data, encoding, callback.getNativeFunction());
    }
    
    public final native void writeFile(String filename, String data, String encoding,
            JavaScriptFunction callback) /*-{
        this.writeFile(filename, data, encoding, callback);
    }-*/;
    
    public final native void writeFileSync(String filename, String data,
            String encoding) /*-{
        this.writeFile(filename, data, encoding);
    }-*/;

    public final native void writeFile(String filename, String data) /*-{
        this.writeFile(filename, data);
    }-*/;
    
    public final void writeFile(String filename, String data,
            JavaScriptFunctionWrapper callback) {
        writeFile(filename, data, callback.getNativeFunction());
    }
    
    public final void writeFile(String filename, String data,
            FsEventHandler callback) {
        writeFile(filename, data, callback.getNativeFunction());
    }
    
    public final native void writeFile(String filename, String data,
            JavaScriptFunction callback) /*-{
        this.writeFile(filename, data, callback);
    }-*/;
    
    public final native void writeFileSync(String filename, String data) /*-{
        this.writeFile(filename, data);
    }-*/;

    public final native void writeFile(String filename, Buffer data,
            String encoding) /*-{
        this.writeFile(filename, data, encoding);
    }-*/;
    
    public final void writeFile(String filename, Buffer data, String encoding,
            JavaScriptFunctionWrapper callback) {
        writeFile(filename, data, encoding, callback.getNativeFunction());
    }
    
    public final void writeFile(String filename, Buffer data, String encoding,
            FsEventHandler callback) {
        writeFile(filename, data, encoding, callback.getNativeFunction());
    }
    
    public final native void writeFile(String filename, Buffer data, String encoding,
            JavaScriptFunction callback) /*-{
        this.writeFile(filename, data, encoding, callback);
    }-*/;
    
    public final native void writeFileSync(String filename, Buffer data,
            String encoding) /*-{
        this.writeFile(filename, data, encoding);
    }-*/;

    public final native void writeFile(String filename, Buffer data) /*-{
        this.writeFile(filename, data);
    }-*/;
    
    public final void writeFile(String filename, Buffer data,
            JavaScriptFunctionWrapper callback) {
        writeFile(filename, data, callback.getNativeFunction());
    }
    
    public final void writeFile(String filename, Buffer data,
            FsEventHandler callback) {
        writeFile(filename, data, callback.getNativeFunction());
    }
    
    public final native void writeFile(String filename, Buffer data,
            JavaScriptFunction callback) /*-{
        this.writeFile(filename, data, callback);
    }-*/;
    
    public final native void writeFileSync(String filename, Buffer data) /*-{
        this.writeFile(filename, data);
    }-*/;

    public final void watchFile(String filename, WatchFileOptions options,
            JavaScriptFunctionWrapper callback) {
        watchFile(filename, options, callback.getNativeFunction());
    }

    public final void watchFile(String filename, WatchFileOptions options,
            WatchFileEventHandler callback) {
        watchFile(filename, options, callback.getNativeFunction());
    }
    
    public final native void watchFile(String filename, WatchFileOptions options,
            JavaScriptFunction callback) /*-{
        this.watchFile(filename, options, callback);
    }-*/;

    public final void watchFile(String filename, JavaScriptFunctionWrapper callback) {
        watchFile(filename, callback.getNativeFunction());
    }

    public final void watchFile(String filename, WatchFileEventHandler callback) {
        watchFile(filename, callback.getNativeFunction());
    }
    
    public final native void watchFile(String filename, JavaScriptFunction callback) /*-{
        this.watchFile(filename, callback);
    }-*/;
    
    public final native void unwatchFile(String filename) /*-{
        this.unwatchFile(filename);
    }-*/;

    public final native ReadableStream createReadStream(String path) /*-{
        return this.createReadStream(path);
    }-*/;
    
    public final native ReadableStream createReadStream(String path, ReadStreamOptions options) /*-{
        return this.createReadStream(path, options);
    }-*/;
    
    //TODO: open

    public final native WriteableStream createWriteStream(String path) /*-{
        return this.createWriteStream(path);
    }-*/;
    
    public final native WriteableStream createWriteStream(String path, WriteStreamOptions options) /*-{
        return this.createReadStream(path, options);
    }-*/;
}
