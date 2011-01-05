package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.Auteur;
import com.jcertif.dao.AuteurDAO;

/**
 * Implémentation Hibernate du DAO pour Auteur.
 * 
 * @author Douneg
 * 
 */
@Repository
public class AuteurDAOHibernate extends AbstractHibernateGenericDAO<Auteur, Long> implements AuteurDAO {
}
