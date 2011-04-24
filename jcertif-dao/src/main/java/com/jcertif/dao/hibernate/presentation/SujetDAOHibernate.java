package com.jcertif.dao.hibernate.presentation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jcertif.bo.presentation.Sujet;
import com.jcertif.dao.api.presentation.SujetDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * Implémentation hibernate pour l'accès aux données Sujet.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class SujetDAOHibernate extends AbstractHibernateGenericDAO<Sujet, Long>
		implements SujetDAO {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SujetDAOHibernate.class);

	@SuppressWarnings("unchecked")
	public List<Sujet> findAll() {
		final List<Sujet> result = this.getCurrentSession()
				.createCriteria(Sujet.class).setCacheable(true).list();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("findAll() persistentClass={}, result={}",
					new Object[] { Sujet.class, result.size() });
		}
		return result;
	}

}
