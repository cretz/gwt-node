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

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;

public final class JsUtils {
	
	public static final JavaScriptObject asJSO(Object value) {
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

	public static final native JavaScriptObject asJSODate(double value) /*-{
  	return new Date(value);
	}-*/;

	public static final native JavaScriptObject asJSOString(String value) /*-{
    return value;
	}-*/;

	public static final native JavaScriptObject asJSOInt(int value) /*-{
    return value;
	}-*/;
	
	public static final native JavaScriptObject asJSODouble(double value) /*-{
    return value;
	}-*/;

	public static final native JavaScriptObject asJSOBoolean(boolean value) /*-{
  	return value;
	}-*/;
	
	public static final native JavaScriptObject asJSOObject(Object value) /*-{
    return value;
	}-*/;

	public static final JsArrayMixed asJSOArray(Object[] value) {
		JsArrayMixed result = JavaScriptObject.createArray().cast();
		for (Object item : value)
			result.push(asJSO(item));
		return result;
	}
	
	public static final JsArrayMixed asJSOArray(Iterable<?> value) {
		JsArrayMixed result = JavaScriptObject.createArray().cast();
		for (Object item : value)
			result.push(asJSO(item));
		return result;
	}

	public static native boolean isUndefined(JavaScriptObject jso) /*-{
		return typeof jso == "undefined";
	}-*/; 

	public static native boolean isNumber(JavaScriptObject jso) /*-{
		return typeof jso == "number";
	}-*/; 

	public static native boolean isObject(JavaScriptObject jso) /*-{
		return typeof jso == "object";
	}-*/; 

	public static native boolean isArray(JavaScriptObject jso) /*-{
		return jso instanceof Array;
	}-*/; 

	public static native double asNumber(JavaScriptObject jso) /*-{
		return typeof jso == "number" ? jso : 0;
	}-*/; 
	
	public static final native JsArrayMixed asArray(JavaScriptObject jso) /*-{
		if (jso == null) return null;
		if (jso instanceof Array) return jso;
		return [jso];
	}-*/;
	
	private JsUtils() {}
}
