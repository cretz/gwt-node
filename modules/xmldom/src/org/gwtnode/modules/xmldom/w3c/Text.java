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
 * The <code>Text</code> interface inherits from <code>CharacterData</code> and represents the textual content (termed
 * <a href='http://www.w3.org/TR/2004/REC-xml-20040204#syntax'>character data</a> in XML) of an <code>Element</code> or
 * <code>Attr</code>. If there is no markup inside an element's content, the text is contained in a single object
 * implementing the <code>Text</code> interface that is the only child of the element. If there is markup, it is parsed
 * into the information items (elements, comments, etc.) and <code>Text</code> nodes that form the list of children of
 * the element.
 * <p>
 * When a document is first made available via the DOM, there is only one <code>Text</code> node for each block of text.
 * Users may create adjacent <code>Text</code> nodes that represent the contents of a given element without any
 * intervening markup, but should be aware that there is no way to represent the separations between these nodes in XML
 * or HTML, so they will not (in general) persist between DOM editing sessions. The <code>Node.normalize()</code> method
 * merges any such adjacent <code>Text</code> objects into a single node for each block of text.
 * <p>
 * No lexical check is done on the content of a <code>Text</code> node and, depending on its position in the document,
 * some characters must be escaped during serialization using character references; e.g. the characters "&lt;&amp;" if
 * the textual content is part of an element or of an attribute, the character sequence "]]&gt;" when part of an
 * element, the quotation mark character " or the apostrophe character ' when part of an attribute.
 * <p>
 * See also the <a href='http://www.w3.org/TR/2004/REC-DOM-Level-3-Core-20040407'>Document Object Model (DOM) Level 3
 * Core Specification</a>.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 * 
 */
@GwtNodeObject
public class Text extends CharacterData {

	protected Text() {}

	/**
	 * Breaks this node into two nodes at the specified <code>offset</code>, keeping both in the tree as siblings. After
	 * being split, this node will contain all the content up to the <code>offset</code> point. A new node of the same
	 * type, which contains all the content at and after the <code>offset</code> point, is returned. If the original node
	 * had a parent node, the new node is inserted as the next sibling of the original node. When the <code>offset</code>
	 * is equal to the length of this node, the new node has no data.
	 * 
	 * @param offset
	 *          The 16-bit unit offset at which to split, starting from <code>0</code>.
	 * @return The new node, of the same type as this node.
	 * @exception JavaScriptException
	 *              INDEX_SIZE_ERR: Raised if the specified offset is negative or greater than the number of 16-bit units
	 *              in <code>data</code>. <br>
	 *              NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
	 */
	@GwtNodeFunction
	public final native Text splitText(int offset) throws JavaScriptException /*-{
		return this.splitText(offset);
	}-*/;
}
