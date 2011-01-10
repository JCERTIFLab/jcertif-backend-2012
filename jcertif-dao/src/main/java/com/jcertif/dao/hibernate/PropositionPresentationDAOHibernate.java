package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.PropositionPresentation;
import com.jcertif.dao.PropostionPresentationDAO;

/**
 * Implémentation Hibernate pour l'accès aux données Presentation.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class PropositionPresentationDAOHibernate extends
		AbstractHibernateGenericDAO<PropositionPresentation, Long> implements
		PropostionPresentationDAO {
}
