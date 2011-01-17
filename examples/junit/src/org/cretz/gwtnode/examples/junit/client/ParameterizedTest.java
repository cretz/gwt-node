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
package org.cretz.gwtnode.examples.junit.client;

import java.util.Arrays;

import org.cretz.gwtnode.dev.junit.NodeJsTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

@RunWith(NodeJsTestRunner.class)
public class ParameterizedTest {
    
    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[] { 1, 2, 3 },
                new Object[] { 4, 5, 9 });
    }
    
    private final int addendOne;
    private final int addendTwo;
    private final int sum;
    
    public ParameterizedTest(int addendOne, int addendTwo, int sum) {
        this.addendOne = addendOne;
        this.addendTwo = addendTwo;
        this.sum = sum;
    }
    
    @Test
    public void verifySum() {
        Assert.assertEquals(sum, addendOne + addendTwo);
    }
}
