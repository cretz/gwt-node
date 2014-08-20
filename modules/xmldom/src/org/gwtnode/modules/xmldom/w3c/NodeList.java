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

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The <code>NodeList</code> interface provides the abstraction of an ordered collection of nodes, without defining or
 * constraining how this collection is implemented. <code>NodeList</code> objects in the DOM are live.
 * <p>
 * The items in the <code>NodeList</code> are accessible via an integral index, starting from 0.
 * <p>
 * See also the <a href='http://www.w3.org/TR/2004/REC-DOM-Level-3-Core-20040407'>Document Object Model (DOM) Level 3
 * Core Specification</a>.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class NodeList extends JavaScriptObject {

	protected NodeList() {}

	/**
	 * The number of nodes in the list. The range of valid child node indices is 0 to <code>length-1</code> inclusive.
	 */
	@GwtNodeProperty
  public final native int length() /*-{
		return this.length;
	}-*/;

  /**
   * Returns the <code>index</code>th item in the collection. If 
   * <code>index</code> is greater than or equal to the number of nodes in 
   * the list, this returns <code>null</code>.
   * @param index Index into the collection.
   * @return The node at the <code>index</code>th position in the 
   *   <code>NodeList</code>, or <code>null</code> if that is not a valid 
   *   index.
   */
	@GwtNodeFunction
  public final native Node item(int index) /*-{
		this.item(index);
	}-*/;
}
