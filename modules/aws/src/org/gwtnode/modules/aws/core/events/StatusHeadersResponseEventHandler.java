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
package org.gwtnode.modules.aws.core.events;

import java.util.Map;

import org.gwtnode.core.JavaScriptFunctionArguments;
import org.gwtnode.core.JavaScriptFunctionWrapper;
import org.gwtnode.core.JsonStringObjectMap;
import org.gwtnode.modules.aws.core.Response;

import com.google.gwt.core.client.JavaScriptObject;

public abstract class StatusHeadersResponseEventHandler extends JavaScriptFunctionWrapper {

	@Override
	public void call(JavaScriptFunctionArguments args) {
		JavaScriptObject headers = args.get(1);
		if (headers == null) headers = JavaScriptObject.createObject();
		onEvent(args.<Integer> get(0), new JsonStringObjectMap<String>(headers), args.<Response> get(2));
	}

	public abstract void onEvent(int statusCode, Map<String, String> headers, Response response);
}
