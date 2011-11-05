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

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.JavaScriptFunctionWrapper;
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeModule;
import org.gwtnode.core.node.Global;
import org.gwtnode.core.node.NodeJsModule;
import org.gwtnode.core.node.buffer.Buffer;
import org.gwtnode.core.node.stream.ReadableStream;
import org.gwtnode.core.node.stream.WritableStream;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.6/api/fs.html">fs</a> module.
 * 
 * @author Chad Retz
 */
@GwtNodeModule
public class Fs extends JavaScriptObject implements NodeJsModule {

    private static Fs instance;
    
    public static Fs get() {
        if (instance == null) {
            instance = Global.get().require("fs");
        }
        return instance;
    }
    
    protected Fs() {
    }

    @GwtNodeFunction
    public final native void rename(String path1, String path2) /*-{
        this.rename(path1, path2);
    }-*/;

    @GwtNodeFunction
    public final void rename(String path1, String path2, JavaScriptFunctionWrapper callback) {
        rename(path1, path2, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void rename(String path1, String path2, FsEventHandler callback) {
        rename(path1, path2, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void rename(String path1, String path2, JavaScriptFunction callback) /*-{
        this.rename(path1, path2, callback);
    }-*/;

    @GwtNodeFunction
    public final native void renameSync(String path1, String path2) /*-{
        this.renameSync(path1, path2);
    }-*/;

    @GwtNodeFunction
    public final native void truncate(int fd, int len) /*-{
        this.truncate(fd, len);
    }-*/;

    @GwtNodeFunction
    public final void truncate(int fd, int len, JavaScriptFunctionWrapper callback) {
        truncate(fd, len, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void truncate(int fd, int len, FsEventHandler callback) {
        truncate(fd, len, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void truncate(int fd, int len, JavaScriptFunction callback) /*-{
        this.truncate(fd, len, callback);
    }-*/;

    @GwtNodeFunction
    public final native void truncateSync(int fd, int len) /*-{
        this.truncateSync(fd, len);
    }-*/;

    @GwtNodeFunction
    public final native void chown(String path, int mode) /*-{
        this.chown(path, mode);
    }-*/;

    @GwtNodeFunction
    public final void chown(String path, int mode, JavaScriptFunctionWrapper callback) {
        chown(path, mode, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void chown(String path, int mode, FsEventHandler callback) {
        chown(path, mode, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void chown(String path, int mode, JavaScriptFunction callback) /*-{
        this.chown(path, mode, callback);
    }-*/;

    @GwtNodeFunction
    public final native void chownSync(String path, int mode) /*-{
        this.chownSync(path, mode);
    }-*/;

    @GwtNodeFunction
    public final native void fchown(String path, int mode) /*-{
        this.fchown(path, mode);
    }-*/;

    @GwtNodeFunction
    public final void fchown(String path, int mode, JavaScriptFunctionWrapper callback) {
        fchown(path, mode, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void fchown(String path, int mode, FsEventHandler callback) {
        fchown(path, mode, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void fchown(String path, int mode, JavaScriptFunction callback) /*-{
        this.fchown(path, mode, callback);
    }-*/;

    @GwtNodeFunction
    public final native void fchownSync(String path, int mode) /*-{
        this.fchownSync(path, mode);
    }-*/;

    @GwtNodeFunction
    public final native void lchown(String path, int mode) /*-{
        this.lchown(path, mode);
    }-*/;

    @GwtNodeFunction
    public final void lchown(String path, int mode, JavaScriptFunctionWrapper callback) {
        lchown(path, mode, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void lchown(String path, int mode, FsEventHandler callback) {
        lchown(path, mode, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void lchown(String path, int mode, JavaScriptFunction callback) /*-{
        this.lchown(path, mode, callback);
    }-*/;

    @GwtNodeFunction
    public final native void lchownSync(String path, int mode) /*-{
        this.lchownSync(path, mode);
    }-*/;

    @GwtNodeFunction
    public final native void chmod(String path, int mode) /*-{
        this.chmod(path, mode);
    }-*/;

    @GwtNodeFunction
    public final void chmod(String path, int mode, JavaScriptFunctionWrapper callback) {
        chmod(path, mode, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void chmod(String path, int mode, FsEventHandler callback) {
        chmod(path, mode, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void chmod(String path, int mode, JavaScriptFunction callback) /*-{
        this.chmod(path, mode, callback);
    }-*/;

    @GwtNodeFunction
    public final native void chmodSync(String path, int mode) /*-{
        this.chmodSync(path, mode);
    }-*/;

    @GwtNodeFunction
    public final native void fchmod(int fd, int mode) /*-{
        this.fchmod(fd, mode);
    }-*/;

    @GwtNodeFunction
    public final void fchmod(int fd, int mode, JavaScriptFunctionWrapper callback) {
        fchmod(fd, mode, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void fchmod(int fd, int mode, FsEventHandler callback) {
        fchmod(fd, mode, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void fchmod(int fd, int mode, JavaScriptFunction callback) /*-{
        this.fchmod(fd, mode, callback);
    }-*/;

    @GwtNodeFunction
    public final native void fchmodSync(String path, int mode) /*-{
        this.fchmodSync(path, mode);
    }-*/;

    @GwtNodeFunction
    public final native void lchmod(int fd, int mode) /*-{
        this.lchmod(fd, mode);
    }-*/;

    @GwtNodeFunction
    public final void lchmod(int fd, int mode, JavaScriptFunctionWrapper callback) {
        lchmod(fd, mode, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void lchmod(int fd, int mode, FsEventHandler callback) {
        lchmod(fd, mode, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void lchmod(int fd, int mode, JavaScriptFunction callback) /*-{
        this.lchmod(fd, mode, callback);
    }-*/;

    @GwtNodeFunction
    public final native void lchmodSync(String path, int mode) /*-{
        this.lchmodSync(path, mode);
    }-*/;

    @GwtNodeFunction
    public final native void stat(String path) /*-{
        this.stat(path);
    }-*/;

    @GwtNodeFunction
    public final void stat(String path, JavaScriptFunctionWrapper callback) {
        stat(path, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void stat(String path, StatEventHandler callback) {
        stat(path, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void stat(String path, JavaScriptFunction callback) /*-{
        this.stat(path, callback);
    }-*/;

    @GwtNodeFunction
    public final native void lstat(String path) /*-{
        this.lstat(path);
    }-*/;

    @GwtNodeFunction
    public final void lstat(String path, JavaScriptFunctionWrapper callback) {
        lstat(path, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void lstat(String path, StatEventHandler callback) {
        lstat(path, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void lstat(String path, JavaScriptFunction callback) /*-{
        this.lstat(path, callback);
    }-*/;

    @GwtNodeFunction
    public final native void fstat(int fd) /*-{
        this.fstat(fd);
    }-*/;

    @GwtNodeFunction
    public final void fstat(int fd, JavaScriptFunctionWrapper callback) {
        fstat(fd, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void fstat(int fd, StatEventHandler callback) {
        fstat(fd, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void fstat(int fd, JavaScriptFunction callback) /*-{
        this.fstat(fd, callback);
    }-*/;

    @GwtNodeFunction
    public final native Stat statSync(String path) /*-{
        return this.statSync(path);
    }-*/;

    @GwtNodeFunction
    public final native Stat lstatSync(String path) /*-{
        return this.lstatSync(path);
    }-*/;

    @GwtNodeFunction
    public final native Stat fstatSync(int fd) /*-{
        return this.fstatSync(fd);
    }-*/;

    @GwtNodeFunction
    public final native void link(String srcpath, String dstpath) /*-{
        this.link(srcpath, dstpath);
    }-*/;

    @GwtNodeFunction
    public final void link(String srcpath, String dstpath, 
            JavaScriptFunctionWrapper callback) {
        link(srcpath, dstpath, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void link(String srcpath, String dstpath, 
            FsEventHandler callback) {
        link(srcpath, dstpath, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void link(String srcpath, String dstpath,
            JavaScriptFunction callback) /*-{
        this.link(srcpath, dstpath, callback);
    }-*/;

    @GwtNodeFunction
    public final native void linkSync(String srcpath, String dstpath) /*-{
        this.linkSync(srcpath, dstpath);
    }-*/;

    @GwtNodeFunction
    public final native void symlink(String linkdata, String path) /*-{
        this.symlink(linkdata, path);
    }-*/;

    @GwtNodeFunction
    public final void symlink(String linkdata, String path, 
            JavaScriptFunctionWrapper callback) {
        symlink(linkdata, path, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void symlink(String linkdata, String path, 
            FsEventHandler callback) {
        symlink(linkdata, path, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void symlink(String linkdata, String path,
            JavaScriptFunction callback) /*-{
        this.symlink(linkdata, path, callback);
    }-*/;

    @GwtNodeFunction
    public final native void symlinkSync(String linkdata, String path) /*-{
        this.symlinkSync(linkdata, path);
    }-*/;

    @GwtNodeFunction
    public final native void readlink(String path) /*-{
        this.readlink(path);
    }-*/;

    @GwtNodeFunction
    public final void readlink(String path, JavaScriptFunctionWrapper callback) {
        readlink(path, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void readlink(String path, PathEventHandler callback) {
        readlink(path, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void readlink(String path, JavaScriptFunction callback) /*-{
        this.readlink(path, callback);
    }-*/;

    @GwtNodeFunction
    public final native String readlinkSync(String path) /*-{
        return this.readlinkSync(path);
    }-*/;

    @GwtNodeFunction
    public final native void realpath(String path) /*-{
        this.realpath(path);
    }-*/;

    @GwtNodeFunction
    public final void realpath(String path, JavaScriptFunctionWrapper callback) {
        realpath(path, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void realpath(String path, PathEventHandler callback) {
        realpath(path, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void realpath(String path, JavaScriptFunction callback) /*-{
        this.realpath(path, callback);
    }-*/;

    @GwtNodeFunction
    public final native String realpathSync(String path) /*-{
        return this.realpathSync(path);
    }-*/;

    @GwtNodeFunction
    public final native void unlink(String path) /*-{
        this.unlink(path);
    }-*/;

    @GwtNodeFunction
    public final void unlink(String path, JavaScriptFunctionWrapper callback) {
        unlink(path, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void unlink(String path, FsEventHandler callback) {
        unlink(path, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void unlink(String path, JavaScriptFunction callback) /*-{
        this.unlink(path, callback);
    }-*/;

    @GwtNodeFunction
    public final native void unlinkSync(String path) /*-{
        this.unlinkSync(path);
    }-*/;

    @GwtNodeFunction
    public final native void rmdir(String path) /*-{
        this.rmdir(path);
    }-*/;

    @GwtNodeFunction
    public final void rmdir(String path, JavaScriptFunctionWrapper callback) {
        rmdir(path, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void rmdir(String path, FsEventHandler callback) {
        rmdir(path, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void rmdir(String path, JavaScriptFunction callback) /*-{
        this.rmdir(path, callback);
    }-*/;

    @GwtNodeFunction
    public final native void rmdirSync(String path) /*-{
        this.rmdirSync(path);
    }-*/;

    @GwtNodeFunction
    public final native void mkdir(String path, int mode) /*-{
        this.mkdir(path, mode);
    }-*/;

    @GwtNodeFunction
    public final void mkdir(String path, int mode, JavaScriptFunctionWrapper callback) {
        mkdir(path, mode, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void mkdir(String path, int mode, PathEventHandler callback) {
        mkdir(path, mode, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void mkdir(String path, int mode, JavaScriptFunction callback) /*-{
        this.mkdir(path, mode, callback);
    }-*/;

    @GwtNodeFunction
    public final native void mkdirSync(String path, int mode) /*-{
        this.mkdirSync(path, mode);
    }-*/;

    @GwtNodeFunction
    public final native void readdir(String path) /*-{
        this.readdir(path);
    }-*/;

    @GwtNodeFunction
    public final void readdir(String path, JavaScriptFunctionWrapper callback) {
        readdir(path, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void readdir(String path, ReaddirEventHandler callback) {
        readdir(path, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void readdir(String path, JavaScriptFunction callback) /*-{
        this.readdir(path, callback);
    }-*/;

    @GwtNodeFunction
    public final native JsArrayString readdirSync(String path) /*-{
        return this.readdirSync(path);
    }-*/;

    @GwtNodeFunction
    public final native void close(int fd) /*-{
        this.close(fd);
    }-*/;

    @GwtNodeFunction
    public final void close(int fd, JavaScriptFunctionWrapper callback) {
        close(fd, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void close(int fd, FsEventHandler callback) {
        close(fd, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void close(int fd, JavaScriptFunction callback) /*-{
        this.close(fd, callback);
    }-*/;

    @GwtNodeFunction
    public final native void closeSync(int fd) /*-{
        this.closeSync(fd);
    }-*/;

    @GwtNodeFunction
    public final native void open(String path, String flags, int mode) /*-{
        this.open(path, flags, mode);
    }-*/;

    @GwtNodeFunction
    public final void open(String path, String flags, int mode,
            JavaScriptFunctionWrapper callback) {
        open(path, flags, mode, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void open(String path, String flags, int mode,
            FileDescriptorEventHandler callback) {
        open(path, flags, mode, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void open(String path, String flags, int mode,
            JavaScriptFunction callback) /*-{
        this.open(path, flags, mode, callback);
    }-*/;

    @GwtNodeFunction
    public final native int openSync(String path, String flags, int mode) /*-{
        return this.openSync(path, flags, mode);
    }-*/;

    @GwtNodeFunction
    public final native void open(String path, String flags) /*-{
        this.open(path, flags);
    }-*/;

    @GwtNodeFunction
    public final void open(String path, String flags,
            JavaScriptFunctionWrapper callback) {
        open(path, flags, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void open(String path, String flags,
            FileDescriptorEventHandler callback) {
        open(path, flags, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void open(String path, String flags,
            JavaScriptFunction callback) /*-{
        this.open(path, flags, callback);
    }-*/;

    @GwtNodeFunction
    public final native int openSync(String path, String flags) /*-{
        return this.openSync(path, flags);
    }-*/;

    @GwtNodeFunction
    public final native void utimes(String path, double atime, double mtime) /*-{
        this.utimes(path, atime, mtime);
    }-*/;

    @GwtNodeFunction
    public final void utimes(String path, double atime, double mtime, JavaScriptFunctionWrapper callback) {
        utimes(path, atime, mtime, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void utimes(String path, double atime, double mtime, FsEventHandler callback) {
        utimes(path, atime, mtime, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void utimes(String path, double atime, double mtime, JavaScriptFunction callback) /*-{
        this.utimes(path, atime, mtime, callback);
    }-*/;

    @GwtNodeFunction
    public final native void utimesSync(String path, double atime, double mtime) /*-{
        this.utimesSync(path, atime, mtime);
    }-*/;

    @GwtNodeFunction
    public final native void futimes(String path, double atime, double mtime) /*-{
        this.futimes(path, atime, mtime);
    }-*/;

    @GwtNodeFunction
    public final void futimes(String path, double atime, double mtime, JavaScriptFunctionWrapper callback) {
        futimes(path, atime, mtime, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void futimes(String path, double atime, double mtime, FsEventHandler callback) {
        futimes(path, atime, mtime, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void futimes(String path, double atime, double mtime, JavaScriptFunction callback) /*-{
        this.futimes(path, atime, mtime, callback);
    }-*/;

    @GwtNodeFunction
    public final native void futimesSync(String path, double atime, double mtime) /*-{
        this.futimesSync(path, atime, mtime);
    }-*/;

    @GwtNodeFunction
    public final native void fsync(int fd) /*-{
        this.fsync(fd);
    }-*/;

    @GwtNodeFunction
    public final void fsync(int fd, JavaScriptFunctionWrapper callback) {
        fsync(fd, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void fsync(int fd, FsEventHandler callback) {
        fsync(fd, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void fsync(int fd, JavaScriptFunction callback) /*-{
        this.fsync(fd, callback);
    }-*/;

    @GwtNodeFunction
    public final native Stat fsyncSync(int fd) /*-{
        return this.fsyncSync(fd);
    }-*/;

    @GwtNodeFunction
    public final native void write(int fd, Buffer buffer, int offset,
            int length, Integer position) /*-{
        this.write(fd, buffer, offset, length, position);
    }-*/;

    @GwtNodeFunction
    public final void write(int fd, Buffer buffer, int offset,
            int length, Integer position, JavaScriptFunctionWrapper callback) {
        write(fd, buffer, offset, length, position, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void write(int fd, Buffer buffer, int offset,
            int length, Integer position, ByteCountEventHandler callback) {
        write(fd, buffer, offset, length, position, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void write(int fd, Buffer buffer, int offset,
            int length, Integer position, JavaScriptFunction callback) /*-{
        this.write(fd, buffer, offset, length, position, callback);
    }-*/;

    @GwtNodeFunction
    public final native int writeSync(int fd, Buffer buffer, int offset,
            int length, Integer position) /*-{
        return this.writeSync(fd, buffer, offset, length, position);
    }-*/;

    @GwtNodeFunction
    public final native int writeSync(int fd, String string, Integer position) /*-{
        return this.writeSync(fd, string, position);
    }-*/;

    @GwtNodeFunction
    public final native int writeSync(int fd, String string, 
            Integer position, String encoding) /*-{
        return this.writeSync(fd, string, position, encoding);
    }-*/;

    @GwtNodeFunction
    public final native void read(int fd, Buffer buffer, int offset,
            int length, Integer position) /*-{
        this.read(fd, buffer, offset, length, position);
    }-*/;

    @GwtNodeFunction
    public final void read(int fd, Buffer buffer, int offset,
            int length, Integer position, JavaScriptFunctionWrapper callback) {
        read(fd, buffer, offset, length, position, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void read(int fd, Buffer buffer, int offset,
            int length, Integer position, ByteCountEventHandler callback) {
        read(fd, buffer, offset, length, position, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void read(int fd, Buffer buffer, int offset,
            int length, Integer position, JavaScriptFunction callback) /*-{
        this.read(fd, buffer, offset, length, position, callback);
    }-*/;

    @GwtNodeFunction
    public final native Buffer readSync(int fd, Buffer buffer, int offset,
            int length, Integer position) /*-{
        return this.readSync(fd, buffer, offset, length, position);
    }-*/;

    @GwtNodeFunction
    public final native String readSync(int fd, int length, 
            Integer position, String encoding) /*-{
        return this.readSync(fd, length, position, encoding);
    }-*/;

    @GwtNodeFunction
    public final native void readFile(String filename, String encoding) /*-{
        this.readFile(filename, encoding);
    }-*/;

    @GwtNodeFunction
    public final void readFile(String filename, String encoding,
            JavaScriptFunctionWrapper callback) {
        readFile(filename, encoding, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void readFile(String filename, String encoding,
            StringEventHandler callback) {
        readFile(filename, encoding, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void readFile(String filename, String encoding,
            JavaScriptFunction callback) /*-{
        this.readFile(filename, encoding, callback);
    }-*/;

    @GwtNodeFunction
    public final native String readFileSync(String filename, String encoding) /*-{
        return this.readFileSync(filename, encoding);
    }-*/;

    @GwtNodeFunction
    public final native void readFile(String filename) /*-{
        this.readFile(filename);
    }-*/;

    @GwtNodeFunction
    public final void readFile(String filename,
            JavaScriptFunctionWrapper callback) {
        readFile(filename, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void readFile(String filename,
            BufferEventHandler callback) {
        readFile(filename, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void readFile(String filename,
            JavaScriptFunction callback) /*-{
        this.readFile(filename, callback);
    }-*/;

    @GwtNodeFunction
    public final native Buffer readFileSync(String filename) /*-{
        return this.readFileSync(filename);
    }-*/;

    @GwtNodeFunction
    public final native void writeFile(String filename, String data,
            String encoding) /*-{
        this.writeFile(filename, data, encoding);
    }-*/;

    @GwtNodeFunction
    public final void writeFile(String filename, String data, String encoding,
            JavaScriptFunctionWrapper callback) {
        writeFile(filename, data, encoding, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void writeFile(String filename, String data, String encoding,
            FsEventHandler callback) {
        writeFile(filename, data, encoding, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void writeFile(String filename, String data, String encoding,
            JavaScriptFunction callback) /*-{
        this.writeFile(filename, data, encoding, callback);
    }-*/;

    @GwtNodeFunction
    public final native void writeFileSync(String filename, String data,
            String encoding) /*-{
        this.writeFile(filename, data, encoding);
    }-*/;

    @GwtNodeFunction
    public final native void writeFile(String filename, String data) /*-{
        this.writeFile(filename, data);
    }-*/;

    @GwtNodeFunction
    public final void writeFile(String filename, String data,
            JavaScriptFunctionWrapper callback) {
        writeFile(filename, data, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void writeFile(String filename, String data,
            FsEventHandler callback) {
        writeFile(filename, data, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void writeFile(String filename, String data,
            JavaScriptFunction callback) /*-{
        this.writeFile(filename, data, callback);
    }-*/;

    @GwtNodeFunction
    public final native void writeFileSync(String filename, String data) /*-{
        this.writeFile(filename, data);
    }-*/;

    @GwtNodeFunction
    public final native void writeFile(String filename, Buffer data,
            String encoding) /*-{
        this.writeFile(filename, data, encoding);
    }-*/;

    @GwtNodeFunction
    public final void writeFile(String filename, Buffer data, String encoding,
            JavaScriptFunctionWrapper callback) {
        writeFile(filename, data, encoding, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void writeFile(String filename, Buffer data, String encoding,
            FsEventHandler callback) {
        writeFile(filename, data, encoding, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void writeFile(String filename, Buffer data, String encoding,
            JavaScriptFunction callback) /*-{
        this.writeFile(filename, data, encoding, callback);
    }-*/;

    @GwtNodeFunction
    public final native void writeFileSync(String filename, Buffer data,
            String encoding) /*-{
        this.writeFile(filename, data, encoding);
    }-*/;

    @GwtNodeFunction
    public final native void writeFile(String filename, Buffer data) /*-{
        this.writeFile(filename, data);
    }-*/;

    @GwtNodeFunction
    public final void writeFile(String filename, Buffer data,
            JavaScriptFunctionWrapper callback) {
        writeFile(filename, data, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void writeFile(String filename, Buffer data,
            FsEventHandler callback) {
        writeFile(filename, data, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void writeFile(String filename, Buffer data,
            JavaScriptFunction callback) /*-{
        this.writeFile(filename, data, callback);
    }-*/;

    @GwtNodeFunction
    public final native void writeFileSync(String filename, Buffer data) /*-{
        this.writeFile(filename, data);
    }-*/;

    @GwtNodeFunction
    public final void watchFile(String filename, WatchFileOptions options,
            JavaScriptFunctionWrapper callback) {
        watchFile(filename, options, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void watchFile(String filename, WatchFileOptions options,
            WatchFileEventHandler callback) {
        watchFile(filename, options, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void watchFile(String filename, WatchFileOptions options,
            JavaScriptFunction callback) /*-{
        this.watchFile(filename, options, callback);
    }-*/;

    @GwtNodeFunction
    public final void watchFile(String filename, JavaScriptFunctionWrapper callback) {
        watchFile(filename, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final void watchFile(String filename, WatchFileEventHandler callback) {
        watchFile(filename, callback.getNativeFunction());
    }

    @GwtNodeFunction
    public final native void watchFile(String filename, JavaScriptFunction callback) /*-{
        this.watchFile(filename, callback);
    }-*/;

    @GwtNodeFunction
    public final native void unwatchFile(String filename) /*-{
        this.unwatchFile(filename);
    }-*/;

    @GwtNodeFunction
    public final native ReadableStream createReadStream(String path) /*-{
        return this.createReadStream(path);
    }-*/;

    @GwtNodeFunction
    public final native ReadableStream createReadStream(String path, ReadStreamOptions options) /*-{
        return this.createReadStream(path, options);
    }-*/;
    
    //TODO: open event on the stream

    @GwtNodeFunction
    public final native WritableStream createWriteStream(String path) /*-{
        return this.createWriteStream(path);
    }-*/;

    @GwtNodeFunction
    public final native WritableStream createWriteStream(String path, WriteStreamOptions options) /*-{
        return this.createReadStream(path, options);
    }-*/;
}
