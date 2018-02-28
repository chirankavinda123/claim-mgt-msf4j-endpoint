package org.wso2.carbon.identity.claim.mgt.endpoint;

import org.wso2.carbon.identity.claim.metadata.mgt.exception.ClaimMetadataException;
import org.wso2.carbon.identity.claim.mgt.endpoint.dto.LocalClaimDTO;
import org.wso2.msf4j.Request;

import javax.ws.rs.core.Response;

public abstract class AttributesApiService {
    public abstract Response addLocalClaim(LocalClaimDTO localClaim
  ,Request request) throws NotFoundException, ClaimMetadataException;
    public abstract Response getLocalClaims( Request request) throws NotFoundException, ClaimMetadataException;
    public abstract Response removeLocalClaim(String localClaimId
  ,Request request) throws NotFoundException;
    public abstract Response updateLocalClaim(String localClaimId
 ,LocalClaimDTO localClaim
  ,Request request) throws NotFoundException, ClaimMetadataException;
}
