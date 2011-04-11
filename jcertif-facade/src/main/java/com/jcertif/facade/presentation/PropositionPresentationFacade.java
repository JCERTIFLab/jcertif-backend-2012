/**
 * 
 */
package com.jcertif.facade.presentation;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.participant.Participant;
import com.jcertif.bo.presentation.PropositionPresentation;
import com.jcertif.facade.AbstractFacade;
import com.jcertif.service.api.presentation.PropositionPresentationService;
import com.jcertif.service.mail.CSenderService;
import com.sun.jersey.api.spring.Autowire;

/**
 * @author rossi
 * 
 */
@Path("propositionpresentation")
@Service
@Autowire
public class PropositionPresentationFacade extends
		AbstractFacade<PropositionPresentationService, PropositionPresentation, Long> {

	@Autowired
	private PropositionPresentationService service;

	@Autowired
	private CSenderService cSenderService;

	@Override
	public PropositionPresentationService getService() {
		return service;
	}

	@Override
	public void setService(PropositionPresentationService service) {
		this.service = service;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(CREATE_SUFFIX)
	@Override
	public PropositionPresentation create(PropositionPresentation clientPropo) {
		Set<Participant> participantSet = clientPropo.getParticipants();
		// TODO résoudre le bug de la sauvegarde
		clientPropo.setParticipants(null);
		PropositionPresentation proposition = super.create(clientPropo);
		clientPropo.setParticipants(participantSet);
		cSenderService.sendAddPropositionConfirmation(clientPropo);
		return proposition;
	}

}
