package com.jcertif.dao.hibernate.salle;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.salle.Salle;
import com.jcertif.dao.api.salle.SalleDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * Implémentation Hibernate de l'accès aux données salle.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class SalleDAOHibernate extends AbstractHibernateGenericDAO<Salle, Long>
		implements SalleDAO {

}
