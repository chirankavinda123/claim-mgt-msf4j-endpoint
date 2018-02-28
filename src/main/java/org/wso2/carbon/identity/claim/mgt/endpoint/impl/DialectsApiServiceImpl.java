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
import org.wso2.carbon.identity.claim.metadata.mgt.model.ClaimDialect;
import org.wso2.carbon.identity.claim.metadata.mgt.model.ExternalClaim;
import org.wso2.carbon.identity.claim.mgt.endpoint.*;
import org.wso2.carbon.identity.claim.mgt.endpoint.dto.*;
import org.wso2.carbon.identity.claim.mgt.endpoint.NotFoundException;
import org.wso2.carbon.identity.claim.mgt.endpoint.util.ClaimMgtUtils;
import org.wso2.msf4j.Request;

import javax.ws.rs.core.Response;
import java.util.List;

public class DialectsApiServiceImpl extends DialectsApiService {

    private static final Log log = LogFactory.getLog(AttributesApiServiceImpl.class);

    private static ClaimMetadataManagementService getClaimManagementService() {
        ClaimMetadataManagementService claimMgtService = (ClaimMetadataManagementService) PrivilegedCarbonContext
                .getThreadLocalCarbonContext().getOSGiService(ClaimMetadataManagementService.class, null);

        return claimMgtService;
    }

    @Override
    public Response addClaimDialect(ClaimDialectDTO claimDialectDTO, Request request) throws NotFoundException, ClaimMetadataException {

        try {
            ClaimDialect dialect = ClaimMgtUtils.convertClaimDialectDTOToClaimDialect(claimDialectDTO);
            String tenantDomain = CarbonContext.getThreadLocalCarbonContext().getTenantDomain();

            getClaimManagementService().addClaimDialect(dialect, tenantDomain);
            return Response.status(Response.Status.CREATED).entity(dialect).build();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw new ClaimMetadataException(e.getMessage(), e);
        }
    }

    @Override
    public Response addExternalClaim(String dialectId, ExternalClaimDTO externalClaimDTO, Request request)
            throws NotFoundException, ClaimMetadataException {

        try {
            ExternalClaim claim = ClaimMgtUtils.convertExternalClaimDTOToExternalClaim(dialectId, externalClaimDTO);

            String tenantDomain = CarbonContext.getThreadLocalCarbonContext().getTenantDomain();

            getClaimManagementService().addExternalClaim(claim, tenantDomain);
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw new ClaimMetadataException(e.getMessage(), e);
        }
    }

    @Override
    public Response getClaimDialects(Request request) throws NotFoundException, ClaimMetadataException {

        try {
            String tenantDomain = CarbonContext.getThreadLocalCarbonContext().getTenantDomain();

            List<ClaimDialect> claimDialectList = getClaimManagementService().getClaimDialects(tenantDomain);

            ClaimDialect[] claimDialects = claimDialectList.toArray(new ClaimDialect[0]);
            ClaimDialectDTO[] claimDialectsDTO = ClaimMgtUtils.convertClaimDialectsToClaimDialectDTOs(claimDialects);
            return Response.status(Response.Status.OK).entity(claimDialectsDTO).build();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw new ClaimMetadataException(e.getMessage(), e);
        }
    }

    @Override
    public Response getExternalClaims(String dialectId, Request request) throws NotFoundException,
            ClaimMetadataException {

        try {
            String tenantDomain = CarbonContext.getThreadLocalCarbonContext().getTenantDomain();

            List<ExternalClaim> externalClaimList = getClaimManagementService().
                    getExternalClaims(dialectId, tenantDomain);

            ExternalClaim[] externalClaims = externalClaimList.toArray(new ExternalClaim[0]);
            ExternalClaimDTO[] externalClaimDTO = ClaimMgtUtils.convertExternalClaimsToExternalClaimDTOs(externalClaims);
            return Response.status(Response.Status.OK).entity(externalClaimDTO).build();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw new ClaimMetadataException(e.getMessage(), e);
        }
    }

    @Override
    public Response removeClaimDialect(String id, Request request) throws NotFoundException, ClaimMetadataException {
        try {
            String tenantDomain = CarbonContext.getThreadLocalCarbonContext().getTenantDomain();

            getClaimManagementService().removeClaimDialect(new ClaimDialect(id), tenantDomain);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw new ClaimMetadataException(e.getMessage(), e);
        }
    }

    @Override
    public Response removeExternalClaim(String dialectId, String claimId, Request request) throws NotFoundException,
            ClaimMetadataException {
        try {
            String tenantDomain = CarbonContext.getThreadLocalCarbonContext().getTenantDomain();

            getClaimManagementService().removeExternalClaim(dialectId, claimId, tenantDomain);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw new ClaimMetadataException(e.getMessage(), e);
        }
    }

    @Override
    public Response renameClaimDialect(String oldClaimDialect, ClaimDialectDTO newClaimDialectDTO, Request request)
            throws NotFoundException, ClaimMetadataException {
        try {
            ClaimDialect oldDialect = new ClaimDialect(oldClaimDialect);
            ClaimDialect newDialect = ClaimMgtUtils.convertClaimDialectDTOToClaimDialect(newClaimDialectDTO);
            String tenantDomain = CarbonContext.getThreadLocalCarbonContext().getTenantDomain();

            getClaimManagementService().renameClaimDialect(oldDialect, newDialect, tenantDomain);
            return Response.status(Response.Status.OK).entity(newDialect).build();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw new ClaimMetadataException(e.getMessage(), e);
        }
    }

    @Override
    public Response updateExternalClaim(String dialectId, String claimId, ExternalClaimDTO newExternalClaimDTO,
                                        Request request) throws NotFoundException, ClaimMetadataException {
        try {
            ExternalClaim claim = ClaimMgtUtils.convertExternalClaimDTOToExternalClaim(dialectId, newExternalClaimDTO);

            String tenantDomain = CarbonContext.getThreadLocalCarbonContext().getTenantDomain();

            getClaimManagementService().updateExternalClaim(claim, tenantDomain);
            return Response.status(Response.Status.OK).entity(claim).build();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw new ClaimMetadataException(e.getMessage(), e);
        }
    }
}
