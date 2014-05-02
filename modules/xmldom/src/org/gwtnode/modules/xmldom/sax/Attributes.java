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
package org.gwtnode.modules.xmldom.sax;

import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.meta.GwtNodeProperty;

import com.google.gwt.core.client.JavaScriptObject;

@GwtNodeObject
public class Attributes extends JavaScriptObject {

	protected Attributes() {}

	/**
	 * Return the number of attributes in the list.
	 * 
	 * <p>
	 * Once you know the number of attributes, you can iterate through the list.
	 * </p>
	 * 
	 * @return The number of attributes in the list.
	 * @see #getURI(int)
	 * @see #getLocalName(int)
	 * @see #getQName(int)
	 * @see #getType(int)
	 * @see #getValue(int)
	 */
	@GwtNodeProperty
	public final native int length() /*-{
		return this.length();
	}-*/;

	/**
	 * Look up an attribute's Namespace URI by index.
	 * 
	 * @param index
	 *          The attribute index (zero-based).
	 * @return The Namespace URI, or the empty string if none is available, or null if the index is out of range.
	 * @see #getLength
	 */
	@GwtNodeFunction
	public final native String getURI(int index) /*-{
		return this.getURI(index);
	}-*/;

	/**
	 * Look up an attribute's local name by index.
	 * 
	 * @param index
	 *          The attribute index (zero-based).
	 * @return The local name, or the empty string if Namespace processing is not being performed, or null if the index is
	 *         out of range.
	 * @see #getLength
	 */
	@GwtNodeFunction
	public final native String getLocalName(int index) /*-{
		return this.getLocalName(index);
	}-*/;

	/**
	 * Look up an attribute's XML qualified (prefixed) name by index.
	 * 
	 * @param index
	 *          The attribute index (zero-based).
	 * @return The XML qualified name, or the empty string if none is available, or null if the index is out of range.
	 * @see #getLength
	 */
	@GwtNodeFunction
	public final native String getQName(int index) /*-{
		return this.getQName(index);
	}-*/;

	/**
	 * Look up an attribute's type by index.
	 * 
	 * <p>
	 * The attribute type is one of the strings "CDATA", "ID", "IDREF", "IDREFS", "NMTOKEN", "NMTOKENS", "ENTITY",
	 * "ENTITIES", or "NOTATION" (always in upper case).
	 * </p>
	 * 
	 * <p>
	 * If the parser has not read a declaration for the attribute, or if the parser does not report attribute types, then
	 * it must return the value "CDATA" as stated in the XML 1.0 Recommendation (clause 3.3.3,
	 * "Attribute-Value Normalization").
	 * </p>
	 * 
	 * <p>
	 * For an enumerated attribute that is not a notation, the parser will report the type as "NMTOKEN".
	 * </p>
	 * 
	 * @param index
	 *          The attribute index (zero-based).
	 * @return The attribute's type as a string, or null if the index is out of range.
	 * @see #getLength
	 */
	@GwtNodeFunction
	public final native String getType(int index) /*-{
		return this.getType(index);
	}-*/;

	/**
	 * Look up an attribute's value by index.
	 * 
	 * <p>
	 * If the attribute value is a list of tokens (IDREFS, ENTITIES, or NMTOKENS), the tokens will be concatenated into a
	 * single string with each token separated by a single space.
	 * </p>
	 * 
	 * @param index
	 *          The attribute index (zero-based).
	 * @return The attribute's value as a string, or null if the index is out of range.
	 * @see #getLength
	 */
	@GwtNodeFunction
	public final native String getValue(int index) /*-{
		return this.getValue(index);
	}-*/;

	/**
	 * Look up the index of an attribute by Namespace name.
	 * 
	 * @param uri
	 *          The Namespace URI, or the empty string if the name has no Namespace URI.
	 * @param localName
	 *          The attribute's local name.
	 * @return The index of the attribute, or -1 if it does not appear in the list.
	 */
	@GwtNodeFunction
	public final native int getIndex(String uri, String localName) /*-{
		return this.getIndex(uri, localName);
	}-*/;

	/**
	 * Look up the index of an attribute by XML qualified (prefixed) name.
	 * 
	 * @param qName
	 *          The qualified (prefixed) name.
	 * @return The index of the attribute, or -1 if it does not appear in the list.
	 */
	@GwtNodeFunction
	public final native int getIndex(String qName) /*-{
		return this.getIndex(qName);
	}-*/;

	/**
	 * Look up an attribute's type by Namespace name.
	 * 
	 * <p>
	 * See {@link #getType(int) getType(int)} for a description of the possible types.
	 * </p>
	 * 
	 * @param uri
	 *          The Namespace URI, or the empty String if the name has no Namespace URI.
	 * @param localName
	 *          The local name of the attribute.
	 * @return The attribute type as a string, or null if the attribute is not in the list or if Namespace processing is
	 *         not being performed.
	 */
	@GwtNodeFunction
	public final native String getType(String uri, String localName) /*-{
		return this.getType(uri, localName);
	}-*/;

	/**
	 * Look up an attribute's type by XML qualified (prefixed) name.
	 * 
	 * <p>
	 * See {@link #getType(int) getType(int)} for a description of the possible types.
	 * </p>
	 * 
	 * @param qName
	 *          The XML qualified name.
	 * @return The attribute type as a string, or null if the attribute is not in the list or if qualified names are not
	 *         available.
	 */
	@GwtNodeFunction
	public final native String getType(String qName) /*-{
		return this.getType(qName);
	}-*/;

	/**
	 * Look up an attribute's value by Namespace name.
	 * 
	 * <p>
	 * See {@link #getValue(int) getValue(int)} for a description of the possible values.
	 * </p>
	 * 
	 * @param uri
	 *          The Namespace URI, or the empty String if the name has no Namespace URI.
	 * @param localName
	 *          The local name of the attribute.
	 * @return The attribute value as a string, or null if the attribute is not in the list.
	 */
	@GwtNodeFunction
	public final native String getValue(String uri, String localName) /*-{
		return this.getValue(uri, localName);
	}-*/;

	/**
	 * Look up an attribute's value by XML qualified (prefixed) name.
	 * 
	 * <p>
	 * See {@link #getValue(int) getValue(int)} for a description of the possible values.
	 * </p>
	 * 
	 * @param qName
	 *          The XML qualified name.
	 * @return The attribute value as a string, or null if the attribute is not in the list or if qualified names are not
	 *         available.
	 */
	@GwtNodeFunction
	public final native String getValue(String qName) /*-{
		return this.getValue(qName);
	}-*/;
}
