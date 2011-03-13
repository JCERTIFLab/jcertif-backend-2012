/**
 * 
 */
package com.jcertif.facade.participant;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.participant.Participant;
import com.jcertif.dao.api.participant.ParticipantDAO;
import com.jcertif.facade.AbstractFacade;
import com.jcertif.service.api.participant.ParticipantService;
import com.jcertif.service.mail.CSenderService;
import com.sun.jersey.api.spring.Autowire;

/**
 * Facade for the {@link ParticipantDAO}.
 * 
 * @author Bernard Adanlessossi
 */
@Path("participant")
@Service
@Autowire
public class ParticipantFacade extends
        AbstractFacade<ParticipantService, Participant, Long> {
	
	@Autowired
    private CSenderService cSenderService;

	@Autowired
	private ParticipantService participantService;

	@Override
	public ParticipantService getService() {
		return participantService;
	}

	@Override
	public void setService(ParticipantService service) {
		this.participantService = service;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(CREATE_SUFFIX)
	public Participant create(Participant entity) {
		Participant part = super.create(entity);
		cSenderService.sendAddParticipantConfirmation(entity);
		return part;
	}
	
	
}
