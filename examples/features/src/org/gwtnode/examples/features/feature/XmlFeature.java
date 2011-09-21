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
package org.gwtnode.examples.features.feature;

import org.gwtnode.core.node.process.Process;
import org.gwtnode.examples.features.resource.Resources;

import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.XMLParser;
import com.google.inject.Inject;

/**
 * Feature to test the XML module
 *
 * @author Chad Retz
 */
public class XmlFeature implements Feature {

    @Inject
    Process process;
    
    @Inject
    Resources resources;
    
    @Override
    public void call() {
        //show the grandchild attribute
        Document doc = XMLParser.parse(resources.tempXml().getText());
        process.stdout().write("Grandchild attribute: " + doc.getElementsByTagName("grandchild").
                item(0).getAttributes().getNamedItem("attribute").getNodeValue() + "\n");
    }

}
