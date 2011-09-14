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
package org.gwtnode.examples.oophmproxy.client.message;

/**
 * @author Chad Retz
 */
public class CheckVersionsMessage extends Message {

    private final int minVersion;
    private final int maxVersion;
    private final String hostedHtmlVersion;
    
    public CheckVersionsMessage(MessageType type, BufferStream stream) {
        super(type);
        minVersion = stream.readInt();
        length += 4;
        maxVersion = stream.readInt();
        length += 4;
        hostedHtmlVersion = stream.readString();
        length += BufferStream.getStringByteLength(hostedHtmlVersion);
    }

    @Override
    public String toString() {
        return super.toString(new StringBuilder()).
                append("minVersion: ").
                append(minVersion).
                append(", maxVersion: ").
                append(maxVersion).
                append(", hostedHtmlVersion: ").
                append(hostedHtmlVersion).toString();
    }

}
