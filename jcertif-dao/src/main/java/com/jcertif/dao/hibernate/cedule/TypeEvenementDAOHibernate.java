package com.jcertif.dao.hibernate.cedule;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jcertif.bo.cedule.TypeEvenement;
import com.jcertif.dao.api.cedule.TypeEvenementDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * Implementation Hibernate pour l'acces aux donnees {@link TypeEvenement}.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class TypeEvenementDAOHibernate extends
		AbstractHibernateGenericDAO<TypeEvenement, Long> implements
		TypeEvenementDAO {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(TypeEvenementDAOHibernate.class);

	@SuppressWarnings("unchecked")
	public List<TypeEvenement> findAll() {
		final List<TypeEvenement> result = this.getCurrentSession()
				.createCriteria(TypeEvenement.class).setCacheable(true).list();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("findAll() persistentClass={}, result={}",
					new Object[] { TypeEvenement.class, result.size() });
		}
		return result;
	}
}
