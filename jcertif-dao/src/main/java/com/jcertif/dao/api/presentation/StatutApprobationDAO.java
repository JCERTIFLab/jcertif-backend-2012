package com.jcertif.dao.api.presentation;

import java.util.List;

import com.jcertif.bo.presentation.StatutApprobation;
import com.jcertif.dao.api.GenericDAO;

/**
 * Interface d'acces aux donnees Statut d'approbation.
 * 
 * @author rossi.oddet
 * 
 */
public interface StatutApprobationDAO extends GenericDAO<StatutApprobation, Long> {

	List<StatutApprobation> findByCode(String code);
}
