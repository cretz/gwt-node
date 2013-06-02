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

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;

public class Col extends JavaScriptObject {

	protected Col() {}
	
	public final native String name() /*-{
		return this.name;
	}-*/;
	
	public final native <T> T value() /*-{
		return this.value;
	}-*/;
	
	public final native String valueAsString() /*-{
		if (this.value == null) return null;
		if (typeof this.value.toString == 'function') return this.value.toString('UTF-8');
		return "" + this.value;
	}-*/;
	
	public final native double valueAsNumber() /*-{
		if (this.value == null || isNaN(this.value)) return 0;
		return Number(this.value);
	}-*/;
	
	public final native JsDate valueAsJsDate() /*-{
		if (this.value == null || this.value instanceof Date) return this.value;
		var d = new Date(isNaN(this.value) ? this.value : Number(this.value));
		return isNaN(d.getTime()) ? null : d;
	}-*/;
	
	public final Date valueAsDate() {
		JsDate result = valueAsJsDate();
		if (result == null) return null;
		return new Date((long) result.getTime());
	}
}
