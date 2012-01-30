package com.jcertif.facade.rest.conference;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.facade.Facade;
import com.jcertif.facade.model.conference.Conference;
import com.jcertif.service.api.conference.ConferenceService;
import com.sun.jersey.api.spring.Autowire;

/**
 * Facade pour service participant.
 * 
 * @author Douneg
 * 
 */
@Path("conference")
@Service
@Autowire
public class ConferenceFacade extends Facade {

	@Autowired
	private ConferenceService service;

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(FINDALL_SUFFIX)
	public List<Conference> findAll() {
		List<Conference> confList = new ArrayList<Conference>();
		Set<com.jcertif.bo.conference.Conference> confSet = new HashSet<com.jcertif.bo.conference.Conference>(
				service.findAll());

		for (com.jcertif.bo.conference.Conference conf : confSet) {
			confList.add(new Conference(conf));
		}
		return confList;
	}

	@GET
	@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("/{id}")
	public Conference findById(@PathParam("id") Long id) {
		Conference conf = new Conference(service.findById(id));
		return conf;
	}
}
