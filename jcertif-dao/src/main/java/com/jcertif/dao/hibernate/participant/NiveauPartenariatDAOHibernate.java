/**
 * 
 */
package com.jcertif.dao.hibernate.participant;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.bo.participant.NiveauPartenariat;
import com.jcertif.dao.api.participant.NiveauPartenariatDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * @author rossi
 * 
 */
public class NiveauPartenariatDAOHibernate extends
		AbstractHibernateGenericDAO<NiveauPartenariat, Long> implements
		NiveauPartenariatDAO {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(NiveauPartenariatDAOHibernate.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<NiveauPartenariat> findByCode(String code) {
		return this.getCurrentSession().createCriteria(NiveauPartenariat.class)
				.add(Restrictions.eq("code", code)).list();
	}

	@SuppressWarnings("unchecked")
	public List<NiveauPartenariat> findAll() {
		final List<NiveauPartenariat> result = this.getCurrentSession()
				.createCriteria(NiveauPartenariat.class).setCacheable(true)
				.list();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("findAll() persistentClass={}, result={}",
					new Object[] { NiveauPartenariat.class, result.size() });
		}
		return result;
	}

}
