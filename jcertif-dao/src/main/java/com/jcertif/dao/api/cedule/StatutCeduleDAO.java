package com.jcertif.dao.api.cedule;

import com.jcertif.bo.cedule.StatutCedule;
import com.jcertif.dao.api.GenericDAO;

/**
 * Interface d'accès au statut cedule.
 * 
 * @author rossi.oddet
 * 
 */
public interface StatutCeduleDAO extends GenericDAO<StatutCedule, Long> {

	/**
	 * Retourne un statut cedule en fonction d'un code de statut.
	 * 
	 * @param code
	 *            un code de statut
	 * @return un StatutCedule
	 */
	StatutCedule findByCode(String code);

}
