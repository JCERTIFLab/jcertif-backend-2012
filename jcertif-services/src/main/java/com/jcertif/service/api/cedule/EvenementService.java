package com.jcertif.service.api.cedule;

import com.jcertif.bo.cedule.Evenement;
import com.jcertif.dao.api.cedule.EvenementDAO;
import com.jcertif.service.GenericService;
import java.util.Set;

/**
 * Business layer interface for Evenement.
 * 
 * @author thierry.balla
 * 
 */
public interface EvenementService extends
		GenericService<Evenement, Long, EvenementDAO> {
    
    Set<Long> addUserToEvent(Long idEvent, String email);
    
    Set<Long> removeUserToEvent(Long idEvent, String email);
    
    Set<Long> findEventForUser(String email);
}
