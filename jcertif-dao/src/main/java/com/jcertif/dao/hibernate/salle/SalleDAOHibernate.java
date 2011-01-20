package com.jcertif.dao.hibernate.salle;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.salle.Salle;
import com.jcertif.dao.api.salle.SalleDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

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
