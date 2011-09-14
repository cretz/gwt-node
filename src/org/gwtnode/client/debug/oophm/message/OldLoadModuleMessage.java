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
package org.gwtnode.client.debug.oophm.message;

import org.gwtnode.client.debug.oophm.OophmBufferBuilder;
import org.gwtnode.client.debug.oophm.OophmStream;
import org.gwtnode.client.node.buffer.Buffer;

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
}
