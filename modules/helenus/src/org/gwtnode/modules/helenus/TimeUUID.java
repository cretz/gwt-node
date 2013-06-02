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

import java.util.Date;

import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.node.buffer.Buffer;

import com.google.gwt.core.client.JsDate;

@GwtNodeObject
public class TimeUUID extends UUID {

	/**
	 * Creates a UUID from a buffer
	 */
	@GwtNodeFunction("constructor")
	public static native TimeUUID fromBuffer(Buffer buf) /*-{
		return (@org.gwtnode.modules.helenus.Helenus::get()()).TimeUUID.fromBuffer(buf);
  }-*/;

	/**
	 * Creates a UUID from a binary string
	 */
	@GwtNodeFunction("constructor")
	public static native TimeUUID fromBinary(String bin) /*-{
		return (@org.gwtnode.modules.helenus.Helenus::get()()).TimeUUID.fromBinary(bin);
  }-*/;
	
	/**
	 * Creates a TimeUUID from a Timestamp 
	 */
	@GwtNodeFunction("constructor")
	public static native TimeUUID fromTimestamp(JsDate ts) /*-{
		return (@org.gwtnode.modules.helenus.Helenus::get()()).TimeUUID.fromTimestamp(ts);
  }-*/;
	
	/**
	 * Creates a TimeUUID from a Timestamp 
	 */
	@GwtNodeFunction("constructor")
	public static TimeUUID fromTimestamp(Date ts) {
		return fromTimestamp(JsDate.create(ts.getTime()));
  }
	
	protected TimeUUID() {}
}
