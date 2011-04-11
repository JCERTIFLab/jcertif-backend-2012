/**
 * 
 */
package com.jcertif.facade.presentation;

import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcertif.facade.AbstractFacade#findAll()
	 */
	@Override
	public List<PropositionPresentation> findAll() {
		List<PropositionPresentation> props = super.findAll();
		for (PropositionPresentation prop : props) {
			removeCycle(prop);
		}

		return props;
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(FINDBYID_SUFFIX)
	@Override
	public PropositionPresentation findById(@PathParam("id") Long id) {
		PropositionPresentation prop = super.findById(id);
		removeCycle(prop);
		return prop;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(CREATE_SUFFIX)
	@Override
	public PropositionPresentation create(PropositionPresentation clientPropo) {
		Set<Participant> participantSet = clientPropo.getParticipants();
		PropositionPresentation proposition = super.create(clientPropo);
		proposition = service.findById(proposition.getId());
		clientPropo.setParticipants(participantSet);
		cSenderService.sendAddPropositionConfirmation(clientPropo);
		removeCycle(proposition);
		return proposition;
	}

	private void removeCycle(PropositionPresentation prop) {
		for (Participant part : prop.getParticipants()) {
			part.setPropositionPresentations(null);
		}
	}

}
