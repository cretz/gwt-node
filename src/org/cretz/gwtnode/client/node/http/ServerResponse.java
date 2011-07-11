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
package org.cretz.gwtnode.client.node.http;

import org.cretz.gwtnode.client.JavaScriptUtils;
import org.cretz.gwtnode.client.JsonStringObjectMap;
import org.cretz.gwtnode.client.node.stream.WriteableStream;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public class ServerResponse extends WriteableStream {

    protected ServerResponse() {
    }

    public final native void writeContinue() /*-{
        this.writeContinue();
    }-*/;

    public final native void writeHead(int statusCode) /*-{
        this.writeHead(statusCode);
    }-*/;

    public final void writeHead(int statusCode, JsonStringObjectMap<String> headers) {
        writeHead(statusCode, headers.getNativeObject());
    }
    
    public final native void writeHead(int statusCode, JavaScriptObject headers) /*-{
        this.writeHead(statusCode, headers);
    }-*/;
    
    public final native void writeHead(int statusCode, String reasonPhrase) /*-{
        this.writeHead(statusCode, reasonPhrase);
    }-*/;

    public final void writeHead(int statusCode, String reasonPhrase,
            JsonStringObjectMap<String> headers) {
        writeHead(statusCode, reasonPhrase, headers.getNativeObject());
    }
    
    public final native void writeHead(int statusCode, String reasonPhrase,
            JavaScriptObject headers) /*-{
        this.writeHead(statusCode, reasonPhrase, headers);
    }-*/;

    public final native int statusCode() /*-{
        return this.statusCode;
    }-*/;

    public final native void statusCode(int statusCode) /*-{
        this.statusCode = statusCode;
    }-*/;

    public final native void setHeader(String name, String value) /*-{
        this.setHeader(name, value);
    }-*/;

    public final void setHeader(String name, String... value) {
        setHeader(name, JavaScriptUtils.toStringArray(value));
    }

    public final native void setHeader(String name, JsArrayString value) /*-{
        this.setHeader(name, value);
    }-*/;

    public final native JsArrayString getHeader(String name) /*-{
        return this.getHeader(name);
    }-*/;

    public final native void removeHeader(String name) /*-{
        this.removeHeader(name);
    }-*/;

    public final void addTrailers(JsonStringObjectMap<String> trailers) {
        addTrailers(trailers.getNativeObject());
    }

    public final native void addTrailers(JavaScriptObject trailers) /*-{
        this.writeHead(trailers);
    }-*/;
}
