/**
 * 
 */
package com.jcertif.dao.hibernate.conference;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jcertif.bo.conference.Faq;
import com.jcertif.dao.api.conference.FaqDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * @author rossi
 * 
 */
@Repository
public class FaqDAOHibernate extends AbstractHibernateGenericDAO<Faq, Long>
		implements FaqDAO {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(FaqDAOHibernate.class);

	@SuppressWarnings("unchecked")
	public List<Faq> findAll() {
		final List<Faq> result = this.getCurrentSession()
				.createCriteria(Faq.class).setCacheable(true).list();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("findAll() persistentClass={}, result={}",
					new Object[] { Faq.class, result.size() });
		}
		return result;
	}

}
