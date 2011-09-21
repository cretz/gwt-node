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
public class LoadModuleMessage extends Message {

    private final String url;
    private final String tabKey;
    private final String sessionKey;
    private final String moduleName;
    private final String userAgent;
    
    public LoadModuleMessage(String url, String tabKey, String sessionKey,
            String moduleName, String userAgent) {
        super(MessageType.LOAD_MODULE);
        this.url = url;
        length += OophmStream.getStringByteLength(url);
        this.tabKey = tabKey;
        length += OophmStream.getStringByteLength(tabKey);
        this.sessionKey = sessionKey;
        length += OophmStream.getStringByteLength(sessionKey);
        this.moduleName = moduleName;
        length += OophmStream.getStringByteLength(moduleName);
        this.userAgent = userAgent;
        length += OophmStream.getStringByteLength(userAgent);
    }
    
    public LoadModuleMessage(OophmStream stream) {
        super(MessageType.LOAD_MODULE);
        url = stream.readString();
        length += OophmStream.getStringByteLength(url);
        tabKey = stream.readString();
        length += OophmStream.getStringByteLength(tabKey);
        sessionKey = stream.readString();
        length += OophmStream.getStringByteLength(sessionKey);
        moduleName = stream.readString();
        length += OophmStream.getStringByteLength(moduleName);
        userAgent = stream.readString();
        length += OophmStream.getStringByteLength(userAgent);
    }
    
    public String getUrl() {
        return url;
    }
    
    public String getTabKey() {
        return tabKey;
    }
    
    public String getSessionKey() {
        return sessionKey;
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
                append("url: ").
                append(url).
                append(", tabKey: ").
                append(tabKey).
                append(", sessionKey: ").
                append(sessionKey).
                append(", moduleName: ").
                append(moduleName).
                append(", userAgent: ").
                append(userAgent).toString();
    }

    @Override
    public Buffer toBuffer() {
        return new OophmBufferBuilder().
                append(type).
                append(url).
                append(tabKey).
                append(sessionKey).
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
                + ((sessionKey == null) ? 0 : sessionKey.hashCode());
        result = prime * result + ((tabKey == null) ? 0 : tabKey.hashCode());
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        result = prime * result
                + ((userAgent == null) ? 0 : userAgent.hashCode());
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
        LoadModuleMessage other = (LoadModuleMessage) obj;
        if (moduleName == null) {
            if (other.moduleName != null) {
                return false;
            }
        } else if (!moduleName.equals(other.moduleName)) {
            return false;
        }
        if (sessionKey == null) {
            if (other.sessionKey != null) {
                return false;
            }
        } else if (!sessionKey.equals(other.sessionKey)) {
            return false;
        }
        if (tabKey == null) {
            if (other.tabKey != null) {
                return false;
            }
        } else if (!tabKey.equals(other.tabKey)) {
            return false;
        }
        if (url == null) {
            if (other.url != null) {
                return false;
            }
        } else if (!url.equals(other.url)) {
            return false;
        }
        if (userAgent == null) {
            if (other.userAgent != null) {
                return false;
            }
        } else if (!userAgent.equals(other.userAgent)) {
            return false;
        }
        return true;
    }
}
