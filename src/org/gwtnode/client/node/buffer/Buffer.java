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
package org.gwtnode.client.node.buffer;

import org.gwtnode.client.JavaScriptUtils;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;

/**
 * A node.js
 * <a href="http://nodejs.org/docs/v0.5.6/api/buffers.html">Buffer</a>
 * 
 * @author Chad Retz
 */
public class Buffer extends JavaScriptObject {
    
    public static final native Buffer create(int size) /*-{
        return new Buffer(size);
    }-*/;

    public static final Buffer create(byte... array) {
        return create(JavaScriptUtils.toIntegerArray(array));
    }
    
    public static final native Buffer create(JsArrayInteger array) /*-{
        return new Buffer(array);
    }-*/;

    public static final native Buffer create(String string) /*-{
        return new Buffer(string);
    }-*/;

    public static final native Buffer create(String string, String encoding) /*-{
        return new Buffer(string, encoding);
    }-*/;
    
    public static final native boolean isBuffer(JavaScriptObject obj) /*-{
        return Buffer.isBuffer(obj);
    }-*/;
    
    public static final native int byteLength(String string) /*-{
        return Buffer.byteLength(string);
    }-*/;
    
    public static final native int byteLength(String string, String encoding) /*-{
        return Buffer.byteLength(string, encoding);
    }-*/;
    
    protected Buffer() {
    }
    
    public final native int write(String string) /*-{
        return this.write(string);
    }-*/;
    
    public final native int write(String string, int offset) /*-{
        return this.write(string, offset);
    }-*/;
    
    public final native int write(String string, int offset, int length) /*-{
        return this.write(string, offset, length);
    }-*/;
    
    public final native int write(String string, int offset, int length, String encoding) /*-{
        return this.write(string, offset, length, encoding);
    }-*/;
    
    public final native String toString(String encoding) /*-{
        return this.toString(encoding);
    }-*/;
    
    public final native String toString(String encoding, int start) /*-{
        return this.toString(encoding, start);
    }-*/;
    
    public final native String toString(String encoding, int start, int end) /*-{
        return this.toString(encoding, start, end);
    }-*/;
    
    public final native byte get(int index) /*-{
        return this[index];
    }-*/;
    
    public final native byte set(int index, byte octet) /*-{
        return (this[index] = octet);
    }-*/;
    
    public final native int length() /*-{
        return this.length;
    }-*/;
    
    public final native void copy(Buffer targetBuffer, int targetStart, int sourceStart) /*-{
        this.copy(targetBuffer, targetStart, sourceStart);
    }-*/;

    public final native void copy(Buffer targetBuffer, int targetStart, 
            int sourceStart, int sourceEnd) /*-{
        this.copy(targetBuffer, targetStart, sourceStart, sourceEnd);
    }-*/;
    
    public final native Buffer slice(int start, int end) /*-{
        return this.slice(start, end);
    }-*/;
    
    //unsigned byte
    public final native short readUInt8(int offset, String endian) /*-{
        return this.readUInt8(offset, endian);
    }-*/;
    
    //unsigned short
    public final native int readUInt16(int offset, String endian) /*-{
        return this.readUInt16(offset, endian);
    }-*/;
    
    //unsigned int
    public final native double readUInt32(int offset, String endian) /*-{
        return this.readUInt32(offset, endian);
    }-*/;
    
    public final native byte readInt8(int offset, String endian) /*-{
        return this.readInt8(offset, endian);
    }-*/;
    
    public final native short readInt16(int offset, String endian) /*-{
        return this.readInt16(offset, endian);
    }-*/;
    
    public final native int readInt32(int offset, String endian) /*-{
        return this.readInt32(offset, endian);
    }-*/;
    
    public final native float readFloat(int offset, String endian) /*-{
        return this.readFloat(offset, endian);
    }-*/;
    
    public final native double readDouble(int offset, String endian) /*-{
        return this.readDouble(offset, endian);
    }-*/;
    
    public final native void writeUInt8(short value, int offset, String endian) /*-{
        this.writeUInt8(value, offset, endian);
    }-*/;
    
    public final native void writeUInt16(int value, int offset, String endian) /*-{
        this.writeUInt16(value, offset, endian);
    }-*/;
    
    public final native void writeUInt32(double value, int offset, String endian) /*-{
        this.writeUInt32(value, offset, endian);
    }-*/;
    
    public final native void writeInt8(byte value, int offset, String endian) /*-{
        this.writeInt8(value, offset, endian);
    }-*/;
    
    public final native void writeInt16(short value, int offset, String endian) /*-{
        this.writeInt16(value, offset, endian);
    }-*/;
    
    public final native void writeInt32(int value, int offset, String endian) /*-{
        this.writeInt32(value, offset, endian);
    }-*/;
    
    public final native void writeFloat(float value, int offset, String endian) /*-{
        this.writeFloat(value, offset, endian);
    }-*/;
    
    public final native void writeDouble(double value, int offset, String endian) /*-{
        this.writeDouble(value, offset, endian);
    }-*/;
    
    public final native void fill(Object value) /*-{
        this.fill(value);
    }-*/;
    
    public final native void fill(Object value, int offset) /*-{
        this.fill(value, offset);
    }-*/;
    
    public final native void fill(Object value, int offset, int length) /*-{
        this.fill(value, offset, length);
    }-*/;
    
    //TODO: INSPECT_MAX_BYTES
}
