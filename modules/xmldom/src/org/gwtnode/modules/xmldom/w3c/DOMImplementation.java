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
package org.gwtnode.modules.xmldom.w3c;

import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * The <code>DOMImplementation</code> interface provides a number of methods for performing operations that are
 * independent of any particular instance of the document object model.
 * <p>
 * See also the <a href='http://www.w3.org/TR/2004/REC-DOM-Level-3-Core-20040407'>Document Object Model (DOM) Level 3
 * Core Specification</a>.
 */
@GwtNodeObject
public class DOMImplementation extends JavaScriptObject {

	protected DOMImplementation() {}

	/**
	 * Test if the DOM implementation implements a specific feature and version, as specified in <a
	 * href="http://www.w3.org/TR/2004/REC-DOM-Level-3-Core-20040407/core.html#DOMFeatures">DOM Features</a>.
	 * 
	 * @param feature
	 *          The name of the feature to test.
	 * @param version
	 *          This is the version number of the feature to test.
	 * @return <code>true</code> if the feature is implemented in the specified version, <code>false</code> otherwise.
	 */
	@GwtNodeFunction
	public final native boolean hasFeature(String feature, String version) /*-{
		return this.hasFeature(feature, version);
	}-*/;

	/**
	 * Creates an empty <code>DocumentType</code> node. Entity declarations and notations are not made available. Entity
	 * reference expansions and default attribute additions do not occur..
	 * 
	 * @param qualifiedName
	 *          The qualified name of the document type to be created.
	 * @param publicId
	 *          The external subset public identifier.
	 * @param systemId
	 *          The external subset system identifier.
	 * @return A new <code>DocumentType</code> node with <code>Node.ownerDocument</code> set to <code>null</code>.
	 * @exception JavaScriptException
	 *              INVALID_CHARACTER_ERR: Raised if the specified qualified name is not an XML name according to [<a
	 *              href='http://www.w3.org/TR/2004/REC-xml-20040204'>XML 1.0</a>]. <br>
	 *              NAMESPACE_ERR: Raised if the <code>qualifiedName</code> is malformed. <br>
	 *              NOT_SUPPORTED_ERR: May be raised if the implementation does not support the feature "XML" and the
	 *              language exposed through the Document does not support XML Namespaces (such as [<a
	 *              href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
	 * @since DOM Level 2
	 */
	@GwtNodeFunction
	public final native DocumentType createDocumentType(String qualifiedName, String publicId, String systemId)
			throws JavaScriptException /*-{
  	return this.createDocumentType(qualifiedName, publicId, systemId);
  }-*/;

	/**
	 * Creates a DOM Document object of the specified type with its document element. <br>
	 * Note that based on the <code>DocumentType</code> given to create the document, the implementation may instantiate
	 * specialized <code>Document</code> objects that support additional features than the "Core", such as "HTML" [<a
	 * href='http://www.w3.org/TR/2003/REC-DOM-Level-2-HTML-20030109'>DOM Level 2 HTML</a>] . On the other hand, setting
	 * the <code>DocumentType</code> after the document was created makes this very unlikely to happen. Alternatively,
	 * specialized <code>Document</code> creation methods, such as <code>createHTMLDocument</code> [<a
	 * href='http://www.w3.org/TR/2003/REC-DOM-Level-2-HTML-20030109'>DOM Level 2 HTML</a>] , can be used to obtain
	 * specific types of <code>Document</code> objects.
	 * 
	 * @param namespaceURI
	 *          The namespace URI of the document element to create or <code>null</code>.
	 * @param qualifiedName
	 *          The qualified name of the document element to be created or <code>null</code>.
	 * @param doctype
	 *          The type of document to be created or <code>null</code>. When <code>doctype</code> is not
	 *          <code>null</code>, its <code>Node.ownerDocument</code> attribute is set to the document being created.
	 * @return A new <code>Document</code> object with its document element. If the <code>NamespaceURI</code>,
	 *         <code>qualifiedName</code>, and <code>doctype</code> are <code>null</code>, the returned
	 *         <code>Document</code> is empty with no document element.
	 * @exception JavaScriptException
	 *              INVALID_CHARACTER_ERR: Raised if the specified qualified name is not an XML name according to [<a
	 *              href='http://www.w3.org/TR/2004/REC-xml-20040204'>XML 1.0</a>]. <br>
	 *              NAMESPACE_ERR: Raised if the <code>qualifiedName</code> is malformed, if the
	 *              <code>qualifiedName</code> has a prefix and the <code>namespaceURI</code> is <code>null</code>, or if
	 *              the <code>qualifiedName</code> is <code>null</code> and the <code>namespaceURI</code> is different
	 *              from <code>null</code>, or if the <code>qualifiedName</code> has a prefix that is "xml" and the
	 *              <code>namespaceURI</code> is different from "<a href='http://www.w3.org/XML/1998/namespace'>
	 *              http://www.w3.org/XML/1998/namespace</a>" [<a
	 *              href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>] , or if the DOM
	 *              implementation does not support the <code>"XML"</code> feature but a non-null namespace URI was
	 *              provided, since namespaces were defined by XML. <br>
	 *              WRONG_DOCUMENT_ERR: Raised if <code>doctype</code> has already been used with a different document or
	 *              was created from a different implementation. <br>
	 *              NOT_SUPPORTED_ERR: May be raised if the implementation does not support the feature "XML" and the
	 *              language exposed through the Document does not support XML Namespaces (such as [<a
	 *              href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
	 * @since DOM Level 2
	 */
	@GwtNodeFunction
	public final native Document createDocument(String namespaceURI, String qualifiedName, DocumentType doctype)
			throws JavaScriptException /*-{
  	return this.createDocument(namespaceURI, qualifiedName, doctype);
  }-*/;
}
