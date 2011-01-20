package com.jcertif.dao.hibernate.cedule;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.cedule.CeduleSalle;
import com.jcertif.dao.api.cedule.CeduleSalleDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

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
