/**
 * 
 */
package com.jcertif.facade.participant;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.participant.RoleParticipant;
import com.jcertif.facade.AbstractFacade;
import com.jcertif.service.api.participant.RoleParticipantService;
import com.sun.jersey.api.spring.Autowire;

/**
 * @author rossi.oddet
 * 
 */
@Path("roleparticipant")
@Service
@Autowire
public class RoleParticipantFacade extends
		AbstractFacade<RoleParticipantService, RoleParticipant, Long> {

	@Autowired
	private RoleParticipantService roleParticipantService;

	@Override
	public RoleParticipantService getService() {
		return roleParticipantService;
	}

	@Override
	public void setService(RoleParticipantService service) {
		this.roleParticipantService = service;
	}

}
