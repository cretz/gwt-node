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
package org.cretz.gwtnode.client.node.buffer;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A node.js
 * <a href="http://nodejs.org/docs/v0.2.6/api.html#buffers-2">Buffer</a>
 * 
 * @author Chad Retz
 */
public class Buffer extends JavaScriptObject {
    
    public static final native Buffer create(int size) /*-{
        return new Buffer(size);
    }-*/;

    public static final native Buffer create(byte[] array) /*-{
        return new Buffer(array);
    }-*/;

    public static final native Buffer create(String string) /*-{
        return new Buffer(string);
    }-*/;

    public static final native Buffer create(String string, String encoding) /*-{
        return new Buffer(string, encoding);
    }-*/;
    
    public static final native int byteLength(String string) /*-{
        return Buffer.byteLength(string);
    }-*/;
    
    public static final native int byteLength(String string, String encoding) /*-{
        return Buffer.byteLength(string, encoding);
    }-*/;
    
    protected Buffer() {
    }
    
    public final native void write(String string) /*-{
        this.write(string);
    }-*/;
    
    public final native void write(String string, int offset) /*-{
        this.write(string, offset);
    }-*/;
    
    public final native void write(String string, int offset, String encoding) /*-{
        this.write(string, offset, encoding);
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
}
