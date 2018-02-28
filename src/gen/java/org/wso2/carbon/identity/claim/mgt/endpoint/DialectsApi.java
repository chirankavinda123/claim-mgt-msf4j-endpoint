package org.wso2.carbon.identity.claim.mgt.endpoint;


import io.swagger.annotations.ApiParam;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Deactivate;
import org.wso2.carbon.identity.claim.metadata.mgt.exception.ClaimMetadataException;
import org.wso2.carbon.identity.claim.mgt.endpoint.dto.ClaimDialectDTO;
import org.wso2.carbon.identity.claim.mgt.endpoint.dto.ErrorDTO;
import org.wso2.carbon.identity.claim.mgt.endpoint.dto.ExternalClaimDTO;
import org.wso2.carbon.identity.claim.mgt.endpoint.factories.DialectsApiServiceFactory;

import org.wso2.msf4j.Microservice;
import org.wso2.msf4j.Request;
import org.wso2.msf4j.formparam.FileInfo;
import org.wso2.msf4j.formparam.FormDataParam;
import org.osgi.service.component.annotations.Component;

import java.io.InputStream;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//@Component(
//        name = "org.wso2.carbon.identity.claim.mgt.endpoint.DialectsApi",
//        service = Microservice.class,
//        immediate = true
//)
@Path("/api/identity/claim/mgt/v1.[\\d]+/dialects")
@Consumes({"application/json"})
@Produces({"application/json"})
@ApplicationPath("/dialects")
@io.swagger.annotations.Api(description = "the dialects API")
public class DialectsApi implements Microservice {
    private final DialectsApiService delegate = DialectsApiServiceFactory.getDialectsApi();

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Add New Claim Dialect.", notes = "", response = void.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 201, message = "Claim Dialect Created Successfully", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 409, message = "Confict Occurred", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = void.class)})
    public Response addClaimDialect(@ApiParam(value = "External Claim Dialect", required = true) ClaimDialectDTO claimDialect
            , @Context Request request)
            throws NotFoundException, ClaimMetadataException {

        return delegate.addClaimDialect(claimDialect, request);
    }

    @POST
    @Path("/{dialect-id}/claims")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Add new external claim", notes = "", response = void.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 201, message = "New External Claim Added Successfully.", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 409, message = "Confict Occurred", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = void.class)})
    public Response addExternalClaim(@ApiParam(value = "URI of the external Claim Dilect.", required = true) @PathParam("dialect-id") String dialectId
            , @ApiParam(value = "URI of the external Claim to be added.", required = true) ExternalClaimDTO externalClaim
            , @Context Request request)
            throws NotFoundException, ClaimMetadataException {

        return delegate.addExternalClaim(dialectId, externalClaim, request);
    }

    @GET
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Get Available Claim Dialects.", notes = "", response = String.class, responseContainer = "List", tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Available claim Dialects retrieved successfully.", response = String.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = String.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found", response = String.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = String.class, responseContainer = "List")})
    public Response getClaimDialects(@Context Request request)
            throws NotFoundException, ClaimMetadataException {

        return delegate.getClaimDialects(request);
    }

    @GET
    @Path("/{dialect-id}/claims")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Get external claims of the given Dialect", notes = "", response = ExternalClaimDTO.class, responseContainer = "List", tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "External Claims retrieved Successfully.", response = ExternalClaimDTO.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = ExternalClaimDTO.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found", response = ExternalClaimDTO.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = ExternalClaimDTO.class, responseContainer = "List")})
    public Response getExternalClaims(@ApiParam(value = "URI of the external Claim Dilect.", required = true) @PathParam("dialect-id") String dialectId
            , @Context Request request)
            throws NotFoundException, ClaimMetadataException {

        return delegate.getExternalClaims(dialectId, request);
    }

    @DELETE
    @Path("/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Delete Claim Dialect", notes = "", response = void.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 204, message = "Claim Dialect deleted Successfully.", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid Request", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 404, message = "Not found", response = void.class)})
    public Response removeClaimDialect(@ApiParam(value = "URI of the claim Dialect", required = true) @PathParam("id") String id
            , @Context Request request)
            throws NotFoundException, ClaimMetadataException {

        return delegate.removeClaimDialect(id, request);
    }

    @DELETE
    @Path("/{dialect-id}/claims/{claim-id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Delete external Claim", notes = "", response = void.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 204, message = "External Claim deleted Successfully.", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid Request", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 404, message = "Not found", response = void.class)})
    public Response removeExternalClaim(@ApiParam(value = "URI of the external Claim Dilect.", required = true) @PathParam("dialect-id") String dialectId
            , @ApiParam(value = "External Claim that needs to be deleted", required = true) @PathParam("claim-id") String claimId
            , @Context Request request)
            throws NotFoundException, ClaimMetadataException {

        return delegate.removeExternalClaim(dialectId, claimId, request);
    }

    @PUT
    @Path("/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Update exisiting claim dialect.", notes = "", response = void.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Claim Dialect Updated", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 409, message = "Confict Occurred", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = void.class)})
    public Response renameClaimDialect(@ApiParam(value = "URI of the Existing claim Dialect", required = true) @PathParam("id") String id
            , @ApiParam(value = "New claim dialect") ClaimDialectDTO claimDialect
            , @Context Request request)
            throws NotFoundException, ClaimMetadataException {

        return delegate.renameClaimDialect(id, claimDialect, request);
    }

    @PUT
    @Path("/{dialect-id}/claims/{claim-id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "update an external claim.", notes = "", response = void.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "External claim Updated Successfully", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 409, message = "Confict Occurred", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = void.class)})
    public Response updateExternalClaim(@ApiParam(value = "URI of the external Claim Dilect.", required = true) @PathParam("dialect-id") String dialectId
            , @ApiParam(value = "URI of External Claim that needs to be updated", required = true) @PathParam("claim-id") String claimId
            , @ApiParam(value = "External claim object to be updated") ExternalClaimDTO externalClaim
            , @Context Request request)
            throws NotFoundException, ClaimMetadataException {

        return delegate.updateExternalClaim(dialectId, claimId, externalClaim, request);
    }
}
