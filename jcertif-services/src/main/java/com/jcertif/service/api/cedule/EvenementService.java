package com.jcertif.service.api.cedule;

import java.util.List;
import java.util.Set;

import com.jcertif.bo.cedule.Evenement;
import com.jcertif.dao.api.cedule.EvenementDAO;
import com.jcertif.service.GenericService;

/**
 * Business layer interface for Evenement.
 * 
 * @author thierry.balla
 * 
 */
public interface EvenementService extends GenericService<Evenement, Long, EvenementDAO> {

	Set<Long> addUserToEvent(Long idEvent, String email);

	Set<Long> removeUserToEvent(Long idEvent, String email);

	Set<Long> findEventForUser(String email);

	List<Evenement> findAll(Long idConference);
}
