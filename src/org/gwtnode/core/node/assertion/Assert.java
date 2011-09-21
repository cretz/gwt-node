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
package org.gwtnode.core.node.assertion;

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.JavaScriptFunctionWrapper;
import org.gwtnode.core.node.Global;
import org.gwtnode.core.node.NodeJsModule;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.6/api/assert.html">Assert</a>
 * module.
 * 
 * @author Chad Retz
 */
public class Assert extends JavaScriptObject implements NodeJsModule {

    private static Assert instance;
    
    public static Assert get() {
        if (instance == null) {
            instance = Global.get().require("assert");
        }
        return instance;
    }
    
    protected Assert() {
    }
    
    public final native void fail(Object actual, Object expected,
            String message, String operator) /*-{
        this.fail(actual, expected, message, operator);
    }-*/;
    
    public final native void ok(boolean value) /*-{
        this.ok(value);
    }-*/;
    
    public final native void ok(boolean value, String message) /*-{
        this.ok(value, message);
    }-*/;
    
    public final native void equal(Object actual, Object expected) /*-{
        this.equal(actual, expected);
    }-*/;
    
    public final native void equal(Object actual, Object expected, String message) /*-{
        this.equal(actual, expected, message);
    }-*/;
    
    public final native void notEqual(Object actual, Object expected) /*-{
        this.notEqual(actual, expected);
    }-*/;
    
    public final native void notEqual(Object actual, Object expected, String message) /*-{
        this.notEqual(actual, expected, message);
    }-*/;
    
    public final native void deepEqual(Object actual, Object expected) /*-{
        this.deepEqual(actual, expected);
    }-*/;
    
    public final native void deepEqual(Object actual, Object expected, String message) /*-{
        this.deepEqual(actual, expected, message);
    }-*/;
    
    public final native void notDeepEqual(Object actual, Object expected) /*-{
        this.notDeepEqual(actual, expected);
    }-*/;
    
    public final native void notDeepEqual(Object actual, Object expected, String message) /*-{
        this.notDeepEqual(actual, expected, message);
    }-*/;
    
    public final native void strictEqual(Object actual, Object expected) /*-{
        this.strictEqual(actual, expected);
    }-*/;
    
    public final native void strictEqual(Object actual, Object expected, String message) /*-{
        this.strictEqual(actual, expected, message);
    }-*/;
    
    public final native void notStrictEqual(Object actual, Object expected) /*-{
        this.notStrictEqual(actual, expected);
    }-*/;
    
    public final native void notStrictEqual(Object actual, Object expected, String message) /*-{
        this.notStrictEqual(actual, expected, message);
    }-*/;
    
    public final void throwsError(JavaScriptFunctionWrapper block) {
        throwsError(block.getNativeFunction());
    }
    
    public final native void throwsError(JavaScriptFunction block) /*-{
        this['throws'](block);
    }-*/;
    
    public final void throwsError(JavaScriptFunctionWrapper block, JavaScriptObject error) {
        throwsError(block.getNativeFunction(), error);
    }
    
    public final native void throwsError(JavaScriptFunction block, JavaScriptObject error) /*-{
        this['throws'](block, error);
    }-*/;
    
    public final void throwsError(JavaScriptFunctionWrapper block, JavaScriptObject error,
            String message) {
        throwsError(block.getNativeFunction(), error, message);
    }
    
    public final native void throwsError(JavaScriptFunction block, JavaScriptObject error,
            String message) /*-{
        this['throws'](block, error, message);
    }-*/;
    
    public final void doesNotThrowError(JavaScriptFunctionWrapper block) {
        doesNotThrowError(block.getNativeFunction());
    }
    
    public final native void doesNotThrowError(JavaScriptFunction block) /*-{
        this.doesNotThrow(block);
    }-*/;
    
    public final void doesNotThrowError(JavaScriptFunctionWrapper block, JavaScriptObject error) {
        doesNotThrowError(block.getNativeFunction(), error);
    }
    
    public final native void doesNotThrowError(JavaScriptFunction block, JavaScriptObject error) /*-{
        this.doesNotThrow(block, error);
    }-*/;
    
    public final void doesNotThrowError(JavaScriptFunctionWrapper block, JavaScriptObject error,
            String message) {
        doesNotThrowError(block.getNativeFunction(), error, message);
    }
    
    public final native void doesNotThrowError(JavaScriptFunction block, JavaScriptObject error,
            String message) /*-{
        this.doesNotThrow(block, error, message);
    }-*/;
    
    public final native void ifError(JavaScriptObject value) /*-{
        this.ifError(value);
    }-*/;
}
