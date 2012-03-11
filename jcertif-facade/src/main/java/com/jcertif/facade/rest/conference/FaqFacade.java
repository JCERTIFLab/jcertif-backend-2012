/**
 * 
 */
package com.jcertif.facade.rest.conference;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.conference.Faq;
import com.jcertif.facade.Facade;
import com.jcertif.service.api.conference.FaqService;
import com.sun.jersey.api.spring.Autowire;

/**
 * @author rossi
 * 
 */
@Path("faq")
@Service
@Autowire
public class FaqFacade extends Facade {

	@Autowired
	private FaqService service;

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(FINDALL_SUFFIX + "/{idConference}")
	public List<Faq> findAll(@PathParam("idConference") Long idConference) {
		return service.findByConferenceId(idConference);
	}

}
