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

import java.util.Date;

import org.gwtnode.client.node.process.Process;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.inject.Inject;

/**
 * Feature to test date formatting
 *
 * @author Chad Retz
 */
public class FormatFeature implements Feature {

    private final Process process;

    @Inject
    public FormatFeature(Process process) {
        this.process = process;
    }

    @Override
    public void call() {
        Date now = new Date();
        process.stdout().write("Showing the current date/time in a lot of ways:\n");
        for (PredefinedFormat format : PredefinedFormat.values()) {
            process.stdout().write(format.name() + ": " + 
                    DateTimeFormat.getFormat(format).format(now) + "\n");
        }
    }

}
