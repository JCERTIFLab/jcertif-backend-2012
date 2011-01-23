package com.jcertif.facade.cedule;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.cedule.Evenement;
import com.jcertif.facade.AbstractFacade;
import com.jcertif.service.api.cedule.EvenementService;
import com.sun.jersey.api.spring.Autowire;

/**
 * 
 * @author Chrisbel
 * 
 */
@Path("evenement")
@Service
@Autowire
public class EvenementFacade extends
		AbstractFacade<EvenementService, Evenement, Long> {

	@Autowired
	private EvenementService service;

	@Override
	public EvenementService getService() {
		return service;
	}

	@Override
	public void setService(EvenementService service) {
		this.service = service;
	}
}
