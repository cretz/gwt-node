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

import org.gwtnode.core.meta.GwtNodeModule;
import org.gwtnode.core.node.Global;
import org.gwtnode.core.node.NodeJsModule;
import org.gwtnode.modules.xmldom.w3c.DOMImplementation;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * <p>The node.js <a href="https://github.com/jindw/xmldom">xmldom</a> module.</p>
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeModule
public class XmlDom extends JavaScriptObject implements NodeJsModule {

	private static XmlDom instance;

	public static XmlDom get() {
		if (instance == null) instance = Global.get().require("xmldom");
		return instance;
	}
	
	protected XmlDom() {}
	
	public final native DOMImplementation createDOMImplementation(JavaScriptObject features) /*-{
		return new this.DOMImplementation(features);
	}-*/;
	
	public final native DOMImplementation createDOMImplementation() /*-{
		return new this.DOMImplementation();
	}-*/;
	
	public final native DOMParser createDOMParser(ParserOptions options) /*-{
		return new this.DOMParser(options);
	}-*/;
	
	public final native DOMParser createDOMParser() /*-{
		return new this.DOMParser();
	}-*/;
	
	public final native XMLSerializer createXMLSerializer() /*-{
		return new this.XMLSerializer();
	}-*/;
}
