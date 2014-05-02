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
 * Each <code>Document</code> has a <code>doctype</code> attribute whose value is either <code>null</code> or a
 * <code>DocumentType</code> object. The <code>DocumentType</code> interface in the DOM Core provides an interface to
 * the list of entities that are defined for the document, and little else because the effect of namespaces and the
 * various XML schema efforts on DTD representation are not clearly understood as of this writing.
 * <p>
 * DOM Level 3 doesn't support editing <code>DocumentType</code> nodes. <code>DocumentType</code> nodes are read-only.
 * <p>
 * See also the <a href='http://www.w3.org/TR/2004/REC-DOM-Level-3-Core-20040407'>Document Object Model (DOM) Level 3
 * Core Specification</a>.
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 * 
 */
@GwtNodeObject
public class DocumentType extends Node {

	protected DocumentType() {}

	/**
	 * The name of DTD; i.e., the name immediately following the <code>DOCTYPE</code> keyword.
	 */
	@GwtNodeProperty
	public final native String name() /*-{
		return this.name;
	}-*/;

	/**
	 * A <code>NamedNodeMap</code> containing the general entities, both external and internal, declared in the DTD.
	 * Parameter entities are not contained. Duplicates are discarded. For example in:
	 * 
	 * <pre>
	 * &lt;!DOCTYPE 
	 * ex SYSTEM "ex.dtd" [ &lt;!ENTITY foo "foo"&gt; &lt;!ENTITY bar 
	 * "bar"&gt; &lt;!ENTITY bar "bar2"&gt; &lt;!ENTITY % baz "baz"&gt; 
	 * ]&gt; &lt;ex/&gt;
	 * </pre>
	 * 
	 * the interface provides access to <code>foo</code> and the first declaration of <code>bar</code> but not the second
	 * declaration of <code>bar</code> or <code>baz</code>. Every node in this map also implements the <code>Entity</code>
	 * interface. <br>
	 * The DOM Level 2 does not support editing entities, therefore <code>entities</code> cannot be altered in any way.
	 */
	@GwtNodeProperty
	public final native NamedNodeMap entities() /*-{
		return this.entities;
	}-*/;

	/**
	 * A <code>NamedNodeMap</code> containing the notations declared in the DTD. Duplicates are discarded. Every node in
	 * this map also implements the <code>Notation</code> interface. <br>
	 * The DOM Level 2 does not support editing notations, therefore <code>notations</code> cannot be altered in any way.
	 */
	@GwtNodeProperty
	public final native NamedNodeMap notations() /*-{
		return this.notations;
	}-*/;

	/**
	 * The public identifier of the external subset.
	 * 
	 * @since DOM Level 2
	 */
	@GwtNodeProperty
	public final native String publicId() /*-{
		return this.publicId;
	}-*/;

	/**
	 * The system identifier of the external subset. This may be an absolute URI or not.
	 * 
	 * @since DOM Level 2
	 */
	@GwtNodeProperty
	public final native String systemId() /*-{
		return this.systemId;
	}-*/;

	/**
	 * The internal subset as a string, or <code>null</code> if there is none. This is does not contain the delimiting
	 * square brackets.
	 * <p >
	 * <b>Note:</b> The actual content returned depends on how much information is available to the implementation. This
	 * may vary depending on various parameters, including the XML processor used to build the document.
	 * 
	 * @since DOM Level 2
	 */
	@GwtNodeProperty
	public final native String internalSubset() /*-{
		return this.internalSubset;
	}-*/;
}
