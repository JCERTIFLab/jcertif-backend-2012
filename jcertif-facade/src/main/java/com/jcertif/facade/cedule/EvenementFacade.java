package com.jcertif.facade.cedule;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.cedule.Evenement;
import com.jcertif.bo.participant.Participant;
import com.jcertif.bo.presentation.PropositionPresentation;
import com.jcertif.facade.AbstractFacade;
import com.jcertif.service.api.cedule.EvenementService;
import com.sun.jersey.api.spring.Autowire;

/**
 * 
 * @author Chrisbel
 * 
 */
@Path("evenement")
@Service
@Autowire
public class EvenementFacade extends AbstractFacade<EvenementService, Evenement, Long> {

	@Autowired
	private EvenementService service;

	@Override
	public EvenementService getService() {
		return service;
	}

	@Override
	public void setService(EvenementService service) {
		this.service = service;
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(FINDALL_SUFFIX)
	@Override
	public List<Evenement> findAll() {
		List<Evenement> events = super.findAll();

		if (events != null && !events.isEmpty()) {
			for (Evenement event : events) {
				PropositionPresentation propo = event.getPropositionPresentation();

				if (propo != null && propo.getParticipants() != null
						&& !propo.getParticipants().isEmpty()) {
					for (Participant part : propo.getParticipants()) {
						part.setPropositionPresentations(null);
					}
				}
			}
		}
		return events;
	}
}
