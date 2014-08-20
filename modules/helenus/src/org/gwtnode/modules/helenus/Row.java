/*
 * Copyright 2013 Maxim Dominichenko
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
package org.gwtnode.modules.helenus;

import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;

import com.google.gwt.core.client.JsArray;

@GwtNodeObject
public class Row extends JsArray<Column> {

	protected Row() {}

	/**
	 * Gets a column by its name rather than by its array index.
	 * 
	 * @param name
	 *          The name of the column to get.
	 * @return a tuple of the column name, timestamp, ttl and value
	 */
	@GwtNodeFunction
	public final native Column get(String name) /*-{
		return this.get(name);
	}-*/;

	/**
	 * Slices out columns based on their name.
	 * 
	 * @param start
	 *          The starting string
	 * @param end
	 *          The ending string
	 * @return Row with the sliced out columns
	 */
	@GwtNodeFunction
	public final native Row nameSlice(String start, String end) /*-{
		return this.nameSlice(start, end);
	}-*/; 

	/**
	 * Slices out columns based on their index.
	 * 
	 * @param start
	 *          An integer that specifies where to start the selection (The first columns has an index of 0).
	 *          You can also use negative numbers to select from the end of the row.
	 * @param end
	 *          An integer that specifies where to end the selection.
	 * @return Row with the sliced out columns
	 */
	@GwtNodeFunction
	public final native Row slice(int start, int end) /*-{
		return this.slice(start, end);
	}-*/; 
	
	/**
	 * Slices out columns based on their index. Selects all elements from the start position and to the end of the row.
	 * 
	 * @param start
	 *          An integer that specifies where to start the selection (The first columns has an index of 0). You can also
	 *          use negative numbers to select from the end of the row.
	 * @return Row with the sliced out columns
	 */
	@GwtNodeFunction
	public final native Row slice(int start) /*-{
		return this.slice(start);
	}-*/; 
}
