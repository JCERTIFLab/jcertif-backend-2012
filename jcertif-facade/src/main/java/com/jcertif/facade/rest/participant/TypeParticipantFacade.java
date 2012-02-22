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

import com.jcertif.bo.participant.TypeParticipant;
import com.jcertif.facade.Facade;
import com.jcertif.service.api.participant.TypeParticipantService;
import com.sun.jersey.api.spring.Autowire;

/**
 * Facade for the {@link TypeParticipant}.
 * 
 * @author rossi.oddet
 */
@Path("typeparticipant")
@Service
@Autowire
public class TypeParticipantFacade extends Facade {

	@Autowired
	private TypeParticipantService service;

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(FINDALL_SUFFIX)
	public List<TypeParticipant> findAll() {
		List<TypeParticipant> typeParticipantList = service.findAll();
		return typeParticipantList;
	}

}
