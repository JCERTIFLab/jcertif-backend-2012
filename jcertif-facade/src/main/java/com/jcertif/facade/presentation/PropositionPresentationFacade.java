/**
 * 
 */
package com.jcertif.facade.presentation;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.presentation.PropositionPresentation;
import com.jcertif.facade.AbstractFacade;
import com.jcertif.service.api.presentation.PropositionPresentationService;
import com.sun.jersey.api.spring.Autowire;

/**
 * @author rossi
 * 
 */
@Path("propositionpresentation")
@Service
@Autowire
public class PropositionPresentationFacade extends
		AbstractFacade<PropositionPresentationService, PropositionPresentation, Long> {

	@Autowired
	private PropositionPresentationService service;

	@Override
	public PropositionPresentationService getService() {
		return service;
	}

	@Override
	public void setService(PropositionPresentationService service) {
		this.service = service;
	}

}
