/*
 * Copyright (c) 2012, United States Government, as represented by the Secretary of Health and Human Services.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above
 *       copyright notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the documentation
 *       and/or other materials provided with the distribution.
 *     * Neither the name of the United States Government nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE UNITED STATES GOVERNMENT BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package gov.hhs.fha.nhinc.patientdiscovery._10.gateway.ws;

import gov.hhs.fha.nhinc.patientdiscovery._10.entity.EntityPatientDiscoveryImpl;

import javax.xml.ws.BindingType;
import javax.xml.ws.soap.Addressing;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hl7.v3.RespondingGatewayPRPAIN201305UV02RequestType;
import org.hl7.v3.RespondingGatewayPRPAIN201306UV02ResponseType;

/**
 * 
 * @author Neil Webb
 */

@Addressing(enabled = true)
@BindingType(value = javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class EntityPatientDiscoveryUnsecured extends PatientDiscoveryBase implements gov.hhs.fha.nhinc.entitypatientdiscovery.EntityPatientDiscoveryPortType {
    private static final Log log = LogFactory.getLog(EntityPatientDiscoveryUnsecured.class);

    public EntityPatientDiscoveryUnsecured() {
        super();
    }

    public EntityPatientDiscoveryUnsecured(PatientDiscoveryServiceFactory serviceFactory) {
        super(serviceFactory);
    }

    protected EntityPatientDiscoveryImpl getEntityPatientDiscoveryImpl() {
        return getServiceFactory().getEntityPatientDiscoveryImpl();
    }

    public RespondingGatewayPRPAIN201306UV02ResponseType respondingGatewayPRPAIN201305UV02(
            RespondingGatewayPRPAIN201305UV02RequestType respondingGatewayPRPAIN201305UV02Request) {
        log.debug("Begin EntityPatientDiscoveryUnsecured.respondingGatewayPRPAIN201305UV02...");
        RespondingGatewayPRPAIN201306UV02ResponseType response = null;

        EntityPatientDiscoveryImpl impl = getEntityPatientDiscoveryImpl();
        if (impl != null) {
            response = impl.respondingGatewayPRPAIN201305UV02(respondingGatewayPRPAIN201305UV02Request);
        }
        log.debug("End EntityPatientDiscoveryUnsecured.respondingGatewayPRPAIN201305UV02...");
        return response;
    }

}