package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.Adresse;
import com.jcertif.dao.api.AdresseDAO;

/**
 * Implémentation Hibernate de l'accès aux données Adresse.
 * 
 * @author Douneg
 * 
 */
@Repository
public class AdresseDAOHibernate extends
		AbstractHibernateGenericDAO<Adresse, Long> implements
		AdresseDAO {

}
