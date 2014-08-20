/*
 * Copyright 2014 Maxim Dominichenko
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
package org.gwtnode.modules.xml2js;

import org.gwtnode.core.JavaScriptFunction;
import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeModule;
import org.gwtnode.core.node.Global;
import org.gwtnode.core.node.NodeJsModule;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * <p>The node.js <a href="https://github.com/Leonidas-from-XIV/node-xml2js">xml2js</a> module.</p>
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeModule
public class Xml2Js extends JavaScriptObject implements NodeJsModule {

	private static Xml2Js instance;

	public static Xml2Js get() {
		if (instance == null) instance = Global.get().require("xml2js");
		return instance;
	}
	
	protected Xml2Js() {}
	
	@GwtNodeFunction
	public final void parseString(String xml, ParseOptions options, ParseEventHandler callback) {
		parseString(xml, options, callback != null ? callback.getNativeFunction() : null);
	}

	@GwtNodeFunction
	public final native void parseString(
			String xml, ParseOptions options, JavaScriptFunction callback) /*-{
		this.parseString(xml, options, callback);
	}-*/;
	
	@GwtNodeFunction
	public final void parseString(String xml, ParseEventHandler callback) {
		parseString(xml, callback != null ? callback.getNativeFunction() : null);
	}

	@GwtNodeFunction
	public final native void parseString(
			String xml, JavaScriptFunction callback) /*-{
		this.parseString(xml, callback);
	}-*/;
	
	//TODO add Builder API
}
