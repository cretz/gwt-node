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
 * SMTP is different from the other transport mechanisms, as in its case a connection pool is created. All the
 * connections try to stay alive as long as possible and are reusable to minimize the protocol overhead delay - for
 * example setting up TLS for authenticating is relatively lengthy process (in CPU terms, not by human terms), you do
 * not want to do it several times.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
public class SMTPOptions extends JavaScriptObject {

	public final static SMTPOptions create() {
		return JavaScriptObject.createObject().<SMTPOptions> cast();
	}

	public final static SMTPOptions create(
			String service, String host, int port, boolean secureConnection, String authUser, String authPass) {
		SMTPOptions result = create();
		result.service(service);
		result.host(host);
		result.port(port);
		result.secureConnection(secureConnection);
		result.authUser(authUser);
		result.authPass(authPass);
		return result;
	}
	
	protected SMTPOptions() {}

	/**
	 * An optional well known service identifier ("Gmail", "Hotmail" etc., see Well known Services for a list of supported
	 * services) to auto-configure host, port and secure connection settings
	 */
	public final native String service() /*-{
		return this.service;
	}-*/;

	/**
	 * An optional well known service identifier ("Gmail", "Hotmail" etc., see Well known Services for a list of supported
	 * services) to auto-configure host, port and secure connection settings
	 */
	public final native void service(String service) /*-{
		this.service = service;
	}-*/;

	/**
	 * Hostname of the SMTP server (defaults to "localhost", not needed with service)
	 */
	public final native String host() /*-{
		return this.host;
	}-*/;

	/**
	 * Hostname of the SMTP server (defaults to "localhost", not needed with service)
	 */
	public final native void host(String host) /*-{
		this.host = host;
	}-*/;

	/**
	 * Port of the SMTP server (defaults to 25, not needed with service)
	 */
	public final native int port() /*-{
		return this.port;
	}-*/;

	/**
	 * Port of the SMTP server (defaults to 25, not needed with service)
	 */
	public final native void port(int port) /*-{
		this.port = port;
	}-*/;

	/**
	 * Use SSL (default is false, not needed with service). If you're using port 587 then keep secureConnection false,
	 * since the connection is started in insecure plain text mode and only later upgraded with STARTTLS
	 */
	public final native boolean secureConnection() /*-{
		return this.secureConnection;
	}-*/;

	/**
	 * Use SSL (default is false, not needed with service). If you're using port 587 then keep secureConnection false,
	 * since the connection is started in insecure plain text mode and only later upgraded with STARTTLS
	 */
	public final native void secureConnection(boolean secureConnection) /*-{
		this.secureConnection = secureConnection;
	}-*/;

	/**
	 * The name of the client server (defaults to machine name)
	 */
	public final native String name() /*-{
		return this.name;
	}-*/;

	/**
	 * The name of the client server (defaults to machine name)
	 */
	public final native void name(String name) /*-{
		this.name = name;
	}-*/;

	/**
	 * Authentication object as {user:"...", pass:"..."} or {XOAuth2: {xoauth2_options}} or {XOAuthToken: "base64data"}
	 */
	public final native JavaScriptObject auth() /*-{
		return this.auth;
	}-*/;

	/**
	 * Authentication object as {user:"...", pass:"..."} or {XOAuth2: {xoauth2_options}} or {XOAuthToken: "base64data"}
	 */
	public final native void auth(JavaScriptObject auth) /*-{
		this.auth = auth;
	}-*/;

	/**
	 * Authentication user name
	 */
	public final native String authUser() /*-{
		return !!this.auth ? this.auth.user : null;
	}-*/;

	/**
	 * Authentication user name
	 */
	public final native void authUser(String authUser) /*-{
		if (!this.auth) this.auth = {};
		this.auth.user = authUser;
	}-*/;

	/**
	 * Authentication user password
	 */
	public final native String authPass() /*-{
		return !!this.auth ? this.auth.pass : null;
	}-*/;

	/**
	 * Authentication user password
	 */
	public final native void authPass(String authPass) /*-{
		if (!this.auth) this.auth = {};
		this.auth.pass = authPass;
	}-*/;

	/**
	 * Ignore server support for STARTTLS (defaults to false)
	 */
	public final native boolean ignoreTLS() /*-{
		return this.ignoreTLS;
	}-*/;

	/**
	 * Ignore server support for STARTTLS (defaults to false)
	 */
	public final native void ignoreTLS(boolean ignoreTLS) /*-{
		this.ignoreTLS = ignoreTLS;
	}-*/;

	/**
	 * Output client and server messages to console
	 */
	public final native boolean debug() /*-{
		return this.debug;
	}-*/;

	/**
	 * Output client and server messages to console
	 */
	public final native void debug(boolean debug) /*-{
		this.debug = debug;
	}-*/;

	/**
	 * How many connections to keep in the pool (defaults to 5)
	 */
	public final native int maxConnections() /*-{
		return this.maxConnections;
	}-*/;

	/**
	 * How many connections to keep in the pool (defaults to 5)
	 */
	public final native void maxConnections(int maxConnections) /*-{
		this.maxConnections = maxConnections;
	}-*/;
}
