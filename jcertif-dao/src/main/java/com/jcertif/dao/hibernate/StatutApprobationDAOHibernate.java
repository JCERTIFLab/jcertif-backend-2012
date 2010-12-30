package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.StatutApprobation;
import com.jcertif.dao.StatutApprobationDAO;

/**
 * Implémentation Hibernate de l'accès aux données statut d'approbation.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class StatutApprobationDAOHibernate extends
		AbstractHibernateGenericDAO<StatutApprobation, Long> implements
		StatutApprobationDAO {

}
