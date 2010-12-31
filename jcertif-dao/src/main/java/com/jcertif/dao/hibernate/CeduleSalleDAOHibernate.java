package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.CeduleSalle;
import com.jcertif.dao.CeduleSalleDAO;

/**
 * Implémentation Hibernate de l'accès aux données cedule_dao.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class CeduleSalleDAOHibernate extends
		AbstractHibernateGenericDAO<CeduleSalle, Long> implements
		CeduleSalleDAO {

}
