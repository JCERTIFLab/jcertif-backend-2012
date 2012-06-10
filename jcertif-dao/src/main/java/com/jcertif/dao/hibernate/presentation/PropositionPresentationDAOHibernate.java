package com.jcertif.dao.hibernate.presentation;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.presentation.PropositionPresentation;
import com.jcertif.dao.api.presentation.PropositionPresentationDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * Implémentation Hibernate pour l'accès aux données Presentation.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class PropositionPresentationDAOHibernate extends
		AbstractHibernateGenericDAO<PropositionPresentation, Long> implements
		PropositionPresentationDAO {
}
