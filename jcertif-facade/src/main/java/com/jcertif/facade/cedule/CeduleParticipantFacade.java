package com.jcertif.facade.cedule;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.cedule.CeduleParticipant;
import com.jcertif.facade.AbstractFacade;
import com.jcertif.service.api.cedule.CeduleParticipantService;
import com.sun.jersey.api.spring.Autowire;

/**
 * Facade pour service participant.
 * 
 * @author rossi.oddet
 * 
 */
@Path("ceduleparticipant")
@Service
@Autowire
public class CeduleParticipantFacade extends
		AbstractFacade<CeduleParticipantService, CeduleParticipant, Long> {

	@Autowired
	private CeduleParticipantService service;

	@Override
	public CeduleParticipantService getService() {
		return service;
	}

	@Override
	public void setService(CeduleParticipantService service) {
		this.service = service;
	}

}
