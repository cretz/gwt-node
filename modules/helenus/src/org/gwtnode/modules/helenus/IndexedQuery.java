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
import com.google.gwt.core.client.JsArray;

public class IndexedQuery extends JavaScriptObject {

	public enum Operator {EQ, GTE, GT, LTE, LT}
	
	public static final class Field extends JavaScriptObject {
		
		public static Field create(String column, Operator operator, String value) {
			Field result = JavaScriptObject.createObject().cast();
			result.column(column);
			result.operator(operator);
			result.value(value);
			return result;
		}
		
		protected Field() {}
		
		/**
		 * The name of the column with the index.
		 */
		public native String column() /*-{
	    return this.column;
		}-*/;

		/**
		 * The name of the column with the index.
		 */
		public native void column(String column) /*-{
	    this.column = column;
		}-*/;
		
		/**
		 * The operator to use.
		 */
		public Operator operator() {
	    return Operator.valueOf(this.operator0());
		}

		private native String operator0() /*-{
	    return this.operator;
		}-*/;

		/**
		 * The operator to use.
		 */
		public void operator(Operator operator) {
			operator0(operator.name());
		}
		
		private native void operator0(String operator) /*-{
	    this.operator = operator;
		}-*/;
		
		/**
		 * The value to query by.
		 */
		public native String value() /*-{
	    return this.value;
		}-*/;

		/**
		 * The value to query by.
		 */
		public native void value(String value) /*-{
	    this.value = value;
		}-*/;
	}
	
	public static final IndexedQuery create() {
		return JavaScriptObject.createObject().<IndexedQuery> cast();
	}
	
	public static final IndexedQuery create(JsArray<Field> fields, String start, int max) {
		IndexedQuery result = create();
		result.fields(fields);
		result.start(start);
		result.max(max);
		return result;
	}
	
	protected IndexedQuery() {}
	
	/**
	 * An array of {@link Field}s.
	 */
	public final native JsArray<Field> fields() /*-{
    return this.fields;
	}-*/;

	/**
	 * An array of {@link Field}s.
	 */
	public final native void fields(JsArray<Field> fields) /*-{
    this.fields = fields;
	}-*/;
	
	/**
	 * The start key to get.
	 */
	public final native String start() /*-{
    return this.start;
	}-*/;

	/**
	 * The start key to get.
	 */
	public final native void start(String start) /*-{
    this.start = start;
	}-*/;
	
	/**
	 * The total amount of rows to return.
	 */
	public final native int max() /*-{
    return this.max;
	}-*/;

	/**
	 * The total amount of rows to return.
	 */
	public final native void max(int max) /*-{
    this.max = max;
	}-*/;
}
