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
import japa.parser.ast.CompilationUnit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DebugInjector {

    public static void main(String[] args) {
        //takes a source dir, a target dir, and a fully qualified entry point
        if (args.length < 3) {
            System.out.println("Source dir, target dir, and entry point are required");
            return;
        }
        File source = new File(args[0]);
        if (!source.isDirectory()) {
            System.out.println("Can't find source dir " + source);
            return;
        }
        File target = new File(args[1]);
        if (!target.isDirectory()) {
            System.out.println("Can't find target dir " + target);
            return;
        }
        String entryPointClass = args[2];
        //copy EVERYTHING over there
        try {
            copy(source, target);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //now that everything's there, do the injection
        inject(target, new InjectionVisitor(entryPointClass));
    }
    
    private static void copy(File source, File target) throws IOException {
        if (source.isDirectory()) {
            if (!target.exists()) {
                target.mkdirs();
            }
            for (String file : source.list()) {
                copy(new File(source, file), new File(target, file));
            }
        } else {
            InputStream in = new FileInputStream(source);
            OutputStream out = null;
            try {
                out = new FileOutputStream(target);
                byte[] buf = new byte[1024];
                int len = in.read(buf);
                while (len > 0) {
                    out.write(buf, 0, len);
                    len = in.read(buf);
                }
            } finally {
                try { in.close(); } catch (Exception e) { }
                try { out.close(); } catch (Exception e) { }
            }
        }
    }
    
    private static void inject(File target, InjectionVisitor visitor) {
        if (target.isDirectory()) {
            for (File file : target.listFiles()) {
                inject(file, visitor);
            }
        } else if (target.getName().endsWith(".java")) {
            try {
                CompilationUnit unit = JavaParser.parse(target);
                visitor.visit(unit, null);
                if (visitor.isUnitChanged()) {
                    //and write it
                    OutputStream out = new FileOutputStream(target);
                    try {
                        out.write(unit.toString().getBytes());
                    } finally {
                        try { out.close(); } catch (Exception e) { }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
