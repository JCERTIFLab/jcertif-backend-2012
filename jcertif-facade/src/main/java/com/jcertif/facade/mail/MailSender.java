/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.facade.mail;

import com.jcertif.bo.participant.ProfilUtilisateur;
import com.jcertif.service.mail.CSenderService;
import com.sun.jersey.api.spring.Autowire;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Douneg
 */
@Path("mail")
@Service
@Autowire
public class MailSender {

    @Autowired
    private CSenderService cSenderService;

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{from}")
    public String sendConfirmation(@PathParam("from") String from, ProfilUtilisateur profilUtilisateur) {
        return cSenderService.sendConfirmation(profilUtilisateur, from).toString();
    }
}
