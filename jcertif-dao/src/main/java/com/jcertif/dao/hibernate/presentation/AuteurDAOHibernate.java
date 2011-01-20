package com.jcertif.dao.hibernate.presentation;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.presentation.Auteur;
import com.jcertif.dao.api.presentation.AuteurDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * Implémentation Hibernate du DAO pour Auteur.
 * 
 * @author Douneg
 * 
 */
@Repository
public class AuteurDAOHibernate extends AbstractHibernateGenericDAO<Auteur, Long> implements AuteurDAO {
}
