package com.jcertif.dao.hibernate.cedule;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.cedule.Evenement;
import com.jcertif.dao.api.cedule.EvenementDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

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
