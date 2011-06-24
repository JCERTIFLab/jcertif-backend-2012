/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.facade.rest.participant;

import java.awt.PageAttributes.MediaType;
import java.util.Calendar;

import com.jcertif.bo.Adresse;
import com.jcertif.bo.participant.Participant;
import com.jcertif.bo.participant.RoleParticipant;
import com.jcertif.bo.participant.TypeParticipant;
import com.jcertif.facade.Facade;
import com.jcertif.facade.model.participant.User;
import com.jcertif.service.api.participant.ParticipantService;
import com.jcertif.service.mail.CSenderService;

import com.sun.jersey.api.spring.Autowire;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Mamadou
 *
 */
@Path("user")
@Service
@Autowire
public class UserFacade extends Facade {

	@Autowired
	private CSenderService cSenderService;

	@Autowired
	private ParticipantService participantService;


	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(CREATE_SUFFIX)
	public Participant create(User user) {

		Participant entity = getParticipant(user);
		Participant part = participantService.save(entity);
		cSenderService.sendAddParticipantConfirmation(entity);
		return part;

	}

	public Participant getParticipant(User user){

		Participant part = new Participant();
		part.setId(null);
		part.setDateInscription(Calendar.getInstance());
		part.setSalutation(user.getCivilite());
		part.setSpecialite(null);
		part.setPrenom(user.getPrenom());
		part.setNom(user.getNom());
		part.setSexe(null);
		part.setEmail(user.getEmail());
		part.setCvSoumis(null);
		part.setDetails(null);
		part.setRoleparticipant( new RoleParticipant( null, user.getRole(), null ) );
		part.setConference(null);
		part.setTypeParticipant( new TypeParticipant(user.getTypeUser(), null ));
		part.setAdresse(new Adresse(null, null, null,null, user.getVille(), null, user.getPays(), null, user.getTelFixe(), user.getTelMobile() , null )) ;

		return part;
	}
}
