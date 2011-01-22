package com.jcertif.facade.participant;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.participant.ProfilUtilisateur;
import com.jcertif.facade.AbstractFacade;
import com.jcertif.service.api.participant.ProfilUtilisateurService;
import com.sun.jersey.api.spring.Autowire;

/**
 * Facade pour le BO ProfilUtilisateur.
 * 
 * @author rossi.oddet
 * 
 */
@Path("profilutilisateur")
@Service
@Autowire
public class ProfilUtilisateurFacade extends
		AbstractFacade<ProfilUtilisateurService, ProfilUtilisateur, Long> {

	@Autowired
	private ProfilUtilisateurService service;

	@Override
	public ProfilUtilisateurService getService() {
		return service;
	}

	@Override
	public void setService(ProfilUtilisateurService service) {
		this.service = service;
	}

}
