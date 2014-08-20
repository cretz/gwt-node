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
package org.gwtnode.modules.mysql;

import java.util.Date;
import java.util.List;

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.meta.GwtNodeEvent;
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.node.event.EventEmitter;
import org.gwtnode.core.node.event.ParameterlessEventHandler;
import org.gwtnode.modules.mysql.events.MySQLErrorEventHandler;
import org.gwtnode.modules.mysql.packets.RowDataPacket;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

//TODO: 1) add multiple statements query support 
//TODO: 2) add full support of stored procedures query 
//TODO: 3) wrap format method (is it really needed?)

@GwtNodeObject
public class Connection extends EventEmitter {
	
	private static final JavaScriptObject asJSO(Object value) {
    if (value == null) return null;
    if (value instanceof String) return asJSOString((String) value); 
    if (value instanceof Integer) return asJSOInt(((Integer) value).intValue());
    if (value instanceof Date) return asJSODate((double) ((Date) value).getTime()); 
    if (value instanceof Double) return asJSODouble(((Double) value).doubleValue());
    if (value instanceof Long) return asJSODouble(((Long) value).doubleValue());
    if (value instanceof Boolean) return asJSOBoolean(((Boolean) value).booleanValue());
    if (value instanceof Iterable) return asJSOArray((Iterable<?>) value);
    if (value.getClass().isArray()) return asJSOArray((Object[]) value);
    return asJSOObject(value);
	}

	private static final native JavaScriptObject asJSODate(double value) /*-{
  	return new Date(value);
	}-*/;

	private static final native JavaScriptObject asJSOString(String value) /*-{
    return value;
	}-*/;

	private static final native JavaScriptObject asJSOInt(int value) /*-{
    return value;
	}-*/;
	
	private static final native JavaScriptObject asJSODouble(double value) /*-{
    return value;
	}-*/;

	private static final native JavaScriptObject asJSOBoolean(boolean value) /*-{
  	return value;
	}-*/;
	
	private static final native JavaScriptObject asJSOObject(Object value) /*-{
    return value;
	}-*/;

	private static final JavaScriptObject asJSOArray(Object[] value) {
		JsArray<JavaScriptObject> result = JavaScriptObject.createArray().cast();
		for (Object item : value)
			result.push(asJSO(item));
		return result;
	}
	
	private static final JavaScriptObject asJSOArray(Iterable<?> value) {
		JsArray<JavaScriptObject> result = JavaScriptObject.createArray().cast();
		for (Object item : value)
			result.push(asJSO(item));
		return result;
	}
	
	protected Connection() {}
	
	@GwtNodeEvent
	public final void onError(MySQLErrorEventHandler handler) {
		on("error", handler);
	}

	@GwtNodeFunction
	public final native void ping() /*-{
		this.ping();
	}-*/;
	
	@GwtNodeFunction
	public final void ping(ParameterlessEventHandler handler) {
		if (handler == null) ping();
		else ping(handler.getNativeFunction());
	}

	public final native void ping(JavaScriptFunction cb) /*-{
		this.ping(cb);
	}-*/;
	
	@GwtNodeFunction
	public final native void connect() /*-{
		this.connect();
	}-*/;
	
	@GwtNodeFunction
	public final void connect(MySQLErrorEventHandler handler) {
		if (handler != null) connect(handler.getNativeFunction());
		else connect();
	}
	
	private final native void connect(JavaScriptFunction cb) /*-{
		this.connect(cb);
	}-*/;
	
	@GwtNodeFunction
	public final native void destroy() /*-{
		this.destroy();
	}-*/;
	
	@GwtNodeFunction
	public final native void end() /*-{
		this.end();
	}-*/;
	
	@GwtNodeFunction
	public final void end(MySQLErrorEventHandler handler) {
		if (handler != null) end(handler.getNativeFunction());
		else end();
	}
	
	private final native void end(JavaScriptFunction cb) /*-{
    this.end(cb);
	}-*/;

	@GwtNodeFunction
	public final native void pause() /*-{
		this.pause();
	}-*/;
	
	@GwtNodeFunction
	public final native void resume() /*-{
		this.resume();
	}-*/;
	
	@GwtNodeFunction
	public final native String escape(String value) /*-{
		this.escape(value);
	}-*/;
	
	@GwtNodeFunction
	public final native Query query(String sql) /*-{
		return this.query(sql);
	}-*/;
	
	@GwtNodeFunction
	public final Query query(String sql, QueryResultCallback callback) {
		return callback == null ? query(sql) : query(sql, callback.getNativeFunction());
	}
	
	private final native Query query(String sql, JavaScriptFunction cb) /*-{
    return this.query(sql, cb);
	}-*/;

	@GwtNodeFunction
	public final Query query(String sql, JavaScriptObject values) {
		if (values == null) return query(sql);
		return query(sql, values, (JavaScriptFunction) null);
	}

	@GwtNodeFunction
	public final Query query(String sql, JavaScriptObject values, QueryResultCallback callback) {
		if (values == null && callback == null) return query(sql);
		if (values == null) return query(sql, callback);
		return query(sql, values, callback != null ? callback.getNativeFunction() : null);
	}

	@GwtNodeFunction
	public final Query query(String sql, RowDataPacket values, QueryResultCallback callback) {
		return query(sql, values != null ? values.getJavaScriptObject() : null, callback);
	}
	
	@GwtNodeFunction
	public final Query query(String sql, List<RowDataPacket> values, QueryResultCallback callback) {
		JsArray<JavaScriptObject> jsaValues = null;
		if (values != null) {
			jsaValues = JavaScriptObject.createArray().cast();
			for (RowDataPacket value : values)
				jsaValues.push(value.getJavaScriptObject());
		}
		return query(sql, jsaValues, callback);
	}
	
	@GwtNodeFunction
	public final Query query(String sql, Object values, QueryResultCallback callback) {
		return query(sql, asJSO(values), callback != null ? callback.getNativeFunction() : null);
	}

	@GwtNodeFunction
	public final Query query(String sql, Object values) {
		return query(sql, asJSO(values), (JavaScriptFunction) null);
	}

	@GwtNodeFunction
	public final Query query(String sql, Object[] values, QueryResultCallback callback) {
		JsArray<JavaScriptObject> jsaValues = null;
		if (values != null) {
			jsaValues = JavaScriptObject.createArray().cast();
			for (Object value : values)
				jsaValues.push(asJSO(value));
		}
		return query(sql, jsaValues, callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	public final Query query(String sql, Object[] values) {
		return query(sql, values, (QueryResultCallback) null);
	}
	
	private final native Query query(String sql, JavaScriptObject values, JavaScriptFunction cb) /*-{
    return this.query(sql, values, cb);
	}-*/;
	
	/**
	 * Use {@link ConnectionOptions#create(String, String, String, String)} method for {@code options}.
	 * @param options
	 * @param handler
	 */
	@GwtNodeFunction
	public final void changeUser(ConnectionOptions options, MySQLErrorEventHandler handler) {
		changeUser(options, handler != null ? handler.getNativeFunction() : null);
	}
	
	/**
	 * @param options
	 * @see #changeUser(ConnectionOptions, MySQLErrorEventHandler)
	 */
	@GwtNodeFunction
	public final void changeUser(ConnectionOptions options) {
		changeUser(options, (JavaScriptFunction) null);
	}
	
	private final native void changeUser(JavaScriptObject options, JavaScriptFunction cb) /*-{
    return this.query(sql, values, cb);
	}-*/;
}
