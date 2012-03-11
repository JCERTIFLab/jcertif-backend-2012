package com.jcertif.facade.rest.presentation;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.presentation.Sujet;
import com.jcertif.facade.Facade;
import com.jcertif.service.api.presentation.SujetService;
import com.sun.jersey.api.spring.Autowire;

/**
 * @author rossi.oddet
 * 
 */
@Path("sujet")
@Service
@Autowire
public class SujetFacade extends Facade {

	@Autowired
	private SujetService service;

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(FINDALL_SUFFIX)
	public List<Sujet> findAll() {
		return service.findAll();
	}

}
