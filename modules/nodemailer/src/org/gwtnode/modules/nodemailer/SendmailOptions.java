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
package org.gwtnode.modules.nodemailer;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * Sendmail transport method streams the compiled message to the stdin of sendmail command.
 * 
 * <p>
 * Currently the command to be spawned is built up like this: the command is either using <code>sendmail -i -f from_addr
 * to_addr[]</code> (by default) or <code>sendmail -i list_of_args[]</code> (if args property was given). {@code -i} is
 * ensured to be present on either case.
 * 
 * <p>
 * In the default case (no {@code args} defined) From and To addresses are either taken from {@code From, To, Cc} and
 * {@code Bcc} properties or from the {@code envelope} property if one is present.
 * 
 * <p>
 * Be wary when using the {@code args} property - no recipients are defined by default, you need to ensure these by
 * yourself, for example by using the {@code -t} flag.
 * 
 * <h1>Compatibility notice</h1>
 * 
 * <p>
 * Some sendmail implementations require all line endings to be &lt;LF> while Nodemailer uses &lt;CR>&lt;LF> - in this
 * case you can not use the sendmail option.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
public class SendmailOptions extends JavaScriptObject {

	public final static SendmailOptions create() {
		return JavaScriptObject.createObject().<SendmailOptions> cast();
	}

	public final static SendmailOptions create(String path, JsArrayString args) {
		SendmailOptions result = create();
		result.path(path);
		result.args(args);
		return result;
	}
	
	protected SendmailOptions() {}

	/**
	 * Path to the sendmail command (defaults to "sendmail")
	 */
	public final native String path() /*-{
		return this.path;
	}-*/;

	/**
	 * Path to the sendmail command (defaults to "sendmail")
	 */
	public final native void path(String path) /*-{
		this.path = path;
	}-*/;
	
	/**
	 * An array of extra command line options to pass to the sendmail command (ie. ["-f", "foo@blurdybloop.com"]).
	 */
	public final native JsArrayString args() /*-{
		return this.args;
	}-*/;
	
	/**
	 * An array of extra command line options to pass to the sendmail command (ie. ["-f", "foo@blurdybloop.com"]).
	 */
	public final native void args(JsArrayString args) /*-{
		this.args = args;
	}-*/;
}
