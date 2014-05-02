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
import com.google.gwt.core.client.JavaScriptObject;

/**
 * <p>
 * The Node interface is the primary datatype for the entire Document Object Model. It represents a single node in the
 * document tree. While all objects implementing the Node interface expose methods for dealing with children, not all
 * objects implementing the Node interface may have children. For example, Text nodes may not have children, and adding
 * children to such nodes results in a DOMException being raised.
 * </p>
 * <p>
 * The attributes nodeName, nodeValue and attributes are included as a mechanism to get at node information without
 * casting down to the specific derived interface. In cases where there is no obvious mapping of these attributes for a
 * specific nodeType (e.g., nodeValue for an Element or attributes for a Comment), this returns null. Note that the
 * specialized interfaces may contain additional and more convenient mechanisms to get and set the relevant information.
 * </p>
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class Node extends JavaScriptObject {

	/**
	 * The node is an <code>Element</code>.
	 */
	public static final int ELEMENT_NODE = 1;
	/**
	 * The node is an <code>Attr</code>.
	 */
	public static final int ATTRIBUTE_NODE = 2;
	/**
	 * The node is a <code>Text</code> node.
	 */
	public static final int TEXT_NODE = 3;
	/**
	 * The node is a <code>CDATASection</code>.
	 */
	public static final int CDATA_SECTION_NODE = 4;
	/**
	 * The node is an <code>EntityReference</code>.
	 */
	public static final int ENTITY_REFERENCE_NODE = 5;
	/**
	 * The node is an <code>Entity</code>.
	 */
	public static final int ENTITY_NODE = 6;
	/**
	 * The node is a <code>ProcessingInstruction</code>.
	 */
	public static final int PROCESSING_INSTRUCTION_NODE = 7;
	/**
	 * The node is a <code>Comment</code>.
	 */
	public static final int COMMENT_NODE = 8;
	/**
	 * The node is a <code>Document</code>.
	 */
	public static final int DOCUMENT_NODE = 9;
	/**
	 * The node is a <code>DocumentType</code>.
	 */
	public static final int DOCUMENT_TYPE_NODE = 10;
	/**
	 * The node is a <code>DocumentFragment</code>.
	 */
	public static final int DOCUMENT_FRAGMENT_NODE = 11;
	/**
	 * The node is a <code>Notation</code>.
	 */
	public static final int NOTATION_NODE = 12;

	protected Node() {}

	/**
	 * The value of this node, depending on its type; see the table above. When it is defined to be <code>null</code>,
	 * setting it has no effect, including if the node is read-only.
	 * 
	 * @exception JavaScriptException
	 *              DOMSTRING_SIZE_ERR: Raised when it would return more characters than fit in a <code>DOMString</code>
	 *              variable on the implementation platform.
	 */
	@GwtNodeProperty
	public final native String nodeValue() throws JavaScriptException /*-{
		return this.nodeValue;
	}-*/;

	/**
	 * The value of this node, depending on its type; see the table above. When it is defined to be <code>null</code>,
	 * setting it has no effect, including if the node is read-only.
	 * 
	 * @exception JavaScriptException
	 *              NO_MODIFICATION_ALLOWED_ERR: Raised when the node is readonly and if it is not defined to be
	 *              <code>null</code>.
	 */
	@GwtNodeProperty
	public final native void nodeValue(String nodeValue) throws JavaScriptException /*-{
		this.nodeValue = nodeValue;
	}-*/;

	/**
	 * The namespace prefix of this node, or <code>null</code> if it is unspecified. When it is defined to be
	 * <code>null</code>, setting it has no effect, including if the node is read-only. <br>
	 * Note that setting this attribute, when permitted, changes the <code>nodeName</code> attribute, which holds the
	 * qualified name, as well as the <code>tagName</code> and <code>name</code> attributes of the <code>Element</code>
	 * and <code>Attr</code> interfaces, when applicable. <br>
	 * Setting the prefix to <code>null</code> makes it unspecified, setting it to an empty string is implementation
	 * dependent. <br>
	 * Note also that changing the prefix of an attribute that is known to have a default value, does not make a new
	 * attribute with the default value and the original prefix appear, since the <code>namespaceURI</code> and
	 * <code>localName</code> do not change. <br>
	 * For nodes of any type other than <code>ELEMENT_NODE</code> and <code>ATTRIBUTE_NODE</code> and nodes created with a
	 * DOM Level 1 method, such as <code>createElement</code> from the <code>Document</code> interface, this is always
	 * <code>null</code>.
	 * 
	 * @since DOM Level 2
	 */
	@GwtNodeProperty
	public final native String prefix() /*-{
		return this.prefix;
	}-*/;

	/**
	 * The namespace prefix of this node, or <code>null</code> if it is unspecified. When it is defined to be
	 * <code>null</code>, setting it has no effect, including if the node is read-only. <br>
	 * Note that setting this attribute, when permitted, changes the <code>nodeName</code> attribute, which holds the
	 * qualified name, as well as the <code>tagName</code> and <code>name</code> attributes of the <code>Element</code>
	 * and <code>Attr</code> interfaces, when applicable. <br>
	 * Setting the prefix to <code>null</code> makes it unspecified, setting it to an empty string is implementation
	 * dependent. <br>
	 * Note also that changing the prefix of an attribute that is known to have a default value, does not make a new
	 * attribute with the default value and the original prefix appear, since the <code>namespaceURI</code> and
	 * <code>localName</code> do not change. <br>
	 * For nodes of any type other than <code>ELEMENT_NODE</code> and <code>ATTRIBUTE_NODE</code> and nodes created with a
	 * DOM Level 1 method, such as <code>createElement</code> from the <code>Document</code> interface, this is always
	 * <code>null</code>.
	 * 
	 * @exception JavaScriptException
	 *              INVALID_CHARACTER_ERR: Raised if the specified prefix contains an illegal character according to the
	 *              XML version in use specified in the <code>Document.xmlVersion</code> attribute. <br>
	 *              NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly. <br>
	 *              NAMESPACE_ERR: Raised if the specified <code>prefix</code> is malformed per the Namespaces in XML
	 *              specification, if the <code>namespaceURI</code> of this node is <code>null</code>, if the specified
	 *              prefix is "xml" and the <code>namespaceURI</code> of this node is different from "<a
	 *              href='http://www.w3.org/XML/1998/namespace'>
	 *              http://www.w3.org/XML/1998/namespace</a>", if this node is an attribute and the specified prefix is "
	 *              xmlns" and the <code>namespaceURI</code> of this node is different from
	 *              "<a href='http://www.w3.org/2000/xmlns/'>http://www.w3.org/2000/xmlns/</a>", or if this node is an
	 *              attribute and the <code>qualifiedName</code> of this node is "xmlns" [<a
	 *              href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>] .
	 * 
	 * @since DOM Level 2
	 */
	@GwtNodeProperty
	public final native void prefix(String prefix) throws JavaScriptException /*-{
		this.prefix = prefix;
	}-*/;

  /**
   * The name of this node, depending on its type; see the table above.
   */
	@GwtNodeProperty
	public final native String nodeName() /*-{
		return this.nodeName;
	}-*/;

  /**
   * A code representing the type of the underlying object, as defined above.
   */
	@GwtNodeProperty
	public final native int nodeType() /*-{
		return this.nodeType;
	}-*/;

	/**
	 * The parent of this node. All nodes, except <code>Attr</code>, <code>Document</code>, <code>DocumentFragment</code>,
	 * <code>Entity</code>, and <code>Notation</code> may have a parent. However, if a node has just been created and not
	 * yet added to the tree, or if it has been removed from the tree, this is <code>null</code>.
	 */
	@GwtNodeProperty
	public final native Node parentNode() /*-{
		return this.parentNode;
	}-*/;

	/**
	 * A <code>NodeList</code> that contains all children of this node. If there are no children, this is a
	 * <code>NodeList</code> containing no nodes.
	 */
	@GwtNodeProperty
	public final native NodeList childNodes() /*-{
		return this.childNodes;
	}-*/;

	/**
	 * The first child of this node. If there is no such node, this returns <code>null</code>.
	 */
	@GwtNodeProperty
	public final native Node firstChild() /*-{
		return this.firstChild;
	}-*/;

	/**
	 * The last child of this node. If there is no such node, this returns <code>null</code>.
	 */
	@GwtNodeProperty
	public final native Node lastChild() /*-{
		return this.lastChild;
	}-*/;

	/**
	 * The node immediately preceding this node. If there is no such node, this returns <code>null</code>.
	 */
	@GwtNodeProperty
	public final native Node previousSibling() /*-{
		return this.previousSibling;
	}-*/;

	/**
	 * The node immediately following this node. If there is no such node, this returns <code>null</code>.
	 */
	@GwtNodeProperty
	public final native Node nextSibling() /*-{
		return this.nextSibling;
	}-*/;

	/**
	 * A <code>NamedNodeMap</code> containing the attributes of this node (if it is an <code>Element</code>) or
	 * <code>null</code> otherwise.
	 */
	@GwtNodeProperty
	public final native NamedNodeMap attributes() /*-{
		return this.attributes;
	}-*/;

	/**
	 * The <code>Document</code> object associated with this node. This is also the <code>Document</code> object used to
	 * create new nodes. When this node is a <code>Document</code> or a <code>DocumentType</code> which is not used with
	 * any <code>Document</code> yet, this is <code>null</code>.
	 * 
	 * @since DOM Level 2
	 */
	@GwtNodeProperty
	public final native Document ownerDocument() /*-{
		return this.ownerDocument;
	}-*/;

	/**
	 * The namespace URI of this node, or <code>null</code> if it is unspecified (see ). <br>
	 * This is not a computed value that is the result of a namespace lookup based on an examination of the namespace
	 * declarations in scope. It is merely the namespace URI given at creation time. <br>
	 * For nodes of any type other than <code>ELEMENT_NODE</code> and <code>ATTRIBUTE_NODE</code> and nodes created with a
	 * DOM Level 1 method, such as <code>Document.createElement()</code>, this is always <code>null</code>.
	 * <p >
	 * <b>Note:</b> Per the <em>Namespaces in XML</em> Specification [<a
	 * href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>] an attribute does not inherit its
	 * namespace from the element it is attached to. If an attribute is not explicitly given a namespace, it simply has no
	 * namespace.
	 * 
	 * @since DOM Level 2
	 */
	@GwtNodeProperty
	public final native String namespaceURI() /*-{
		return this.namespaceURI;
	}-*/;

	/**
	 * Returns the local part of the qualified name of this node. <br>
	 * For nodes of any type other than <code>ELEMENT_NODE</code> and <code>ATTRIBUTE_NODE</code> and nodes created with a
	 * DOM Level 1 method, such as <code>Document.createElement()</code>, this is always <code>null</code>.
	 * 
	 * @since DOM Level 2
	 */
	@GwtNodeProperty
	public final native String localName() /*-{
		return this.localName;
	}-*/;

	/**
	 * This attribute returns the text content of this node and its descendants. When it is defined to be
	 * <code>null</code>, setting it has no effect. On setting, any possible children this node may have are removed and,
	 * if it the new string is not empty or <code>null</code>, replaced by a single <code>Text</code> node containing the
	 * string this attribute is set to. <br>
	 * On getting, no serialization is performed, the returned string does not contain any markup. No whitespace
	 * normalization is performed and the returned string does not contain the white spaces in element content (see the
	 * attribute <code>Text.isElementContentWhitespace</code>). Similarly, on setting, no parsing is performed either, the
	 * input string is taken as pure textual content. <br>
	 * The string returned is made of the text content of this node depending on its type, as defined below:
	 * <table border='1' cellpadding='3'>
	 * <tr>
	 * <th>Node type</th>
	 * <th>Content</th>
	 * </tr>
	 * <tr>
	 * <td valign='top' rowspan='1' colspan='1'>
	 * ELEMENT_NODE, ATTRIBUTE_NODE, ENTITY_NODE, ENTITY_REFERENCE_NODE, DOCUMENT_FRAGMENT_NODE</td>
	 * <td valign='top' rowspan='1' colspan='1'>concatenation of the <code>textContent</code> attribute value of every
	 * child node, excluding COMMENT_NODE and PROCESSING_INSTRUCTION_NODE nodes. This is the empty string if the node has
	 * no children.</td>
	 * </tr>
	 * <tr>
	 * <td valign='top' rowspan='1' colspan='1'>TEXT_NODE, CDATA_SECTION_NODE, COMMENT_NODE, PROCESSING_INSTRUCTION_NODE</td>
	 * <td valign='top' rowspan='1' colspan='1'><code>nodeValue</code></td>
	 * </tr>
	 * <tr>
	 * <td valign='top' rowspan='1' colspan='1'>DOCUMENT_NODE, DOCUMENT_TYPE_NODE, NOTATION_NODE</td>
	 * <td valign='top' rowspan='1' colspan='1'><em>null</em></td>
	 * </tr>
	 * </table>
	 * 
	 * @exception JavaScriptException
	 *              DOMSTRING_SIZE_ERR: Raised when it would return more characters than fit in a <code>DOMString</code>
	 *              variable on the implementation platform.
	 * 
	 * @since DOM Level 3
	 */
	@GwtNodeProperty
	public final native String textContent() throws JavaScriptException /*-{
		return this.textContent;
	}-*/;

	/**
	 * This attribute returns the text content of this node and its descendants. When it is defined to be
	 * <code>null</code>, setting it has no effect. On setting, any possible children this node may have are removed and,
	 * if it the new string is not empty or <code>null</code>, replaced by a single <code>Text</code> node containing the
	 * string this attribute is set to. <br>
	 * On getting, no serialization is performed, the returned string does not contain any markup. No whitespace
	 * normalization is performed and the returned string does not contain the white spaces in element content (see the
	 * attribute <code>Text.isElementContentWhitespace</code>). Similarly, on setting, no parsing is performed either, the
	 * input string is taken as pure textual content. <br>
	 * The string returned is made of the text content of this node depending on its type, as defined below:
	 * <table border='1' cellpadding='3'>
	 * <tr>
	 * <th>Node type</th>
	 * <th>Content</th>
	 * </tr>
	 * <tr>
	 * <td valign='top' rowspan='1' colspan='1'>
	 * ELEMENT_NODE, ATTRIBUTE_NODE, ENTITY_NODE, ENTITY_REFERENCE_NODE, DOCUMENT_FRAGMENT_NODE</td>
	 * <td valign='top' rowspan='1' colspan='1'>concatenation of the <code>textContent</code> attribute value of every
	 * child node, excluding COMMENT_NODE and PROCESSING_INSTRUCTION_NODE nodes. This is the empty string if the node has
	 * no children.</td>
	 * </tr>
	 * <tr>
	 * <td valign='top' rowspan='1' colspan='1'>TEXT_NODE, CDATA_SECTION_NODE, COMMENT_NODE, PROCESSING_INSTRUCTION_NODE</td>
	 * <td valign='top' rowspan='1' colspan='1'><code>nodeValue</code></td>
	 * </tr>
	 * <tr>
	 * <td valign='top' rowspan='1' colspan='1'>DOCUMENT_NODE, DOCUMENT_TYPE_NODE, NOTATION_NODE</td>
	 * <td valign='top' rowspan='1' colspan='1'><em>null</em></td>
	 * </tr>
	 * </table>
	 * 
	 * @exception JavaScriptException
	 *              NO_MODIFICATION_ALLOWED_ERR: Raised when the node is readonly.
	 * 
	 * @since DOM Level 3
	 */
	@GwtNodeProperty
	public final native void textContent(String textContent) throws JavaScriptException /*-{
		this.textContent = textContent;
	}-*/;

	/**
	 * Numbered starting from '1' 
	 */
	@GwtNodeProperty
	public final native int lineNumber() /*-{
		return this.lineNumber;
	}-*/;
	
	/**
	 * Numbered starting from '1' 
	 */
	@GwtNodeProperty
	public final native int columnNumber() /*-{
		return this.columnNumber;
	}-*/;
	
	/**
	 * Inserts the node <code>newChild</code> before the existing child node <code>refChild</code>. If
	 * <code>refChild</code> is <code>null</code>, insert <code>newChild</code> at the end of the list of children. <br>
	 * If <code>newChild</code> is a <code>DocumentFragment</code> object, all of its children are inserted, in the same
	 * order, before <code>refChild</code>. If the <code>newChild</code> is already in the tree, it is first removed.
	 * <p >
	 * <b>Note:</b> Inserting a node before itself is implementation dependent.
	 * 
	 * @param newChild
	 *          The node to insert.
	 * @param refChild
	 *          The reference node, i.e., the node before which the new node must be inserted.
	 * @return The node being inserted.
	 * @exception JavaScriptException
	 *              HIERARCHY_REQUEST_ERR: Raised if this node is of a type that does not allow children of the type of
	 *              the <code>newChild</code> node, or if the node to insert is one of this node's ancestors or this node
	 *              itself, or if this node is of type <code>Document</code> and the DOM application attempts to insert a
	 *              second <code>DocumentType</code> or <code>Element</code> node. <br>
	 *              WRONG_DOCUMENT_ERR: Raised if <code>newChild</code> was created from a different document than the one
	 *              that created this node. <br>
	 *              NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly or if the parent of the node being
	 *              inserted is readonly. <br>
	 *              NOT_FOUND_ERR: Raised if <code>refChild</code> is not a child of this node. <br>
	 *              NOT_SUPPORTED_ERR: if this node is of type <code>Document</code>, this exception might be raised if
	 *              the DOM implementation doesn't support the insertion of a <code>DocumentType</code> or
	 *              <code>Element</code> node.
	 * 
	 * @since DOM Level 3
	 */
	@GwtNodeFunction
	public final native Node insertBefore(Node newChild, Node refChild) throws JavaScriptException /*-{
		return this.insertBefore(newChild, refChild);
	}-*/;

	/**
	 * Replaces the child node <code>oldChild</code> with <code>newChild</code> in the list of children, and returns the
	 * <code>oldChild</code> node. <br>
	 * If <code>newChild</code> is a <code>DocumentFragment</code> object, <code>oldChild</code> is replaced by all of the
	 * <code>DocumentFragment</code> children, which are inserted in the same order. If the <code>newChild</code> is
	 * already in the tree, it is first removed.
	 * <p >
	 * <b>Note:</b> Replacing a node with itself is implementation dependent.
	 * 
	 * @param newChild
	 *          The new node to put in the child list.
	 * @param oldChild
	 *          The node being replaced in the list.
	 * @return The node replaced.
	 * @exception JavaScriptException
	 *              HIERARCHY_REQUEST_ERR: Raised if this node is of a type that does not allow children of the type of
	 *              the <code>newChild</code> node, or if the node to put in is one of this node's ancestors or this node
	 *              itself, or if this node is of type <code>Document</code> and the result of the replacement operation
	 *              would add a second <code>DocumentType</code> or <code>Element</code> on the <code>Document</code>
	 *              node. <br>
	 *              WRONG_DOCUMENT_ERR: Raised if <code>newChild</code> was created from a different document than the one
	 *              that created this node. <br>
	 *              NO_MODIFICATION_ALLOWED_ERR: Raised if this node or the parent of the new node is readonly. <br>
	 *              NOT_FOUND_ERR: Raised if <code>oldChild</code> is not a child of this node. <br>
	 *              NOT_SUPPORTED_ERR: if this node is of type <code>Document</code>, this exception might be raised if
	 *              the DOM implementation doesn't support the replacement of the <code>DocumentType</code> child or
	 *              <code>Element</code> child.
	 * 
	 * @since DOM Level 3
	 */
	@GwtNodeFunction
	public final native Node replaceChild(Node newChild, Node oldChild) throws JavaScriptException /*-{
		return this.replaceChild(newChild, oldChild);
	}-*/;

	/**
	 * Removes the child node indicated by <code>oldChild</code> from the list of children, and returns it.
	 * 
	 * @param oldChild
	 *          The node being removed.
	 * @return The node removed.
	 * @exception JavaScriptException
	 *              NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly. <br>
	 *              NOT_FOUND_ERR: Raised if <code>oldChild</code> is not a child of this node. <br>
	 *              NOT_SUPPORTED_ERR: if this node is of type <code>Document</code>, this exception might be raised if
	 *              the DOM implementation doesn't support the removal of the <code>DocumentType</code> child or the
	 *              <code>Element</code> child.
	 * 
	 * @since DOM Level 3
	 */
	@GwtNodeFunction
	public final native Node removeChild(Node oldChild) throws JavaScriptException /*-{
		return this.removeChild(oldChild);
	}-*/;

	/**
	 * Adds the node <code>newChild</code> to the end of the list of children of this node. If the <code>newChild</code>
	 * is already in the tree, it is first removed.
	 * 
	 * @param newChild
	 *          The node to add.If it is a <code>DocumentFragment</code> object, the entire contents of the document
	 *          fragment are moved into the child list of this node
	 * @return The node added.
	 * @exception JavaScriptException
	 *              HIERARCHY_REQUEST_ERR: Raised if this node is of a type that does not allow children of the type of
	 *              the <code>newChild</code> node, or if the node to append is one of this node's ancestors or this node
	 *              itself, or if this node is of type <code>Document</code> and the DOM application attempts to append a
	 *              second <code>DocumentType</code> or <code>Element</code> node. <br>
	 *              WRONG_DOCUMENT_ERR: Raised if <code>newChild</code> was created from a different document than the one
	 *              that created this node. <br>
	 *              NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly or if the previous parent of the node
	 *              being inserted is readonly. <br>
	 *              NOT_SUPPORTED_ERR: if the <code>newChild</code> node is a child of the <code>Document</code> node,
	 *              this exception might be raised if the DOM implementation doesn't support the removal of the
	 *              <code>DocumentType</code> child or <code>Element</code> child.
	 * 
	 * @since DOM Level 3
	 */
	@GwtNodeFunction
	public final native Node appendChild(Node newChild) throws JavaScriptException /*-{
		return this.appendChild(newChild);
	}-*/;

	/**
	 * Returns whether this node has any children.
	 * 
	 * @return Returns <code>true</code> if this node has any children, <code>false</code> otherwise.
	 */
	@GwtNodeFunction
	public final native boolean hasChildNodes() /*-{
		return this.hasChildNodes();
	}-*/;

	/**
	 * Returns a duplicate of this node, i.e., serves as a generic copy constructor for nodes. The duplicate node has no
	 * parent ( <code>parentNode</code> is <code>null</code>) and no user data. User data associated to the imported node
	 * is not carried over. However, if any <code>UserDataHandlers</code> has been specified along with the associated
	 * data these handlers will be called with the appropriate parameters before this method returns. <br>
	 * Cloning an <code>Element</code> copies all attributes and their values, including those generated by the XML
	 * processor to represent defaulted attributes, but this method does not copy any children it contains unless it is a
	 * deep clone. This includes text contained in an the <code>Element</code> since the text is contained in a child
	 * <code>Text</code> node. Cloning an <code>Attr</code> directly, as opposed to be cloned as part of an
	 * <code>Element</code> cloning operation, returns a specified attribute (<code>specified</code> is <code>true</code>
	 * ). Cloning an <code>Attr</code> always clones its children, since they represent its value, no matter whether this
	 * is a deep clone or not. Cloning an <code>EntityReference</code> automatically constructs its subtree if a
	 * corresponding <code>Entity</code> is available, no matter whether this is a deep clone or not. Cloning any other
	 * type of node simply returns a copy of this node. <br>
	 * Note that cloning an immutable subtree results in a mutable copy, but the children of an
	 * <code>EntityReference</code> clone are readonly . In addition, clones of unspecified <code>Attr</code> nodes are
	 * specified. And, cloning <code>Document</code>, <code>DocumentType</code>, <code>Entity</code>, and
	 * <code>Notation</code> nodes is implementation dependent.
	 * 
	 * @param deep
	 *          If <code>true</code>, recursively clone the subtree under the specified node; if <code>false</code>, clone
	 *          only the node itself (and its attributes, if it is an <code>Element</code>).
	 * @return The duplicate node.
	 */
	@GwtNodeFunction
	public final native Node cloneNode(boolean deep) /*-{
		return this.cloneNode(deep);
	}-*/;

	/**
	 * Puts all <code>Text</code> nodes in the full depth of the sub-tree underneath this <code>Node</code>, including
	 * attribute nodes, into a "normal" form where only structure (e.g., elements, comments, processing instructions,
	 * CDATA sections, and entity references) separates <code>Text</code> nodes, i.e., there are neither adjacent
	 * <code>Text</code> nodes nor empty <code>Text</code> nodes. This can be used to ensure that the DOM view of a
	 * document is the same as if it were saved and re-loaded, and is useful when operations (such as XPointer [<a
	 * href='http://www.w3.org/TR/2003/REC-xptr-framework-20030325/'>XPointer</a>] lookups) that depend on a particular
	 * document tree structure are to be used. If the parameter "normalize-characters" of the
	 * <code>DOMConfiguration</code> object attached to the <code>Node.ownerDocument</code> is <code>true</code>, this
	 * method will also fully normalize the characters of the <code>Text</code> nodes.
	 * <p >
	 * <b>Note:</b> In cases where the document contains <code>CDATASections</code>, the normalize operation alone may not
	 * be sufficient, since XPointers do not differentiate between <code>Text</code> nodes and <code>CDATASection</code>
	 * nodes.
	 * 
	 * @since DOM Level 3
	 */
	@GwtNodeFunction
	public final native void normalize() /*-{
		this.normalize();
	}-*/;

	/**
	 * Tests whether the DOM implementation implements a specific feature and that feature is supported by this node, as
	 * specified in.
	 * 
	 * @param feature
	 *          The name of the feature to test.
	 * @param version
	 *          This is the version number of the feature to test.
	 * @return Returns <code>true</code> if the specified feature is supported on this node, <code>false</code> otherwise.
	 * 
	 * @since DOM Level 2
	 */
	@GwtNodeFunction
	public final native boolean isSupported(String feature, String version) /*-{
		return this.isSupported(feature, version);
	}-*/;

	/**
	 * Returns whether this node (if it is an element) has any attributes.
	 * 
	 * @return Returns <code>true</code> if this node has any attributes, <code>false</code> otherwise.
	 * 
	 * @since DOM Level 2
	 */
	@GwtNodeFunction
	public final native boolean hasAttributes() /*-{
		return this.hasAttributes();
	}-*/;

	/**
	 * This method checks if the specified <code>namespaceURI</code> is the default namespace or not.
	 * 
	 * @param namespaceURI
	 *          The namespace URI to look for.
	 * @return Returns <code>true</code> if the specified <code>namespaceURI</code> is the default namespace,
	 *         <code>false</code> otherwise.
	 * 
	 * @since DOM Level 3
	 */
	@GwtNodeFunction
	public final native boolean isDefaultNamespace(String namespaceURI) /*-{
		return this.isDefaultNamespace(namespaceURI);
	}-*/;

	/**
	 * Look up the namespace URI associated to the given prefix, starting from this node. <br>
	 * See for details on the algorithm used by this method.
	 * 
	 * @param prefix
	 *          The prefix to look for. If this parameter is <code>null</code>, the method will return the default
	 *          namespace URI if any.
	 * @return Returns the associated namespace URI or <code>null</code> if none is found.
	 * 
	 * @since DOM Level 3
	 */
	@GwtNodeFunction
	public final native String lookupNamespaceURI(String prefix) /*-{
		return this.lookupNamespaceURI(prefix);
	}-*/;
}
