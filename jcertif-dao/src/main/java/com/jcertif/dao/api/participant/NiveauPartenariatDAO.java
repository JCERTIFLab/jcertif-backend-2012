package com.jcertif.dao.api.participant;

import java.util.List;

import com.jcertif.bo.participant.NiveauPartenariat;
import com.jcertif.dao.api.GenericDAO;

/**
 * @author rossi.oddet
 * 
 */
public interface NiveauPartenariatDAO extends
		GenericDAO<NiveauPartenariat, Long> {

	List<NiveauPartenariat> findByCode(String code);
}
