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

import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.meta.GwtNodeProperty;
import org.gwtnode.modules.aws.s3.Client;
import org.gwtnode.modules.aws.s3.data.RequestError;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * <p>
 * This class encapsulates the the response information from a service request operation sent through {@link Request}.
 * </p>
 * <p>
 * See <a href="http://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/Response.html">AWS.Response</a> for details.
 * </p>
 * 
 * @see Request
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class Response extends JavaScriptObject {

	protected Response() {}
	
	/**
	 * The de-serialized response data from the service.
	 */
	@GwtNodeProperty
	public final native JavaScriptObject data() /*-{
		return this.data;
	}-*/;
	
	/**
	 * An structure containing information about a service or networking error.
	 */
	@GwtNodeProperty
	public final native RequestError error() /*-{
		return this.error;
	}-*/;
	
	/**
	 * The low-level service client object that initiated the request.
	 */
	@GwtNodeProperty
	public final native Client client() /*-{
		return this.client;
	}-*/;

	/**
	 * The name of the operation executed on the service.
	 */
	@GwtNodeProperty
	public final native String operation() /*-{
		return this.operation;
	}-*/;
	
	/**
	 * The parameters sent in the request to the service.
	 */
	@GwtNodeProperty
	public final native JavaScriptObject params() /*-{
		return this.params;
	}-*/;
	
	/**
	 * The number of retries that have were attempted before the request was completed.
	 */
	@GwtNodeProperty
	public final native int retryCount() /*-{
		return this.retryCount;
	}-*/;
	
	/**
	 * The raw HTTP response object containing the response headers and body information from the server.
	 */
	public final native HttpResponse httpResponse() /*-{
		return this.httpResponse;
	}-*/;
}
