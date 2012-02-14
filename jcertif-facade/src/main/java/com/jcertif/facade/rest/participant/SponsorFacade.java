package com.jcertif.facade.rest.participant;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.participant.Participant;
import com.jcertif.facade.Facade;
import com.jcertif.facade.model.participant.Sponsor;
import com.jcertif.service.api.participant.SponsorService;
import com.sun.jersey.api.spring.Autowire;

/**
 * Sponsor Facade.
 * 
 * @author rossi.oddet
 * 
 */
@Path("sponsor")
@Service
@Autowire
public class SponsorFacade extends Facade {

	@Autowired
	private SponsorService sponsorService;

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(FINDALL_SUFFIX + "/{idConference}")
	public List<Sponsor> findAll(@PathParam("idConference") Long idConference) {
		Set<Participant> participantList = sponsorService.findAll(idConference);

		List<Sponsor> speakerList = new ArrayList<Sponsor>();

		for (Participant part : participantList) {
			speakerList.add(new Sponsor(part));
		}

		return speakerList;
	}
}
