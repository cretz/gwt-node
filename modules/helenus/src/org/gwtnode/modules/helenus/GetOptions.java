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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;

public class GetOptions extends JavaScriptObject {
	
	public static final GetOptions create() {
		return JavaScriptObject.createObject().<GetOptions> cast();
	}

	public static final GetOptions create(
			Object start, Object end, boolean reversed, int max, JsArrayMixed columns, int consistencyLevel) {
		GetOptions result = create();
		result.start(start);
		result.end(end);
		result.reversed(reversed);
		result.max(max);
		result.columns(columns);
		result.consistencyLevel(consistencyLevel);
		return result;
	}
	
	protected GetOptions() {}
	
	/**
	 * The from part of the column name, for composites pass an array. By default the composite queries are inclusive, to
	 * make them exclusive pass an array of arrays where the inner array is [ value, false ]
	 */
	public final native Object start() /*-{
    return this.start;
	}-*/;

	/**
	 * The from part of the column name, for composites pass an array. By default the composite queries are inclusive, to
	 * make them exclusive pass an array of arrays where the inner array is [ value, false ]
	 */
	public final native void start(Object start) /*-{
    this.start = start;
	}-*/;
	
	/**
	 * The end part of the column name, for composites pass an array. By default the composite queries are inclusive, to
	 * make them exclusive pass an array of arrays where the inner array is [ value, false ]
	 */
	public final native Object end() /*-{
    return this.end;
	}-*/;

	/**
	 * The end part of the column name, for composites pass an array. By default the composite queries are inclusive, to
	 * make them exclusive pass an array of arrays where the inner array is [ value, false ]
	 */
	public final native void end(Object end) /*-{
    this.end = end;
	}-*/;
	
	/**
	 * To whether the range is reversed or not.
	 */
	public final native boolean reversed() /*-{
    return this.reversed;
	}-*/;

	/**
	 * To whether the range is reversed or not.
	 */
	public final native void reversed(boolean reversed) /*-{
    this.reversed = reversed;
	}-*/;

	/**
	 * The max amount of columns to return.
	 */
	public final native int max() /*-{
    return this.max;
	}-*/;

	/**
	 * The max amount of columns to return.
	 */
	public final native void max(int max) /*-{
    this.max = max;
	}-*/;
	
	/**
	 * An array of column names to get.
	 */
	public final native JsArrayMixed columns() /*-{
    return this.columns;
	}-*/;

	/**
	 * An array of column names to get.
	 */
	public final native void columns(JsArrayMixed columns) /*-{
    this.columns = columns;
	}-*/;

	/**
	 * The read consistency level.
	 */
	public final native int consistencyLevel() /*-{
    return this.consistencyLevel;
	}-*/;

	/**
	 * The read consistency level.
	 */
	public final native void consistencyLevel(int consistencyLevel) /*-{
    this.consistencyLevel = consistencyLevel;
	}-*/;
}
