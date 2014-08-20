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
 * The <code>CharacterData</code> interface extends Node with a set of attributes and methods for accessing character
 * data in the DOM. For clarity this set is defined here rather than on each object that uses these attributes and
 * methods. No DOM objects correspond directly to <code>CharacterData</code>, though <code>Text</code> and others do
 * inherit the interface from it. All <code>offsets</code> in this interface start from <code>0</code>.
 * <p>
 * As explained in the <code>DOMString</code> interface, text strings in the DOM are represented in UTF-16, i.e. as a
 * sequence of 16-bit units. In the following, the term 16-bit units is used whenever necessary to indicate that
 * indexing on CharacterData is done in 16-bit units.
 * <p>
 * See also the <a href='http://www.w3.org/TR/2004/REC-DOM-Level-3-Core-20040407'>Document Object Model (DOM) Level 3
 * Core Specification</a>.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class CharacterData extends Node {

	protected CharacterData() {}

	/**
	 * The character data of the node that implements this interface. The DOM implementation may not put arbitrary limits
	 * on the amount of data that may be stored in a <code>CharacterData</code> node. However, implementation limits may
	 * mean that the entirety of a node's data may not fit into a single <code>DOMString</code>. In such cases, the user
	 * may call <code>substringData</code> to retrieve the data in appropriately sized pieces.
	 * 
	 * @exception JavaScriptException
	 *              DOMSTRING_SIZE_ERR: Raised when it would return more characters than fit in a <code>DOMString</code>
	 *              variable on the implementation platform.
	 */
	@GwtNodeProperty
	public final native String data() throws JavaScriptException /*-{
		return this.data;
	}-*/;

	/**
	 * The character data of the node that implements this interface. The DOM implementation may not put arbitrary limits
	 * on the amount of data that may be stored in a <code>CharacterData</code> node. However, implementation limits may
	 * mean that the entirety of a node's data may not fit into a single <code>DOMString</code>. In such cases, the user
	 * may call <code>substringData</code> to retrieve the data in appropriately sized pieces.
	 * 
	 * @exception JavaScriptException
	 *              NO_MODIFICATION_ALLOWED_ERR: Raised when the node is readonly.
	 */
	@GwtNodeProperty
	public final native void data(String data) throws JavaScriptException /*-{
		this.data = data;
	}-*/;

	/**
	 * The number of 16-bit units that are available through <code>data</code> and the <code>substringData</code> method
	 * below. This may have the value zero, i.e., <code>CharacterData</code> nodes may be empty.
	 */
	@GwtNodeProperty
	public final native int length() /*-{
		return this.length;
	}-*/;
	
  /**
   * Extracts a range of data from the node.
   * @param offset Start offset of substring to extract.
   * @param count The number of 16-bit units to extract.
   * @return The specified substring. If the sum of <code>offset</code> and 
   *   <code>count</code> exceeds the <code>length</code>, then all 16-bit 
   *   units to the end of the data are returned.
   * @exception JavaScriptException
   *   INDEX_SIZE_ERR: Raised if the specified <code>offset</code> is 
   *   negative or greater than the number of 16-bit units in 
   *   <code>data</code>, or if the specified <code>count</code> is 
   *   negative.
   *   <br>DOMSTRING_SIZE_ERR: Raised if the specified range of text does 
   *   not fit into a <code>DOMString</code>.
   */
	@GwtNodeFunction
  public final native String substringData(int offset, int count) throws JavaScriptException /*-{
		return this.substringData(offset, count);
	}-*/;

  /**
   * Append the string to the end of the character data of the node. Upon 
   * success, <code>data</code> provides access to the concatenation of 
   * <code>data</code> and the <code>DOMString</code> specified.
   * @param arg The <code>DOMString</code> to append.
   * @exception JavaScriptException
   *   NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
   */
	@GwtNodeFunction
  public final native void appendData(String arg) throws JavaScriptException /*-{
		this.appendData(arg);
	}-*/;

  /**
   * Insert a string at the specified 16-bit unit offset.
   * @param offset The character offset at which to insert.
   * @param arg The <code>DOMString</code> to insert.
   * @exception JavaScriptException
   *   INDEX_SIZE_ERR: Raised if the specified <code>offset</code> is 
   *   negative or greater than the number of 16-bit units in 
   *   <code>data</code>.
   *   <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
   */
	@GwtNodeFunction
  public final native void insertData(int offset, String arg) throws JavaScriptException /*-{
		this.insertData(offset, arg);
	}-*/;

  /**
   * Remove a range of 16-bit units from the node. Upon success, 
   * <code>data</code> and <code>length</code> reflect the change.
   * @param offset The offset from which to start removing.
   * @param count The number of 16-bit units to delete. If the sum of 
   *   <code>offset</code> and <code>count</code> exceeds 
   *   <code>length</code> then all 16-bit units from <code>offset</code> 
   *   to the end of the data are deleted.
   * @exception JavaScriptException
   *   INDEX_SIZE_ERR: Raised if the specified <code>offset</code> is 
   *   negative or greater than the number of 16-bit units in 
   *   <code>data</code>, or if the specified <code>count</code> is 
   *   negative.
   *   <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
   */
	@GwtNodeFunction
  public final native void deleteData(int offset, int count) throws JavaScriptException /*-{
		this.deleteData(offset, count);
	}-*/;

  /**
   * Replace the characters starting at the specified 16-bit unit offset 
   * with the specified string.
   * @param offset The offset from which to start replacing.
   * @param count The number of 16-bit units to replace. If the sum of 
   *   <code>offset</code> and <code>count</code> exceeds 
   *   <code>length</code>, then all 16-bit units to the end of the data 
   *   are replaced; (i.e., the effect is the same as a <code>remove</code>
   *    method call with the same range, followed by an <code>append</code>
   *    method invocation).
   * @param arg The <code>DOMString</code> with which the range must be 
   *   replaced.
   * @exception JavaScriptException
   *   INDEX_SIZE_ERR: Raised if the specified <code>offset</code> is 
   *   negative or greater than the number of 16-bit units in 
   *   <code>data</code>, or if the specified <code>count</code> is 
   *   negative.
   *   <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
   */
	@GwtNodeFunction
  public final native void replaceData(int offset, int count, String arg) throws JavaScriptException /*-{
		this.replaceData(offset, count, arg);
	}-*/;
}
