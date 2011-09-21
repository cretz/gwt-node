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
package org.gwtnode.examples.features;

import org.gwtnode.core.node.process.Process;
import org.gwtnode.core.node.util.Util;
import org.gwtnode.examples.features.feature.ClientBundleFeature;
import org.gwtnode.examples.features.feature.FormatFeature;
import org.gwtnode.examples.features.feature.HttpFeature;
import org.gwtnode.examples.features.feature.JsonpFeature;
import org.gwtnode.examples.features.feature.LoggingFeature;
import org.gwtnode.examples.features.feature.XmlFeature;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * GIN module
 *
 * @author Chad Retz
 */
public class FeaturesModule extends AbstractGinModule {

    @Override
    protected void configure() {
        //modules
        bind(Process.class).toProvider(new Provider<Process>() {
            @Override
            public Process get() {
                return Process.get();
            }
        }.getClass());
        bind(Util.class).toProvider(new Provider<Util>() {
            @Override
            public Util get() {
                return Util.get();
            }
        }.getClass());
        
        //features
        bind(ClientBundleFeature.class).in(Singleton.class);
        bind(FormatFeature.class).in(Singleton.class);
        bind(HttpFeature.class).in(Singleton.class);
        bind(JsonpFeature.class).in(Singleton.class);
        bind(LoggingFeature.class).in(Singleton.class);
        bind(XmlFeature.class).in(Singleton.class);
    }
}
