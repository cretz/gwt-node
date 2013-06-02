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
 * The endpoint that a service will talk to, for example, "https://ec2.ap-southeast-1.amazonaws.com". If you need to
 * override an endpoint for a service, you can set the endpoint on a service by passing the endpoint object with the
 * endpoint option key:
 * <pre>
 * Options o = Options.create();
 * o.endpoint(Endpoint.create("awsproxy.example.com"));
 * S3Try s3 = S3Try.create(o);
 * Util.get().log("" + "awsproxy.example.com".equals(s3.client().endpoint().hostname()));
 * </pre>
 * Note that if you do not specify a protocol, the protocol will be selected based on your
 * current {@link AWS#config()} configuration.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class Endpoint extends JavaScriptObject {

	/**
	 * Constructs a new endpoint given an endpoint URL.
	 */
	@GwtNodeFunction("constructor")
	public static final native Endpoint create(String endpoint) /*-{
    return new (@org.gwtnode.modules.aws.AWS::get()()).Endpoint(endpoint);
	}-*/;

	protected Endpoint() {}

	/**
	 * The host portion of the endpoint including the port, e.g., example.com:80.
	 */
	@GwtNodeProperty
	public final native String host() /*-{
		return this.host;
	}-*/;
	
	/**
	 * The host portion of the endpoint including the port, e.g., example.com:80.
	 */
	@GwtNodeProperty
	public final native void host(String host) /*-{
		this.host = host;
	}-*/;
	
	/**
	 * The host portion of the endpoint, e.g., example.com.
	 */
	@GwtNodeProperty
	public final native String hostname() /*-{
		return this.hostname;
	}-*/;
	
	/**
	 * The host portion of the endpoint, e.g., example.com.
	 */
	@GwtNodeProperty
	public final native void hostname(String hostname) /*-{
		this.hostname = hostname;
	}-*/;
	
	/**
	 * The full URL of the endpoint.
	 */
	@GwtNodeProperty
	public final native String href() /*-{
		return this.href;
	}-*/;

	/**
	 * The full URL of the endpoint.
	 */
	@GwtNodeProperty
	public final native void href(String href) /*-{
		this.href = href;
	}-*/;

	/**
	 * The port of the endpoint.
	 */
	@GwtNodeProperty
	public final native int port() /*-{
		return this.port;
	}-*/;

	/**
	 * The port of the endpoint.
	 */
	@GwtNodeProperty
	public final native void port(int port) /*-{
		this.port = port;
	}-*/;

	/**
	 * The protocol (http or https) of the endpoint URL.
	 */
	@GwtNodeProperty
	public final native String protocol() /*-{
		return this.protocol;
	}-*/;
	
	/**
	 * The protocol (http or https) of the endpoint URL.
	 */
	@GwtNodeProperty
	public final native void protocol(String protocol) /*-{
		this.protocol = protocol;
	}-*/;
}
