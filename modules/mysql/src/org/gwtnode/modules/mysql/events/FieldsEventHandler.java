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
package org.gwtnode.modules.mysql.events;

import org.gwtnode.core.JavaScriptFunctionArguments;
import org.gwtnode.core.JavaScriptFunctionWrapper;
import org.gwtnode.modules.mysql.packets.FieldPacket;

import com.google.gwt.core.client.JsArray;

public abstract class FieldsEventHandler extends JavaScriptFunctionWrapper {

	@Override
	public void call(JavaScriptFunctionArguments args) {
		JsArray<FieldPacket> fields = args.get(0);
		FieldPacket[] fieldPackets = new FieldPacket[fields != null ? fields.length() : 0];
		if (fields != null)
			for (int i = 0; i < fields.length(); i++)
				fieldPackets[i] = fields.get(i);
		onEvent(fieldPackets);
	}

	public abstract void onEvent(FieldPacket[] fieldPackets);
}
