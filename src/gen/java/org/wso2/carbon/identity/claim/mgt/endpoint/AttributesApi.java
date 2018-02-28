package org.wso2.carbon.identity.claim.mgt.endpoint;


import io.swagger.annotations.ApiParam;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.wso2.carbon.identity.claim.metadata.mgt.exception.ClaimMetadataException;
import org.wso2.carbon.identity.claim.mgt.endpoint.dto.LocalClaimDTO;
import org.wso2.carbon.identity.claim.mgt.endpoint.factories.AttributesApiServiceFactory;
import org.wso2.msf4j.Microservice;
import org.wso2.msf4j.Request;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component(
        name = "org.wso2.carbon.identity.claim.mgt.endpoint.AttributesApi",
        service = Microservice.class,
        immediate = true
)
@Path("/api/identity/claim/mgt/v1.[\\d]+/attributes")
@Consumes({"application/json"})
@Produces({"application/json"})
@ApplicationPath("/attributes")
@io.swagger.annotations.Api(description = "the attributes API")
public class AttributesApi implements Microservice {
    private final AttributesApiService delegate = AttributesApiServiceFactory.getAttributesApi();

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Add new local claim", notes = "", response = void.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 201, message = "Local Claim Added Successfully", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 409, message = "Confict Occurred", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = void.class)})
    public Response addLocalClaim(@ApiParam(value = "Local Claim to be added.", required = true) LocalClaimDTO localClaim
            , @Context Request request)
            throws NotFoundException, ClaimMetadataException {

        return delegate.addLocalClaim(localClaim, request);
    }

    @GET
    @Path("/testing")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Get Available Local Claims.", notes = "", response = LocalClaimDTO.class, responseContainer = "List", tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Local Claims Retrieved Successfully", response = LocalClaimDTO.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = LocalClaimDTO.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found", response = LocalClaimDTO.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = LocalClaimDTO.class, responseContainer = "List")})
    public Response getLocalClaims(@Context Request request)
            throws NotFoundException, ClaimMetadataException {

        return delegate.getLocalClaims(request);
    }

    @DELETE
    @Path("/{local-claim-id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Delete Local Claim", notes = "", response = void.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 204, message = "Local Claim deleted Successfully.", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid user supplied", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = void.class)})
    public Response removeLocalClaim(@ApiParam(value = "Local claim URI that needs to be deleted.", required = true) @PathParam("local-claim-id") String localClaimId
            , @Context Request request)
            throws NotFoundException {

        return delegate.removeLocalClaim(localClaimId, request);
    }

    @PUT
    @Path("/{local-claim-id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Update a Local Claim.", notes = "", response = void.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Updated", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 409, message = "Confict Occurred", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = void.class)})
    public Response updateLocalClaim(@ApiParam(value = "URI of the local claim that needs to be updated.", required = true) @PathParam("local-claim-id") String localClaimId
            , @ApiParam(value = "Local Claim with new properties.") LocalClaimDTO localClaim
            , @Context Request request)
            throws NotFoundException, ClaimMetadataException {

        return delegate.updateLocalClaim(localClaimId, localClaim, request);
    }


}
