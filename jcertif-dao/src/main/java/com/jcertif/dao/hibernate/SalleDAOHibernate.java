package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.Salle;
import com.jcertif.dao.SalleDAO;

/**
 * Impl�mentation Hibernate de l'acc�s aux donn�es salle.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class SalleDAOHibernate extends AbstractHibernateGenericDAO<Salle, Long>
		implements SalleDAO {

}
