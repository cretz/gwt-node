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
package org.gwtnode.examples.features.client.feature;

import org.gwtnode.client.node.process.Process;
import org.gwtnode.examples.features.client.resource.Resources;

import com.google.inject.Inject;

/**
 * Feature to test a client bundle
 *
 * @author Chad Retz
 */
public class ClientBundleFeature implements Feature {

    private final Process process;
    private final Resources resources;
    
    @Inject
    public ClientBundleFeature(Process process, Resources resources) {
        this.process = process;
        this.resources = resources;
    }

    @Override
    public void call() {
        process.stdout().write("From temp.txt: " + resources.tempTxt().getText() + "\n");
    }
}
