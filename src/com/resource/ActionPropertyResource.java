package com.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.model.ActionProperty;
import com.service.ActionPropertyService;

@Path("/properties")
@Api(value = "H2Configurations", description = "Opereations with H2 Database")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ActionPropertyResource implements IActionPropertyResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get All Properties", response = ActionProperty.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Could not connect to the H2 Database") })
	@Override
	public List<ActionProperty> getAllProperties() {
		List<ActionProperty> propertyList = null;
		try {
			propertyList = ActionPropertyService.getInstance()
					.getAllProperties();
		} catch (Exception e) {
			System.out.println("Exception = " + e);
		}
		return propertyList;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Create New Property", response = ActionProperty.class)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid Property Supplied"),
			@ApiResponse(code = 404, message = "Could not connect to the service") })
	@Override
	public ActionProperty createProperty(
			@ApiParam(value = "Property to be created in the H2 DB", required = true) ActionProperty newProperty) {
		try {
			ActionPropertyService.getInstance().createProperty(newProperty);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception = " + e);
			e.printStackTrace();
		}
		return newProperty;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Update Existing Property", response = ActionProperty.class)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid Property Supplied"),
			@ApiResponse(code = 404, message = "Could not connect to the service") })
	@Override
	public ActionProperty updateProperty(
			@ApiParam(value = "Property to be updated in the H2 DB, matched in the DB using the property's ID.", required = true) ActionProperty property) {
		try {
			ActionPropertyService.getInstance().updateProperty(property);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception = " + e);
			e.printStackTrace();
		}
		return property;
	}

	@DELETE
	@Path("/deleteId")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Delete Property", response = ActionProperty.class)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid ID Supplied"),
			@ApiResponse(code = 404, message = "Could not connect to the service") })
	@Override
	public Response removeProperty(
			@ApiParam(value = "id of the property to be deleted", required = true) @QueryParam("id") String propertyId) {
		try {
			int id = Integer.parseInt(propertyId);
			ActionPropertyService.getInstance().removeProperty(id);
			return Response.ok().build();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception = " + e);
			e.printStackTrace();
		}
		return null;
	}

}
