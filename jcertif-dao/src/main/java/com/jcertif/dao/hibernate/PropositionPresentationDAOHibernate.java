package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.PropositionPresentation;
import com.jcertif.dao.PropostionPresentationDAO;

/**
 * Impl�mentation Hibernate pour l'acc�s aux donn�es Presentation.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class PropositionPresentationDAOHibernate extends
		AbstractHibernateGenericDAO<PropositionPresentation, Long> implements
		PropostionPresentationDAO {
}
