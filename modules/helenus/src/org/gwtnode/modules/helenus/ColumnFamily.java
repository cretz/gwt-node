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
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

@GwtNodeObject
public class ColumnFamily extends JavaScriptObject {

	protected ColumnFamily() {}

	/**
	 * Sets the marshaller for a given column name.
	 * 
	 * @param name
	 *          The name of column to set.
	 * @param type
	 *          The validation Class to use for the specified column.
	 */
	@GwtNodeFunction
	public final native void setColumnValidator(Object name, String type) /*-{
    this.setColumnValidator(name, type);
	}-*/;

	/**
	 * Gets the column validator (marshaller) for a column.
	 * 
	 * @param name
	 *          The name of column
	 * @return {@link Marshal}
	 */
	@GwtNodeFunction
	public final native Marshal getColumnValidator(Object name) /*-{
    return this.getColumnValidator(name);
	}-*/;

	/**
	 * Performs a set command to the cluster.
	 * 
	 * @param key
	 *          The key for the row.
	 * @param columns
	 *          The value for the columns as represented by an array of Column objects.
	 * @param options
	 *          The options for the insert.
	 * @param callback
	 *          The callback to call once complete.
	 */
	//FIXME: callback should be extended to get the successful results
	@GwtNodeFunction
	public final void insert(String key, Column[] columns, ThriftOptions options, EmptyEventHandler callback) {
		JsArray<Column> cols = JsUtils.asJSOArray((Object[]) columns).cast();
		insert(key, cols, options, callback != null ? callback.getNativeFunction() : null);
	}
	
	/**
	 * Performs a set command to the cluster.
	 * 
	 * @param key
	 *          The key for the row.
	 * @param columns
	 *          The value for the columns as represented by an array of Column objects.
	 * @param options
	 *          The options for the insert.
	 * @param callback
	 *          The callback to call once complete.
	 */
	//FIXME: callback should be extended to get the successful results
	@GwtNodeFunction
	public final void insert(String key, Iterable<Column> columns, ThriftOptions options, EmptyEventHandler callback) {
		JsArray<Column> cols = JsUtils.asJSOArray(columns).cast();
		insert(key, cols, options, callback != null ? callback.getNativeFunction() : null);
	}
	
	/**
	 * Performs a set command to the cluster.
	 * 
	 * @param key
	 *          The key for the row.
	 * @param columns
	 *          The value for the columns as represented by an array of Column objects.
	 * @param options
	 *          The options for the insert.
	 * @param callback
	 *          The callback to call once complete.
	 */
	//FIXME: callback should be extended to get the successful results
	@GwtNodeFunction
	public final void insert(String key, JsArray<Column> columns, ThriftOptions options, EmptyEventHandler callback) {
		insert(key, columns, options, callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void insert(
			String key, JsArray<Column> columns, ThriftOptions options, JavaScriptFunction callback) /*-{
		this.insert(key, columns, options, callback);
	}-*/;

	/**
	 * Remove a single column.
	 * 
	 * @param key
	 *          The key for this row.
	 * @param column
	 *          The column name.
	 * @param subcolumn
	 *          The subcolumn name.
	 * @param options
	 *          The thrift options for this operation.
	 * @param callback
	 *          The callback to call once complete.
	 */
	// FIXME: callback should be extended to get the successful results
	@GwtNodeFunction
	public final void remove(
			String key, Object column, Object subcolumn, ThriftOptions options, EmptyEventHandler callback) {
		remove(key, column, subcolumn, options, callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void remove(
			String key, Object column, Object subcolumn, ThriftOptions options, JavaScriptFunction callback) /*-{
		this.remove(key, column, subcolumn, options, callback);
	}-*/;
	
	/**
	 * Remove a single column.
	 * 
	 * @param key
	 *          The key for this row.
	 * @param column
	 *          The column name.
	 * @param subcolumn
	 *          The subcolumn name.
	 * @param callback
	 *          The callback to call once complete.
	 */
	// FIXME: callback should be extended to get the successful results
	@GwtNodeFunction
	public final void remove(String key, Object column, Object subcolumn, EmptyEventHandler callback) {
		remove(key, column, subcolumn, callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void remove(String key, Object column, Object subcolumn, JavaScriptFunction callback) /*-{
		this.remove(key, column, subcolumn, callback);
	}-*/;
	
	/**
	 * Remove a single column.
	 * 
	 * @param key
	 *          The key for this row.
	 * @param column
	 *          The column name.
	 * @param callback
	 *          The callback to call once complete.
	 */
	// FIXME: callback should be extended to get the successful results
	@GwtNodeFunction
	public final void remove(String key, Object column, EmptyEventHandler callback) {
		remove(key, column, callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void remove(String key, Object column, JavaScriptFunction callback) /*-{
		this.remove(key, column, callback);
	}-*/;
	
	/**
	 * Remove a single row.
	 * 
	 * @param key
	 *          The key for this row.
	 * @param callback
	 *          The callback to call once complete.
	 */
	// FIXME: callback should be extended to get the successful results
	@GwtNodeFunction
	public final void remove(String key, EmptyEventHandler callback) {
		remove(key, callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void remove(String key, JavaScriptFunction callback) /*-{
		this.remove(key, callback);
	}-*/;

	/**
	 * Counts the number of columns in a row by it's key.
	 * 
	 * @param key
	 *          The key to get.
	 * @param options
	 *          Options for the get.
	 * @param callback
	 *          The callback to invoke once the response has been received.
	 */
	@GwtNodeFunction
	public final void count(String key, GetOptions options, CountEventHandler callback) {
		count(key, options, callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void count(String key, GetOptions options, JavaScriptFunction callback) /*-{
		this.count(key, options, callback);
	}-*/;
	
	/**
	 * Counts the number of columns in a row by it's key.
	 * 
	 * @param key
	 *          The key to get.
	 * @param callback
	 *          The callback to invoke once the response has been received.
	 */
	@GwtNodeFunction
	public final void count(String key, CountEventHandler callback) {
		count(key, callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void count(String key, JavaScriptFunction callback) /*-{
		this.count(key, callback);
	}-*/;

	/**
	 * Get a row by its key.
	 * 
	 * @param key
	 *          The key to get.
	 * @param options
	 *          Options for the get.
	 * @param callback
	 *          The callback to invoke once the response has been received.
	 */
	@GwtNodeFunction
	public final void get(String key, GetOptions options, RowEventHandler callback) {
		get(key, options, callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void get(String key, GetOptions options, JavaScriptFunction callback) /*-{
		this.get(key, options, callback);
	}-*/;
	
	/**
	 * Get a row by its key.
	 * 
	 * @param key
	 *          The key to get.
	 * @param callback
	 *          The callback to invoke once the response has been received.
	 */
	@GwtNodeFunction
	public final void get(String key, RowEventHandler callback) {
		get(key, callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void get(String key, JavaScriptFunction callback) /*-{
		this.get(key, callback);
	}-*/;

	/**
	 * Truncates a ColumnFamily.
	 * 
	 * @param callback
	 *          The callback to invoke once the ColumnFamily has been truncated
	 */
	// FIXME: callback should be extended to get the successful results
	@GwtNodeFunction
	public final void truncate(EmptyEventHandler callback) {
		truncate(callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void truncate(JavaScriptFunction callback) /*-{
		this.truncate(callback);
	}-*/;

	/**
	 * Gets rows by their indexed fields.
	 * 
	 * @param query
	 *          Options for the rows part of the get.
	 * @param options
	 *          Options for the get.
	 * @param callback
	 *          The callback to invoke once the response has been received.
	 */
	@GwtNodeFunction
	public final void getIndexed(IndexedQuery query, GetOptions options, ResultEventHandler callback) {
		getIndexed(query, options, callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void getIndexed(IndexedQuery query, GetOptions options, JavaScriptFunction callback) /*-{
		this.getIndexed(query, options, callback);
	}-*/;
	
	/**
	 * Gets rows by their indexed fields.
	 * 
	 * @param query
	 *          Options for the rows part of the get.
	 * @param callback
	 *          The callback to invoke once the response has been received.
	 */
	@GwtNodeFunction
	public final void getIndexed(IndexedQuery query, ResultEventHandler callback) {
		getIndexed(query, callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void getIndexed(IndexedQuery query, JavaScriptFunction callback) /*-{
		this.getIndexed(query, callback);
	}-*/;

	/**
	 * Increments a counter column.
	 * 
	 * @param key
	 *          Row key
	 * @param column
	 *          Column name
	 * @param value
	 *          Integer to increase by, defaults to 1
	 * @param options
	 *          The thrift options
	 * @param callback
	 *          The callback to call once complete
	 */
	// FIXME: callback should be extended to get the successful results
	@GwtNodeFunction
	public final void incr(Object key, Object column, int value, ThriftOptions options, EmptyEventHandler callback) {
		incr(key, column, value, options, callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void incr(
			Object key, Object column, int value, ThriftOptions options, JavaScriptFunction callback) /*-{
		this.incr(key, column, value, options, callback);
	}-*/;
	
	/**
	 * Increments a counter column.
	 * 
	 * @param key
	 *          Row key
	 * @param column
	 *          Column name
	 * @param value
	 *          Integer to increase by, defaults to 1
	 * @param callback
	 *          The callback to call once complete
	 */
	// FIXME: callback should be extended to get the successful results
	@GwtNodeFunction
	public final void incr(Object key, Object column, int value, EmptyEventHandler callback) {
		incr(key, column, value, callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void incr(Object key, Object column, int value, JavaScriptFunction callback) /*-{
		this.incr(key, column, value, callback);
	}-*/;
	
	/**
	 * Increments a counter column.
	 * 
	 * @param key
	 *          Row key
	 * @param column
	 *          Column name
	 * @param callback
	 *          The callback to call once complete
	 */
	// FIXME: callback should be extended to get the successful results
	@GwtNodeFunction
	public final void incr(Object key, Object column, EmptyEventHandler callback) {
		incr(key, column, callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void incr(Object key, Object column, JavaScriptFunction callback) /*-{
		this.incr(key, column, callback);
	}-*/;
}
