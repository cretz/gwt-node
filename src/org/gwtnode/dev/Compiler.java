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
package org.gwtnode.dev;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Compiler
 *
 * @author Chad Retz
 */
public class Compiler {
    
    private static LogLevel logLevel = LogLevel.ERROR;
    
    private static void printUsage() {
        StringBuilder usage = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                Compiler.class.getResourceAsStream("USAGE")));
        try {
            usage.append(reader.readLine()).append("\n");
        } catch (IOException e) {
            throw new RuntimeException("Unable to read USAGE");
        } finally {
            try {
                reader.close();
            } catch (Exception ignore) { }
        }
    }
    
    public static void main(String[] args) {
        //TODO: modularize
        try {
            List<String> argList = new ArrayList<String>(Arrays.asList(args));
            //validate options...
            assertValidOptions(argList);
            //grab the log level
            logLevel = getLogLevel(argList);
            //grab the module name
            List<String> simpleNames = getSimpleModuleNames(argList);
            //get the out directory
            File outDir = getOutputDirectory(argList);
            //create temp dirs (0 - work, 1 - war, 2 - deploy, 3 - extra)
            File[] tempDirs = createTempDirectories(argList);
            //insert params
            argList.addAll(0, Arrays.asList(
                    "-workDir", tempDirs[0].getAbsolutePath(),
                    "-war", tempDirs[1].getAbsolutePath(),
                    "-deploy", tempDirs[2].getAbsolutePath(),
                    "-extra", tempDirs[3].getAbsolutePath()));
            //run
            run(argList.toArray(new String[0]));
            //copy everything in the war folder to the out folder
            if (simpleNames.size() == 1) {
                //if there is one, just copy it
                copyRecursively(new File(tempDirs[1], simpleNames.get(0)), outDir);
            } else {
                //if there isn't, put the whole war dir structure there...
                copyRecursively(tempDirs[1], outDir);
            }
            //XXX: should I be deleting the temp directories?
            if (tempDirs[0].getParentFile().getName().startsWith("gwt-node-")) {
                //delete the parent if the parent starts with "gwt-node-"
                deleteRecursively(tempDirs[0].getParentFile());
            } else {
                //nope, just the kids
                deleteRecursively(tempDirs[0]);
                deleteRecursively(tempDirs[1]);
                deleteRecursively(tempDirs[2]);
                deleteRecursively(tempDirs[3]);
            }
        } catch (Exception e) {
            System.out.println("Error - " + e.getMessage());
            printUsage();
            if (logLevel.isEnabled(LogLevel.INFO)) {
                e.printStackTrace();
            }
            System.exit(1);
        }
    }

    private static int run(String[] array) {
        //preventing System.exit()
        NoExitSecurityManager.install();
        try {
            //I have to set this system property because the persistent unit cache
            //  (com.google.gwt.dev.javac.PersistentUnitCache) reads from the temp
            //  files in another thread while I'm trying to delete them later...
            //This property is referenced in com.google.gwt.dev.javac.UnitCacheFactory
            System.setProperty("gwt.persistentunitcache", "false");
            com.google.gwt.dev.Compiler.main(array);
        } catch (ExitInvokedException e) {
            return e.status;
        } finally {
            NoExitSecurityManager.uninstall();
        }
        throw new IllegalStateException("Didn't get System.exit() as expected");
    }

    private static File getOutputDirectory(List<String> argList) throws FriendlyException {
        File ret;
        try {
            if (argList.contains("-out")) {
                int index = argList.indexOf("-out");
                ret = new File(argList.get(index + 1));
                argList.remove(index);
                argList.remove(index);
            } else {
                ret = new File(".");
            }
        } catch (Exception e) {
            throw new FriendlyException("Can't get output directory", e);
        }
        if (!ret.exists()) {
            throw new FriendlyException("Output directory " + ret + " does not exist");
        }
        return ret;
    }

    private static void deleteRecursively(File file) throws IOException {
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                deleteRecursively(child);
            }
        }
        if (!file.delete()) {
            if (logLevel.isEnabled(LogLevel.DEBUG)) {
                System.out.println("Unable to delete file " + file + ", deleting on exit");
            }
            file.deleteOnExit();
        }
    }
    
    private static void copyRecursively(File source, File target) throws IOException {
        if (source.isDirectory()) {
            if (!target.exists()) {
                target.mkdir();
            }
            for (String child : source.list()) {
                copyRecursively(new File(source, child), new File(target, child));
            }
        } else {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = new FileInputStream(source);
                out = new FileOutputStream(target);
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            } finally {
                try {
                    in.close();
                } catch (Exception ignore) { }
                try {
                    out.close();
                } catch (Exception ignore) { }
            }
        }
    }
    
    private static File[] createTempDirectories(List<String> argList) throws FriendlyException {
        try {
            File workDir;
            if (argList.contains("-workDir")) {
                int index = argList.indexOf("-workDir");
                workDir = new File(argList.get(index + 1));
                //remove it from the list
                argList.remove(index);
                argList.remove(index);
            } else {
                workDir = new File(System.getProperty("java.io.tmpdir"));
            }
            File tempDir;
            do {
                tempDir = new File(workDir, "gwt-node-" + Long.toHexString(System.currentTimeMillis()));
                Thread.sleep(10);
            } while (tempDir.exists() || !tempDir.mkdir());
            if (logLevel.isEnabled(LogLevel.DEBUG)) {
                System.out.println("Using temporary directory: " + tempDir);
            }
            File[] ret = new File[] {
                    new File(tempDir, "work"), new File(tempDir, "war"), 
                    new File(tempDir, "deploy"), new File(tempDir, "extra")
            };
            ret[0].mkdir();
            ret[1].mkdir();
            ret[2].mkdir();
            ret[3].mkdir();
            return ret;
        } catch (Exception e) {
            throw new FriendlyException("Unable to create temporary directories", e);
        }
    }

    private static List<String> getSimpleModuleNames(List<String> argList) {
        //work backwards and consider each argument that doesn't have a 
        //  [-arg arg] or [-arg] style a module name
        List<String> moduleNames = new ArrayList<String>();
        for (int i = argList.size() - 1; i >= 0; i--) {
            String arg = argList.get(i);
            if (!arg.startsWith("-") && 
                    (i == 0 || !argList.get(i - 1).startsWith("-"))) {
                moduleNames.add(arg.substring(arg.lastIndexOf('.') + 1));
            }
        }
        return moduleNames;
    }

    private static LogLevel getLogLevel(List<String> argList) throws FriendlyException {
        try {
            if (argList.contains("-logLevel")) {
                return LogLevel.valueOf(argList.get(argList.indexOf("-logLevel") + 1));
            } else {
                return LogLevel.ERROR;
            }
        } catch (Exception e) {
            throw new FriendlyException("Invalid log level", e);
        }
    }

    private static void assertValidOptions(List<String> argList) throws FriendlyException {
        List<String> errors = new ArrayList<String>(5);
        if (argList.contains("-gen")) {
            //not needed during standard compilation
            errors.add("-gen is not allowed");
        }
        if (argList.contains("-localWorkers")) {
            //we only have one permutation
            errors.add("-localWorkers is not allowed");
        }
        if (argList.contains("-war")) {
            //we create this directory
            errors.add("-war is not allowed");
        }
        if (argList.contains("-deploy")) {
            //we create this directory
            errors.add("-deploy is not allowed");
        }
        if (argList.contains("-extra")) {
            //we create this directory
            errors.add("-extra is not allowed");
        }
        if (!errors.isEmpty()) {
            throw new FriendlyException("Invalid options: " + errors);
        }
    }
    
    private static enum LogLevel {
        ERROR, 
        WARN, 
        INFO, 
        TRACE, 
        DEBUG, 
        SPAM, 
        ALL;
        
        private boolean isEnabled(LogLevel requested) {
            return ordinal() >= requested.ordinal();
        }
    }
    
    @SuppressWarnings("serial")
    private static class FriendlyException extends Exception {
        
        public FriendlyException(String message) {
            super(message);
        }
        
        public FriendlyException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    
    private static class NoExitSecurityManager extends SecurityManager {
        
        public static void install() {
            System.setSecurityManager(new NoExitSecurityManager(System.getSecurityManager()));
        }
        
        public static void uninstall() {
            if (System.getSecurityManager() instanceof NoExitSecurityManager) {
                System.setSecurityManager(((NoExitSecurityManager) System.getSecurityManager()).previous);
            }
        }
        
        private final SecurityManager previous;
        
        private NoExitSecurityManager(SecurityManager previous) {
            this.previous = previous;
        }
        
        @Override
        public void checkPermission(Permission perm) {
            //meh
        }
        
        @Override
        public void checkPermission(Permission perm, Object context) {
            //meh
        }
        
        @Override
        public void checkExit(int status) {
            super.checkExit(status);
            throw new ExitInvokedException(status);
        }
    }
    
    @SuppressWarnings("serial")
    private static class ExitInvokedException extends RuntimeException {
        private final int status;
        
        private ExitInvokedException(int status) {
            this.status = status;
        }
    }
}
