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
package org.gwtnode.modules.aws.s3;

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.meta.GwtNodeProperty;
import org.gwtnode.modules.aws.core.Endpoint;
import org.gwtnode.modules.aws.core.Options;
import org.gwtnode.modules.aws.core.Request;
import org.gwtnode.modules.aws.s3.events.GetObjectEventHandler;
import org.gwtnode.modules.aws.s3.events.ListObjectsEventHandler;
import org.gwtnode.modules.aws.s3.params.GetObjectParams;
import org.gwtnode.modules.aws.s3.params.ListObjectsParams;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The low-level S3 client class. This class provides one function for each API operation on the service.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class Client extends JavaScriptObject {

	/**
	 * Constructs a service client object.
	 */
	@GwtNodeFunction("constructor")
	public static final native Client create(Options options) /*-{
		return new (@org.gwtnode.modules.aws.AWS::get()()).S3.Client(options);
	}-*/;

	protected Client() {}
	
	/**
	 * An Endpoint object representing the endpoint URL for service requests.
	 */
	@GwtNodeProperty
	public final native Endpoint endpoint() /*-{
		return this.endpoint;
	}-*/;
	
	/**
	 * An Endpoint object representing the endpoint URL for service requests.
	 */
	@GwtNodeProperty
	public final native void endpoint(Endpoint endpoint) /*-{
		this.endpoint = endpoint;
	}-*/;
	
	/**
	 * Calls the ListObjects API operation.
	 */
	@GwtNodeFunction
	public final Request listObjects(ListObjectsParams params, ListObjectsEventHandler callback) {
		return listObjects(params, callback != null ? callback.getNativeFunction() : null);
	}

	@GwtNodeFunction
	private final native Request listObjects(ListObjectsParams params, JavaScriptFunction callback) /*-{
		return this.listObjects(params, callback);
	}-*/;
	
	/**
	 * Calls the GetObject API operation.
	 */
	@GwtNodeFunction
	public final Request getObject(GetObjectParams params, GetObjectEventHandler callback) {
		return getObject(params, callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native Request getObject(GetObjectParams params, JavaScriptFunction callback) /*-{
		return this.getObject(params, callback);
	}-*/;
}
