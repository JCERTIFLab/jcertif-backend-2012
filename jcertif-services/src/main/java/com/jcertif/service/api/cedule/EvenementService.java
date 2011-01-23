package com.jcertif.service.api.cedule;

import com.jcertif.bo.cedule.Evenement;
import com.jcertif.dao.api.cedule.EvenementDAO;
import com.jcertif.service.GenericService;

/**
 * Business layer interface for Evenement.
 * 
 * @author thierry.balla
 * 
 */
public interface EvenementService extends
		GenericService<Evenement, Long, EvenementDAO> {
}
