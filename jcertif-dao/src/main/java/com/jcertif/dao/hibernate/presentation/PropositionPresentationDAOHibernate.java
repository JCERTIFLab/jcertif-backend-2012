package com.jcertif.dao.hibernate.presentation;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.presentation.PropositionPresentation;
import com.jcertif.dao.api.presentation.PropositionPresentationDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * Impl�mentation Hibernate pour l'acc�s aux donn�es Presentation.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class PropositionPresentationDAOHibernate extends
		AbstractHibernateGenericDAO<PropositionPresentation, Long> implements
		PropositionPresentationDAO {
}
