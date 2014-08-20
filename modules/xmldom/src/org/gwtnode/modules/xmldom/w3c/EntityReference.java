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

/**
 * <code>EntityReference</code> nodes may be used to represent an entity reference in the tree. Note that character
 * references and references to predefined entities are considered to be expanded by the HTML or XML processor so that
 * characters are represented by their Unicode equivalent rather than by an entity reference. Moreover, the XML
 * processor may completely expand references to entities while building the <code>Document</code>, instead of providing
 * <code>EntityReference</code> nodes. If it does provide such nodes, then for an <code>EntityReference</code> node that
 * represents a reference to a known entity an <code>Entity</code> exists, and the subtree of the
 * <code>EntityReference</code> node is a copy of the <code>Entity</code> node subtree. However, the latter may not be
 * true when an entity contains an unbound namespace prefix. In such a case, because the namespace prefix resolution
 * depends on where the entity reference is, the descendants of the <code>EntityReference</code> node may be bound to
 * different namespace URIs. When an <code>EntityReference</code> node represents a reference to an unknown entity, the
 * node has no children and its replacement value, when used by <code>Attr.value</code> for example, is empty.
 * <p>
 * As for <code>Entity</code> nodes, <code>EntityReference</code> nodes and all their descendants are readonly.
 * <p >
 * <b>Note:</b> <code>EntityReference</code> nodes may cause element content and attribute value normalization problems
 * when, such as in XML 1.0 and XML Schema, the normalization is performed after entity reference are expanded.
 * <p>
 * See also the <a href='http://www.w3.org/TR/2004/REC-DOM-Level-3-Core-20040407'>Document Object Model (DOM) Level 3
 * Core Specification</a>.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
@GwtNodeObject
public class EntityReference extends Node {

	protected EntityReference() {}
}
