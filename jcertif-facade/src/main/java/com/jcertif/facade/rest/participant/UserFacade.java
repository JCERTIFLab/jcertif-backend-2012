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

import com.jcertif.facade.model.participant.ModifyPassword;
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
 * @author Mamadou
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
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path(CREATE_SUFFIX)
    public User create(User user) {
        logger.info("Creating new user " + user.getEmail());
        Participant entity = getParticipant(user);
        Participant part = participantService.save(entity);
        User userSaved = new User(part);
        cSenderService.sendAddParticipantConfirmation(entity);
        return userSaved;

    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Path("/update/bio/{email}/{conferenceId}")
    public void updateBio(String bio, @PathParam("email") String email,
                          @PathParam("conferenceId") Long conferenceId) {
        participantService.updateBio(bio, email, conferenceId);
    }

    @GET
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/connect/{email}/{password}/{conferenceId}")
    public User connect(@PathParam("email") String email, @PathParam("password") String password,
                        @PathParam("conferenceId") Long conferenceId) {
        Participant participant = participantService.connect(email, password, conferenceId);

        if (participant == null) {
            return new User();
        }

        return new User(participant);
    }

    @GET
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{email}/{conferenceId}")
    public User findByEmail(@PathParam("email") String email,
                            @PathParam("conferenceId") Long conferenceId) {
        Participant participant = participantService.findByEmail(email, conferenceId);
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
        part.setCompagnie(user.getCompagnie());
        part.setWebsite(user.getSiteWeb());
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
    @Path("/resetPassword/{email}/{conferenceId}")
    public void resetPassword(@PathParam("email") String email,
                              @PathParam("conferenceId") Long conferenceId) {
        participantService.generateNewPassword(email, conferenceId);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/modifyPassword/{conferenceId}")
    public void changePassword(ModifyPassword modifyPassword, @PathParam("conferenceId") Long conferenceId) {
        participantService.modifyPassword(modifyPassword.getEmail(), modifyPassword.getOldPassword(), modifyPassword.getNewPassword(), conferenceId);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path(UPDATE_SUFFIX)
    public User update(User user) {
        logger.info("Update user " + user.getEmail());
        Participant part = participantService.update(getParticipant(user));
        return new User(part);
    }
}
