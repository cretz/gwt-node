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
package org.gwtnode.modules.cassandra;

import com.google.gwt.core.client.JavaScriptObject;

public abstract class CommonOptions extends JavaScriptObject {

	protected CommonOptions() {}
	
	/**
	 * Keyspace name.
	 */
	public final native String keyspace() /*-{
		return this.keyspace;
	}-*/;
	
	/**
	 * Keyspace name.
	 */
	public final native void keyspace(String keyspace) /*-{
		this.keyspace = keyspace;
	}-*/;

	/**
	 * User for authentication (optional).
	 */
	public final native String user() /*-{
		return this.user;
	}-*/;
	
	/**
	 * User for authentication (optional).
	 */
	public final native void user(String user) /*-{
		this.user = user;
	}-*/;

	/**
	 * Password for authentication (optional).
	 */
	public final native String pass() /*-{
		return this.pass;
	}-*/;
	
	/**
	 * Password for authentication (optional).
	 */
	public final native void pass(String pass) /*-{
		this.pass = pass;
	}-*/;

	/**
	 * Indicating whether or not to use BigInteger or Number in numerical results (optional).
	 */
	public final native boolean useBigints() /*-{
		return this.use_bigints;
	}-*/;
	
	/**
	 * Indicating whether or not to use BigInteger or Number in numerical results (optional).
	 */
	public final native void useBigints(boolean useBigints) /*-{
		this.use_bigints = useBigints;
	}-*/;
	
	public final native int cqlVersion() /*-{
		return this.cql_version;
	}-*/;
	
	public final native void cqlVersion(int cqlVersion) /*-{
		this.cql_version = cqlVersion;
	}-*/;

	/**
	 * Connection timeout (optional).
	 */
	public final native int timeout() /*-{
		return this.timeout;
	}-*/;
	
	/**
	 * Connection timeout (optional).
	 */
	public final native void timeout(int timeout) /*-{
		this.timeout = timeout;
	}-*/;

	/**
	 * Query execution timeout (optional).
	 */
	public final native int queryTimeout() /*-{
		return this.query_timeout;
	}-*/;
	
	/**
	 * Query execution timeout (optional).
	 */
	public final native void queryTimeout(int queryTimeout) /*-{
		this.query_timeout = queryTimeout;
	}-*/;
	
	/**
	 * Indicates whether emit time logging events (log.timing) or not (optional).
	 */
	public final native boolean logTime() /*-{
		return this.log_time;
	}-*/;
	
	/**
	 * Indicates whether emit time logging events (log.timing) or not (optional).
	 */
	public final native void logTime(boolean logTime) /*-{
		this.log_time = logTime;
	}-*/;
}
