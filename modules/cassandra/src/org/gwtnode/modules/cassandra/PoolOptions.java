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
import com.google.gwt.core.client.JsArrayString;

public class PoolOptions extends CommonOptions {

	public static final PoolOptions create() {
		return JavaScriptObject.createObject().cast();
	}

	public static final PoolOptions create(String[] hosts, String keyspace) {
		PoolOptions result = create();
		result.hosts(hosts);
		result.keyspace(keyspace);
		return result;
	}
	
	public static final PoolOptions create(String[] hosts, String keyspace, int maxSize) {
		PoolOptions result = create();
		result.hosts(hosts);
		result.keyspace(keyspace);
		result.maxSize(maxSize);
		return result;
	}
	
	public static final PoolOptions create(String[] hosts, String keyspace, String user, String pass) {
		PoolOptions result = create();
		result.hosts(hosts);
		result.keyspace(keyspace);
		result.user(user);
		result.pass(pass);
		return result;
	}
	
	public static final PoolOptions create(String[] hosts, String keyspace, int maxSize, String user, String pass) {
		PoolOptions result = create();
		result.hosts(hosts);
		result.keyspace(keyspace);
		result.maxSize(maxSize);
		result.user(user);
		result.pass(pass);
		return result;
	}
	
	protected PoolOptions() {}
	
	public final native int staleThreshold() /*-{
		return this.staleThreshold;
	}-*/;

	public final native void staleThreshold(int staleThreshold) /*-{
		this.staleThreshold = staleThreshold;
	}-*/;
	
	/**
	 * List of strings in host:port format.
	 */
	public final native JsArrayString hosts() /*-{
		return this.hosts;
	}-*/;

	/**
	 * List of strings in host:port format.
	 */
	public final native void hosts(JsArrayString hosts) /*-{
		this.hosts = hosts;
	}-*/;

	/**
	 * List of strings in host:port format.
	 */
	public final void hosts(String[] hosts) {
		hosts(JsUtils.asJSOArray(hosts).<JsArrayString> cast());
	}

	/**
	 * List of strings in host:port format.
	 */
	public final void hosts(Iterable<String> hosts) {
		hosts(JsUtils.asJSOArray(hosts).<JsArrayString> cast());
	}

	/**
	 * Maximum number of connection to pool (optional).
	 */
	public final native int maxSize() /*-{
		return this.maxSize;
	}-*/;

	/**
	 * Maximum number of connection to pool (optional).
	 */
	public final native void maxSize(int maxSize) /*-{
		this.maxSize = maxSize;
	}-*/;

	/**
	 * Idle connection timeout in milliseconds (optional).
	 */
	public final native int idleMillis() /*-{
		return this.idleMillis;
	}-*/;

	/**
	 * Idle connection timeout in milliseconds (optional).
	 */
	public final native void idleMillis(int idleMillis) /*-{
		this.idleMillis = idleMillis;
	}-*/;
}
