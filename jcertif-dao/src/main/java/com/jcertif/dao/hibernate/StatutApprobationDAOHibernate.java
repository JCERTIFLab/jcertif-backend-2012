package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.StatutApprobation;
import com.jcertif.dao.StatutApprobationDAO;

/**
 * Impl�mentation Hibernate de l'acc�s aux donn�es statut d'approbation.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class StatutApprobationDAOHibernate extends
		AbstractHibernateGenericDAO<StatutApprobation, Long> implements
		StatutApprobationDAO {

}
