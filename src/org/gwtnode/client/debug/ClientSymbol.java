/*
 * Copyright 2011 Chad Retz
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
package org.gwtnode.client.debug;

import com.google.gwt.core.client.JavaScriptObject;

public abstract class ClientSymbol extends JavaScriptObject {

    protected ClientSymbol() {
    }
    
    protected final native String getClassName() /*-{
        return this.className;
    }-*/;

    protected final native String getJsniIdent() /*-{
        return this.jsniIdent;
    }-*/;

    protected final native String getMemberName() /*-{
        return this.memberName;
    }-*/;

    protected final native int getQueryId() /*-{
        return this.queryId;
    }-*/;

    protected final native int getSourceLine() /*-{
        return this.sourceLine;
    }-*/;

    protected final native String getSourceUri() /*-{
        return this.sourceUri;
    }-*/;

    protected final native String getSymbolName() /*-{
        return this.symbolName;
    }-*/;

    protected final native boolean isClass() /*-{
        return this.isClass;
    }-*/;

    protected final native boolean isField() /*-{
        return this.isField;
    }-*/;

    protected final native boolean isMethod() /*-{
        return this.isMethod;
    }-*/;
}
