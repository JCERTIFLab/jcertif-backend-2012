/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.facade.rest.participant;

import com.jcertif.bo.participant.Participant;
import com.jcertif.facade.Facade;
import com.jcertif.facade.model.participant.Speaker;
import com.jcertif.service.api.participant.SpeakerService;
import com.sun.jersey.api.spring.Autowire;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rossi.oddet
 */
@Path("speaker")
@Service
@Autowire
public class SpeakerFacade extends Facade {

    @Autowired
    private SpeakerService speakerService;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path(FINDALL_SUFFIX)
    public List<Speaker> findAll() {
        Set<Participant> participantList = speakerService.findAll();

        List<Speaker> speakerList = new ArrayList<Speaker>();

        for (Participant part : participantList) {
            speakerList.add(new Speaker(part));
        }

        return speakerList;
    }
}
