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

import java.util.Map;

import org.gwtnode.core.JsonStringObjectMap;
import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.meta.GwtNodeProperty;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The low level HTTP response object, encapsulating all HTTP header and body data returned from the request.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class HttpResponse extends JavaScriptObject {

	protected HttpResponse() {}
	
	/**
	 * The response body payload.
	 */
	@GwtNodeProperty
	public final native String body() /*-{
		return this.body;
	}-*/;
	
	/**
	 * The response body payload.
	 */
	@GwtNodeProperty
	public final native void body(String body) /*-{
		this.body = body;
	}-*/;
	
	/**
	 * A map of response header keys and their respective values.
	 */
	@GwtNodeProperty
	public final Map<String, String> headers() {
		JavaScriptObject headers = headers0();
		if (headers == null) headers = JavaScriptObject.createObject();
		return new JsonStringObjectMap<String>(headers);
	}
	
	@GwtNodeProperty("headers")
	private final native JavaScriptObject headers0() /*-{
		return this.headers;
	}-*/;
	
	/**
	 * A map of response header keys and their respective values.
	 */
	@GwtNodeProperty
	public final void headers(Map<String, String> headers) {
		JsonStringObjectMap<String> jsom = new JsonStringObjectMap<String>();
		jsom.putAll(headers);
		headers0(jsom.getNativeObject());
	}

	@GwtNodeProperty("headers")
	private final native void headers0(JavaScriptObject headers) /*-{
		this.headers = headers;
	}-*/;
	
	/**
	 * The HTTP status code of the response (e.g., 200, 404).
	 */
	@GwtNodeProperty
	public final native int statusCode() /*-{
		return this.statusCode;
	}-*/;
	
	/**
	 * The HTTP status code of the response (e.g., 200, 404).
	 */
	@GwtNodeProperty
	public final native void statusCode(int statusCode) /*-{
		this.statusCode = statusCode;
	}-*/;
}
