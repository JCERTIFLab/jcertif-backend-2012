package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.Sujet;
import com.jcertif.dao.SujetDAO;

/**
 * Implémentation hibernate pour l'accès aux données Sujet.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class SujetDAOHibernate extends
		AbstractHibernateGenericDAO<Sujet, Long> implements SujetDAO {
}
