package org.wso2.carbon.identity.claim.mgt.endpoint;

import org.wso2.carbon.identity.claim.metadata.mgt.exception.ClaimMetadataException;
import org.wso2.carbon.identity.claim.mgt.endpoint.*;
import org.wso2.carbon.identity.claim.mgt.endpoint.dto.*;

import org.wso2.msf4j.formparam.FormDataParam;
import org.wso2.msf4j.formparam.FileInfo;
import org.wso2.msf4j.Request;

import org.wso2.carbon.identity.claim.mgt.endpoint.dto.ClaimDialectDTO;
import org.wso2.carbon.identity.claim.mgt.endpoint.dto.ErrorDTO;
import org.wso2.carbon.identity.claim.mgt.endpoint.dto.ExternalClaimDTO;

import java.util.List;
import org.wso2.carbon.identity.claim.mgt.endpoint.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

public abstract class DialectsApiService {
    public abstract Response addClaimDialect(ClaimDialectDTO claimDialect
  ,Request request) throws NotFoundException, ClaimMetadataException;
    public abstract Response addExternalClaim(String dialectId
 ,ExternalClaimDTO externalClaim
  ,Request request) throws NotFoundException, ClaimMetadataException;
    public abstract Response getClaimDialects( Request request) throws NotFoundException, ClaimMetadataException;
    public abstract Response getExternalClaims(String dialectId
  ,Request request) throws NotFoundException, ClaimMetadataException;
    public abstract Response removeClaimDialect(String id
  ,Request request) throws NotFoundException, ClaimMetadataException;
    public abstract Response removeExternalClaim(String dialectId
 ,String claimId
  ,Request request) throws NotFoundException, ClaimMetadataException;
    public abstract Response renameClaimDialect(String id
 ,ClaimDialectDTO claimDialect
  ,Request request) throws NotFoundException, ClaimMetadataException;
    public abstract Response updateExternalClaim(String dialectId
 ,String claimId
 ,ExternalClaimDTO externalClaim
  ,Request request) throws NotFoundException, ClaimMetadataException;
}
