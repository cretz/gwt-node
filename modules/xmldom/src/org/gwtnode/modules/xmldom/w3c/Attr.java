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

import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.meta.GwtNodeProperty;

import com.google.gwt.core.client.JavaScriptException;

/**
 * The <code>Attr</code> interface represents an attribute in an <code>Element</code> object. Typically the allowable
 * values for the attribute are defined in a schema associated with the document.
 * <p>
 * <code>Attr</code> objects inherit the <code>Node</code> interface, but since they are not actually child nodes of the
 * element they describe, the DOM does not consider them part of the document tree. Thus, the <code>Node</code>
 * attributes <code>parentNode</code>, <code>previousSibling</code>, and <code>nextSibling</code> have a
 * <code>null</code> value for <code>Attr</code> objects. The DOM takes the view that attributes are properties of
 * elements rather than having a separate identity from the elements they are associated with; this should make it more
 * efficient to implement such features as default attributes associated with all elements of a given type. Furthermore,
 * <code>Attr</code> nodes may not be immediate children of a <code>DocumentFragment</code>. However, they can be
 * associated with <code>Element</code> nodes contained within a <code>DocumentFragment</code>. In short, users and
 * implementors of the DOM need to be aware that <code>Attr</code> nodes have some things in common with other objects
 * inheriting the <code>Node</code> interface, but they also are quite distinct.
 * <p>
 * The attribute's effective value is determined as follows: if this attribute has been explicitly assigned any value,
 * that value is the attribute's effective value; otherwise, if there is a declaration for this attribute, and that
 * declaration includes a default value, then that default value is the attribute's effective value; otherwise, the
 * attribute does not exist on this element in the structure model until it has been explicitly added. Note that the
 * <code>Node.nodeValue</code> attribute on the <code>Attr</code> instance can also be used to retrieve the string
 * version of the attribute's value(s).
 * <p>
 * If the attribute was not explicitly given a value in the instance document but has a default value provided by the
 * schema associated with the document, an attribute node will be created with <code>specified</code> set to
 * <code>false</code>. Removing attribute nodes for which a default value is defined in the schema generates a new
 * attribute node with the default value and <code>specified</code> set to <code>false</code>. If validation occurred
 * while invoking <code>Document.normalizeDocument()</code>, attribute nodes with <code>specified</code> equals to
 * <code>false</code> are recomputed according to the default attribute values provided by the schema. If no default
 * value is associate with this attribute in the schema, the attribute node is discarded.
 * <p>
 * In XML, where the value of an attribute can contain entity references, the child nodes of the <code>Attr</code> node
 * may be either <code>Text</code> or <code>EntityReference</code> nodes (when these are in use; see the description of
 * <code>EntityReference</code> for discussion).
 * <p>
 * The DOM Core represents all attribute values as simple strings, even if the DTD or schema associated with the
 * document declares them of some specific type such as tokenized.
 * <p>
 * The way attribute value normalization is performed by the DOM implementation depends on how much the implementation
 * knows about the schema in use. Typically, the <code>value</code> and <code>nodeValue</code> attributes of an
 * <code>Attr</code> node initially returns the normalized value given by the parser. It is also the case after
 * <code>Document.normalizeDocument()</code> is called (assuming the right options have been set). But this may not be
 * the case after mutation, independently of whether the mutation is performed by setting the string value directly or
 * by changing the <code>Attr</code> child nodes. In particular, this is true when <a
 * href='http://www.w3.org/TR/2004/REC-xml-20040204#dt-charref'>character references</a> are involved, given that they
 * are not represented in the DOM and they impact attribute value normalization. On the other hand, if the
 * implementation knows about the schema in use when the attribute value is changed, and it is of a different type than
 * CDATA, it may normalize it again at that time. This is especially true of specialized DOM implementations, such as
 * SVG DOM implementations, which store attribute values in an internal form different from a string.
 * <p>
 * The following table gives some examples of the relations between the attribute value in the original document (parsed
 * attribute), the value as exposed in the DOM, and the serialization of the value:
 * <table border='1' cellpadding='3'>
 * <tr>
 * <th>Examples</th>
 * <th>Parsed attribute value</th>
 * <th>Initial <code>Attr.value</code></th>
 * <th>Serialized attribute value</th>
 * </tr>
 * <tr>
 * <td valign='top' rowspan='1' colspan='1'>
 * Character reference</td>
 * <td valign='top' rowspan='1' colspan='1'>
 * 
 * <pre>
 * &quot;x&amp;#178;=5&quot;
 * </pre>
 * 
 * </td>
 * <td valign='top' rowspan='1' colspan='1'>
 * 
 * <pre>
 * &quot;x\u00b2=5&quot;
 * </pre>
 * 
 * </td>
 * <td valign='top' rowspan='1' colspan='1'>
 * 
 * <pre>
 * &quot;x&amp;#178;=5&quot;
 * </pre>
 * 
 * </td>
 * </tr>
 * <tr>
 * <td valign='top' rowspan='1' colspan='1'>Built-in character entity</td>
 * <td valign='top' rowspan='1' colspan='1'>
 * 
 * <pre>
 * &quot;y&amp;lt;6&quot;
 * </pre>
 * 
 * </td>
 * <td valign='top' rowspan='1' colspan='1'>
 * 
 * <pre>
 * &quot;y&lt;6&quot;
 * </pre>
 * 
 * </td>
 * <td valign='top' rowspan='1' colspan='1'>
 * 
 * <pre>
 * &quot;y&amp;lt;6&quot;
 * </pre>
 * 
 * </td>
 * </tr>
 * <tr>
 * <td valign='top' rowspan='1' colspan='1'>Literal newline between</td>
 * <td valign='top' rowspan='1' colspan='1'>
 * 
 * <pre>
 * &quot;x=5&amp;#10;y=6&quot;
 * </pre>
 * 
 * </td>
 * <td valign='top' rowspan='1' colspan='1'>
 * 
 * <pre>
 * &quot;x=5 y=6&quot;
 * </pre>
 * 
 * </td>
 * <td valign='top' rowspan='1' colspan='1'>
 * 
 * <pre>
 * &quot;x=5&amp;#10;y=6&quot;
 * </pre>
 * 
 * </td>
 * </tr>
 * <tr>
 * <td valign='top' rowspan='1' colspan='1'>Normalized newline between</td>
 * <td valign='top' rowspan='1' colspan='1'>
 * 
 * <pre>
 * "x=5 
 * y=6"
 * </pre>
 * 
 * </td>
 * <td valign='top' rowspan='1' colspan='1'>
 * 
 * <pre>
 * &quot;x=5 y=6&quot;
 * </pre>
 * 
 * </td>
 * <td valign='top' rowspan='1' colspan='1'>
 * 
 * <pre>
 * &quot;x=5 y=6&quot;
 * </pre>
 * 
 * </td>
 * </tr>
 * <tr>
 * <td valign='top' rowspan='1' colspan='1'>Entity <code>e</code> with literal newline</td>
 * <td valign='top' rowspan='1' colspan='1'>
 * 
 * <pre>
 * &lt;!ENTITY e '...&amp;#10;...'&gt; [...]&gt; "x=5&amp;e;y=6"
 * </pre>
 * 
 * </td>
 * <td valign='top' rowspan='1' colspan='1'><em>Dependent on Implementation and Load Options</em></td>
 * <td valign='top' rowspan='1' colspan='1'><em>Dependent on Implementation and Load/Save Options</em></td>
 * </tr>
 * </table>
 * <p>
 * See also the <a href='http://www.w3.org/TR/2004/REC-DOM-Level-3-Core-20040407'>Document Object Model (DOM) Level 3
 * Core Specification</a>.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class Attr extends Node {

	protected Attr() {}

	/**
	 * On retrieval, the value of the attribute is returned as a string. Character and general entity references are
	 * replaced with their values. See also the method <code>getAttribute</code> on the <code>Element</code> interface. <br>
	 * On setting, this creates a <code>Text</code> node with the unparsed contents of the string, i.e. any characters
	 * that an XML processor would recognize as markup are instead treated as literal text. See also the method
	 * <code>Element.setAttribute()</code>. <br>
	 * Some specialized implementations, such as some [<a href='http://www.w3.org/TR/2003/REC-SVG11-20030114/'>SVG
	 * 1.1</a>] implementations, may do normalization automatically, even after mutation; in such case, the value on
	 * retrieval may differ from the value on setting.
	 */
	@GwtNodeProperty
	public final native String value() /*-{
		return this.value;
	}-*/;

	/**
	 * On retrieval, the value of the attribute is returned as a string. Character and general entity references are
	 * replaced with their values. See also the method <code>getAttribute</code> on the <code>Element</code> interface. <br>
	 * On setting, this creates a <code>Text</code> node with the unparsed contents of the string, i.e. any characters
	 * that an XML processor would recognize as markup are instead treated as literal text. See also the method
	 * <code>Element.setAttribute()</code>. <br>
	 * Some specialized implementations, such as some [<a href='http://www.w3.org/TR/2003/REC-SVG11-20030114/'>SVG
	 * 1.1</a>] implementations, may do normalization automatically, even after mutation; in such case, the value on
	 * retrieval may differ from the value on setting.
	 * 
	 * @exception JavaScriptException
	 *              NO_MODIFICATION_ALLOWED_ERR: Raised when the node is readonly.
	 */
	@GwtNodeProperty
	public final native void value(String value) throws JavaScriptException /*-{
		this.value = value;
	}-*/;

	/**
	 * Returns the name of this attribute. If <code>Node.localName</code> is different from <code>null</code>, this
	 * attribute is a qualified name.
	 */
	@GwtNodeProperty
	public final native String name() /*-{
		return this.name;
	}-*/;

	/**
	 * <code>True</code> if this attribute was explicitly given a value in the instance document, <code>false</code>
	 * otherwise. If the application changed the value of this attribute node (even if it ends up having the same value as
	 * the default value) then it is set to <code>true</code>. The implementation may handle attributes with default
	 * values from other schemas similarly but applications should use <code>Document.normalizeDocument()</code> to
	 * guarantee this information is up-to-date.
	 */
	@GwtNodeProperty
	public final native boolean specified() /*-{
		return this.specified;
	}-*/;

	/**
	 * The <code>Element</code> node this attribute is attached to or <code>null</code> if this attribute is not in use.
	 * 
	 * @since DOM Level 2
	 */
	@GwtNodeProperty
	public final native Element ownerElement() /*-{
		return this.ownerElement;
	}-*/;
}
