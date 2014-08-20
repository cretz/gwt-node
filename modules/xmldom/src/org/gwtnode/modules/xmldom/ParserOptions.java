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
package org.gwtnode.modules.xmldom;

import org.gwtnode.core.JsonStringObjectMap;
import org.gwtnode.modules.xmldom.sax.Locator;

import com.google.gwt.core.client.JavaScriptObject;

public class ParserOptions extends JavaScriptObject {

	public static final ParserOptions create() {
		return JavaScriptObject.createObject().cast();
	}
	
	protected ParserOptions() {}

	public final native DOMHandler domBuilder() /*-{
		return this.domBuilder;
	}-*/;

	public final native ParserOptions domBuilder(DOMHandler domBuilder) /*-{
		this.domBuilder = domBuilder;
		return this;
	}-*/;

	public final native DOMHandler errorHandler() /*-{
		return this.errorHandler;
	}-*/;

	public final native ParserOptions errorHandler(DOMHandler errorHandler) /*-{
		this.errorHandler = errorHandler;
		return this;
	}-*/;

	public final native Locator locator() /*-{
		return this.locator;
	}-*/;

	public final native ParserOptions locator(Locator locator) /*-{
		this.locator = locator;
		return this;
	}-*/;

	public final native JavaScriptObject xmlns() /*-{
		return this.xmlns;
	}-*/;

	public final native ParserOptions xmlns(JavaScriptObject xmlns) /*-{
		this.xmlns = xmlns;
		return this;
	}-*/;

	public final JsonStringObjectMap<String> getXmlns() {
		JavaScriptObject result = xmlns();
		if (result == null) return null;
		return new JsonStringObjectMap<String>(result);
	}

	public final ParserOptions setXmlns(JsonStringObjectMap<String> xmlns) {
		return xmlns(xmlns != null ? xmlns.getNativeObject() : null);
	}
}
