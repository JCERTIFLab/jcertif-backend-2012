/**
 * 
 */
package com.jcertif.facade.participant;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.participant.Participant;
import com.jcertif.bo.presentation.PropositionPresentation;
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
public class ParticipantFacade extends AbstractFacade<ParticipantService, Participant, Long> {

	@Autowired
	private CSenderService cSenderService;

	@Autowired
	private ParticipantService participantService;

	// @Autowired
	// private ServletContext context;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(cSenderService).append(participantService).toHashCode();
	}

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

	@POST
	@Consumes({ MediaType.APPLICATION_OCTET_STREAM })
	@Path("store/{role}/{id}/{ext}")
	public void store(final InputStream fileStream, @PathParam(value = "id") Long idParticipant,
			@PathParam(value = "role") String codeRole, @PathParam(value = "ext") String ext)
			throws IOException {
		participantService.saveInFile(fileStream, idParticipant, codeRole, ext);
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("/listByEmail/{email}")
	public List<Participant> findBy(@PathParam(value = "email") String email) {
		List<Participant> participants = participantService.findByEmail(email);
		removeCycle(participants);
		return participants;
	}
	
	@POST
	@Path("/generateNewPassword/{email}")
	public void generateNewPassword(@PathParam(value = "email") String email) {
	    participantService.generateNewPassword(email);
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(FINDALL_SUFFIX)
	@Override
	public List<Participant> findAll() {
		List<Participant> participants = participantService.findAllWithProposition();
		removeCycle(participants);
		return participants;
	}

	/**
	 * @param participants
	 */
	private void removeCycle(List<Participant> participants) {
		if (participants != null && !participants.isEmpty()) {
			for (Participant participant : participants) {
		removeCycle(participant);
			}
		}
	}

    private void removeCycle(Participant participant) {
	if (participant.getPropositionPresentations() != null
			&& !participant.getPropositionPresentations().isEmpty()) {
		for (PropositionPresentation prop : participant.getPropositionPresentations()) {
			prop.setParticipants(null);
		}
	}
    }

}
