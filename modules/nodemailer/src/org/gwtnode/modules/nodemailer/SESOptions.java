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
package org.gwtnode.modules.nodemailer;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * SES is actually a HTTP based protocol, the compiled e-mail and related info (signatures and such) are sent as a HTTP request to SES servers.
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
public class SESOptions extends JavaScriptObject {

	public final static SESOptions create() {
		return JavaScriptObject.createObject().<SESOptions> cast();
	}
	
	public final static SESOptions create(String awsAccessKeyID, String awsSecretKey) {
		SESOptions result = create();
		result.awsAccessKeyID(awsAccessKeyID);
		result.awsSecretKey(awsSecretKey);
		return result;
	}
	
	public final static SESOptions create(String awsAccessKeyID, String awsSecretKey, String serviceUrl) {
		SESOptions result = create();
		result.awsAccessKeyID(awsAccessKeyID);
		result.awsSecretKey(awsSecretKey);
		result.serviceUrl(serviceUrl);
		return result;
	}
	
	protected SESOptions() {}
	
	/**
	 * AWS access key (required)
	 */
	public final native String awsAccessKeyID() /*-{
		return this.AWSAccessKeyID;
	}-*/;
	
	/**
	 * AWS access key (required)
	 */
	public final native void awsAccessKeyID(String awsAccessKeyID) /*-{
		this.AWSAccessKeyID = awsAccessKeyID;
	}-*/;
	
	/**
	 * AWS secret (required)
	 */
	public final native String awsSecretKey() /*-{
		return this.AWSSecretKey;
	}-*/;
	
	/**
	 * AWS secret (required)
	 */
	public final native void awsSecretKey(String awsSecretKey) /*-{
		this.AWSSecretKey = awsSecretKey;
	}-*/;
	
	/**
	 * Optional API end point URL (defaults to "https://email.us-east-1.amazonaws.com")
	 */
	public final native void serviceUrl(String serviceUrl) /*-{
		this.ServiceUrl = serviceUrl;
	}-*/;
	
	/**
	 * Optional API end point URL (defaults to "https://email.us-east-1.amazonaws.com")
	 */
	public final native String serviceUrl() /*-{
		return this.ServiceUrl;
	}-*/;
}
