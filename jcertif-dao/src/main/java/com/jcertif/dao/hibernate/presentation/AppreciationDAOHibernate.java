package com.jcertif.dao.hibernate.presentation;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.presentation.Appreciation;
import com.jcertif.dao.api.presentation.AppreciationDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * Implementation Hibernate de l'acces aux donnees Appreciation.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class AppreciationDAOHibernate extends
		AbstractHibernateGenericDAO<Appreciation, Long> implements
		AppreciationDAO {

}
