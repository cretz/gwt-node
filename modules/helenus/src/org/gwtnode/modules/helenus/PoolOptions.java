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
package org.gwtnode.modules.helenus;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public class PoolOptions extends AbstractConnectionOptions {

	public static final PoolOptions create() {
		return JavaScriptObject.createObject().cast();
	}

	public static final PoolOptions create(String[] hosts, String keyspace) {
		PoolOptions result = create();
		result.hosts(hosts);
		result.keyspace(keyspace);
		return result;
	}
	
	public static final PoolOptions create(String[] hosts, String keyspace, String cqlVersion) {
		PoolOptions result = create();
		result.hosts(hosts);
		result.keyspace(keyspace);
		result.cqlVersion(cqlVersion);
		return result;
	}
	
	public static final PoolOptions create(String[] hosts, String keyspace, String user, String password) {
		PoolOptions result = create();
		result.hosts(hosts);
		result.keyspace(keyspace);
		result.user(user);
		result.password(password);
		return result;
	}
	
	public static final PoolOptions create(
			String[] hosts, String keyspace, String cqlVersion, String user, String password) {
		PoolOptions result = create();
		result.hosts(hosts);
		result.keyspace(keyspace);
		result.cqlVersion(cqlVersion);
		result.user(user);
		result.password(password);
		return result;
	}
	
	protected PoolOptions() {}
	
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
		hosts(JsUtils.asJSOArray((Object[]) hosts).<JsArrayString> cast());
	}

	/**
	 * List of strings in host:port format.
	 */
	public final void hosts(Iterable<String> hosts) {
		hosts(JsUtils.asJSOArray(hosts).<JsArrayString> cast());
	}

	public final native int hostPoolSize() /*-{
		return this.hostPoolSize;
	}-*/;

	public final native void hostPoolSize(int hostPoolSize) /*-{
		this.hostPoolSize = hostPoolSize;
	}-*/;
}
