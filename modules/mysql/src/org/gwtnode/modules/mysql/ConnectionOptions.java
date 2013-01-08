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
package org.gwtnode.modules.mysql;

import com.google.gwt.core.client.JavaScriptObject;

public class ConnectionOptions extends JavaScriptObject {

	/**
	 * Useful for {@link Connection#changeUser(ConnectionOptions, com.parsci.node.mysql.events.MySQLErrorEventHandler)}
	 */
	public static final ConnectionOptions create(
			String user,
			String password,
			String database,
			String charset) {
		ConnectionOptions o = JavaScriptObject.createObject().cast();
		o.setUser(user);
		o.setPassword(password);
		o.setDatabase(database);
		o.setCharset(charset);
		return o;
	}
	
	public static final ConnectionOptions create(
			String host,
			int port,
			String user,
			String password,
			String database,
			String charset,
			String timezone,
			String flags) {
		ConnectionOptions o = JavaScriptObject.createObject().cast();
		o.setHost(host);
		o.setPort(port);
		o.setUser(user);
		o.setPassword(password);
		o.setDatabase(database);
		o.setCharset(charset);
		o.setTimezone(timezone);
		o.setFlags(flags);
		return o;
	}
	
	public static final ConnectionOptions create(
			String socketPath,
			String user,
			String password,
			String database,
			String charset,
			String timezone,
			String flags) {
		ConnectionOptions o = JavaScriptObject.createObject().cast();
		o.setSocketPath(socketPath);
		o.setUser(user);
		o.setPassword(password);
		o.setDatabase(database);
		o.setCharset(charset);
		o.setTimezone(timezone);
		o.setFlags(flags);
		return o;
	}
	
  //TODO: add queryFormat function property support 
	
	/**
	 * Default value is {@code 'localhost'}.
	 * @return The host to connect to.
	 */
	public final native String getHost() /*-{
		return this.host;
	}-*/;

	/**
	 * Sets the host to connect to.
	 * @param host name
	 */
	public final native void setHost(String host) /*-{
    this.host = host;
	}-*/;

	/**
	 * Default value is {@code 3306}.
	 * @return The port to connect to.
	 */
	public final native int getPort() /*-{
    return this.port;
	}-*/;

	/**
	 * Sets the port to connect to.
	 * @param port number
	 */
	public final native void setPort(int port) /*-{
    this.port = port;
	}-*/;

	/**
	 * Default value is {@code null}.
	 * @return The path to a unix domain socket to connect to.
	 */
	public final native String getSocketPath() /*-{
    return this.socketPath;
	}-*/;

	/**
	 * Sets the path to a unix domain socket to connect to. When used host and port are ignored.
	 * @param socketPath path to a unix domain socket.
	 */
	public final native void setSocketPath(String socketPath) /*-{
    this.socketPath = socketPath;
	}-*/;

	/**
	 * Default value is {@code null}.
	 * @return The username to authenticate as.
	 */
	public final native String getUser() /*-{
    return this.user === undefined ? null : this.user;
	}-*/;

	/**
	 * Sets the username to authenticate as.
	 * @param user name
	 */
	public final native void setUser(String user) /*-{
    this.user = user;
	}-*/;

	/**
	 * Default value is {@code null}.
	 * @return The password to authenticate with.
	 */
	public final native String getPassword() /*-{
    return this.password === undefined ? null : this.password;
	}-*/;

	/**
	 * Sets the password to authenticate with.
	 * @param password to use.
	 */
	public final native void setPassword(String password) /*-{
    this.password = password;
	}-*/;

	/**
	 * Default value is {@code null}.
	 * @return The name of the database to connect to.
	 */
	public final native String getDatabase() /*-{
    return this.database;
	}-*/;

	/**
	 * Sets the name of the database to connect to (optional).
	 * @param database name
	 */
	public final native void setDatabase(String database) /*-{
    this.database = database;
	}-*/;

	/**
	 * Gets availability of connecting to MySQL instances that ask for the old (insecure) authentication method.
	 * Default value is {@code false}.
	 * @return {@code true} if allowed.
	 */
	public final native boolean isInsecureAuth() /*-{
    return this.insecureAuth;
	}-*/;
	
	/**
	 * Allows/disallows connecting to MySQL instances that ask for the old (insecure) authentication method.
	 * @param insecureAuth {@code true} allows printing.
	 */
	public final native void setInsecureAuth(boolean insecureAuth) /*-{
    this.insecureAuth = insecureAuth;
	}-*/;
	
	/**
	 * Gets availability of printing incoming and outgoing packets.
	 * Default value is {@code false}.
	 * @return {@code true} if printing is allowed.
	 */
	public final native boolean isDebug() /*-{
    return this.debug;
	}-*/;
	
	/**
	 * Allows/disallows printing incoming and outgoing packets, useful for development / testing purposes.
	 * @param debug {@code true} allows printing.
	 */
	public final native void setDebug(boolean debug) /*-{
    this.debug = debug;
	}-*/;
	
	/**
	 * Default value is {@code 'local'}.
	 * @return The timezone used to store local dates.
	 */
	public final native String getTimezone() /*-{
    return this.timezone;
	}-*/;

	/**
	 * Sets the timezone used to store local dates.
	 * @param timezone
	 */
	public final native void setTimezone(String timezone) /*-{
    this.timezone = timezone;
	}-*/;

	/**
	 * Default value is {@code 'local'}.
	 * @return The list of comma-separated connection flags to use other than the default ones.
	 */
	public final native String getFlags() /*-{
    return this.flags;
	}-*/;

	/**
	 * Sets the list of connection flags to use other than the default ones.
	 * It is also possible to blacklist default ones.
	 * @param flags list of comma-separated connection flags.
	 */
	public final native void setFlags(String flags) /*-{
    this.flags = flags;
	}-*/;
	
	/**
	 * Default value is {@code true}.
	 * @return {@code true} if column values should be converted to native JavaScript types.
	 */
	public final native boolean isTypeCast() /*-{
    return this.typeCast;
	}-*/;	
	
	/**
	 * Determines if column values should be converted to native JavaScript types.
	 * @param typeCast {@code true} if column values should be converted.
	 */
	public final native void setTypeCast(boolean typeCast) /*-{
    this.typeCast = typeCast;
	}-*/;

	/**
	 * Default value is {@code 'UTF8_GENERAL_CI'}.
	 * @return The charset for the connection.
	 */
	public final native String getCharset() /*-{
    return this.charset;
	}-*/;

	/**
	 * Sets the charset for the connection.
	 * @param charset
	 */
	public final native void setCharset(String charset) /*-{
    this.charset = charset;
	}-*/;
	
	/**
	 * Default value is {@code false}.
	 * @return {@code true} if multiple mysql statements per query is allowed.
	 */
	public final native boolean isMultipleStatements() /*-{
    return this.multipleStatements;
	}-*/;	
	
	/**
	 * Allows/Disallows multiple mysql statements per query.
	 * Be careful with this, it exposes you to SQL injection attacks.
	 * @param multipleStatements {@code true} if allowed.
	 */
	public final native void setMultipleStatements(boolean multipleStatements) /*-{
    this.multipleStatements = multipleStatements;
	}-*/;
	
	protected ConnectionOptions() {}
}
