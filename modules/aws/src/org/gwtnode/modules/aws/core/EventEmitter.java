/*
 * Copyright 2013 Maxim Dominichenko
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
package org.gwtnode.modules.aws.core;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.JavaScriptFunctionWrapper;
import org.gwtnode.core.JsonStringObjectMap;
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * See <a href="http://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/EventEmitter.html">AWS.EventEmitter</a> for
 * details.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class EventEmitter extends JavaScriptObject {
	
	/**
	 * Constructs an event emitter object.
	 */
	@GwtNodeFunction("constructor")
	public static final native EventEmitter create() /*-{
		return new (@org.gwtnode.modules.aws.AWS::get()()).EventEmitter();
	}-*/;
	
	protected EventEmitter() {}

	/**
	 * Adds or copies a set of listeners from another list of listeners.
	 */
	@GwtNodeFunction
	public final EventEmitter addListeners(Map<String, List<JavaScriptFunctionWrapper>> listeners) {
		JsonStringObjectMap<JsArray<JavaScriptFunction>> jsom = new JsonStringObjectMap<JsArray<JavaScriptFunction>>();
		for (Entry<String, List<JavaScriptFunctionWrapper>> entry : listeners.entrySet()) {
			JsArray<JavaScriptFunction> value = JavaScriptObject.createArray().cast();
			for (JavaScriptFunctionWrapper function : entry.getValue())
				value.push(function.getNativeFunction());
			jsom.put(entry.getKey(), value);
		}
		return addListeners(jsom.getNativeObject());
	}
	
	@GwtNodeFunction
	private final native EventEmitter addListeners(JavaScriptObject listeners) /*-{
		return this.addListeners(listeners);
	}-*/;

	/**
	 * Adds or copies a set of listeners from another EventEmitter object.
	 */
	@GwtNodeFunction
	public final native EventEmitter addListeners(EventEmitter eventEmitter) /*-{
		return this.addListeners(eventEmitter);
	}-*/;
	
	/**
	 * Registers an event with {@link #on()} and saves the callback handle function as a property on the emitter object
	 * using a given name.
	 */
	@GwtNodeFunction
	public final EventEmitter addNamedListener(String name, String eventName, JavaScriptFunctionWrapper callback) {
		return addNamedListener(name, eventName, callback.getNativeFunction());
	}
	
	@GwtNodeFunction
	private final native EventEmitter addNamedListener(String name, String eventName, JavaScriptFunction callback) /*-{
		return this.addNamedListener(name, eventName, callback);
	}-*/;
	
	/**
	 * Registers an event listener callback for the event given by eventName.
	 */
	@GwtNodeFunction
	public final EventEmitter on(String eventName, JavaScriptFunctionWrapper listener) {
		return on(eventName, listener.getNativeFunction());
	}

	@GwtNodeFunction
	private final native EventEmitter on(String eventName, JavaScriptFunction listener) /*-{
		return this.on(eventName, listener);
	}-*/;
	
	@GwtNodeFunction
	public final native void removeAllListeners(String eventName) /*-{
		this.removeAllListeners(eventName);
	}-*/;
	
	@GwtNodeFunction
	public final void removeListener(String eventName, JavaScriptFunctionWrapper listener) {
		removeListener(eventName, listener.getNativeFunction());
	}
	
	@GwtNodeFunction
	private final native void removeListener(String eventName, JavaScriptFunction listener) /*-{
		this.removeListener(eventName, listener);
	}-*/;
}
