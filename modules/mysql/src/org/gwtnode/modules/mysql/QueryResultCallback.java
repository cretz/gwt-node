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

import org.gwtnode.core.JavaScriptFunctionArguments;
import org.gwtnode.core.JavaScriptFunctionWrapper;
import org.gwtnode.modules.mysql.packets.FieldPacket;
import org.gwtnode.modules.mysql.packets.RowDataPacket;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public abstract class QueryResultCallback extends JavaScriptFunctionWrapper {

	private static final native <T extends JsArray<?>> T getJSObjectAsArray(JavaScriptObject jso) /*-{
		if (typeof jso == "undefined") return null;
		if (jso instanceof Array) return jso;
		return [jso];
	}-*/;
	
	@Override
	public void call(JavaScriptFunctionArguments args) {
		MySQLError error = args.get(0);
		JavaScriptObject jsoResults = args.get(1);
		JavaScriptObject jsoFields = args.get(2);
		
		JsArray<JavaScriptObject> jsaResults = getJSObjectAsArray(jsoResults);
		RowDataPacket[] results = null;
		if (jsaResults != null) {
			results = new RowDataPacket[jsaResults.length()];
			for (int i = 0; i < jsaResults.length(); i++)
				results[i] = new RowDataPacket(jsaResults.get(i));
		}
		
		JsArray<FieldPacket> jsaFields = getJSObjectAsArray(jsoFields);
		FieldPacket[] fields = null;
		if (jsaFields != null) {
			fields = new FieldPacket[jsaFields.length()];
			for (int i = 0; i < jsaFields.length(); i++)
				fields[i] = jsaFields.get(i);
		}
				
		onEvent(error, results, fields);
	}
	
	public abstract void onEvent(MySQLError error, RowDataPacket[] results, FieldPacket[] fields);
}
