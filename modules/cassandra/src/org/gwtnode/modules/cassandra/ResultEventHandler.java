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

import org.gwtnode.core.JavaScriptFunctionArguments;
import org.gwtnode.core.JavaScriptFunctionWrapper;
import org.gwtnode.core.node.NodeJsError;
//import org.gwtnode.core.node.util.Util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import static org.gwtnode.modules.cassandra.JsUtils.*;

public abstract class ResultEventHandler extends JavaScriptFunctionWrapper {

//	private static final Util U = Util.get();
	
	@Override
	public void call(JavaScriptFunctionArguments args) {
//		U.log("ResultEventHandler.call: args=" + U.inspect(args));
		NodeJsError error = args.get(0);
		JavaScriptObject rows = args.get(1);
		Metadata metadata = args.get(2);
//		U.log("ResultEventHandler.call: isArray(rows)=" + isArray(rows) + "; isNumber(rows)=" + isNumber(rows));
		if (error != null) onError(error, metadata);
		else if (rows == null || isNumber(rows)) onCount((int) asNumber(args), metadata);
		else onRows(asArray(rows).<JsArray<Row>> cast(), metadata);
	}

	public abstract void onError(NodeJsError error, Metadata metadata);
	
	/**
	 * Is invoked only in case if result is a rowset (SELECT operations).
	 */
	public abstract void onRows(JsArray<Row> rows, Metadata metadata);
	
	/**
	 * Is invoked only in case if result is a number (INSERT/UPDATE/DELETE/TRUNCATE/DROP etc operations).
	 */
	public abstract void onCount(int count, Metadata metadata);
}
