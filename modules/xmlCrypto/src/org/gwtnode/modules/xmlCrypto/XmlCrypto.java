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
package org.gwtnode.modules.xmlCrypto;

import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeModule;
import org.gwtnode.core.node.Global;
import org.gwtnode.core.node.NodeJsModule;
import org.gwtnode.modules.xmldom.w3c.Document;
import org.gwtnode.modules.xmldom.w3c.Node;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * <p>The node.js <a href="https://github.com/yaronn/xml-crypto">xml-crypto</a> module.</p>
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeModule
public class XmlCrypto extends JavaScriptObject implements NodeJsModule {

	private static XmlCrypto instance;

	public static XmlCrypto get() {
		if (instance == null) instance = Global.get().require("xml-crypto");
		return instance;
	}
	
	protected XmlCrypto() {}

	/**
	 * @param idMode Value of "wssecurity" will create/validate id's with the ws-security namespace
	 * @param options additional options
	 */
	public final native SignedXml createSignedXml(String idMode, SignedXmlOptions options) /*-{
		return new this.SignedXml(idMode, options);
	}-*/;

	/**
	 * @param idMode Value of "wssecurity" will create/validate id's with the ws-security namespace
	 */
	public final native SignedXml createSignedXml(String idMode) /*-{
		return new this.SignedXml(idMode);
	}-*/;
	
	public final native SignedXml createSignedXml() /*-{
		return new this.SignedXml();
	}-*/;
	
	public final native FileKeyInfo createFileKeyInfo(String file) /*-{
		return new this.FileKeyInfo(file);
	}-*/;
	
	@GwtNodeFunction
	public final native JsArray<Node> xpath(Document doc, String xpath) /*-{
		return this.xpath(doc, xpath);
	}-*/;
}
