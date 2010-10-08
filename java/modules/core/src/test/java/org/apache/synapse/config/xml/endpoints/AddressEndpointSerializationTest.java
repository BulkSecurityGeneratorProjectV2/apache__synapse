/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *   * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.synapse.config.xml.endpoints;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.synapse.config.xml.AbstractTestCase;
import org.apache.synapse.endpoints.AddressEndpoint;
import org.apache.synapse.endpoints.Endpoint;

import javax.xml.stream.XMLStreamException;
import java.util.Properties;

public class AddressEndpointSerializationTest extends AbstractTestCase {

    public void testAddressEndpointScenarioOne() throws Exception {
        String inputXML = "<endpoint  xmlns=\"http://synapse.apache.org/ns/2010/04/configuration\">" +
                "<address uri=\"http://localhost:9000/services/SimpleStockQuoteService\" />" +
                "</endpoint>" ;

        OMElement inputElement = createOMElement(inputXML);
        AddressEndpoint endpoint = (AddressEndpoint) AddressEndpointFactory.getEndpointFromElement(
                inputElement,true,null);

        OMElement serializedOut = AddressEndpointSerializer.getElementFromEndpoint(endpoint);
        assertTrue(compare(serializedOut,inputElement));

    }

    public void testAddressEndpointScenarioTwo() throws Exception {
        String inputXML =
                "<endpoint name=\"testEndpoint\" onFault=\"foo\" xmlns=" +
                        "\"http://synapse.apache.org/ns/2010/04/configuration\">" +
                "<address uri=\"http://localhost:9000/services/SimpleStockQuoteService\" >" +
                "</address>"+
                "</endpoint>" ;

        OMElement inputElement = createOMElement(inputXML);
        AddressEndpoint endpoint = (AddressEndpoint) AddressEndpointFactory.getEndpointFromElement(
                inputElement,false,null);
        OMElement serializedOut = AddressEndpointSerializer.getElementFromEndpoint(endpoint);
        
        assertTrue(compare(serializedOut,inputElement));
    }
}
