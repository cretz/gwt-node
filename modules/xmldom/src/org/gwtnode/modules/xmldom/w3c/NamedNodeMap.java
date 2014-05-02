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

/**
 * Objects implementing the <code>NamedNodeMap</code> interface are used to represent collections of nodes that can be
 * accessed by name. Note that <code>NamedNodeMap</code> does not inherit from <code>NodeList</code>;
 * <code>NamedNodeMaps</code> are not maintained in any particular order. Objects contained in an object implementing
 * <code>NamedNodeMap</code> may also be accessed by an ordinal index, but this is simply to allow convenient
 * enumeration of the contents of a <code>NamedNodeMap</code>, and does not imply that the DOM specifies an order to
 * these Nodes.
 * <p>
 * <code>NamedNodeMap</code> objects in the DOM are live.
 * <p>
 * See also the <a href='http://www.w3.org/TR/2004/REC-DOM-Level-3-Core-20040407'>Document Object Model (DOM) Level 3
 * Core Specification</a>.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class NamedNodeMap extends NodeList {

	protected NamedNodeMap() {}

	/**
	 * Retrieves a node specified by name.
	 * 
	 * @param name
	 *          The <code>nodeName</code> of a node to retrieve.
	 * @return A <code>Node</code> (of any type) with the specified <code>nodeName</code>, or <code>null</code> if it does
	 *         not identify any node in this map.
	 */
	@GwtNodeFunction
	public final native Node getNamedItem(String name) /*-{
		return this.getNamedItem(name);
	}-*/;

	/**
	 * Adds a node using its <code>nodeName</code> attribute. If a node with that name is already present in this map, it
	 * is replaced by the new one. Replacing a node by itself has no effect. <br>
	 * As the <code>nodeName</code> attribute is used to derive the name which the node must be stored under, multiple
	 * nodes of certain types (those that have a "special" string value) cannot be stored as the names would clash. This
	 * is seen as preferable to allowing nodes to be aliased.
	 * 
	 * @param arg
	 *          A node to store in this map. The node will later be accessible using the value of its
	 *          <code>nodeName</code> attribute.
	 * @return If the new <code>Node</code> replaces an existing node the replaced <code>Node</code> is returned,
	 *         otherwise <code>null</code> is returned.
	 * @exception JavaScriptException
	 *              WRONG_DOCUMENT_ERR: Raised if <code>arg</code> was created from a different document than the one that
	 *              created this map. <br>
	 *              NO_MODIFICATION_ALLOWED_ERR: Raised if this map is readonly. <br>
	 *              INUSE_ATTRIBUTE_ERR: Raised if <code>arg</code> is an <code>Attr</code> that is already an attribute
	 *              of another <code>Element</code> object. The DOM user must explicitly clone <code>Attr</code> nodes to
	 *              re-use them in other elements. <br>
	 *              HIERARCHY_REQUEST_ERR: Raised if an attempt is made to add a node doesn't belong in this NamedNodeMap.
	 *              Examples would include trying to insert something other than an Attr node into an Element's map of
	 *              attributes, or a non-Entity node into the DocumentType's map of Entities.
	 */
	@GwtNodeFunction
	public final native Node setNamedItem(Node arg) throws JavaScriptException /*-{
		return this.setNamedItem(arg);
	}-*/;

	/**
	 * Removes a node specified by name. When this map contains the attributes attached to an element, if the removed
	 * attribute is known to have a default value, an attribute immediately appears containing the default value as well
	 * as the corresponding namespace URI, local name, and prefix when applicable.
	 * 
	 * @param name
	 *          The <code>nodeName</code> of the node to remove.
	 * @return The node removed from this map if a node with such a name exists.
	 * @exception JavaScriptException
	 *              NOT_FOUND_ERR: Raised if there is no node named <code>name</code> in this map. <br>
	 *              NO_MODIFICATION_ALLOWED_ERR: Raised if this map is readonly.
	 */
	@GwtNodeFunction
	public final native Node removeNamedItem(String name) throws JavaScriptException /*-{
		return this.removeNamedItem(name);
	}-*/;

	/**
	 * Retrieves a node specified by local name and namespace URI. <br>
	 * Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>] , applications must use the
	 * value null as the namespaceURI parameter for methods if they wish to have no namespace.
	 * 
	 * @param namespaceURI
	 *          The namespace URI of the node to retrieve.
	 * @param localName
	 *          The local name of the node to retrieve.
	 * @return A <code>Node</code> (of any type) with the specified local name and namespace URI, or <code>null</code> if
	 *         they do not identify any node in this map.
	 * @exception JavaScriptException
	 *              NOT_SUPPORTED_ERR: May be raised if the implementation does not support the feature "XML" and the
	 *              language exposed through the Document does not support XML Namespaces (such as [<a
	 *              href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
	 * @since DOM Level 2
	 */
	@GwtNodeFunction
	public final native Node getNamedItemNS(String namespaceURI, String localName) throws JavaScriptException /*-{
		return this.getNamedItemNS(namespaceURI, localName);
	}-*/;

	/**
	 * Adds a node using its <code>namespaceURI</code> and <code>localName</code>. If a node with that namespace URI and
	 * that local name is already present in this map, it is replaced by the new one. Replacing a node by itself has no
	 * effect. <br>
	 * Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>] , applications must use the
	 * value null as the namespaceURI parameter for methods if they wish to have no namespace.
	 * 
	 * @param arg
	 *          A node to store in this map. The node will later be accessible using the value of its
	 *          <code>namespaceURI</code> and <code>localName</code> attributes.
	 * @return If the new <code>Node</code> replaces an existing node the replaced <code>Node</code> is returned,
	 *         otherwise <code>null</code> is returned.
	 * @exception JavaScriptException
	 *              WRONG_DOCUMENT_ERR: Raised if <code>arg</code> was created from a different document than the one that
	 *              created this map. <br>
	 *              NO_MODIFICATION_ALLOWED_ERR: Raised if this map is readonly. <br>
	 *              INUSE_ATTRIBUTE_ERR: Raised if <code>arg</code> is an <code>Attr</code> that is already an attribute
	 *              of another <code>Element</code> object. The DOM user must explicitly clone <code>Attr</code> nodes to
	 *              re-use them in other elements. <br>
	 *              HIERARCHY_REQUEST_ERR: Raised if an attempt is made to add a node doesn't belong in this NamedNodeMap.
	 *              Examples would include trying to insert something other than an Attr node into an Element's map of
	 *              attributes, or a non-Entity node into the DocumentType's map of Entities. <br>
	 *              NOT_SUPPORTED_ERR: May be raised if the implementation does not support the feature "XML" and the
	 *              language exposed through the Document does not support XML Namespaces (such as [<a
	 *              href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
	 * @since DOM Level 2
	 */
	@GwtNodeFunction
	public final native Node setNamedItemNS(Node arg) throws JavaScriptException /*-{
		return this.setNamedItemNS(arg);
	}-*/;

	/**
	 * Removes a node specified by local name and namespace URI. A removed attribute may be known to have a default value
	 * when this map contains the attributes attached to an element, as returned by the attributes attribute of the
	 * <code>Node</code> interface. If so, an attribute immediately appears containing the default value as well as the
	 * corresponding namespace URI, local name, and prefix when applicable. <br>
	 * Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>] , applications must use the
	 * value null as the namespaceURI parameter for methods if they wish to have no namespace.
	 * 
	 * @param namespaceURI
	 *          The namespace URI of the node to remove.
	 * @param localName
	 *          The local name of the node to remove.
	 * @return The node removed from this map if a node with such a local name and namespace URI exists.
	 * @exception JavaScriptException
	 *              NOT_FOUND_ERR: Raised if there is no node with the specified <code>namespaceURI</code> and
	 *              <code>localName</code> in this map. <br>
	 *              NO_MODIFICATION_ALLOWED_ERR: Raised if this map is readonly. <br>
	 *              NOT_SUPPORTED_ERR: May be raised if the implementation does not support the feature "XML" and the
	 *              language exposed through the Document does not support XML Namespaces (such as [<a
	 *              href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
	 * @since DOM Level 2
	 */
	@GwtNodeFunction
	public final native Node removeNamedItemNS(String namespaceURI, String localName) throws JavaScriptException /*-{
		return this.removeNamedItemNS(namespaceURI, localName);
	}-*/;
}
