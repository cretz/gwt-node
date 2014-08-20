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
import org.gwtnode.modules.aws.AWS;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * <p>
 * The main configuration class used by all service objects to set the region, credentials, and other options for
 * requests.
 * </p>
 * <p>
 * By default, credentials and region settings are left unconfigured. This should be configured by the application
 * before using any AWS service APIs.
 * </p>
 * <p>
 * In order to set global configuration options, properties should be assigned to the global {@link AWS#config()}
 * object.
 * </p>
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class Config extends JavaScriptObject {

	/**
	 * Creates a new configuration object.
	 */
	@GwtNodeFunction("constructor")
	public static final native Config create(Options options) /*-{
    return new (@org.gwtnode.modules.aws.AWS::get()()).Config(options);
	}-*/;

	protected Config() {}

	/**
	 * Loads configuration data from a JSON file into this config object.
	 */
	@GwtNodeFunction
	public final native Config loadFromPath(String path) /*-{
		return this.loadFromPath(path);
	}-*/;

	/**
	 * Updates the current configuration object with new options.
	 */
	@GwtNodeFunction
	public final native void update(Options options) /*-{
		this.update(options);
	}-*/;
	
	/**
	 * Whether to compute checksums for payload bodies when the service accepts it (currently supported in S3Try only).
	 */
	@GwtNodeProperty
	public final native boolean computeChecksums() /*-{
		return this.computeChecksums;
	}-*/;

	/**
	 * Whether to compute checksums for payload bodies when the service accepts it (currently supported in S3Try only).
	 */
	@GwtNodeProperty
	public final native void computeChecksums(boolean computeChecksums) /*-{
		this.computeChecksums = computeChecksums;
	}-*/;
	
	/**
	 * The AWS credentials to sign requests with.
	 */
	@GwtNodeProperty
	public final native Credentials credentials() /*-{
		return this.credentials;
	}-*/;
	
	/**
	 * The AWS credentials to sign requests with.
	 */
	@GwtNodeProperty
	public final native void credentials(Credentials credentials) /*-{
		this.credentials = credentials;
	}-*/;
	
	/**
	 * The maximum amount of retries to perform for a service request.
	 */
	@GwtNodeProperty
	public final native int maxRetries() /*-{
		return this.maxRetries;
	}-*/;
	
	/**
	 * The maximum amount of retries to perform for a service request.
	 */
	@GwtNodeProperty
	public final native void maxRetries(int maxRetries) /*-{
		this.maxRetries = maxRetries;
	}-*/;
	
	/**
	 * Whether input parameters should be validated against the operation description before sending the request.
	 */
	@GwtNodeProperty
	public final native boolean paramValidation() /*-{
		return this.paramValidation;
	}-*/;
	
	/**
	 * Whether input parameters should be validated against the operation description before sending the request.
	 */
	@GwtNodeProperty
	public final native void paramValidation(boolean paramValidation) /*-{
		this.paramValidation = paramValidation;
	}-*/;
	
	/**
	 * The region to send service requests to.
	 */
	@GwtNodeProperty
	public final native Credentials region() /*-{
		return this.region;
	}-*/;
	
	/**
	 * The region to send service requests to.
	 */
	@GwtNodeProperty
	public final native void region(Credentials region) /*-{
		this.region = region;
	}-*/;
	
	/**
	 * Whether to force path style URLs for S3Try objects.
	 */
	@GwtNodeProperty
	public final native boolean s3ForcePathStyle() /*-{
		return this.s3ForcePathStyle;
	}-*/;
	
	/**
	 * Whether to force path style URLs for S3Try objects.
	 */
	@GwtNodeProperty
	public final native void s3ForcePathStyle(boolean s3ForcePathStyle) /*-{
		this.s3ForcePathStyle = s3ForcePathStyle;
	}-*/;
	
	/**
	 * Whether SSL is enabled for requests.
	 */
	@GwtNodeProperty
	public final native boolean sslEnabled() /*-{
		return this.sslEnabled;
	}-*/;
	
	/**
	 * Whether SSL is enabled for requests.
	 */
	@GwtNodeProperty
	public final native void sslEnabled(boolean sslEnabled) /*-{
		this.sslEnabled = sslEnabled;
	}-*/;
}
