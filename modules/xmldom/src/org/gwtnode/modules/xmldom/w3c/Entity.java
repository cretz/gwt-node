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
 * This interface represents a known entity, either parsed or unparsed, in an XML document. Note that this models the
 * entity itself <em>not</em> the entity declaration.
 * <p>
 * The <code>nodeName</code> attribute that is inherited from <code>Node</code> contains the name of the entity.
 * <p>
 * An XML processor may choose to completely expand entities before the structure model is passed to the DOM; in this
 * case there will be no <code>EntityReference</code> nodes in the document tree.
 * <p>
 * XML does not mandate that a non-validating XML processor read and process entity declarations made in the external
 * subset or declared in parameter entities. This means that parsed entities declared in the external subset need not be
 * expanded by some classes of applications, and that the replacement text of the entity may not be available. When the
 * <a href='http://www.w3.org/TR/2004/REC-xml-20040204#intern-replacement'> replacement text</a> is available, the
 * corresponding <code>Entity</code> node's child list represents the structure of that replacement value. Otherwise,
 * the child list is empty.
 * <p>
 * DOM Level 3 does not support editing <code>Entity</code> nodes; if a user wants to make changes to the contents of an
 * <code>Entity</code>, every related <code>EntityReference</code> node has to be replaced in the structure model by a
 * clone of the <code>Entity</code>'s contents, and then the desired changes must be made to each of those clones
 * instead. <code>Entity</code> nodes and all their descendants are readonly.
 * <p>
 * An <code>Entity</code> node does not have any parent.
 * <p >
 * <b>Note:</b> If the entity contains an unbound namespace prefix, the <code>namespaceURI</code> of the corresponding
 * node in the <code>Entity</code> node subtree is <code>null</code>. The same is true for <code>EntityReference</code>
 * nodes that refer to this entity, when they are created using the <code>createEntityReference</code> method of the
 * <code>Document</code> interface.
 * <p>
 * See also the <a href='http://www.w3.org/TR/2004/REC-DOM-Level-3-Core-20040407'>Document Object Model (DOM) Level 3
 * Core Specification</a>.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class Entity extends Notation {

	protected Entity() {}

	/**
	 * For unparsed entities, the name of the notation for the entity. For parsed entities, this is <code>null</code>.
	 */
	@GwtNodeProperty
	public final native String notationName() /*-{
		return this.notationName;
	}-*/;
}
