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

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;

import com.google.gwt.core.client.JavaScriptObject;

@GwtNodeObject
public class Keyspace extends JavaScriptObject {

	protected Keyspace() {}
	
	/**
	 * Gets a column family from the cache or loads it up.
	 * 
	 * @param columnFamily
	 *          The name of the columnFamily to get the definition for
	 * @param callback
	 *          The callback to invoke once the column family has been retreived
	 */
	@GwtNodeFunction
	public final void get(String columnFamily, ColumnFamilyEventHandler callback) {
		get(columnFamily, callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void get(String columnFamily, JavaScriptFunction callback) /*-{
		this.get(columnFamily, callback);
	}-*/;

	/**
	 * Loads gets all the column families and calls back with them.
	 * 
	 * @param callback
	 *          The callback to invoke once the column families have been retreived
	 */
	@GwtNodeFunction
	public final void describe(ColumnFamiliesEventHandler callback) {
		describe(callback != null ? callback.getNativeFunction() : null);
	}
	
	@GwtNodeFunction
	private final native void describe(JavaScriptFunction callback) /*-{
		this.describe(callback);
	}-*/;
	
	//TODO: implement createColumnFamily method

	//TODO: implement dropColumnFamily method
}
