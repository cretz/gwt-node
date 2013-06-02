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
package org.gwtnode.modules.cassandra;

import static org.gwtnode.modules.cassandra.JsUtils.asJSO;
import static org.gwtnode.modules.cassandra.JsUtils.asJSOArray;

import java.util.List;

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.meta.GwtNodeEvent;
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.node.event.ErrorEventHandler;
import org.gwtnode.core.node.event.EventEmitter;
import org.gwtnode.core.node.event.ParameterlessEventHandler;
import org.gwtnode.core.node.util.Util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;

@GwtNodeObject
public class Connection extends EventEmitter {

	private static final Util U = Util.get();
	
	@GwtNodeFunction("constructor")
	public static final native Connection create(Options options) /*-{
		return new (@org.gwtnode.modules.cassandra.Cassandra::get()()).Connection(options);
	}-*/;
	
	protected Connection() {}
	
	/**
	 * Makes the connection.
	 * 
	 * @param callback
	 *          Called when connection is successful or ultimately fails (error will be present).
	 */
	@GwtNodeFunction
	public final void connect(ErrorEventHandler callback) {
		connect(callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void connect(JavaScriptFunction callback) /*-{
		this.connect(callback);
	}-*/;
	
	/**
	 * Closes the current connection.<br>
	 * Note that the callback is only called, if the "close" event is fired. Also we only wait for the "close" event if a
	 * callback is given.
	 * 
	 * @param callback
	 */
	@GwtNodeFunction
	public final void close(ParameterlessEventHandler callback) {
		close(callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void close(JavaScriptFunction callback) /*-{
		this.close(callback);
	}-*/;

	/**
	 * Executes any query.
	 * 
	 * @param query
	 *          Any CQL statement with '?' placeholders.
	 * @param args
	 *          Array of arguments that will be bound to the query.
	 * @param callback
	 *          executed when the query returns.
	 */
	@GwtNodeFunction
	public final void execute(String query, Object[] args, ResultEventHandler callback) {
		execute(query, asJSOArray(args), callback != null ? callback.getNativeFunction() : null);
	}
	
	/**
	 * Executes any query.
	 * 
	 * @param query
	 *          Any CQL statement with '?' placeholders.
	 * @param args
	 *          List of arguments that will be bound to the query.
	 * @param callback
	 *          executed when the query returns.
	 */
	@GwtNodeFunction
	public final void execute(String query, List<?> args, ResultEventHandler callback) {
		execute(query, asJSOArray(args), callback != null ? callback.getNativeFunction() : null);
	}
	
	/**
	 * Executes any query.
	 * 
	 * @param query
	 *          Any CQL statement with '?' placeholders.
	 * @param arg
	 *          An arguments that will be bound to the query.
	 * @param callback
	 *          executed when the query returns.
	 */
	@GwtNodeFunction
	public final void execute(String query, Object arg, ResultEventHandler callback) {
		JsArrayMixed args = JavaScriptObject.createArray().cast();
		args.push(asJSO(arg));
		execute(query, args, callback != null ? callback.getNativeFunction() : null);
	}
	
	/**
	 * Executes any query.
	 * 
	 * @param query
	 *          Any CQL statement.
	 * @param callback
	 *          executed when the query returns.
	 */
	@GwtNodeFunction
	public final void execute(String query, ResultEventHandler callback) {
		JsArrayMixed args = JavaScriptObject.createArray().cast();
		execute(query, args, callback != null ? callback.getNativeFunction() : null);
	}
	
	/**
	 * Executes any query.
	 * 
	 * @param query
	 *          Any CQL statement with '?' placeholders.
	 * @param args
	 *          Array of arguments that will be bound to the query.
	 * @param callback
	 *          executed when the query returns.
	 */
	@GwtNodeFunction
	public final void execute(String query, JsArrayMixed args, ResultEventHandler callback) {
		execute(query, args, callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void execute(String query, JsArrayMixed args, JavaScriptFunction callback) /*-{
		this.execute(query, args, callback);
	}-*/;
	
	@GwtNodeEvent
	public final void onLog(LogEventHandler handler) {
		on("log", handler);
	}
}
