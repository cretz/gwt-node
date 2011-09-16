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

import java.util.Set;

import com.google.gwt.core.ext.LinkerContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.linker.AbstractLinker;
import com.google.gwt.core.ext.linker.ArtifactSet;
import com.google.gwt.core.ext.linker.CompilationResult;
import com.google.gwt.core.ext.linker.LinkerOrder;
import com.google.gwt.core.ext.linker.LinkerOrder.Order;
import com.google.gwt.dev.util.DefaultTextOutput;

/**
 * Simple linker to remove a lot of GWT fluff
 * 
 * @author Chad Retz
 */
@LinkerOrder(Order.PRIMARY)
public class GwtNodeLinker extends AbstractLinker {

    @Override
    public String getDescription() {
        return "GwtNode";
    }

    @Override
    public ArtifactSet link(TreeLogger logger, LinkerContext context,
            ArtifactSet artifacts) throws UnableToCompleteException {
        ArtifactSet toReturn = new ArtifactSet(artifacts);
        DefaultTextOutput out = new DefaultTextOutput(true);
        //inject other scripts
        //for (ScriptReference resource : artifacts.find(ScriptReference.class)) {
        //    out.print(resource.toString());
        //}
        //closure
        out.print("(function () {");
        out.newline();
        // grab compilation result
        Set<CompilationResult> results = artifacts
                .find(CompilationResult.class);
        CompilationResult result = null;
        if (results.size() > 1) {
            logger.log(TreeLogger.ERROR,
                    "The module must have exactly one distinct"
                            + " permutation when using the " + getDescription()
                            + " Linker.", null);
            throw new UnableToCompleteException();
        } else if (!results.isEmpty()) {
            result = results.iterator().next();
            // dump JS
            String[] js = result.getJavaScript();
            if (js.length != 1) {
                logger.log(TreeLogger.ERROR,
                        "The module must not have multiple fragments when using the "
                                + getDescription() + " Linker.", null);
                throw new UnableToCompleteException();
            }
            out.print(js[0]);
            out.newline();
        }
        out.print("var $stats = function() { };");
        out.newline();
        out.print("var $sessionId = function() { };");
        out.newline();
        //global window
        //TODO: check this against jsdom
        out.print("var window = { };");
        out.newline();
        //preload code
        addPreloadCode(logger, context, artifacts, result, out);
        out.newline();
        out.print("gwtOnLoad(null, '" + context.getModuleName() + "', null);");
        out.newline();
        out.print("})();");
        out.newline();
        //and to string
        toReturn.add(emitString(logger, out.toString(), context.getModuleName() + ".js"));
        return toReturn;
    }
    
    protected void addPreloadCode(TreeLogger logger, LinkerContext context,
            ArtifactSet artifacts, CompilationResult result,
            DefaultTextOutput out) throws UnableToCompleteException {
        //noop
    }

}
