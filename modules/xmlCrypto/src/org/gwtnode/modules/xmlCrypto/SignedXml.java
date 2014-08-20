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
package org.gwtnode.modules.xmlCrypto;

import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;
import org.gwtnode.core.meta.GwtNodeProperty;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

@GwtNodeObject
public class SignedXml extends JavaScriptObject {
	
	protected SignedXml() {}

	@GwtNodeProperty
	public final native String signingKey() /*-{
		return this.signingKey;
	}-*/; 

	@GwtNodeProperty
	public final native void signingKey(String signingKey) /*-{
		this.signingKey = signingKey;
	}-*/; 
	
	@GwtNodeProperty
	public final native KeyInfoProvider keyInfoProvider() /*-{
		return this.keyInfoProvider;
	}-*/;

	@GwtNodeProperty
	public final native KeyInfoProvider keyInfoProvider(KeyInfoProvider keyInfoProvider) /*-{
		this.keyInfoProvider = keyInfoProvider;
	}-*/;

	@GwtNodeProperty
	public final native String signatureAlgorithm() /*-{
		return this.signatureAlgorithm;
	}-*/;

	@GwtNodeProperty
	public final native void signatureAlgorithm(String signatureAlgorithm) /*-{
		this.signatureAlgorithm = signatureAlgorithm;
	}-*/;

	@GwtNodeProperty
	public final native String canonicalizationAlgorithm() /*-{
		return this.canonicalizationAlgorithm;
	}-*/;

	@GwtNodeProperty
	public final native void canonicalizationAlgorithm(String canonicalizationAlgorithm) /*-{
		this.canonicalizationAlgorithm = canonicalizationAlgorithm;
	}-*/;
	
	@GwtNodeProperty
	public final native JsArrayString validationErrors() /*-{
		return this.validationErrors;
	}-*/;
	
	public final native void setCanonicalizationAlgorithm(final ProcessAlgorithm canonicalizationAlgorithm) /*-{
		var algorithm = canonicalizationAlgorithm.@org.gwtnode.modules.xmlCrypto.ProcessAlgorithm::getAlgorithmName()();
		this.CanonicalizationAlgorithms[algorithm] = function() {
			
			this.process = function(node) {
				return canonicalizationAlgorithm.@org.gwtnode.modules.xmlCrypto.ProcessAlgorithm::process(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
			}

			this.getAlgorithmName = function() {
				return algorithm;
			}
		};
	}-*/;
	
	public final native void setHashAlgorithm(final HashAlgorithm hashAlgorithm) /*-{
		var algorithm = hashAlgorithm.@org.gwtnode.modules.xmlCrypto.HashAlgorithm::getAlgorithmName()();
		this.HashAlgorithms[algorithm] = function() {
			
			this.getHash = function(xml) {
				return hashAlgorithm.@org.gwtnode.modules.xmlCrypto.HashAlgorithm::getHash(Ljava/lang/String;)(xml);
			}

			this.getAlgorithmName = function() {
				return algorithm;
			}
		};
	}-*/;
	
	public final native void setSignatureAlgorithm(final SignatureAlgorithm signatureAlgorithm) /*-{
		var algorithm = signatureAlgorithm.@org.gwtnode.modules.xmlCrypto.SignatureAlgorithm::getAlgorithmName()();
		this.SignatureAlgorithms[algorithm] = function() {
			
			this.getSignature = function(signedInfo, signingKey) {
				return hashAlgorithm.@org.gwtnode.modules.xmlCrypto.SignatureAlgorithm::getSignature(Ljava/lang/String;Ljava/lang/String;)(signedInfo, signingKey);
			}

			this.getAlgorithmName = function() {
				return algorithm;
			}
		};
	}-*/;
	
	@GwtNodeFunction
	public final native void loadSignature(String signatureXml) /*-{
		this.loadSignature(signatureXml);
	}-*/; 
	
	@GwtNodeFunction
	public final native boolean checkSignature(String xml) /*-{
		return this.checkSignature(xml);
	}-*/;
	
	@GwtNodeFunction
	public final native void addReference(
			String xpath, 
			JsArrayString transforms, 
			String digestAlgorithm, 
			String uri, 
			String digestValue, 
			String inclusiveNamespacesPrefixList) /*-{
		this.addReference(xpath, transforms, digestAlgorithm, uri, digestValue, inclusiveNamespacesPrefixList);
	}-*/; 
	
	@GwtNodeFunction
	public final native void addReference(String xpath, JsArrayString transforms, String digestAlgorithm) /*-{
		this.addReference(xpath, transforms, digestAlgorithm);
	}-*/;
	
	@GwtNodeFunction
	public final native void addReference(String xpath) /*-{
		this.addReference(xpath);
	}-*/;
	
	@GwtNodeFunction
	public final native void computeSignature(String xml, String xpathToNodeBeforeSignature) /*-{
		this.computeSignature(xml, xpathToNodeBeforeSignature);
	}-*/; 
	
	@GwtNodeFunction
	public final native void computeSignature(String xml) /*-{
		this.computeSignature(xml);
	}-*/;
	
	@GwtNodeFunction
	public final native String getSignatureXml() /*-{
		this.getSignatureXml();
	}-*/;
	
	@GwtNodeFunction
	public final native String getOriginalXmlWithIds() /*-{
		this.getOriginalXmlWithIds();
	}-*/;
	
	@GwtNodeFunction
	public final native String getSignedXml() /*-{
		this.getSignedXml();
	}-*/;
}
