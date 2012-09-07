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
package gov.hhs.fha.nhinc.docsubmission.adapter.deferred.request.error;

import gov.hhs.fha.nhinc.common.nhinccommon.AssertionType;
import gov.hhs.fha.nhinc.common.nhinccommonadapter.AdapterProvideAndRegisterDocumentSetRequestErrorSecuredType;
import gov.hhs.fha.nhinc.common.nhinccommonadapter.AdapterProvideAndRegisterDocumentSetRequestErrorType;
import gov.hhs.fha.nhinc.messaging.server.BaseService;
import gov.hhs.healthit.nhin.XDRAcknowledgementType;
import ihe.iti.xds_b._2007.ProvideAndRegisterDocumentSetRequestType;

import javax.xml.ws.WebServiceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author JHOPPESC
 */
public class AdapterXDRSecuredRequestErrorImpl extends BaseService {
    private Log log = null;

    public AdapterXDRSecuredRequestErrorImpl() {
        log = createLogger();
    }

    protected Log createLogger() {
        return LogFactory.getLog(getClass());
    }

    public XDRAcknowledgementType provideAndRegisterDocumentSetBRequestError(
            AdapterProvideAndRegisterDocumentSetRequestErrorSecuredType body, WebServiceContext context) {
        log.debug("Begin AdapterXDRSecuredRequestErrorImpl.provideAndRegisterDocumentSetBRequestError(secured)");
        XDRAcknowledgementType response = null;

        ProvideAndRegisterDocumentSetRequestType request = null;
        String errorMessage = null;
        AssertionType assertion = null;
        if (body != null) {
            request = body.getProvideAndRegisterDocumentSetRequest();
            errorMessage = body.getErrorMsg();
        }
        assertion = getAssertion(context, assertion);
        response = provideAndRegisterDocumentSetBRequestError(request, errorMessage, assertion);

        log.debug("End AdapterXDRSecuredRequestErrorImpl.provideAndRegisterDocumentSetBRequestError(secured)");
        return response;
    }

    public XDRAcknowledgementType provideAndRegisterDocumentSetBRequestError(
            AdapterProvideAndRegisterDocumentSetRequestErrorType body, WebServiceContext context) {
        log.debug("Begin AdapterXDRSecuredRequestErrorImpl.provideAndRegisterDocumentSetBRequestError(unsecured)");
        XDRAcknowledgementType response = null;

        ProvideAndRegisterDocumentSetRequestType request = null;
        String errorMessage = null;
        AssertionType assertion = null;
        if (body != null) {
            request = body.getProvideAndRegisterDocumentSetRequest();
            errorMessage = body.getErrorMsg();
            assertion = body.getAssertion();
        }
        assertion = getAssertion(context, assertion);
        response = provideAndRegisterDocumentSetBRequestError(request, errorMessage, assertion);

        log.debug("End AdapterXDRSecuredRequestErrorImpl.provideAndRegisterDocumentSetBRequestError(unsecured)");
        return response;
    }

    protected XDRAcknowledgementType provideAndRegisterDocumentSetBRequestError(
            ProvideAndRegisterDocumentSetRequestType request, String errorMessage, AssertionType assertion) {
        return new AdapterDocSubmissionDeferredRequestErrorOrchImpl().provideAndRegisterDocumentSetBRequestError(
                request, errorMessage, assertion);
    }
}