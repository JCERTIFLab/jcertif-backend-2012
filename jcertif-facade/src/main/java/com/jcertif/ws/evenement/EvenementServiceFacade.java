package com.jcertif.ws.evenement;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.cedule.Evenement;
import com.jcertif.service.evenement.EvenementService;
import com.sun.jersey.api.spring.Autowire;

/**
 * 
 * @author Chrisbel
 * 
 */
@Path(value = "/evenements")
@Service
@Autowire
public class EvenementServiceFacade {
	private static final Logger LOG = LoggerFactory.getLogger(EvenementServiceFacade.class);
	@Autowired
	private EvenementService evenementService;

	public void setEvenementService(EvenementService evenementService) {
		this.evenementService = evenementService;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("/evenement")
	public Evenement createEvenementFacade(Evenement evenement) {
		LOG.debug("Creation d'un nouvel évenement: {}", evenement.getNomEvenement() + " "+evenement.getId());
		return evenementService.createEvenement(evenement);
	}

	/**
	 * service qui retourne la liste des événements
	 * 
	 * @return
	 */
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("list/evenements")
	public List<Evenement> findAll() {
       
		return evenementService.findAll();

	}

	/**
	 * Permet d etrouver un événement en fonction de son id
	 * 
	 * @param key
	 * @return
	 */
	public Evenement findById(Long key) {

		return evenementService.findById(key);

	}

	/**
	 * sauvegarde un événement
	 * 
	 * @param evenement
	 * @return
	 */
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Evenement save(Evenement evenement) {

		return evenementService.save(evenement);

	}

	/**
	 * permet de mettre à jour un événement
	 * @param evenement
	 * @return
	 */
	@PUT
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("/evenement/update")
	public Evenement update(Evenement evenement) {

		return evenementService.update(evenement);
	}

	/**
	 * Supprime un événement de la base
	 * @param evenement
	 */
	@DELETE
	@Path("remove/event/{id}")
	public void remove(@PathParam("id") Long id ,Evenement evenement) {
		evenementService.remove(evenement);

	}
}
