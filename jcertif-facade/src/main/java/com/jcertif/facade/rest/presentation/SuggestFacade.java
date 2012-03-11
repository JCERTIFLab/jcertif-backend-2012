package com.jcertif.facade.rest.presentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.presentation.PropositionPresentation;
import com.jcertif.facade.Facade;
import com.jcertif.facade.model.participant.Suggest;
import com.jcertif.service.api.presentation.PropositionPresentationService;
import com.jcertif.service.mail.CSenderService;
import com.sun.jersey.api.spring.Autowire;

/**
 * @author rossi.oddet
 * 
 */
@Path("suggest")
@Service
@Autowire
public class SuggestFacade extends Facade {

	@Autowired
	private PropositionPresentationService service;

	@Autowired
	private CSenderService cSenderService;

	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(CREATE_SUFFIX)
	public Suggest create(Suggest suggest) {
		PropositionPresentation proposition = service.save(suggest.toProposition());
		cSenderService.sendAddPropositionConfirmation(proposition);
		return new Suggest(proposition);

	}

}
