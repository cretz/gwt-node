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

import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.meta.GwtNodeProperty;
import org.gwtnode.modules.aws.s3.Client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * <p>
 * Represents your AWS security credentials, specifically the {@link #accessKeyId()}, {@link #secretAccessKey()}, and
 * optional {@link #sessionToken()}. Creating a {@code Credentials} object allows you to pass around your security
 * information to configuration and service objects.
 * </p>
 * <p>
 * Note that this class typically does not need to be constructed manually, as the {@link Config} and {@link Client}
 * classes both accept simple options hashes with the three keys. These structures will be converted into
 * {@code Credentials} objects automatically.
 * </p>
 * <h4>
 * Expiring and Refreshing {@code Credentials}</h4>
 * <p>
 * Occasionally credentials can expire in the middle of a long-running application. In this case, the SDK will
 * automatically attempt to refresh the credentials from the storage location if the {@code Credentials} class
 * implements the {@link #refresh()} method.
 * </p>
 * <p>
 * If you are implementing a credential storage location, you will want to create a subclass of the {@code Credentials}
 * class and override the {@link #refresh()} method. This method allows credentials to be retrieved from the backing
 * store, be it a file system, database, or some network storage. The method should reset the credential attributes on
 * the object.
 * </p>
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class Credentials extends JavaScriptObject {

	/**
	 * A credentials object can be created using positional arguments or an options hash.
	 */
	@GwtNodeFunction("constructor")
	public static final native Credentials create() /*-{
		return new (@org.gwtnode.modules.aws.AWS::get()()).Credentials();
	}-*/;

	protected Credentials() {}

	/**
	 * Refreshes the credentials.
	 */
	@GwtNodeFunction
	public final native void refresh() /*-{
		return this.refresh();
	}-*/;
	
	/**
	 * The AWS access key ID.
	 */
	@GwtNodeProperty
	public final native String accessKeyId() /*-{
		return this.accessKeyId;
	}-*/;
	
	/**
	 * The AWS access key ID.
	 */
	@GwtNodeProperty
	public final native void accessKeyId(String accessKeyId) /*-{
		this.accessKeyId = accessKeyId;
	}-*/;

	/**
	 * The AWS secret access key.
	 */
	@GwtNodeProperty
	public final native String secretAccessKey() /*-{
		return this.secretAccessKey;
	}-*/;
	
	/**
	 * The AWS secret access key.
	 */
	@GwtNodeProperty
	public final native void secretAccessKey(String secretAccessKey) /*-{
		this.secretAccessKey = secretAccessKey;
	}-*/;
	
	/**
	 * An optional AWS session token.
	 */
	@GwtNodeProperty
	public final native String sessionToken() /*-{
		return this.sessionToken;
	}-*/;
	
	/**
	 * An optional AWS session token.
	 */
	@GwtNodeProperty
	public final native void sessionToken(String sessionToken) /*-{
		this.sessionToken = sessionToken;
	}-*/;
}
