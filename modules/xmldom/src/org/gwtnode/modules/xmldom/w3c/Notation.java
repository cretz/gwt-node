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

/**
 * This interface represents a notation declared in the DTD. A notation either declares, by name, the format of an
 * unparsed entity (see <a href='http://www.w3.org/TR/2004/REC-xml-20040204#Notations'>section 4.7</a> of the XML 1.0
 * specification [<a href='http://www.w3.org/TR/2004/REC-xml-20040204'>XML 1.0</a>]), or is used for formal declaration
 * of processing instruction targets (see <a href='http://www.w3.org/TR/2004/REC-xml-20040204#sec-pi'>section 2.6</a> of
 * the XML 1.0 specification [<a href='http://www.w3.org/TR/2004/REC-xml-20040204'>XML 1.0</a>]). The
 * <code>nodeName</code> attribute inherited from <code>Node</code> is set to the declared name of the notation.
 * <p>
 * The DOM Core does not support editing <code>Notation</code> nodes; they are therefore readonly.
 * <p>
 * A <code>Notation</code> node does not have any parent.
 * <p>
 * See also the <a href='http://www.w3.org/TR/2004/REC-DOM-Level-3-Core-20040407'>Document Object Model (DOM) Level 3
 * Core Specification</a>.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class Notation extends Node {

	protected Notation() {}

	/**
	 * The public identifier of this notation. If the public identifier was not specified, this is <code>null</code>.
	 */
	@GwtNodeProperty
	public final native String publicId() /*-{
		return this.publicId;
	}-*/;

	/**
	 * The system identifier of this notation. If the system identifier was not specified, this is <code>null</code>. This
	 * may be an absolute URI or not.
	 */
	@GwtNodeProperty
	public final native String systemId() /*-{
		return this.systemId;
	}-*/;
}
