package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.Adresse;
import com.jcertif.dao.api.AdresseDAO;

/**
 * Implementation Hibernate de l'acces aux donnees Adresse.
 * 
 * @author Douneg
 * 
 */
@Repository
public class AdresseDAOHibernate extends
		AbstractHibernateGenericDAO<Adresse, Long> implements
		AdresseDAO {

}
