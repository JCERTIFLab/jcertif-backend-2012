package com.jcertif.dao.api.cedule;

import java.util.List;

import com.jcertif.bo.cedule.Evenement;
import com.jcertif.dao.api.GenericDAO;

/**
 * DAO Interface for Evenement.
 * 
 * @author Douneg
 * 
 */
public interface EvenementDAO extends GenericDAO<Evenement, Long> {
	List<Evenement> findByConference(Long idConference);
}
