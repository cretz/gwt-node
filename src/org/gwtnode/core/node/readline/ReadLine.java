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
package org.gwtnode.core.node.readline;

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.JavaScriptReturningFunction;
import org.gwtnode.core.node.Global;
import org.gwtnode.core.node.NodeJsModule;
import org.gwtnode.core.node.event.EventEmitter;
import org.gwtnode.core.node.event.ParameterlessEventHandler;
import org.gwtnode.core.node.event.StringEventHandler;
import org.gwtnode.core.node.stream.ReadableStream;
import org.gwtnode.core.node.stream.WritableStream;

import com.google.gwt.core.client.JsArrayString;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.6/api/readline.html">readline</a>
 * module.
 *
 * @author Chad Retz
 */
public class ReadLine extends EventEmitter implements NodeJsModule {

    private static ReadLine instance;
    
    public static ReadLine get() {
        if (instance == null) {
            instance = Global.get().require("readline");
        }
        return instance;
    }
    
    protected ReadLine() {
    }
    
    public final void onLine(StringEventHandler handler) {
        on("line", handler);
    }
    
    public final void onClose(ParameterlessEventHandler handler) {
        on("close", handler);
    }

    public final native Interface createInterface(ReadableStream input, WritableStream output) /*-{
        return this.createInterface(input, output);
    }-*/;
    
    public final Interface createInterface(ReadableStream input, WritableStream output,
            Completer completer) {
        return createInterface(input, output, completer.getNativeFunction());
    }

    public final native Interface createInterface(ReadableStream input, WritableStream output,
            JavaScriptReturningFunction<JsArrayString> completer) /*-{
        return this.createInterface(input, output, completer);
    }-*/;
    
    public final void question(String query, QuestionCallback callback) {
        question(query, callback.getNativeFunction());
    }
    
    public final native void question(String query, JavaScriptFunction callback) /*-{
        this.question(query, callback);
    }-*/;
    
    public final native void close() /*-{
        this.close();
    }-*/;

    public final native void pause() /*-{
        this.pause();
    }-*/;

    public final native void resume() /*-{
        this.resume();
    }-*/;

    //TODO: write()

}
