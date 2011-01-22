/**
 * 
 */
package com.jcertif.facade.participant;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.participant.TypeParticipant;
import com.jcertif.facade.AbstractFacade;
import com.jcertif.service.participant.TypeParticipantService;
import com.sun.jersey.api.spring.Autowire;

/**
 * Facade for the {@link TypeParticipant}.
 * 
 * @author Bernard Adanlessossi
 */
@Path("/typeparticipant")
@Service
@Autowire
public class TypeParticipantFacade extends
        AbstractFacade<TypeParticipantService, TypeParticipant, Long> {

	@Autowired
	private TypeParticipantService service;

	@Override
	public TypeParticipantService getService() {
		return this.service;
	}

	@Override
	public void setService(TypeParticipantService service) {
		this.service = service;
	}
}
