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
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.meta.GwtNodeProperty;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The low level HTTP request object, encapsulating all HTTP header and body data sent by a service request.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class HttpRequest extends JavaScriptObject {

	protected HttpRequest() {}
	
	/**
	 * The part of the path excluding the query string.
	 */
	@GwtNodeFunction
	public final native String pathname() /*-{
		return this.pathname();
	}-*/; 
	
	/**
	 * The query string portion of the path.
	 */
	@GwtNodeFunction
	public final native String search() /*-{
		return this.search();
	}-*/;

	/**
	 * The request body payload.
	 */
	@GwtNodeProperty
	public final native String body() /*-{
		return this.body;
	}-*/;
	
	/**
	 * The request body payload.
	 */
	@GwtNodeProperty
	public final native void body(String body) /*-{
		this.body = body;
	}-*/;
	
	/**
	 * The endpoint for the request.
	 */
	@GwtNodeProperty
	public final native Endpoint endpoint() /*-{
		return this.endpoint;
	}-*/;
	
	/**
	 * The endpoint for the request.
	 */
	@GwtNodeProperty
	public final native void endpoint(Endpoint endpoint) /*-{
		this.endpoint = endpoint;
	}-*/;
	
	/**
	 * A map of header keys and their respective values.
	 */
	@GwtNodeProperty
	public Map<String, String> headers() {
		JavaScriptObject headers = headers0();
		if (headers == null) headers = JavaScriptObject.createObject();
		return new JsonStringObjectMap<String>(headers);
	}
	
	@GwtNodeProperty("headers")
	private final native JavaScriptObject headers0() /*-{
		return this.headers;
	}-*/;
	
	/**
	 * A map of header keys and their respective values.
	 */
	@GwtNodeProperty
	public void headers(Map<String, String> headers) {
		JsonStringObjectMap<String> jsom = new JsonStringObjectMap<String>();
		jsom.putAll(headers);
		headers0(jsom.getNativeObject());
	}

	@GwtNodeProperty("headers")
	private final native void headers0(JavaScriptObject headers) /*-{
		this.headers = headers;
	}-*/;
	
	/**
	 * The HTTP method of the request.
	 */
	@GwtNodeProperty
	public final native String method() /*-{
		return this.method;
	}-*/;
	
	/**
	 * The HTTP method of the request.
	 */
	@GwtNodeProperty
	public final native void method(String method) /*-{
		this.method = method;
	}-*/;
	
	/**
	 * The path portion of the URI, e.g., "/list/?start=5&num=10".
	 */
	@GwtNodeProperty
	public final native String path() /*-{
		return this.path;
	}-*/;
		
	/**
	 * The path portion of the URI, e.g., "/list/?start=5&num=10".
	 */
	@GwtNodeProperty
	public final native void path(String path) /*-{
		this.path = path;
	}-*/;
}
