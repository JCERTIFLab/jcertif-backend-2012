package com.jcertif.ws.participant;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

import com.jcertif.facade.ParticipantFacade;
import com.jcertif.facade.exception.ItemNotFoundException;

@Path("/users/{id}")
public class ParticipantResource {

	@GET
	@Produces("application/xml")
	public String getXML(@PathParam("id") Long id) {
		String xml = ParticipantFacade.getXML(id);
		if (xml != null) {
			return xml;
		} else {
			throw new WebApplicationException(404);
		}
	}

	@GET
	@Produces("application/json")
	public String getJSON(@PathParam("id") Long id) {
		String json = ParticipantFacade.getJSON(id);
		if (json != null) {
			return json;
		} else {
			throw new WebApplicationException(404);
		}
	}
	
	@PUT
	@Consumes("application/xml")
	@Produces("application/xml")
	public String updateUser(@PathParam("username") String username, String representation) {
		try {
			return ParticipantFacade.update(representation);		
		} catch (ItemNotFoundException e) {
			throw new WebApplicationException(404);
		}
	}

	@DELETE
	public void deleteUser(@PathParam("id") Long id) {
		try {
			ParticipantFacade.delete(id);
		} catch (ItemNotFoundException e) {
			throw new WebApplicationException(404);
		}
	}
}
