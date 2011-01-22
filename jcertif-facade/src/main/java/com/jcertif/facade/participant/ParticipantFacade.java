/**
 * 
 */
package com.jcertif.facade.participant;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	@Path("/participant")
	public Participant createParticipant(Participant participant) {

		LOG.debug("Creating a new Participant with Name: {}",
		        participant.getPrenom() + " " + participant.getNom());
		return participantService.save(participant);
	}

	/**
	 * Searches for a participant by its key.
	 */
	@Path("/participant/{id}")
	public Participant getParticipant(@PathParam("id") Long key) {
		LOG.debug("Retrieving the participant with key: {}", key);
		return participantService.findById(key);
	}

	/**
	 * Retrieves the list of all participants.
	 */
	@Path("/allparticipants")
	public List<Participant> findAllParticipants() {
		LOG.debug("Retrieving the list of all participants");
		return participantService.findAll();
	}
	
	/**
	 * Updates the given participant.
	 */
	@Path("/updateparticipant")
	public Participant updateParticipant(Participant participant) {
		LOG.debug("Updating the participant with key: {}", participant.getId());
		return participantService.update(participant);
	}

	/**
	 * Deletes the participant.
	 */
	@Path("/deleteparticipant")
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
