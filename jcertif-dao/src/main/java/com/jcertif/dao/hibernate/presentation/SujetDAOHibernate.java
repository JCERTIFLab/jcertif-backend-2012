package com.jcertif.dao.hibernate.presentation;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.presentation.Sujet;
import com.jcertif.dao.api.presentation.SujetDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

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
