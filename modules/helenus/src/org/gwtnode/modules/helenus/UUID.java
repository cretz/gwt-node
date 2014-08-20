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
import org.gwtnode.core.node.buffer.Buffer;

import com.google.gwt.core.client.JavaScriptObject;

@GwtNodeObject
public class UUID extends JavaScriptObject {

	/**
	 * Creates a UUID from a buffer
	 */
	@GwtNodeFunction("constructor")
	public static native UUID fromBuffer(Buffer buf) /*-{
		return (@org.gwtnode.modules.helenus.Helenus::get()()).UUID.fromBuffer(buf);
  }-*/;

	/**
	 * Creates a UUID from a binary string
	 */
	@GwtNodeFunction("constructor")
	public static native UUID fromBinary(String bin) /*-{
		return (@org.gwtnode.modules.helenus.Helenus::get()()).UUID.fromBinary(bin);
  }-*/;
	
	protected UUID() {}
	
	/**
	 * Returns a buffer with the bytes for the UUID
	 */
	@GwtNodeFunction
	public final native Buffer toBuffer() /*-{
		return this.toBuffer();
	}-*/;
	
	/**
	 * Returns a binary string representation of the UUID
	 */
	@GwtNodeFunction
	public final native String toBinary() /*-{
		return this.toBinary();
	}-*/;
}
