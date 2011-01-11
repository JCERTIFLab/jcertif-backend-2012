package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.Evenement;
import com.jcertif.dao.EvenementDAO;

/**
 * Implémentation Hibernate de l'accès aux données Evenement.
 * 
 * @author Douneg
 * 
 */
@Repository
public class EvenementDAOHibernate extends
		AbstractHibernateGenericDAO<Evenement, Long> implements
		EvenementDAO {

}
