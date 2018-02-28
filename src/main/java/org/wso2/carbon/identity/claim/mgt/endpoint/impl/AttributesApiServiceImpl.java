/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.carbon.identity.claim.mgt.endpoint.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.context.CarbonContext;
import org.wso2.carbon.context.PrivilegedCarbonContext;
import org.wso2.carbon.identity.claim.metadata.mgt.ClaimMetadataManagementService;
import org.wso2.carbon.identity.claim.metadata.mgt.exception.ClaimMetadataException;
import org.wso2.carbon.identity.claim.metadata.mgt.model.AttributeMapping;
import org.wso2.carbon.identity.claim.metadata.mgt.model.LocalClaim;
import org.wso2.carbon.identity.claim.mgt.endpoint.AttributesApiService;
import org.wso2.carbon.identity.claim.mgt.endpoint.NotFoundException;
import org.wso2.carbon.identity.claim.mgt.endpoint.dto.AttributeMappingDTO;
import org.wso2.carbon.identity.claim.mgt.endpoint.dto.LocalClaimDTO;
import org.wso2.carbon.identity.claim.mgt.endpoint.util.ClaimMgtUtils;
import org.wso2.msf4j.Request;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class AttributesApiServiceImpl extends AttributesApiService {

    private static final Log log = LogFactory.getLog(AttributesApiServiceImpl.class);

    private static ClaimMetadataManagementService getClaimManagementService() {
        ClaimMetadataManagementService claimMgtService = (ClaimMetadataManagementService) PrivilegedCarbonContext
                .getThreadLocalCarbonContext().getOSGiService(ClaimMetadataManagementService.class, null);

        return claimMgtService;
    }

    @Override
    public Response addLocalClaim(LocalClaimDTO localClaimDTO, Request request) throws NotFoundException,
            ClaimMetadataException {


        String tenantDomain = PrivilegedCarbonContext.getThreadLocalCarbonContext().getTenantDomain();

        LocalClaim localClaim = new LocalClaim(localClaimDTO.getLocalClaimURI());

        List<AttributeMapping> attributeMappings = new ArrayList<>();

        for (AttributeMappingDTO attributeMappingDTO : localClaimDTO.getAttributeMappings()) {
            attributeMappings.add(new AttributeMapping(attributeMappingDTO.getUserStoreDomain(),
                    attributeMappingDTO.getAttributeName()));
        }
        localClaim.setMappedAttributes(attributeMappings);

        try {
            getClaimManagementService().addLocalClaim(localClaim, tenantDomain);
            return Response.status(Response.Status.CREATED).entity(localClaim).build();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw new ClaimMetadataException(e.getMessage(), e);
        }
    }

    @Override
    public Response getLocalClaims(Request request) throws NotFoundException, ClaimMetadataException {
        String tenantDomain = "";
        try {
            tenantDomain = PrivilegedCarbonContext.getThreadLocalCarbonContext().getTenantDomain();
            List<LocalClaim> localClaims = getClaimManagementService().getLocalClaims(tenantDomain);
            return Response.status(Response.Status.OK).entity(localClaims).build();
        } catch (Throwable e) {
            log.error("Error while fetching local claims under tenantDomain : " + tenantDomain);
            throw new ClaimMetadataException(e.getMessage(), e);
        }
    }

    @Override
    public Response removeLocalClaim(String localClaimId, Request request) throws NotFoundException {

        String tenantDomain = CarbonContext.getThreadLocalCarbonContext().getTenantDomain();
        try {
            getClaimManagementService().removeLocalClaim(localClaimId, tenantDomain);
        } catch (ClaimMetadataException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @Override
    public Response updateLocalClaim(String localClaimId, LocalClaimDTO localClaim, Request request)
            throws NotFoundException, ClaimMetadataException {

        try {
            LocalClaim claim = ClaimMgtUtils.convertLocalClaimDTOToLocalClaim(localClaim);

            String tenantDomain = CarbonContext.getThreadLocalCarbonContext().getTenantDomain();

            getClaimManagementService().updateLocalClaim(claim, tenantDomain);
            return Response.status(Response.Status.OK).entity(claim).build();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw new ClaimMetadataException(e.getMessage(), e);
        }
    }
}
