package com.jcertif.facade.presentation;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.presentation.Sujet;
import com.jcertif.facade.AbstractFacade;
import com.jcertif.service.api.presentation.SujetService;
import com.sun.jersey.api.spring.Autowire;

@Path("sujet")
@Service
@Autowire
public class SujetFacade extends AbstractFacade<SujetService, Sujet, Long> {

	@Autowired
	private SujetService service;

	@Override
	public SujetService getService() {
		return service;
	}

	@Override
	public void setService(SujetService service) {
		this.service = service;
	}
}
