package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.Appreciation;
import com.jcertif.dao.AppreciationDAO;

/**
 * Impl�mentation Hibernate de l'acc�s aux donn�es Appreciation.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class AppreciationDAOHibernate extends
		AbstractHibernateGenericDAO<Appreciation, Long> implements
		AppreciationDAO {

}
