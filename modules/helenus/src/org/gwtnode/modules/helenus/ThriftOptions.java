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
import com.google.gwt.core.client.JsDate;

public class ThriftOptions extends JavaScriptObject {

	public static final ThriftOptions create() {
		return JavaScriptObject.createObject().cast();
	}

	public static final ThriftOptions create(int ttl, int consistencyLevel, JsDate timestamp) {
		ThriftOptions result = create();
		result.ttl(ttl);
		result.consistencyLevel(consistencyLevel);
		result.timestamp(timestamp);
		return result;
	}
	
	protected ThriftOptions() {}

	public final native int ttl() /*-{
    return this.ttl;
	}-*/;

	public final native void ttl(int ttl) /*-{
    this.ttl = ttl;
	}-*/;

	public final native int consistencyLevel() /*-{
    return this.consistencyLevel;
	}-*/;

	public final native void consistencyLevel(int consistencyLevel) /*-{
    this.consistencyLevel = consistencyLevel;
	}-*/;
	
	public final native JsDate timestamp() /*-{
    return this.timestamp;
	}-*/;

	public final native void timestamp(JsDate timestamp) /*-{
    this.timestamp = timestamp;
	}-*/;
}
