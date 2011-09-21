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
package org.gwtnode.core.node.buffer;

import org.gwtnode.core.JavaScriptUtils;

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

    public final native void copy(Buffer targetBuffer) /*-{
        this.copy(targetBuffer);
    }-*/;
    
    public final native void copy(Buffer targetBuffer, int targetStart) /*-{
        this.copy(targetBuffer, targetStart);
    }-*/;
    
    public final native void copy(Buffer targetBuffer, int targetStart, int sourceStart) /*-{
        this.copy(targetBuffer, targetStart, sourceStart);
    }-*/;

    public final native void copy(Buffer targetBuffer, int targetStart, 
            int sourceStart, int sourceEnd) /*-{
        this.copy(targetBuffer, targetStart, sourceStart, sourceEnd);
    }-*/;
    
    public final native Buffer slice(int start) /*-{
        return this.slice(start);
    }-*/;

    public final native Buffer slice(int start, int end) /*-{
        return this.slice(start, end);
    }-*/;
    
    //unsigned byte
    public final native short readUInt8(int offset) /*-{
        return this.readUInt8(offset);
    }-*/;

    public final native short readUInt8(int offset, boolean noAssert) /*-{
        return this.readUInt8(offset, noAssert);
    }-*/;
    
    //unsigned short
    public final native int readUInt16BE(int offset) /*-{
        return this.readUInt16BE(offset);
    }-*/;

    public final native int readUInt16BE(int offset, boolean noAssert) /*-{
        return this.readUInt16BE(offset, noAssert);
    }-*/;

    public final native int readUInt16LE(int offset) /*-{
        return this.readUInt16LE(offset);
    }-*/;

    public final native int readUInt16LE(int offset, boolean noAssert) /*-{
        return this.readUInt16LE(offset, noAssert);
    }-*/;
    
    //unsigned int
    public final native double readUInt32BE(int offset) /*-{
        return this.readUInt32BE(offset);
    }-*/;

    public final native double readUInt32BE(int offset, boolean noAssert) /*-{
        return this.readUInt32BE(offset, noAssert);
    }-*/;

    public final native double readUInt32LE(int offset) /*-{
        return this.readUInt32LE(offset);
    }-*/;

    public final native double readUInt32LE(int offset, boolean noAssert) /*-{
        return this.readUInt32LE(offset, noAssert);
    }-*/;
    
    public final native byte readInt8(int offset) /*-{
        return this.readInt8(offset);
    }-*/;

    public final native byte readInt8(int offset, boolean noAssert) /*-{
        return this.readInt8(offset, noAssert);
    }-*/;
    
    public final native short readInt16BE(int offset) /*-{
        return this.readInt16BE(offset);
    }-*/;

    public final native short readInt16BE(int offset, boolean noAssert) /*-{
        return this.readInt16BE(offset, noAssert);
    }-*/;
    
    public final native short readInt16LE(int offset) /*-{
        return this.readInt16LE(offset);
    }-*/;

    public final native short readInt16LE(int offset, boolean noAssert) /*-{
        return this.readInt16LE(offset, noAssert);
    }-*/;
    
    public final native int readInt32BE(int offset) /*-{
        return this.readInt32BE(offset);
    }-*/;

    public final native int readInt32BE(int offset, boolean noAssert) /*-{
        return this.readInt32BE(offset, noAssert);
    }-*/;
    
    public final native int readInt32LE(int offset) /*-{
        return this.readInt32LE(offset);
    }-*/;

    public final native int readInt32LE(int offset, boolean noAssert) /*-{
        return this.readInt32LE(offset, noAssert);
    }-*/;
    
    public final native float readFloatBE(int offset) /*-{
        return this.readFloatBE(offset);
    }-*/;

    public final native float readFloatBE(int offset, boolean noAssert) /*-{
        return this.readFloatBE(offset, noAssert);
    }-*/;
    
    public final native float readFloatLE(int offset) /*-{
        return this.readFloatLE(offset);
    }-*/;

    public final native float readFloatLE(int offset, boolean noAssert) /*-{
        return this.readFloatLE(offset, noAssert);
    }-*/;
    
    public final native double readDoubleBE(int offset) /*-{
        return this.readDoubleBE(offset);
    }-*/;

    public final native double readDoubleBE(int offset, boolean noAssert) /*-{
        return this.readDoubleBE(offset, noAssert);
    }-*/;
    
    public final native double readDoubleLE(int offset) /*-{
        return this.readDoubleLE(offset);
    }-*/;

    public final native double readDoubleLE(int offset, boolean noAssert) /*-{
        return this.readDoubleLE(offset, noAssert);
    }-*/;
    
    public final native void writeUInt8(short value, int offset) /*-{
        this.writeUInt8(value, offset);
    }-*/;

    public final native void writeUInt8(short value, int offset, boolean noAssert) /*-{
        this.writeUInt8(value, offset, noAssert);
    }-*/;
    
    public final native void writeUInt16BE(int value, int offset) /*-{
        this.writeUInt16BE(value, offset);
    }-*/;

    public final native void writeUInt16BE(int value, int offset, boolean noAssert) /*-{
        this.writeUInt16BE(value, offset, noAssert);
    }-*/;
    
    public final native void writeUInt16LE(int value, int offset) /*-{
        this.writeUInt16LE(value, offset);
    }-*/;

    public final native void writeUInt16LE(int value, int offset, boolean noAssert) /*-{
        this.writeUInt16LE(value, offset, noAssert);
    }-*/;
    
    public final native void writeUInt32BE(double value, int offset) /*-{
        this.writeUInt32BE(value, offset);
    }-*/;

    public final native void writeUInt32BE(double value, int offset, boolean noAssert) /*-{
        this.writeUInt32BE(value, offset, noAssert);
    }-*/;
    
    public final native void writeUInt32LE(double value, int offset) /*-{
        this.writeUInt32LE(value, offset);
    }-*/;

    public final native void writeUInt32LE(double value, int offset, boolean noAssert) /*-{
        this.writeUInt32LE(value, offset, noAssert);
    }-*/;
    
    public final native void writeInt8(byte value, int offset) /*-{
        this.writeInt8(value, offset);
    }-*/;

    public final native void writeInt8(byte value, int offset, boolean noAssert) /*-{
        this.writeInt8(value, offset, noAssert);
    }-*/;
    
    public final native void writeInt16BE(short value, int offset) /*-{
        this.writeInt16BE(value, offset);
    }-*/;

    public final native void writeInt16BE(short value, int offset, boolean noAssert) /*-{
        this.writeInt16BE(value, offset, noAssert);
    }-*/;
    
    public final native void writeInt16LE(short value, int offset) /*-{
        this.writeInt16LE(value, offset);
    }-*/;

    public final native void writeInt16LE(short value, int offset, boolean noAssert) /*-{
        this.writeInt16LE(value, offset, noAssert);
    }-*/;
    
    public final native void writeInt32BE(int value, int offset) /*-{
        this.writeInt32BE(value, offset);
    }-*/;

    public final native void writeInt32BE(int value, int offset, boolean noAssert) /*-{
        this.writeInt32BE(value, offset, noAssert);
    }-*/;
    
    public final native void writeInt32LE(int value, int offset) /*-{
        this.writeInt32LE(value, offset);
    }-*/;

    public final native void writeInt32LE(int value, int offset, boolean noAssert) /*-{
        this.writeInt32LE(value, offset, noAssert);
    }-*/;

    public final native void writeFloatBE(float value, int offset) /*-{
        this.writeFloatBE(value, offset);
    }-*/;
    
    public final native void writeFloatBE(float value, int offset, boolean noAssert) /*-{
        this.writeFloatBE(value, offset, noAssert);
    }-*/;

    public final native void writeFloatLE(float value, int offset) /*-{
        this.writeFloatLE(value, offset);
    }-*/;
    
    public final native void writeFloatLE(float value, int offset, boolean noAssert) /*-{
        this.writeFloatLE(value, offset, noAssert);
    }-*/;

    public final native void writeDoubleBE(double value, int offset) /*-{
        this.writeDoubleBE(value, offset);
    }-*/;
    
    public final native void writeDoubleBE(double value, int offset, boolean noAssert) /*-{
        this.writeDoubleBE(value, offset, noAssert);
    }-*/;

    public final native void writeDoubleLE(double value, int offset) /*-{
        this.writeDoubleLE(value, offset);
    }-*/;
    
    public final native void writeDoubleLE(double value, int offset, boolean noAssert) /*-{
        this.writeDoubleLE(value, offset, noAssert);
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
