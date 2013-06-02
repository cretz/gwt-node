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

import java.util.Date;

import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.meta.GwtNodeProperty;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;

@GwtNodeObject
public class Column extends JavaScriptObject {
	
	@GwtNodeFunction("constructor")
	public static final native Column create(Object name, Object value, JsDate timestamp, int ttl) /*-{
		return new (@org.gwtnode.modules.helenus.Helenus::get()()).Column(name, value, timestamp, ttl);
	}-*/;

	@GwtNodeFunction("constructor")
	public static final native Column create(Object name, Object value, JsDate timestamp) /*-{
		return new (@org.gwtnode.modules.helenus.Helenus::get()()).Column(name, value, timestamp);
	}-*/;

	@GwtNodeFunction("constructor")
	public static final native Column create(Object name, Object value) /*-{
		return new (@org.gwtnode.modules.helenus.Helenus::get()()).Column(name, value);
	}-*/;

	protected Column() {}
	
	/**
	 * The name of the column, can be any type, for composites use Array.
	 */
	@GwtNodeProperty
	public final native Object name() /*-{
    return this.name;
	}-*/;

	/**
	 * The name of the column, can be any type, for composites use Array.
	 */
	@GwtNodeProperty
	public final native void name(Object name) /*-{
    this.name = name;
	}-*/;
	
	/**
	 * The value of the column.
	 */
	@GwtNodeProperty
	public final native Object value() /*-{
    return this.value;
	}-*/;
	
	/**
	 * The string value of the column.
	 */
	public final native String valueAsString() /*-{
    return this.value != null ? String(this.value) : null;
	}-*/;

	/**
	 * The numeric value of the column.
	 */
	public final native double valueAsNumber() /*-{
    return this.value != null ? Number(this.value) : 0;
	}-*/;

	/**
	 * The boolean value of the column.
	 */
	public final native boolean valueAsBoolean() /*-{
    return !!this.value;
	}-*/;

	/**
	 * The JS date value of the column.
	 */
	public final native JsDate valueAsJsDate() /*-{
		if (this.value == null) return null;
		var n = Number(this.value);
		if (isNaN(n)) return null;
		return new Date(n);
	}-*/;

	/**
	 * The Java date value of the column.
	 */
	public final Date valueAsDate() {
		JsDate result = valueAsJsDate();
		return result != null ? new Date((long) result.getTime()) : null;
	}

	/**
	 * The value of the column.
	 */
	@GwtNodeProperty
	public final native void value(Object value) /*-{
    this.value = value;
	}-*/;
	
	/**
	 * The timestamp of the value. Default - new Date().
	 */
	@GwtNodeProperty
	public final native JsDate timestamp() /*-{
    return this.timestamp;
	}-*/;

	/**
	 * The timestamp of the value. Default - new Date().
	 */
	@GwtNodeProperty
	public final native void timestamp(JsDate timestamp) /*-{
    this.timestamp = timestamp;
	}-*/;
	
	/**
	 * The ttl for the column.
	 */
	@GwtNodeProperty
	public final native int ttl() /*-{
    return this.ttl;
	}-*/;

	/**
	 * The ttl for the column.
	 */
	@GwtNodeProperty
	public final native void ttl(int ttl) /*-{
    this.ttl = ttl;
	}-*/;
}
