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

import com.google.gwt.core.client.JavaScriptObject;

@GwtNodeObject
public class Options extends JavaScriptObject {
	
	@GwtNodeFunction("constructor")
	public static final Options create() {
		return JavaScriptObject.createObject().cast();
	}

	@GwtNodeFunction("constructor")
	public static final Options create(String accessKeyId, String secretAccessKey) {
		Options result = create();
		result.accessKeyId(accessKeyId);
		result.secretAccessKey(secretAccessKey);
		return result;
	}
	
	protected Options() {}
	
	/**
	 * your AWS access key ID.
	 */
	@GwtNodeProperty
	public final native String accessKeyId() /*-{
		return this.accessKeyId;
	}-*/;

	/**
	 * your AWS access key ID.
	 */
	@GwtNodeProperty
	public final native void accessKeyId(String accessKeyId) /*-{
		this.accessKeyId = accessKeyId;
	}-*/;
	
	/**
	 * your AWS secret access key.
	 */
	@GwtNodeProperty
	public final native String secretAccessKey() /*-{
		return this.secretAccessKey;
	}-*/;
	
	/**
	 * your AWS secret access key.
	 */
	@GwtNodeProperty
	public final native void secretAccessKey(String secretAccessKey) /*-{
		this.secretAccessKey = secretAccessKey;
	}-*/;
	
	/**
	 * the optional AWS session token to sign requests with.
	 */
	@GwtNodeProperty
	public final native Credentials sessionToken() /*-{
		return this.sessionToken;
	}-*/;
	
	/**
	 * the optional AWS session token to sign requests with.
	 */
	@GwtNodeProperty
	public final native void sessionToken(Credentials sessionToken) /*-{
		this.sessionToken = sessionToken;
	}-*/;
	
	/**
	 * the AWS credentials to sign requests with.
	 * You can either specify this object, or specify the accessKeyId and secretAccessKey options directly.
	 */
	@GwtNodeProperty
	public final native Credentials credentials() /*-{
		return this.credentials;
	}-*/;
	
	/**
	 * the AWS credentials to sign requests with.
	 * You can either specify this object, or specify the accessKeyId and secretAccessKey options directly.
	 */
	@GwtNodeProperty
	public final native void credentials(Credentials credentials) /*-{
		this.credentials = credentials;
	}-*/;
	
	/**
	 * the region to send service requests to. See region for more information.
	 */
	@GwtNodeProperty
	public final native String region() /*-{
		return this.region;
	}-*/;
	
	/**
	 * the region to send service requests to. See region for more information.
	 */
	@GwtNodeProperty
	public final native void region(String region) /*-{
		this.region = region;
	}-*/;
	
	/**
	 * the maximum amount of retries to attempt with a request. See maxRetries for more information.
	 */
	@GwtNodeProperty
	public final native int maxRetries() /*-{
		return this.maxRetries;
	}-*/;
	
	/**
	 * the maximum amount of retries to attempt with a request. See maxRetries for more information.
	 */
	@GwtNodeProperty
	public final native void maxRetries(int maxRetries) /*-{
		this.maxRetries = maxRetries;
	}-*/;
	
	/**
	 * whether to enable SSL for requests.
	 */
	@GwtNodeProperty
	public final native boolean sslEnabled() /*-{
		return this.sslEnabled;
	}-*/;
	
	/**
	 * whether to enable SSL for requests.
	 */
	@GwtNodeProperty
	public final native void sslEnabled(boolean sslEnabled) /*-{
		this.sslEnabled = sslEnabled;
	}-*/;
	
	/**
	 * whether parameter validation is on.
	 */
	@GwtNodeProperty
	public final native boolean paramValidation() /*-{
		return this.paramValidation;
	}-*/;
	
	/**
	 * whether parameter validation is on.
	 */
	@GwtNodeProperty
	public final native void paramValidation(boolean paramValidation) /*-{
		this.paramValidation = paramValidation;
	}-*/;
	
	/**
	 * whether to compute checksums for payload bodies when the service accepts it (currently supported in S3Try only)
	 */
	@GwtNodeProperty
	public final native boolean computeChecksums() /*-{
		return this.computeChecksums;
	}-*/;
	
	/**
	 * whether to compute checksums for payload bodies when the service accepts it (currently supported in S3Try only)
	 */
	@GwtNodeProperty
	public final native void computeChecksums(boolean computeChecksums) /*-{
		this.computeChecksums = computeChecksums;
	}-*/;
	
	/**
	 * whether to force path style URLs for S3Try objects.
	 */
	@GwtNodeProperty
	public final native boolean s3ForcePathStyle() /*-{
		return this.s3ForcePathStyle;
	}-*/;
	
	/**
	 * whether to force path style URLs for S3Try objects.
	 */
	@GwtNodeProperty
	public final native void s3ForcePathStyle(boolean s3ForcePathStyle) /*-{
		this.s3ForcePathStyle = s3ForcePathStyle;
	}-*/;

	/**
	 * The endpoint URI to send requests to. The default endpoint is built from the configured region. The endpoint should
	 * be a string like "https://s3.amazonaws.com".
	 */
	@GwtNodeProperty
	public final native Endpoint endpoint() /*-{
		return this.endpoint;
	}-*/;
	
	/**
	 * The endpoint URI to send requests to. The default endpoint is built from the configured region. The endpoint should
	 * be a string like "https://s3.amazonaws.com".
	 */
	@GwtNodeProperty
	public final native void endpoint(Endpoint endpoint) /*-{
		this.endpoint = endpoint;
	}-*/;
}
