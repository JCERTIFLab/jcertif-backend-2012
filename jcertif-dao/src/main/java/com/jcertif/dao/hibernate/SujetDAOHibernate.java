package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.Sujet;
import com.jcertif.dao.SujetDAO;

/**
 * Impl�mentation hibernate pour l'acc�s aux donn�es Sujet.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class SujetDAOHibernate extends
		AbstractHibernateGenericDAO<Sujet, Long> implements SujetDAO {
}
