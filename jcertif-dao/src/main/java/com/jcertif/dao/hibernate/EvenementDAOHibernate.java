package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.Evenement;
import com.jcertif.dao.EvenementDAO;

/**
 * Impl�mentation Hibernate de l'acc�s aux donn�es Evenement.
 * 
 * @author Douneg
 * 
 */
@Repository
public class EvenementDAOHibernate extends
		AbstractHibernateGenericDAO<Evenement, Long> implements
		EvenementDAO {

}
