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
package org.gwtnode.modules.xml2js;

import org.gwtnode.core.JavaScriptFunction;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class ParseOptions extends JavaScriptObject {
	
	public static final ParseOptions create() {
		return JavaScriptObject.createObject().cast();
	}

	protected ParseOptions() {}
	
	/**
	 * (default: $): Prefix that is used to access the attributes.
	 */
	public final native String attrkey() /*-{
		return this.attrkey;
	}-*/;
	
	/**
	 * (default: $): Prefix that is used to access the attributes.
	 */
	public final native ParseOptions attrkey(String attrkey) /*-{
		this.attrkey = attrkey;
		return this;
	}-*/;
	
	/**
	 * (default: _): Prefix that is used to access the character content.
	 */
	public final native String charkey() /*-{
		return this.charkey;
	}-*/;
	
	/**
	 * (default: _): Prefix that is used to access the character content.
	 */
	public final native ParseOptions charkey(String charkey) /*-{
		this.charkey = charkey;
		return this;
	}-*/;

	/**
	 * (default: false)
	 */
	public final native boolean explicitCharkey() /*-{
		return this.explicitCharkey;
	}-*/;
	
	/**
	 * (default: false)
	 */
	public final native ParseOptions explicitCharkey(boolean explicitCharkey) /*-{
		this.explicitCharkey = explicitCharkey;
		return this;
	}-*/;
	
	/**
	 * (default: false): Trim the whitespace at the beginning and end of text nodes.
	 */
	public final native boolean trim() /*-{
		return this.trim;
	}-*/;
	
	/**
	 * (default: false): Trim the whitespace at the beginning and end of text nodes.
	 */
	public final native ParseOptions trim(boolean trim) /*-{
		this.trim = trim;
		return this;
	}-*/;

	/**
	 * (default: false): Normalize all tag names to lowercase.
	 */
	public final native boolean normalizeTags() /*-{
		return this.normalizeTags;
	}-*/;
	
	/**
	 * (default: false): Normalize all tag names to lowercase.
	 */
	public final native ParseOptions normalizeTags(boolean normalizeTags) /*-{
		this.normalizeTags = normalizeTags;
		return this;
	}-*/;

	/**
	 * (default: false): Trim whitespaces inside text nodes.
	 */
	public final native boolean normalize() /*-{
		return this.normalize;
	}-*/;

	/**
	 * (default: false): Trim whitespaces inside text nodes.
	 */
	public final native ParseOptions normalize(boolean normalize) /*-{
		this.normalize = normalize;
		return this;
	}-*/;
	
	/**
	 * (default: true): Set this if you want to get the root node in the resulting object.
	 */
	public final native boolean explicitRoot() /*-{
		return this.explicitRoot;
	}-*/;
	
	/**
	 * (default: true): Set this if you want to get the root node in the resulting object.
	 */
	public final native ParseOptions explicitRoot(boolean explicitRoot) /*-{
		this.explicitRoot = explicitRoot;
		return this;
	}-*/;

	/**
	 * (default: undefined): what will the value of empty nodes be. Default is {}.
	 */
	public final native Object emptyTag() /*-{
		return this.emptyTag;
	}-*/;
	
	/**
	 * (default: undefined): what will the value of empty nodes be. Default is {}.
	 */
	public final native ParseOptions emptyTag(Object emptyTag) /*-{
		this.emptyTag = emptyTag;
		return this;
	}-*/;

	/**
	 * (default: true): Always put child nodes in an array if true; otherwise an array is created only if there is more
	 * than one.
	 */
	public final native boolean explicitArray() /*-{
		return this.explicitArray;
	}-*/;
	
	/**
	 * (default: true): Always put child nodes in an array if true; otherwise an array is created only if there is more
	 * than one.
	 */
	public final native ParseOptions explicitArray(boolean explicitArray) /*-{
		this.explicitArray = explicitArray;
		return this;
	}-*/;

	/**
	 * (default: false): Ignore all XML attributes and only create text nodes.
	 */
	public final native boolean ignoreAttrs() /*-{
		return this.ignoreAttrs;
	}-*/;
	
	/**
	 * (default: false): Ignore all XML attributes and only create text nodes.
	 */
	public final native ParseOptions ignoreAttrs(boolean ignoreAttrs) /*-{
		this.ignoreAttrs = ignoreAttrs;
		return this;
	}-*/;

	/**
	 * (default: false): Merge attributes and child elements as properties of the parent, instead of keying attributes off
	 * a child attribute object. This option is ignored if ignoreAttrs is false.
	 */
	public final native boolean mergeAttrs() /*-{
		return this.mergeAttrs;
	}-*/;
	
	/**
	 * (default: false): Merge attributes and child elements as properties of the parent, instead of keying attributes off
	 * a child attribute object. This option is ignored if ignoreAttrs is false.
	 */
	public final native ParseOptions mergeAttrs(boolean mergeAttrs) /*-{
		this.mergeAttrs = mergeAttrs;
		return this;
	}-*/;

	/**
	 * (default null): You can specify a callable that validates the resulting structure somehow, however you want. See
	 * unit tests for an example.
	 */
	public final native JavaScriptFunction validator() /*-{
		return this.validator;
	}-*/;
	
	/**
	 * (default null): You can specify a callable that validates the resulting structure somehow, however you want. See
	 * unit tests for an example.
	 */
	public final native ParseOptions validator(JavaScriptFunction validator) /*-{
		this.validator = validator;
		return this;
	}-*/;
	
	/**
	 * (default false): Give each element a field usually called '$ns' (the first character is the same as attrkey) that
	 * contains its local name and namespace URI.
	 */
	public final native boolean xmlns() /*-{
		return this.xmlns;
	}-*/;
	
	/**
	 * (default false): Give each element a field usually called '$ns' (the first character is the same as attrkey) that
	 * contains its local name and namespace URI.
	 */
	public final native ParseOptions xmlns(boolean xmlns) /*-{
		this.xmlns = xmlns;
		return this;
	}-*/;
	
	/**
	 * (default false): Put child elements to separate property. Doesn't work with mergeAttrs = true. If element has no
	 * children then "children" won't be created.
	 */
	public final native boolean explicitChildren() /*-{
		return this.explicitChildren;
	}-*/;
	
	/**
	 * (default false): Put child elements to separate property. Doesn't work with mergeAttrs = true. If element has no
	 * children then "children" won't be created.
	 */
	public final native ParseOptions explicitChildren(boolean explicitChildren) /*-{
		this.explicitChildren = explicitChildren;
		return this;
	}-*/;

	/**
	 * (default $$): Prefix that is used to access child elements if explicitChildren is set to true. 
	 */
	public final native String childkey() /*-{
		return this.childkey;
	}-*/;
	
	/**
	 * (default $$): Prefix that is used to access child elements if explicitChildren is set to true. 
	 */
	public final native ParseOptions childkey(String childkey) /*-{
		this.childkey = childkey;
		return this;
	}-*/;
	
	/**
	 * (default false): Determines whether chars should be considered children if explicitChildren is on.
	 */
	public final native boolean charsAsChildren() /*-{
		return this.charsAsChildren;
	}-*/;
	
	/**
	 * (default false): Determines whether chars should be considered children if explicitChildren is on.
	 */
	public final native ParseOptions charsAsChildren(boolean charsAsChildren) /*-{
		this.charsAsChildren = charsAsChildren;
		return this;
	}-*/;

	/**
	 * (default false): Should the callbacks be async? This might be an incompatible change if your code depends on sync
	 * execution of callbacks.
	 */
	public final native boolean async() /*-{
		return this.async;
	}-*/;
	
	/**
	 * (default false): Should the callbacks be async? This might be an incompatible change if your code depends on sync
	 * execution of callbacks.
	 */
	public final native ParseOptions async(boolean async) /*-{
		this.async = async;
		return this;
	}-*/;
	
	/**
	 * (default true): Set sax-js to strict or non-strict parsing mode. Defaults to true which is highly recommended,
	 * since parsing HTML which is not well-formed XML might yield just about anything.
	 */
	public final native boolean strict() /*-{
		return this.strict;
	}-*/;
	
	/**
	 * (default true): Set sax-js to strict or non-strict parsing mode. Defaults to true which is highly recommended,
	 * since parsing HTML which is not well-formed XML might yield just about anything.
	 */
	public final native ParseOptions strict(boolean strict) /*-{
		this.strict = strict;
		return this;
	}-*/;
	
	/**
	 * (default: null): Allows the addition of attribute name processing functions. Accepts an Array of functions with
	 * following signature: <code>javascript function (name){ //do something with `name` return name }</code>
	 */
	public final native JsArray<JavaScriptFunction> attrNameProcessors() /*-{
		return this.attrNameProcessors;
	}-*/;
	
	/**
	 * (default: null): Allows the addition of attribute name processing functions. Accepts an Array of functions with
	 * following signature: <code>javascript function (name){ //do something with `name` return name }</code>
	 */
	public final native ParseOptions attrNameProcessors(JsArray<JavaScriptFunction> attrNameProcessors) /*-{
		this.attrNameProcessors = attrNameProcessors;
		return this;
	}-*/;
	
	/**
	 * (default: null): Allows the addition of tag name processing functions. Accepts an Array of functions with following
	 * signature: <code>javascript function (name){ //do something with `name` return name }</code>
	 */
	public final native JsArray<JavaScriptFunction> tagNameProcessors() /*-{
		return this.tagNameProcessors;
	}-*/;
	
	/**
	 * (default: null): Allows the addition of tag name processing functions. Accepts an Array of functions with following
	 * signature: <code>javascript function (name){ //do something with `name` return name }</code>
	 */
	public final native ParseOptions tagNameProcessors(JsArray<JavaScriptFunction> tagNameProcessors) /*-{
		this.tagNameProcessors = tagNameProcessors;
		return this;
	}-*/;
}
