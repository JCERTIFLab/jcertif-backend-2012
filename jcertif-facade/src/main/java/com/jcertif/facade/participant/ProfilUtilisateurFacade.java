package com.jcertif.facade.participant;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ProfilUtilisateurFacade extends AbstractFacade {

	/**
	 * Un logger.
	 */
	private Logger log = LoggerFactory.getLogger(ProfilUtilisateurFacade.class);

	/**
	 * Service profil utilisateur.
	 */
	@Autowired
	private ProfilUtilisateurService profilUtilisateurService;

	/**
	 * Creates a ProfilUtilisateur.
	 * 
	 * @param profil
	 *            un profil
	 * @return le profil utili
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(CREATE_SUFFIX)
	public ProfilUtilisateur create(ProfilUtilisateur profil) {
		if (log.isDebugEnabled()) {
			log.debug("creating ProfilUtilisateur with name {}",
					profil.getNomProfil());
		}
		return profilUtilisateurService.save(profil);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(UPDATE_SUFFIX)
	public ProfilUtilisateur update(ProfilUtilisateur profil) {
		if (log.isDebugEnabled()) {
			log.debug("updating ProfilUtilisateur with name {}",
					profil.getNomProfil());
		}
		return profilUtilisateurService.update(profil);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(DELETE_SUFFIX)
	public ProfilUtilisateur delete(ProfilUtilisateur profil) {
		if (log.isDebugEnabled()) {
			log.debug("deleting ProfilUtilisateur with name {}",
					profil.getNomProfil());
		}
		profilUtilisateurService.remove(profil);
		return profil;
	}

	/**
	 * @return the list of ProfilUtilisateur.
	 */
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(FINDALL_SUFFIX)
	public List<ProfilUtilisateur> findAll() {
		return profilUtilisateurService.findAll();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(FINDBYID_SUFFIX)
	public ProfilUtilisateur findById(@PathParam("id") Long id) {
		return profilUtilisateurService.findById(id);
	}

}
