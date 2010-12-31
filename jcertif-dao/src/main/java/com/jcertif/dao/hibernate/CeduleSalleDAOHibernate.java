package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.CeduleSalle;
import com.jcertif.dao.CeduleSalleDAO;

/**
 * Impl�mentation Hibernate de l'acc�s aux donn�es cedule_dao.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class CeduleSalleDAOHibernate extends
		AbstractHibernateGenericDAO<CeduleSalle, Long> implements
		CeduleSalleDAO {

}
