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
 * The <code>ProcessingInstruction</code> interface represents a "processing 
 * instruction", used in XML as a way to keep processor-specific information 
 * in the text of the document.
 * <p> No lexical check is done on the content of a processing instruction and 
 * it is therefore possible to have the character sequence 
 * <code>"?&gt;"</code> in the content, which is illegal a processing 
 * instruction per section 2.6 of [<a href='http://www.w3.org/TR/2004/REC-xml-20040204'>XML 1.0</a>]. The 
 * presence of this character sequence must generate a fatal error during 
 * serialization. 
 * <p>See also the <a href='http://www.w3.org/TR/2004/REC-DOM-Level-3-Core-20040407'>Document Object Model (DOM) Level 3 Core Specification</a>.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class ProcessingInstruction extends Node {

	protected ProcessingInstruction() {}
	
  /**
   * The target of this processing instruction. XML defines this as being 
   * the first token following the markup that begins the processing 
   * instruction.
   */
	@GwtNodeProperty
	public final native String target() /*-{
		return this.target;
	}-*/;

  /**
   * The content of this processing instruction. This is from the first non 
   * white space character after the target to the character immediately 
   * preceding the <code>?&gt;</code>.
   */
	@GwtNodeProperty
	public final native String data() /*-{
		return this.data;
	}-*/;
	
  /**
   * The content of this processing instruction. This is from the first non 
   * white space character after the target to the character immediately 
   * preceding the <code>?&gt;</code>.
   * @exception JavaScriptException
   *   NO_MODIFICATION_ALLOWED_ERR: Raised when the node is readonly.
   */
	@GwtNodeProperty
	public final native void data(String data) throws JavaScriptException /*-{
		this.data = data;
	}-*/;
}
