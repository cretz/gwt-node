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
import org.gwtnode.core.meta.GwtNodeProperty;

import com.google.gwt.core.client.JavaScriptException;

/**
 * The <code>Element</code> interface represents an element in an HTML or XML document. Elements may have attributes
 * associated with them; since the <code>Element</code> interface inherits from <code>Node</code>, the generic
 * <code>Node</code> interface attribute <code>attributes</code> may be used to retrieve the set of all attributes for
 * an element. There are methods on the <code>Element</code> interface to retrieve either an <code>Attr</code> object by
 * name or an attribute value by name. In XML, where an attribute value may contain entity references, an
 * <code>Attr</code> object should be retrieved to examine the possibly fairly complex sub-tree representing the
 * attribute value. On the other hand, in HTML, where all attributes have simple string values, methods to directly
 * access an attribute value can safely be used as a convenience.
 * <p >
 * <b>Note:</b> In DOM Level 2, the method <code>normalize</code> is inherited from the <code>Node</code> interface
 * where it was moved.
 * <p>
 * See also the <a href='http://www.w3.org/TR/2004/REC-DOM-Level-3-Core-20040407'>Document Object Model (DOM) Level 3
 * Core Specification</a>.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class Element extends Node {

	protected Element() {}

	/**
	 * The name of the element. If <code>Node.localName</code> is different from <code>null</code>, this attribute is a
	 * qualified name. For example, in:
	 * 
	 * <pre>
	 * &lt;elementExample id="demo"&gt; ... 
	 * &lt;/elementExample&gt; ,
	 * </pre>
	 * 
	 * <code>tagName</code> has the value <code>"elementExample"</code>. Note that this is case-preserving in XML, as are
	 * all of the operations of the DOM. The HTML DOM returns the <code>tagName</code> of an HTML element in the canonical
	 * uppercase form, regardless of the case in the source HTML document.
	 */
	@GwtNodeProperty
	public final native String tagName() /*-{
		return this.tagName;
	}-*/;

	/**
	 * Retrieves an attribute value by name.
	 * 
	 * @param name
	 *          The name of the attribute to retrieve.
	 * @return The <code>Attr</code> value as a string, or the empty string if that attribute does not have a specified or
	 *         default value.
	 */
	@GwtNodeFunction
	public final native String getAttribute(String name) /*-{
		return this.getAttribute(name);
	}-*/;

	/**
	 * Adds a new attribute. If an attribute with that name is already present in the element, its value is changed to be
	 * that of the value parameter. This value is a simple string; it is not parsed as it is being set. So any markup
	 * (such as syntax to be recognized as an entity reference) is treated as literal text, and needs to be appropriately
	 * escaped by the implementation when it is written out. In order to assign an attribute value that contains entity
	 * references, the user must create an <code>Attr</code> node plus any <code>Text</code> and
	 * <code>EntityReference</code> nodes, build the appropriate subtree, and use <code>setAttributeNode</code> to assign
	 * it as the value of an attribute. <br>
	 * To set an attribute with a qualified name and namespace URI, use the <code>setAttributeNS</code> method.
	 * 
	 * @param name
	 *          The name of the attribute to create or alter.
	 * @param value
	 *          Value to set in string form.
	 * @exception JavaScriptException
	 *              INVALID_CHARACTER_ERR: Raised if the specified name is not an XML name according to the XML version in
	 *              use specified in the <code>Document.xmlVersion</code> attribute. <br>
	 *              NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
	 */
	@GwtNodeFunction
	public final native void setAttribute(String name, String value) throws JavaScriptException /*-{
		this.setAttribute(name, value);
	}-*/;

	/**
	 * Removes an attribute by name. If a default value for the removed attribute is defined in the DTD, a new attribute
	 * immediately appears with the default value as well as the corresponding namespace URI, local name, and prefix when
	 * applicable. The implementation may handle default values from other schemas similarly but applications should use
	 * <code>Document.normalizeDocument()</code> to guarantee this information is up-to-date. <br>
	 * If no attribute with this name is found, this method has no effect. <br>
	 * To remove an attribute by local name and namespace URI, use the <code>removeAttributeNS</code> method.
	 * 
	 * @param name
	 *          The name of the attribute to remove.
	 * @exception JavaScriptException
	 *              NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
	 */
	@GwtNodeFunction
	public final native void removeAttribute(String name) throws JavaScriptException /*-{
		this.removeAttribute(name);
	}-*/;

	/**
	 * Retrieves an attribute node by name. <br>
	 * To retrieve an attribute node by qualified name and namespace URI, use the <code>getAttributeNodeNS</code> method.
	 * 
	 * @param name
	 *          The name (<code>nodeName</code>) of the attribute to retrieve.
	 * @return The <code>Attr</code> node with the specified name ( <code>nodeName</code>) or <code>null</code> if there
	 *         is no such attribute.
	 */
	@GwtNodeFunction
	public final native Attr getAttributeNode(String name) /*-{
		return this.getAttributeNode(name);
	}-*/;

	/**
	 * Adds a new attribute node. If an attribute with that name ( <code>nodeName</code>) is already present in the
	 * element, it is replaced by the new one. Replacing an attribute node by itself has no effect. <br>
	 * To add a new attribute node with a qualified name and namespace URI, use the <code>setAttributeNodeNS</code>
	 * method.
	 * 
	 * @param newAttr
	 *          The <code>Attr</code> node to add to the attribute list.
	 * @return If the <code>newAttr</code> attribute replaces an existing attribute, the replaced <code>Attr</code> node
	 *         is returned, otherwise <code>null</code> is returned.
	 * @exception JavaScriptException
	 *              WRONG_DOCUMENT_ERR: Raised if <code>newAttr</code> was created from a different document than the one
	 *              that created the element. <br>
	 *              NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly. <br>
	 *              INUSE_ATTRIBUTE_ERR: Raised if <code>newAttr</code> is already an attribute of another
	 *              <code>Element</code> object. The DOM user must explicitly clone <code>Attr</code> nodes to re-use them
	 *              in other elements.
	 */
	@GwtNodeFunction
	public final native Attr setAttributeNode(Attr newAttr) throws JavaScriptException /*-{
		return this.setAttributeNode(newAttr);
	}-*/;

	/**
	 * Removes the specified attribute node. If a default value for the removed <code>Attr</code> node is defined in the
	 * DTD, a new node immediately appears with the default value as well as the corresponding namespace URI, local name,
	 * and prefix when applicable. The implementation may handle default values from other schemas similarly but
	 * applications should use <code>Document.normalizeDocument()</code> to guarantee this information is up-to-date.
	 * 
	 * @param oldAttr
	 *          The <code>Attr</code> node to remove from the attribute list.
	 * @return The <code>Attr</code> node that was removed.
	 * @exception JavaScriptException
	 *              NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly. <br>
	 *              NOT_FOUND_ERR: Raised if <code>oldAttr</code> is not an attribute of the element.
	 */
	@GwtNodeFunction
	public final native Attr removeAttributeNode(Attr oldAttr) throws JavaScriptException /*-{
		return this.removeAttributeNode(oldAttr);
	}-*/;

	/**
	 * Returns a <code>NodeList</code> of all descendant <code>Elements</code> with a given tag name, in document order.
	 * 
	 * @param name
	 *          The name of the tag to match on. The special value "*" matches all tags.
	 * @return A list of matching <code>Element</code> nodes.
	 */
	@GwtNodeFunction
	public final native NodeList getElementsByTagName(String name) /*-{
		return this.getElementsByTagName(name);
	}-*/;

	/**
	 * Retrieves an attribute value by local name and namespace URI. <br>
	 * Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>] , applications must use the
	 * value <code>null</code> as the <code>namespaceURI</code> parameter for methods if they wish to have no namespace.
	 * 
	 * @param namespaceURI
	 *          The namespace URI of the attribute to retrieve.
	 * @param localName
	 *          The local name of the attribute to retrieve.
	 * @return The <code>Attr</code> value as a string, or the empty string if that attribute does not have a specified or
	 *         default value.
	 * @exception DOMException
	 *              NOT_SUPPORTED_ERR: May be raised if the implementation does not support the feature <code>"XML"</code>
	 *              and the language exposed through the Document does not support XML Namespaces (such as [<a
	 *              href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
	 * @since DOM Level 2
	 */
	@GwtNodeFunction
	public final native String getAttributeNS(String namespaceURI, String localName) throws JavaScriptException /*-{
		return this.getAttributeNS(namespaceURI, localName);
	}-*/;

	/**
	 * Adds a new attribute. If an attribute with the same local name and namespace URI is already present on the element,
	 * its prefix is changed to be the prefix part of the <code>qualifiedName</code>, and its value is changed to be the
	 * <code>value</code> parameter. This value is a simple string; it is not parsed as it is being set. So any markup
	 * (such as syntax to be recognized as an entity reference) is treated as literal text, and needs to be appropriately
	 * escaped by the implementation when it is written out. In order to assign an attribute value that contains entity
	 * references, the user must create an <code>Attr</code> node plus any <code>Text</code> and
	 * <code>EntityReference</code> nodes, build the appropriate subtree, and use <code>setAttributeNodeNS</code> or
	 * <code>setAttributeNode</code> to assign it as the value of an attribute. <br>
	 * Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>] , applications must use the
	 * value <code>null</code> as the <code>namespaceURI</code> parameter for methods if they wish to have no namespace.
	 * 
	 * @param namespaceURI
	 *          The namespace URI of the attribute to create or alter.
	 * @param qualifiedName
	 *          The qualified name of the attribute to create or alter.
	 * @param value
	 *          The value to set in string form.
	 * @exception JavaScriptException
	 *              INVALID_CHARACTER_ERR: Raised if the specified qualified name is not an XML name according to the XML
	 *              version in use specified in the <code>Document.xmlVersion</code> attribute. <br>
	 *              NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly. <br>
	 *              NAMESPACE_ERR: Raised if the <code>qualifiedName</code> is malformed per the Namespaces in XML
	 *              specification, if the <code>qualifiedName</code> has a prefix and the <code>namespaceURI</code> is
	 *              <code>null</code>, if the <code>qualifiedName</code> has a prefix that is "xml" and the
	 *              <code>namespaceURI</code> is different from "<a href='http://www.w3.org/XML/1998/namespace'>
	 *              http://www.w3.org/XML/1998/namespace</a>", if the <code>qualifiedName</code> or its prefix is "xmlns"
	 *              and the <code>namespaceURI</code> is different from
	 *              "<a href='http://www.w3.org/2000/xmlns/'>http://www.w3.org/2000/xmlns/</a>", or if the
	 *              <code>namespaceURI</code> is
	 *              "<a href='http://www.w3.org/2000/xmlns/'>http://www.w3.org/2000/xmlns/</a>" and neither the
	 *              <code>qualifiedName</code> nor its prefix is "xmlns". <br>
	 *              NOT_SUPPORTED_ERR: May be raised if the implementation does not support the feature <code>"XML"</code>
	 *              and the language exposed through the Document does not support XML Namespaces (such as [<a
	 *              href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
	 * @since DOM Level 2
	 */
	@GwtNodeFunction
	public final native void setAttributeNS(String namespaceURI, String qualifiedName, String value)
			throws JavaScriptException /*-{
		this.setAttributeNS(namespaceURI, qualifiedName, value);
	}-*/;

	/**
	 * Removes an attribute by local name and namespace URI. If a default value for the removed attribute is defined in
	 * the DTD, a new attribute immediately appears with the default value as well as the corresponding namespace URI,
	 * local name, and prefix when applicable. The implementation may handle default values from other schemas similarly
	 * but applications should use <code>Document.normalizeDocument()</code> to guarantee this information is up-to-date. <br>
	 * If no attribute with this local name and namespace URI is found, this method has no effect. <br>
	 * Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>] , applications must use the
	 * value <code>null</code> as the <code>namespaceURI</code> parameter for methods if they wish to have no namespace.
	 * 
	 * @param namespaceURI
	 *          The namespace URI of the attribute to remove.
	 * @param localName
	 *          The local name of the attribute to remove.
	 * @exception JavaScriptException
	 *              NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly. <br>
	 *              NOT_SUPPORTED_ERR: May be raised if the implementation does not support the feature <code>"XML"</code>
	 *              and the language exposed through the Document does not support XML Namespaces (such as [<a
	 *              href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
	 * @since DOM Level 2
	 */
	@GwtNodeFunction
	public final native void removeAttributeNS(String namespaceURI, String localName) throws JavaScriptException /*-{
		this.removeAttributeNS(namespaceURI, localName);
	}-*/;

	/**
	 * Retrieves an <code>Attr</code> node by local name and namespace URI. <br>
	 * Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>] , applications must use the
	 * value <code>null</code> as the <code>namespaceURI</code> parameter for methods if they wish to have no namespace.
	 * 
	 * @param namespaceURI
	 *          The namespace URI of the attribute to retrieve.
	 * @param localName
	 *          The local name of the attribute to retrieve.
	 * @return The <code>Attr</code> node with the specified attribute local name and namespace URI or <code>null</code>
	 *         if there is no such attribute.
	 * @exception JavaScriptException
	 *              NOT_SUPPORTED_ERR: May be raised if the implementation does not support the feature <code>"XML"</code>
	 *              and the language exposed through the Document does not support XML Namespaces (such as [<a
	 *              href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
	 * @since DOM Level 2
	 */
	@GwtNodeFunction
	public final native Attr getAttributeNodeNS(String namespaceURI, String localName) throws JavaScriptException /*-{
		return this.getAttributeNodeNS(namespaceURI, localName);
	}-*/;

	/**
	 * Adds a new attribute. If an attribute with that local name and that namespace URI is already present in the
	 * element, it is replaced by the new one. Replacing an attribute node by itself has no effect. <br>
	 * Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>] , applications must use the
	 * value <code>null</code> as the <code>namespaceURI</code> parameter for methods if they wish to have no namespace.
	 * 
	 * @param newAttr
	 *          The <code>Attr</code> node to add to the attribute list.
	 * @return If the <code>newAttr</code> attribute replaces an existing attribute with the same local name and namespace
	 *         URI, the replaced <code>Attr</code> node is returned, otherwise <code>null</code> is returned.
	 * @exception JavaScriptException
	 *              WRONG_DOCUMENT_ERR: Raised if <code>newAttr</code> was created from a different document than the one
	 *              that created the element. <br>
	 *              NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly. <br>
	 *              INUSE_ATTRIBUTE_ERR: Raised if <code>newAttr</code> is already an attribute of another
	 *              <code>Element</code> object. The DOM user must explicitly clone <code>Attr</code> nodes to re-use them
	 *              in other elements. <br>
	 *              NOT_SUPPORTED_ERR: May be raised if the implementation does not support the feature <code>"XML"</code>
	 *              and the language exposed through the Document does not support XML Namespaces (such as [<a
	 *              href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
	 * @since DOM Level 2
	 */
	@GwtNodeFunction
	public final native Attr setAttributeNodeNS(Attr newAttr) throws JavaScriptException /*-{
		return this.setAttributeNodeNS(newAttr);
	}-*/;

	/**
	 * Returns a <code>NodeList</code> of all the descendant <code>Elements</code> with a given local name and namespace
	 * URI in document order.
	 * 
	 * @param namespaceURI
	 *          The namespace URI of the elements to match on. The special value "*" matches all namespaces.
	 * @param localName
	 *          The local name of the elements to match on. The special value "*" matches all local names.
	 * @return A new <code>NodeList</code> object containing all the matched <code>Elements</code>.
	 * @exception JavaScriptException
	 *              NOT_SUPPORTED_ERR: May be raised if the implementation does not support the feature <code>"XML"</code>
	 *              and the language exposed through the Document does not support XML Namespaces (such as [<a
	 *              href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
	 * @since DOM Level 2
	 */
	@GwtNodeFunction
	public final native NodeList getElementsByTagNameNS(String namespaceURI, String localName)
			throws JavaScriptException /*-{
		return this.getElementsByTagNameNS(namespaceURI, localName);
	}-*/;

	/**
	 * Returns <code>true</code> when an attribute with a given name is specified on this element or has a default value,
	 * <code>false</code> otherwise.
	 * 
	 * @param name
	 *          The name of the attribute to look for.
	 * @return <code>true</code> if an attribute with the given name is specified on this element or has a default value,
	 *         <code>false</code> otherwise.
	 * @since DOM Level 2
	 */
	@GwtNodeFunction
	public final native boolean hasAttribute(String name) /*-{
		return this.hasAttribute(name);
	}-*/;

	/**
	 * Returns <code>true</code> when an attribute with a given local name and namespace URI is specified on this element
	 * or has a default value, <code>false</code> otherwise. <br>
	 * Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>] , applications must use the
	 * value <code>null</code> as the <code>namespaceURI</code> parameter for methods if they wish to have no namespace.
	 * 
	 * @param namespaceURI
	 *          The namespace URI of the attribute to look for.
	 * @param localName
	 *          The local name of the attribute to look for.
	 * @return <code>true</code> if an attribute with the given local name and namespace URI is specified or has a default
	 *         value on this element, <code>false</code> otherwise.
	 * @exception JavaScriptException
	 *              NOT_SUPPORTED_ERR: May be raised if the implementation does not support the feature <code>"XML"</code>
	 *              and the language exposed through the Document does not support XML Namespaces (such as [<a
	 *              href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
	 * @since DOM Level 2
	 */
	@GwtNodeFunction
	public final native boolean hasAttributeNS(String namespaceURI, String localName) throws JavaScriptException /*-{
		return this.hasAttributeNS(namespaceURI, localName);
	}-*/;
}
