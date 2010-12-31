package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.Presentation;
import com.jcertif.dao.PresentationDAO;

/**
 * Impl�mentation Hibernate pour l'acc�s aux donn�es Presentation.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class PresentationDAOHibernate extends
		AbstractHibernateGenericDAO<Presentation, Long> implements
		PresentationDAO {
}
