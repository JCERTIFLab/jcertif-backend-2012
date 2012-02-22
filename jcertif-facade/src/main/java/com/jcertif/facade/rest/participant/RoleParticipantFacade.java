/**
 * 
 */
package com.jcertif.facade.rest.participant;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.participant.RoleParticipant;
import com.jcertif.facade.Facade;
import com.jcertif.service.api.participant.RoleParticipantService;
import com.sun.jersey.api.spring.Autowire;

/**
 * @author rossi.oddet
 * 
 */
@Path("roleparticipant")
@Service
@Autowire
public class RoleParticipantFacade extends Facade {

	@Autowired
	private RoleParticipantService service;

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(FINDALL_SUFFIX)
	public List<RoleParticipant> findAll() {
		List<RoleParticipant> typeParticipantList = service.findAll();
		return typeParticipantList;
	}

}
