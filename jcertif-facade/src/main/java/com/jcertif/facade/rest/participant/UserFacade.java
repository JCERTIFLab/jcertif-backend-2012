/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.facade.rest.participant;

import java.util.Calendar;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.Adresse;
import com.jcertif.bo.conference.Conference;
import com.jcertif.bo.participant.Participant;
import com.jcertif.bo.participant.ProfilUtilisateur;
import com.jcertif.bo.participant.RoleParticipant;
import com.jcertif.bo.participant.TypeParticipant;
import com.jcertif.facade.Facade;
import com.jcertif.facade.model.participant.User;
import com.jcertif.service.api.participant.ParticipantService;
import com.jcertif.service.mail.CSenderService;
import com.sun.jersey.api.spring.Autowire;

/**
 * 
 * @author Mamadou
 * 
 */
@Path("user")
@Service
@Autowire
public class UserFacade extends Facade {

	private Logger logger = LoggerFactory.getLogger(UserFacade.class);

	@Autowired
	private CSenderService cSenderService;
	@Autowired
	private ParticipantService participantService;

	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(CREATE_SUFFIX)
	public User create(User user) {

		Participant entity = getParticipant(user);
		Participant part = participantService.save(entity);
		User userSaved = new User(part);
		cSenderService.sendAddParticipantConfirmation(entity);
		return userSaved;

	}

	@GET
	@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("/{email}")
	public User findByEmail(@PathParam("email") String email) {
		try {
			Participant participant = participantService.findUniqueByEmail(email);
			return new User(participant);
		} catch (RuntimeException e) {
			logger.error("UserFacade.findByEmail : ", e);
			return new User();
		}

	}

	@GET
	@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("/connect/{email}/{password}")
	public User connect(@PathParam("email") String email, @PathParam("password") String password) {
		Participant participant = participantService.connect(email, password);

		if (participant == null) {
			return new User();
		}

		return new User(participant);
	}

	public Participant getParticipant(User user) {
		Participant part = new Participant();
		part.setDateInscription(Calendar.getInstance());
		part.setSalutation(user.getCivilite());
		part.setPrenom(user.getPrenom());
		part.setNom(user.getNom());
		part.setEmail(user.getEmail());
		part.setRoleparticipant(new RoleParticipant(null, user.getRole(), null));
		part.setTypeParticipant(new TypeParticipant(user.getTypeUser(), null));
		part.setAdresse(new Adresse(null, null, null, null, user.getVille(), null, user.getPays(),
				null, user.getTelFixe(), user.getTelMobile(), null));
		part.setProfilUtilisateur(new ProfilUtilisateur(null, "", user.getEmail(),
				user.getPasswd(), user.getPhoto(), "", ""));
		Conference conf = new Conference();
		conf.setId(user.getIdConference());
		part.setConference(conf);
		return part;
	}

	@POST
	@Path("/resetPassword/{email}")
	public void resetPassword(@PathParam(value = "email") String email) {
		participantService.generateNewPassword(email);
	}
}
