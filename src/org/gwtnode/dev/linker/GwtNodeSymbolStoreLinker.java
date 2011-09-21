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
package org.gwtnode.dev.linker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.gwtnode.dev.symbol.ClientSymbolStore;

import com.google.gwt.core.ext.LinkerContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.TreeLogger.Type;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.linker.ArtifactSet;
import com.google.gwt.core.ext.linker.CompilationResult;
import com.google.gwt.core.ext.linker.SymbolData;
import com.google.gwt.dev.util.DefaultTextOutput;

/**
 * @author Chad Retz
 */
public class GwtNodeSymbolStoreLinker extends GwtNodeLinker {
    
    @Override
    protected void addPreloadCode(TreeLogger logger, LinkerContext context,
            ArtifactSet artifacts, CompilationResult result,
            DefaultTextOutput out) throws UnableToCompleteException {
        super.addPreloadCode(logger, context, artifacts, result, out);
        //add the symbols
        out.print("//--- BEGIN SYMBOL MAPPING ---");
        out.newline();
        out.print("//create symbol mapping object");
        out.newline();
        StringBuilder objectJs = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    GwtNodeSymbolStoreLinker.class.getResourceAsStream("SymbolStoreObject.js")));
            String line = reader.readLine();
            while (line != null) {
                line = line.replace("${objectName}", ClientSymbolStore.GLOBAL_JS_OBJECT_NAME);
                line = line.replace("${classesName}", ClientSymbolStore.CLASSES_MAP_NAME);
                line = line.replace("${methodsName}", ClientSymbolStore.METHODS_MAP_NAME);
                line = line.replace("${fieldsName}", ClientSymbolStore.FIELDS_MAP_NAME);
                objectJs.append(line).append("\n");
                line = reader.readLine();
            }
        } catch (IOException e) {
            logger.log(Type.ERROR, "Can't read local file", e);
            throw new UnableToCompleteException();
        } finally {
            try {
                reader.close();
            } catch (Exception ignore) { }
        }
        out.print(objectJs.toString());
        out.newline();
        out.print("//add symbols");
        for (SymbolData symbol : result.getSymbolMap()) {
            out.newline();
            out.print("global.");
            out.print(ClientSymbolStore.GLOBAL_JS_OBJECT_NAME);
            out.print("._add(");
            out.print(buildSymbolJson(symbol));
            out.print(");");
        }
        out.newline();
        out.print("//--- END SYMBOL MAPPING ---");
        out.newline();
    }
    
    private String buildSymbolJson(SymbolData symbol) {
        return new StringBuilder("{").
            append("'className' : ").append(toJsValue(symbol.getClassName())).append(',').
            append("'jsniIdent' : ").append(toJsValue(symbol.getJsniIdent())).append(',').
            append("'memberName' : ").append(toJsValue(symbol.getMemberName())).append(',').
            append("'queryId' : ").append(toJsValue(symbol.getQueryId())).append(',').
            append("'sourceLine' : ").append(toJsValue(symbol.getSourceLine())).append(',').
            append("'sourceUri' : ").append(toJsValue(symbol.getSourceUri())).append(',').
            append("'symbolName' : ").append(toJsValue(symbol.getSymbolName())).append(',').
            append("'isClass' : ").append(toJsValue(symbol.isClass())).append(',').
            append("'isField' : ").append(toJsValue(symbol.isField())).append(',').
            append("'isMethod' : ").append(toJsValue(symbol.isMethod())).
            append("}").toString();
    }
    
    private String toJsValue(Object object) {
        if (object == null) {
            return "null";
        } else if (object instanceof Boolean || object instanceof Number) {
            return object.toString();
        } else if (object instanceof String) {
            return '\'' + object.toString() + '\'';
        } else {
            throw new IllegalArgumentException("Unrecognized JS type: " + object.getClass());
        }
    }
}
