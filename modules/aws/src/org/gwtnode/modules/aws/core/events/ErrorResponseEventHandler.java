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

import org.gwtnode.core.JavaScriptFunctionArguments;
import org.gwtnode.core.JavaScriptFunctionWrapper;
import org.gwtnode.modules.aws.core.Response;
import org.gwtnode.modules.aws.s3.data.RequestError;

public abstract class ErrorResponseEventHandler extends JavaScriptFunctionWrapper {

	@Override
	public void call(JavaScriptFunctionArguments args) {
		onEvent(args.<RequestError> get(0), args.<Response> get(1));
	}

	public abstract void onEvent(RequestError error, Response response);
}
