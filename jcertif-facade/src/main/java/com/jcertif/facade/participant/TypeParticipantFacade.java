/**
 * 
 */
package com.jcertif.facade.participant;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.participant.TypeParticipant;
import com.jcertif.facade.AbstractFacade;
import com.jcertif.service.participant.TypeParticipantService;
import com.sun.jersey.api.spring.Autowire;

/**
 * Facade for the {@link TypeParticipant}.
 * 
 * @author Bernard Adanlessossi
 *
 */
@Path("/typeparticipant")
@Service
@Autowire
public class TypeParticipantFacade extends AbstractFacade<TypeParticipantService, TypeParticipant, Long>{

private static final Logger LOG = LoggerFactory.getLogger(ParticipantFacade.class);
	
	@Autowired
	private TypeParticipantService service;
	
	@PUT
	@Path("/typeparticipant/{id}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	/**
	 * Creates a new {@link TypeParticipant}.
	 * @param type the new type participant
	 * @return the type if created
	 */
	public TypeParticipant createTypeParticipant(TypeParticipant type){
		LOG.debug("Creating the type participant with key: {}", type.getId());
		return service.save(type);
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("/typeparticipant/{id}")
	/**
	 * Gets a type participant by its id.
	 * @param key the type id
	 * @return the type
	 */
	public TypeParticipant getTypeParticipantById(Long key){
		LOG.debug("Finding the type participant with key: {}", key);
		return service.findById(key);
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("/alltypesparticipant")
	/**
	 * Find all types participants.
	 * @return a list of types
	 */
	public List<TypeParticipant> findAllTypeParticipant(){
		LOG.debug("Finding all type participant ");
		return service.findAll();
	}
	
	@PUT
	@Path("/updatetypeparticipant")
	/**
	 * Updates the given type participant.
	 * @param the type to update
	 * @return the type if successfully updated
	 */
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public TypeParticipant update(TypeParticipant type){
		LOG.debug("Updating the type participant with key: {}", type.getId());
		return service.update(type);
	}
	
	@DELETE
	@Path("/deletetypeparticipant")
	/**
	 * Deletes the given type participant from the database.
	 * @param type the type to delete
	 */
	public TypeParticipant delete(TypeParticipant type){
		LOG.debug("Deleting the type participant with key: {}", type.getId());
		service.remove(type);
		return type;
	}

	@Override
    public TypeParticipantService getService() {
	    return this.service;
    }

	@Override
    public void setService(TypeParticipantService service) {
	    this.service = service;	    
    }
}
