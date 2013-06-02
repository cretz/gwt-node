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
package org.gwtnode.modules.helenus;

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
	public static final native Connection create(ConnectionOptions options) /*-{
		return new (@org.gwtnode.modules.helenus.Helenus::get()()).Connection(options);
	}-*/;
	
	protected Connection() {}

	/**
	 * Connects to the cassandra cluster
	 */
	@GwtNodeFunction
	public final void connect(ConnectionEventHandler callback) {
		connect(callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void connect(JavaScriptFunction callback) /*-{
		this.connect(callback);
	}-*/;

	/**
	 * Sets the current keyspace
	 */
	@GwtNodeFunction
	public final void use(String keyspace, ConnectionEventHandler callback) {
		use(keyspace, callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void use(String keyspace, JavaScriptFunction callback) /*-{
		this.use(keyspace, callback);
	}-*/;
	
	/**
	 * Executes a CQL Query Against the DB.
	 * 
	 * @param query
	 *          A string representation of the query: 'select %s, %s from MyCf where key=%s'
	 * @param args
	 *          An Array of arguments for the query
	 * @param gzip
	 *          Whether use GZip for request or not
	 * @param callback
	 *          The callback function for the results
	 */
	@GwtNodeFunction
	public final void cql(String query, JsArrayMixed args, boolean gzip, ResultEventHandler callback) {
		JavaScriptObject options = JavaScriptObject.createObject();
		if (gzip) JsUtils.setProperty(options, "gzip", JsUtils.asJSOBoolean(true));
		cql(query, args, options, callback != null ? callback.getNativeFunction() : null);
	}

	/**
	 * Executes a CQL Query Against the DB.
	 * 
	 * @param query
	 *          A string representation of the query: 'select %s, %s from MyCf where key=%s'
	 * @param args
	 *          An Array of arguments for the query
	 * @param callback
	 *          The callback function for the results
	 */
	@GwtNodeFunction
	public final void cql(String query, Object[] args, ResultEventHandler callback) {
		cql(query, JsUtils.asJSOArray(args), callback != null ? callback.getNativeFunction() : null);
	}

	/**
	 * Executes a CQL Query Against the DB.
	 * 
	 * @param query
	 *          A string representation of the query: 'select %s, %s from MyCf where key=%s'
	 * @param args
	 *          An Array of arguments for the query
	 * @param callback
	 *          The callback function for the results
	 */
	@GwtNodeFunction
	public final void cql(String query, Iterable<?> args, ResultEventHandler callback) {
		cql(query, JsUtils.asJSOArray(args), callback != null ? callback.getNativeFunction() : null);
	}

	/**
	 * Executes a CQL Query Against the DB.
	 * 
	 * @param query
	 *          A string representation of the query: 'select * from MyCf where key=%s'
	 * @param arg
	 *          An only argument for the query
	 * @param callback
	 *          The callback function for the results
	 */
	@GwtNodeFunction
	public final void cql(String query, Object arg, ResultEventHandler callback) {
		JsArrayMixed args = JavaScriptObject.createArray().cast();
		args.push(JsUtils.asJSO(arg));
		cql(query, args, callback != null ? callback.getNativeFunction() : null);
	}

	/**
	 * Executes a CQL Query Against the DB.
	 * 
	 * @param query
	 *          A string representation of the query: 'select %s, %s from MyCf where key=%s'
	 * @param args
	 *          An Array of arguments for the query
	 * @param callback
	 *          The callback function for the results
	 */
	@GwtNodeFunction
	public final void cql(String query, JsArrayMixed args, ResultEventHandler callback) {
		cql(query, args, callback != null ? callback.getNativeFunction() : null);
	}

	/**
	 * Executes a CQL Query Against the DB.
	 * 
	 * @param query
	 *          A string representation of the parameterless query: 'select * from MyCf'
	 * @param callback
	 *          The callback function for the results
	 */
	@GwtNodeFunction
	public final void cql(String query, ResultEventHandler callback) {
		JsArrayMixed args = JavaScriptObject.createArray().cast();
		cql(query, args, callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void cql(
			String query, JsArrayMixed args, JavaScriptObject options, JavaScriptFunction callback) /*-{
		this.cql(query, args, options, callback);
	}-*/;


	@GwtNodeFunction
	private final native void cql(String query, JsArrayMixed args, JavaScriptFunction callback) /*-{
		this.cql(query, args, callback);
	}-*/;
	
	//TODO: implement createKeyspace method

	//TODO: implement dropKeyspace method

	@GwtNodeFunction
	public final native void close() /*-{
		this.close();
	}-*/;
	
	@GwtNodeEvent
	public final void onClose(ParameterlessEventHandler handler) {
		on("close", handler);
	}
	
	@GwtNodeEvent
	public final void onError(ErrorEventHandler handler) {
		on("error", handler);
	}
}
