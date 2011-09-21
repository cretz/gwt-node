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
package org.gwtnode.dev.debug;

import org.gwtnode.core.node.stream.WritableStream;
import org.gwtnode.core.node.util.Util;

/**
 * Simple log implementation for the OOPHM debugger
 *
 * @author Chad Retz
 */
public class OophmLog {
    
    private final static Util util = Util.get();
    
    private final WritableStream out;
    private final Level lowestLevel;
    
    public OophmLog(WritableStream out, Level lowestLevel) {
        this.out = out;
        this.lowestLevel = lowestLevel;
    }
    
    public Level getLowestLevel() {
        return lowestLevel;
    }
    
    public boolean isDebugEnabled() {
        return lowestLevel.ordinal() <= Level.DEBUG.ordinal();
    }
    
    public boolean isInfoEnabled() {
        return lowestLevel.ordinal() <= Level.INFO.ordinal();
    }
    
    public boolean isWarnEnabled() {
        return lowestLevel.ordinal() <= Level.WARN.ordinal();
    }
    
    public boolean isErrorEnabled() {
        return lowestLevel.ordinal() <= Level.ERROR.ordinal();
    }
    
    public void log(Level level, Object... args) {
        if (lowestLevel.ordinal() <= level.ordinal()) {
            out.write(level + " - " + util.format(args) + "\n");
        }
    }
    
    public void debug(Object... args) {
        log(Level.DEBUG, args);
    }
    
    public void info(Object... args) {
        log(Level.INFO, args);
    }
    
    public void warn(Object... args) {
        log(Level.WARN, args);
    }
    
    public void error(Object... args) {
        log(Level.ERROR, args);
    }
    
    public static enum Level {
        DEBUG,
        INFO,
        WARN,
        ERROR
    }
}
