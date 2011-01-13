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
package org.cretz.gwtnode.dev.debug.inject;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.Node;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.stmt.Statement;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

class ParserUtils {

    public static List<Statement> getStatementsFromString(String code) throws ParseException {
        String newline = System.getProperty("line.separator");
        String source = new StringBuilder().
                append("class Noop { void noop() {").
                append(newline).
                append(code).
                append(newline).
                append("} }").toString();
        System.out.println(source);
        CompilationUnit unit = JavaParser.parse(new ByteArrayInputStream(source.getBytes()));
        List<Statement> stmts = ((MethodDeclaration) unit.getTypes().get(0).
                getMembers().get(0)).getBody().getStmts();
        removeLineNumbers(stmts);
        return stmts;
    }
    
    @SuppressWarnings("unchecked")
    public static <T extends Statement> T getStatementFromString(
            String code) throws ParseException {
        return (T) getStatementsFromString(code).get(0);
    }
    
    public static void removeLineNumbers(Iterable<?> nodes) {
        //I wish I was smarter than all this reflection
        if (nodes == null) {
            return;
        }
        for (Object obj : nodes) {
            if (obj != null && obj instanceof Node) {
                Node node = (Node) obj;
                node.setBeginColumn(0);
                node.setBeginLine(0);
                node.setEndColumn(0);
                node.setEndLine(0);
                for (Method method : node.getClass().getMethods()) {
                    if (method.getParameterTypes().length == 0 &&
                            Node.class.isAssignableFrom(method.getReturnType())) {
                        try {
                            removeLineNumbers(Collections.singleton(method.invoke(node)));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (method.getParameterTypes().length == 0 &&
                            Iterable.class.isAssignableFrom(method.getReturnType())) {
                        try {
                            removeLineNumbers((Iterable<?>) method.invoke(node));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    
    private ParserUtils() {        
    }
}
