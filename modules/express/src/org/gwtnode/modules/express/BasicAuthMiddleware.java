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
package org.gwtnode.modules.express;

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.JavaScriptFunctionArguments;
import org.gwtnode.core.JavaScriptFunctionWrapper;

public class BasicAuthMiddleware implements Middleware {
	
	public abstract static class Callback extends JavaScriptFunctionWrapper {

		@Override
		public void call(JavaScriptFunctionArguments args) {
			onEvent(args.<String> get(0), args.<String> get(1));
		}

		public abstract void onEvent(String user, String pass);
	}
	
	private String user;
	private String pass;
	private JavaScriptFunction callback;
	
	BasicAuthMiddleware(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}

	BasicAuthMiddleware(Callback callback) {
		this.callback = callback != null ? callback.getNativeFunction() : null;
	}

	@Override
	public native JavaScriptFunction get() /*-{
		var basicAuth = (@org.gwtnode.modules.express.Express::get()()).basicAuth;
		var cb = this.@org.gwtnode.modules.express.BasicAuthMiddleware::callback;
		return cb != null ? basicAuth(cb) : basicAuth(
				this.@org.gwtnode.modules.express.BasicAuthMiddleware::user,
				this.@org.gwtnode.modules.express.BasicAuthMiddleware::pass);
	}-*/;
}
