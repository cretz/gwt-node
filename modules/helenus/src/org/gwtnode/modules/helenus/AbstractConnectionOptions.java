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

public abstract class AbstractConnectionOptions extends JavaScriptObject {

	protected AbstractConnectionOptions() {}
	
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
	public final native String password() /*-{
		return this.password;
	}-*/;
	
	/**
	 * Password for authentication (optional).
	 */
	public final native void password(String password) /*-{
		this.password = password;
	}-*/;

	/**
	 * The CQL version.
	 * <ul>
	 * <li>Cassandra 1.0 supports CQL 2.0.0
	 * <li>Cassandra 1.1 supports CQL 2.0.0 and 3.0.0 (with 2.0.0 the default)
	 * <li>Cassandra 1.2 will have CQL 3.0.0 as the default
	 * </ul>
	 * 
	 * Cassandra will support choosing the CQL version for a while, see
	 * <a href='https://issues.apache.org/jira/browse/CASSANDRA-3990'>https://issues.apache.org/jira/browse/CASSANDRA-3990</a>
	 */
	public final native String cqlVersion() /*-{
		return this.cqlVersion;
	}-*/;
	
	/**
	 * The CQL version.
	 * <ul>
	 * <li>Cassandra 1.0 supports CQL 2.0.0
	 * <li>Cassandra 1.1 supports CQL 2.0.0 and 3.0.0 (with 2.0.0 the default)
	 * <li>Cassandra 1.2 will have CQL 3.0.0 as the default
	 * </ul>
	 * 
	 * Cassandra will support choosing the CQL version for a while, see
	 * <a href='https://issues.apache.org/jira/browse/CASSANDRA-3990'>https://issues.apache.org/jira/browse/CASSANDRA-3990</a>
	 */
	public final native void cqlVersion(String cqlVersion) /*-{
		this.cqlVersion = cqlVersion;
	}-*/;

	/**
	 * Connection timeout (optional). default 3000.
	 */
	public final native int timeout() /*-{
		return this.timeout;
	}-*/;
	
	/**
	 * Connection timeout (optional). default 3000.
	 */
	public final native void timeout(int timeout) /*-{
		this.timeout = timeout;
	}-*/;

	/**
	 * Consistency level for cql queries (optional).
	 */
	public final native int consistencyLevel() /*-{
		return this.consistencylevel;
	}-*/;
	
	/**
	 * Consistency level for cql queries (optional).
	 */
	public final native void consistencyLevel(int consistencyLevel) /*-{
		this.consistencylevel = consistencyLevel;
	}-*/;
}
