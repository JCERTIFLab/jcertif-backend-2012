/**
 * 
 */
package com.jcertif.facade;

import java.util.List;
import java.util.Set;

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

import com.jcertif.bo.CeduleParticipant;
import com.jcertif.bo.Conference;
import com.jcertif.bo.Participant;
import com.jcertif.bo.RoleParticipant;
import com.jcertif.dao.ParticipantDAO;
import com.jcertif.service.participant.ParticipantService;
import com.sun.jersey.api.spring.Autowire;
import com.sun.jersey.spi.inject.Inject;

/**
 * Facade for the {@link ParticipantDAO}.
 * 
 * @author Bernard Adanlessossi
 */
@Path("/participants")
@Service
@Autowire
public class ParticipantFacade {
	
	private static final Logger LOG = LoggerFactory.getLogger(ParticipantFacade.class);
	
	@Autowired
	private ParticipantService participantService;

	/**
	 * Creates a new {@link Participant} in the database.
	 * 
	 * @param id
	 *            the id
	 * @param dateinscription
	 *            the registration date
	 * @param salutation
	 *            the salutation
	 * @param specialite
	 *            the speciality
	 * @param prenom
	 *            the first name
	 * @param nom
	 *            the last name
	 * @param sexe
	 *            the sex
	 * @param email
	 *            the email
	 * @param presentationsoumise
	 *            the submitted paper
	 * @param cvsoumis
	 *            the submitted curriculum
	 * @param details
	 *            the details
	 * @param roleparticipant
	 *            the role
	 * @param conference
	 *            the conference
	 * @param ceduleparticipants
	 *            the schedule
	 * @return the newly created {@link Participant}
	 */
	@PUT
	@Path("/participant/{id}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Participant createParticipant(Participant participant) {

		LOG.debug("Creating a new Participant with Name: {}", participant.getPrenom() + " " + participant.getNom());
		return participantService.createParticipant(participant);
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
	@Path("/list")
	/**
	 * Retrieves the list of all participants.
	 */
	public List<Participant> findAllParticipants() {
		LOG.debug("Retrieving the list of all participants");
		return participantService.findAll();
	}

	@PUT
	@Path("/participant/update")
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
	@Path("/participant/delete")
	/**
	 * Deletes the participant.
	 */
	public void deleteParticipant(Participant participant) {
		LOG.debug("Deleting the participant with key: {}", participant.getId());
		participantService.remove(participant);
	}
}
