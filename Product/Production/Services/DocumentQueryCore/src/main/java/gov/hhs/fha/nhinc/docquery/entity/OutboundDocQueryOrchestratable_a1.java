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
package gov.hhs.fha.nhinc.docquery.entity;

import gov.hhs.fha.nhinc.orchestration.OutboundDelegate;
import gov.hhs.fha.nhinc.orchestration.OutboundResponseProcessor;
import gov.hhs.fha.nhinc.orchestration.AuditTransformer;
import gov.hhs.fha.nhinc.orchestration.PolicyTransformer;

import gov.hhs.fha.nhinc.common.nhinccommon.AssertionType;
import gov.hhs.fha.nhinc.common.nhinccommon.NhinTargetSystemType;

import oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryRequest;
import oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryResponse;

/**
 * OutboundDocQueryOrchestratable_a1 returns the response for the a1 specification Note that for DocQuery, the
 * individual response is a AdhocQueryResponse and the cumulative response is also a AdhocQueryResponse Currently, a0
 * and a1 specs are same for Doc Query.
 *
 * @author paul.eftis
 */
//CHECKSTYLE:OFF
public class OutboundDocQueryOrchestratable_a1 extends OutboundDocQueryOrchestratable {
//CHECKSTYLE:ON

    private AdhocQueryResponse cumulativeResponse = null;

    /**
     * Constructor overrides OutboundDocQueryOrchestratable.
     */
    public OutboundDocQueryOrchestratable_a1() {
        super();
    }

    /** Override SuperClass Constructor.
     * @param d Delegate.
     * @param p outboundResponseProcessor.
     * @param at AuditTransformer.
     * @param pt PolicyTransformer.
     * @param a assertion.
     * @param name serviceName.
     * @param t target.
     * @param req AdhocQUery Request.
     */
    //CHECKSTYLE:OFF
    public OutboundDocQueryOrchestratable_a1(OutboundDelegate d, OutboundResponseProcessor p, AuditTransformer at,
            PolicyTransformer pt, AssertionType a, String name, NhinTargetSystemType t, AdhocQueryRequest req) {
    //CHECKSTYLE:ON
        super(d, p, at, pt, a, name, t, req);
    }

    // OutboundDocQueryOrchestratable objects are run by the nhin delegate
    // so we should override this and return null so that you can't get a circular reference
    // by accident
    @Override
    public OutboundDelegate getDelegate() {
        return null;
    }

    /**
     * @return AdhocQueryResponse which is cumulativeResponse.
     */
    public AdhocQueryResponse getCumulativeResponse() {
        return cumulativeResponse;
    }

    /**
     * @param r cumulativeResponse passed.
     */
    public void setCumulativeResponse(AdhocQueryResponse r) {
        cumulativeResponse = r;
    }

}