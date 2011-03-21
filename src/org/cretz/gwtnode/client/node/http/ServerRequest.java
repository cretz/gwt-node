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

import org.cretz.gwtnode.client.JsonStringObjectMap;
import org.cretz.gwtnode.client.node.event.EventEmitter;
import org.cretz.gwtnode.client.node.event.ParameterlessEventHandler;
import org.cretz.gwtnode.client.node.event.StringOrBufferEventHandler;
import org.cretz.gwtnode.client.node.net.Socket;

import com.google.gwt.core.client.JavaScriptObject;

public class ServerRequest extends EventEmitter {

    protected ServerRequest() {
    }
    
    public final void onData(StringOrBufferEventHandler handler) {
        on("data", handler);
    }
    
    public final void end(ParameterlessEventHandler handler) {
        on("end", handler);
    }
    
    public final native String method() /*-{
        return this.method;
    }-*/;

    public final native String url() /*-{
        return this.url;
    }-*/;
    
    public final JsonStringObjectMap<String> headerMap() {
        return new JsonStringObjectMap<String>(headers());
    }

    public final native JavaScriptObject headers() /*-{
        return this.headers;
    }-*/;
    
    public final JsonStringObjectMap<String> trailerMap() {
        return new JsonStringObjectMap<String>(trailers());
    }

    public final native JavaScriptObject trailers() /*-{
        return this.trailers;
    }-*/;

    public final native String httpVersion() /*-{
        return this.httpVersion;
    }-*/;
    
    public final native void setEncoding() /*-{
        this.setEncoding();
    }-*/;
    
    public final native void setEncoding(String encoding) /*-{
        this.setEncoding(encoding);
    }-*/;
    
    public final native void pause() /*-{
        this.pause();
    }-*/;
    
    public final native void resume() /*-{
        this.resume();
    }-*/;
    
    public final native Socket connection() /*-{
        this.connection;
    }-*/;
    
}
