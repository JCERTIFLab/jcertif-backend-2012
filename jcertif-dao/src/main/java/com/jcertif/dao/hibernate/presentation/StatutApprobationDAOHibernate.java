package com.jcertif.dao.hibernate.presentation;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.presentation.StatutApprobation;
import com.jcertif.dao.api.presentation.StatutApprobationDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

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