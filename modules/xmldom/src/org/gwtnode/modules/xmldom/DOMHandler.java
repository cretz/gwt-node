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

import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.node.NodeJsError;
import org.gwtnode.modules.xmldom.sax.Attributes;
import org.gwtnode.modules.xmldom.sax.ContentHandler;
import org.gwtnode.modules.xmldom.sax.ErrorHandler;
import org.gwtnode.modules.xmldom.sax.Locator;

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.JavaScriptObject;

@GwtNodeObject
public class DOMHandler extends JavaScriptObject implements ContentHandler, ErrorHandler {

	@GwtNodeFunction("constructor")
	public static final DOMHandler create(final ContentHandler ch) {
		return create(ch, null);
	}

	@GwtNodeFunction("constructor")
	public static final DOMHandler create(final ErrorHandler eh) {
		return create(null, eh);
	}
	
	@GwtNodeFunction("constructor")
	public static final native DOMHandler create(final ContentHandler ch, final ErrorHandler eh) /*-{
		var result = {};
		var dummy = function() {};
		var that = this;
		if (ch != null) {
			result.setDocumentLocator = function(locator) {
				var f = ch.@org.gwtnode.modules.xmldom.sax.ContentHandler::setDocumentLocator(Lorg/gwtnode/modules/xmldom/sax/Locator;);
				f.call(that, locator);
			};
			result.startDocument = function() {
				var f = ch.@org.gwtnode.modules.xmldom.sax.ContentHandler::startDocument();
				f.call(that);
			};
			result.endDocument = function() {
				var f = ch.@org.gwtnode.modules.xmldom.sax.ContentHandler::endDocument();
				f.call(that);
			};
			result.startPrefixMapping = function(prefix, uri) {
				var f = ch.@org.gwtnode.modules.xmldom.sax.ContentHandler::startPrefixMapping(Ljava/lang/String;Ljava/lang/String;);
				f.call(that, prefix, uri);
			};
			result.endPrefixMapping = function(prefix) {
				var f = ch.@org.gwtnode.modules.xmldom.sax.ContentHandler::endPrefixMapping(Ljava/lang/String;);
				f.call(that, prefix);
			}
			result.startElement = function(uri, localName, qName, attrs) {
				var f = ch.@org.gwtnode.modules.xmldom.sax.ContentHandler::startElement(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/gwtnode/modules/xmldom/sax/Attributes;);
				f.call(that, uri, localName, qName, attrs);
			};
			result.endElement = function(uri, localName, qName) {
				var f = ch.@org.gwtnode.modules.xmldom.sax.ContentHandler::endElement(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;);
				f.call(that, uri, localName, qName);
			};
			result.characters = function(ch, start, length) {
				var f = ch.@org.gwtnode.modules.xmldom.sax.ContentHandler::characters(Ljava/lang/String;II);
				f.call(that, ch, start, length);
			};
			result.ignorableWhitespace = function(ch, start, length) {
				var f = ch.@org.gwtnode.modules.xmldom.sax.ContentHandler::ignorableWhitespace(Ljava/lang/String;II);
				f.call(that, ch, start, length);
			};
			result.processingInstruction = function(target, data) {
				var f = ch.@org.gwtnode.modules.xmldom.sax.ContentHandler::processingInstruction(Ljava/lang/String;Ljava/lang/String;);
				f.call(that, target, data);
			};
			result.skippedEntity = function(name) {
				var f = ch.@org.gwtnode.modules.xmldom.sax.ContentHandler::skippedEntity(Ljava/lang/String;);
				f.call(that, name);
			};
		} else {
			result.setDocumentLocator = dummy;
			result.startDocument = dummy;
			result.endDocument = dummy;
			result.startPrefixMapping = dummy;
			result.endPrefixMapping = dummy;
			result.startElement = dummy;
			result.endElement = dummy;
			result.characters = dummy;
			result.ignorableWhitespace = dummy;
			result.processingInstruction = dummy;
			result.skippedEntity = dummy;
		}
		if (eh != null) {
			result.warning = function(error) {
				var f = eh.@org.gwtnode.modules.xmldom.sax.ErrorHandler::warning(Lorg/gwtnode/core/node/NodeJsError;);
				f.call(that, error);
			};
			result.error = function(error) {
				var f = eh.@org.gwtnode.modules.xmldom.sax.ErrorHandler::error(Lorg/gwtnode/core/node/NodeJsError;);
				f.call(that, error);
			};
			result.fatalError = function(error) {
				var f = eh.@org.gwtnode.modules.xmldom.sax.ErrorHandler::fatalError(Lorg/gwtnode/core/node/NodeJsError;);
				f.call(that, error);
			};
		} else {
			result.warning = dummy;
			result.error = dummy;
			result.fatalError = dummy;
		}
		return result;
	}-*/;

	protected DOMHandler() {}
	
	@Override
	@GwtNodeFunction
	public final native void setDocumentLocator(Locator locator) /*-{
		this.setDocumentLocator(locator);
	}-*/;

	@Override
	@GwtNodeFunction
	public final native void startDocument() throws JavaScriptException /*-{
		this.startDocument();
	}-*/;

	@Override
	@GwtNodeFunction
	public final native void endDocument() throws JavaScriptException /*-{
		this.endDocument();
	}-*/;

	@Override
	@GwtNodeFunction
	public final native void startPrefixMapping(String prefix, String uri) throws JavaScriptException /*-{
		this.startPrefixMapping(prefix, uri);
	}-*/;

	@Override
	@GwtNodeFunction
	public final native void endPrefixMapping(String prefix) throws JavaScriptException /*-{
		this.endPrefixMapping(prefix);
	}-*/;

	@Override
	@GwtNodeFunction
	public final native void startElement(String uri, String localName, String qName, Attributes attrs) 
			throws JavaScriptException /*-{
		this.startElement(uri, localName, qName, attrs);
	}-*/;

	@Override
	@GwtNodeFunction
	public final native void endElement(String uri, String localName, String qName) throws JavaScriptException /*-{
		this.endElement(uri, localName, qName);
	}-*/;

	@Override
	@GwtNodeFunction
	public final native void characters(String ch, int start, int length) throws JavaScriptException /*-{
		this.characters(ch, start, length);
	}-*/;

	@Override
	@GwtNodeFunction
	public final native void ignorableWhitespace(String ch, int start, int length) throws JavaScriptException /*-{
		this.ignorableWhitespace(ch, start, length);
	}-*/;

	@Override
	@GwtNodeFunction
	public final native void processingInstruction(String target, String data) throws JavaScriptException /*-{
		this.processingInstruction(target, data);
	}-*/;

	@Override
	@GwtNodeFunction
	public final native void skippedEntity(String name) throws JavaScriptException /*-{
		this.skippedEntity(name);
	}-*/;

	@Override
	@GwtNodeFunction
	public final native void warning(NodeJsError error) throws JavaScriptException /*-{
		this.warning(error);
	}-*/;

	@Override
	@GwtNodeFunction
	public final native void error(NodeJsError error) throws JavaScriptException /*-{
		this.error(error);
	}-*/;

	@Override
	@GwtNodeFunction
	public final native void fatalError(NodeJsError error) throws JavaScriptException /*-{
		this.fatalError(error);
	}-*/;
}
