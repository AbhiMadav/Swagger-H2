package com.resource;

import java.util.List;

import javax.websocket.server.PathParam;
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

import com.model.*;

public interface IActionPropertyResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ActionProperty> getAllProperties();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ActionProperty createProperty(ActionProperty newProperty);
	
	@PUT
    //@Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ActionProperty updateProperty(ActionProperty property);
	
	@DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeProperty(@javax.ws.rs.PathParam("id") String propertyId);
}	
