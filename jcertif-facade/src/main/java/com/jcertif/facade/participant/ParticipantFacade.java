/**
 * 
 */
package com.jcertif.facade.participant;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.participant.Participant;
import com.jcertif.dao.api.participant.ParticipantDAO;
import com.jcertif.facade.AbstractFacade;
import com.jcertif.service.api.participant.ParticipantService;
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
	private ParticipantService participantService;

	@Override
	public ParticipantService getService() {
		return participantService;
	}

	@Override
	public void setService(ParticipantService service) {
		this.participantService = service;
	}
}
