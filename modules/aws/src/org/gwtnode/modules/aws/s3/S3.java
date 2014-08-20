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

import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.meta.GwtNodeProperty;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Constructs a service interface and a low-level Client. Use the client property to make API calls. Each API operation
 * is exposed as a function on the client.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class S3 extends JavaScriptObject {
	
	/**
	 * Constructs a service interface. The returned service will have a {@link S3#client()} property that provides access
	 * to the API operations.
	 */
	@GwtNodeFunction("constructor")
	public static final native S3 create() /*-{
		return new (@org.gwtnode.modules.aws.AWS::get()()).S3();
	}-*/;
	
	protected S3() {}
	
	/**
	 * A client that provides one method for each API operation.
	 */
	@GwtNodeProperty
	public final native Client client() /*-{
		return this.client;
	}-*/;
	
	/**
	 * A client that provides one method for each API operation.
	 */
	@GwtNodeProperty
	public final native void client(Client client) /*-{
		this.client = client;
	}-*/;
}
