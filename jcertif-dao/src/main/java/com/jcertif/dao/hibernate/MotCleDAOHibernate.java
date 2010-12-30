package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.MotCle;
import com.jcertif.dao.MotCleDAO;

/**
 * Impl�mentation Hibernate du DAO pour MotCle.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class MotCleDAOHibernate extends
		AbstractHibernateGenericDAO<MotCle, Long> implements MotCleDAO {

}
