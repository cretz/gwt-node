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
package org.cretz.gwtnode.examples.features.client;

import org.cretz.gwtnode.client.GwtNodeBootstrap;
import org.cretz.gwtnode.client.node.process.Process;
import org.cretz.gwtnode.examples.features.client.feature.ClientBundleFeature;
import org.cretz.gwtnode.examples.features.client.feature.FormatFeature;
import org.cretz.gwtnode.examples.features.client.resource.Resources;

import com.google.gwt.core.client.GWT;

/**
 * Entry point. This application mainly just tests known
 * modules to see if they work.
 *
 * @author Chad Retz
 */
public class Features extends GwtNodeBootstrap {

    //not working
    FeaturesGinjector ginjector = GWT.create(FeaturesGinjector.class);
    
    @Override
    public Integer main(String... args) {
        //working
        Process.get().stdout().write("\n\nClientBundle Feature:\n\n");
        new ClientBundleFeature(Process.get(), Resources.INSTANCE).call();
        Process.get().stdout().write("\n\nFormat Feature:\n\n");
        new FormatFeature(Process.get()).call();
        
        //not working
        //Process.get().stdout().write("\n\nHTTP Feature:\n\n");
        //new HttpFeature(Process.get()).call();
        //Process.get().stdout().write("\n\nJsonp Feature:\n\n");
        //new JsonpFeature(Sys.get(), Process.get()).call();
        //Process.get().stdout().write("\n\nLogging Feature:\n\n");
        //new LoggingFeature().call();
        //Process.get().stdout().write("\n\nXML Feature:\n\n");
        //new XmlFeature().call();
        return 0;
    }

}
