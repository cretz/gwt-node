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
public class LoadJsniMessage extends Message {

    private final String jsCode;
    
    public LoadJsniMessage(String jsCode) {
        super(MessageType.LOAD_JSNI);
        this.jsCode = jsCode;
        length += OophmStream.getStringByteLength(jsCode);
    }
    
    public LoadJsniMessage(OophmStream stream) {
        super(MessageType.LOAD_JSNI);
        jsCode = stream.readString();
        length += OophmStream.getStringByteLength(jsCode);
    }
    
    public String getJsCode() {
        return jsCode;
    }

    @Override
    public String toString() {
        return super.toString(new StringBuilder()).
                append("jsCodeLength: ").
                append(jsCode.length()).toString();
    }

    @Override
    public Buffer toBuffer() {
        return new OophmBufferBuilder().
                append(type).
                append(jsCode).toBuffer();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((jsCode == null) ? 0 : jsCode.hashCode());
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
        LoadJsniMessage other = (LoadJsniMessage) obj;
        if (jsCode == null) {
            if (other.jsCode != null) {
                return false;
            }
        } else if (!jsCode.equals(other.jsCode)) {
            return false;
        }
        return true;
    }
}
