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

import org.gwtnode.core.node.NodeJsError;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;

/**
 * Read-only structure that holds info about connection.
 * Is used for information purposes in event handlers.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
public class Metadata extends JavaScriptObject {

	protected Metadata() {}

	/**
	 * As a rule is presented in each event, except log.info for setting CQL version operation, log.debug events for
	 * connection closing and log.error events of executing queries against pooled connections. 
	 */
	public final native Options connectionInfo() /*-{
    return this.connectionInfo;
	}-*/;

	/**
	 * Is appeared in log.error events and in log.warn events for unhealthy connections in pool.
	 */
	public final native NodeJsError error() /*-{
		return this.err;
	}-*/;

	/**
	 * Is appeared in log.cql events, and in log.trace, log.warn, log.timing events that are related to queries.
	 */
	public final native String query() /*-{
		return this.query;
	}-*/;
	
	/**
	 * Is appeared in log.cql events and in log.timing events that are related to queries.
	 */
	public final native String parameterizedQuery() /*-{
		return this.parameterized_query;
	}-*/;
	
	/**
	 * Is appeared in log.cql events and in log.timing events that are related to queries.
	 */
	public final native JsArrayMixed args() /*-{
		return this.args;
	}-*/;
	
	/**
	 * Is appeared in log.trace and log.warn events that are related to queries.
	 */
	public final native int timeout() /*-{
		return this.timeout;
	}-*/;
	
	/**
	 * Is appeared in log.timing events that are related to queries.
	 */
	public final native int time() /*-{
		return this.time;
	}-*/;
}
