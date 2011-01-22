/**
 * 
 */
package com.jcertif.facade.participant;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.participant.Participant;
import com.jcertif.dao.api.participant.ParticipantDAO;
import com.jcertif.facade.AbstractFacade;
import com.jcertif.service.participant.ParticipantService;
import com.sun.jersey.api.spring.Autowire;

/**
 * Facade for the {@link ParticipantDAO}.
 * 
 * @author Bernard Adanlessossi
 */
@Path("/participants")
@Service
@Autowire
public class ParticipantFacade extends AbstractFacade<ParticipantService, Participant, Long> {

	private static final Logger LOG = LoggerFactory
	        .getLogger(ParticipantFacade.class);

	@Autowired
	private ParticipantService participantService;

	/**
	 * Creates a new {@link Participant} in the database.
	 * 
	 * @param participant
	 *            the participant
	 * @return the newly created {@link Participant}
	 */
	@PUT
	@Path("/participant")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Participant createParticipant(Participant participant) {

		LOG.debug("Creating a new Participant with Name: {}",
		        participant.getPrenom() + " " + participant.getNom());
		return participantService.save(participant);
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("/participant/{id}")
	/**
	 * Searches for a participant by its key.
	 */
	public Participant getParticipant(@PathParam("id") Long key) {
		LOG.debug("Retrieving the participant with key: {}", key);
		return participantService.findById(key);
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("/allparticipants")
	/**
	 * Retrieves the list of all participants.
	 */
	public List<Participant> findAllParticipants() {
		LOG.debug("Retrieving the list of all participants");
		return participantService.findAll();
	}

	@PUT
	@Path("/updateparticipant")
	/**
	 * Updates the given participant.
	 */
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Participant updateParticipant(Participant participant) {
		LOG.debug("Updating the participant with key: {}", participant.getId());
		return participantService.update(participant);
	}

	@DELETE
	@Path("/deleteparticipant")
	/**
	 * Deletes the participant.
	 */
	public void deleteParticipant(Participant participant) {
		LOG.debug("Deleting the participant with key: {}", participant.getId());
		participantService.remove(participant);
	}

	@Override
    public ParticipantService getService() {
	    return participantService;
    }

	@Override
    public void setService(ParticipantService service) {
	    this.participantService = service;	    
    }
}
