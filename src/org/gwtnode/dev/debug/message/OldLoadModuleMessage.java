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
package org.gwtnode.dev.debug.message;

import org.gwtnode.core.node.buffer.Buffer;
import org.gwtnode.dev.debug.OophmBufferBuilder;
import org.gwtnode.dev.debug.OophmStream;

/**
 * @author Chad Retz
 */
public class OldLoadModuleMessage extends Message {

    private final int version;
    private final String moduleName;
    private final String userAgent;
    
    public OldLoadModuleMessage(int version, String moduleName,
            String userAgent) {
        super(MessageType.OLD_LOAD_MODULE);
        this.version = version;
        length += 4;
        this.moduleName = moduleName;
        length += OophmStream.getStringByteLength(moduleName);
        this.userAgent = userAgent;
        length += OophmStream.getStringByteLength(userAgent);
    }
    
    public OldLoadModuleMessage(OophmStream stream) {
        super(MessageType.OLD_LOAD_MODULE);
        version = stream.readInt();
        length += 4;
        moduleName = stream.readString();
        length += OophmStream.getStringByteLength(moduleName);
        userAgent = stream.readString();
        length += OophmStream.getStringByteLength(userAgent);
    }
    
    public int getVersion() {
        return version;
    }
    
    public String getModuleName() {
        return moduleName;
    }
    
    public String getUserAgent() {
        return userAgent;
    }

    @Override
    public String toString() {
        return super.toString(new StringBuilder()).
                append("version: ").
                append(version).
                append(", moduleName: ").
                append(moduleName).
                append(", userAgent: ").
                append(userAgent).toString();
    }

    @Override
    public Buffer toBuffer() {
        return new OophmBufferBuilder().
                append(type).
                append(version).
                append(moduleName).
                append(userAgent).toBuffer();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((moduleName == null) ? 0 : moduleName.hashCode());
        result = prime * result
                + ((userAgent == null) ? 0 : userAgent.hashCode());
        result = prime * result + version;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OldLoadModuleMessage other = (OldLoadModuleMessage) obj;
        if (moduleName == null) {
            if (other.moduleName != null) {
                return false;
            }
        } else if (!moduleName.equals(other.moduleName)) {
            return false;
        }
        if (userAgent == null) {
            if (other.userAgent != null) {
                return false;
            }
        } else if (!userAgent.equals(other.userAgent)) {
            return false;
        }
        if (version != other.version) {
            return false;
        }
        return true;
    }
}
