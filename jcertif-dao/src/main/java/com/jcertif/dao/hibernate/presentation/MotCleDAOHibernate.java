package com.jcertif.dao.hibernate.presentation;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.presentation.MotCle;
import com.jcertif.dao.api.presentation.MotCleDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * Implémentation Hibernate du DAO pour MotCle.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class MotCleDAOHibernate extends
		AbstractHibernateGenericDAO<MotCle, Long> implements MotCleDAO {

}
