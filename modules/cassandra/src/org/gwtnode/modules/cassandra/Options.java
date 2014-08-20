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

public class Options extends CommonOptions {
	
	public static final Options create() {
		return JavaScriptObject.createObject().cast();
	}

	public static final Options create(String host, int port, String keyspace) {
		Options result = create();
		result.host(host);
		result.port(port);
		result.keyspace(keyspace);
		return result;
	}
	
	public static final Options create(String host, int port, String keyspace, String user, String pass) {
		Options result = create();
		result.host(host);
		result.port(port);
		result.keyspace(keyspace);
		result.user(user);
		result.pass(pass);
		return result;
	}
	
	protected Options() {}

	/**
	 * Cassandra host.
	 */
	public final native String host() /*-{
    return this.host;
	}-*/;

	/**
	 * Cassandra host.
	 */
	public final native void host(String host) /*-{
    this.host = host;
	}-*/;

	/**
	 * Cassandra port.
	 */
	public final native int port() /*-{
    return this.port;
	}-*/;

	/**
	 * Cassandra port.
	 */
	public final native void port(int port) /*-{
    this.port = port;
	}-*/;
}
