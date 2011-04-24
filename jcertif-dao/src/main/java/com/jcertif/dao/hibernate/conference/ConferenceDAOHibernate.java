/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.dao.hibernate.conference;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jcertif.bo.conference.Conference;
import com.jcertif.dao.api.conference.ConferenceDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * @author chrisbel
 */
@Repository
public class ConferenceDAOHibernate extends
		AbstractHibernateGenericDAO<Conference, Long> implements ConferenceDAO {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ConferenceDAOHibernate.class);

	@SuppressWarnings("unchecked")
	public List<Conference> findAll() {
		final List<Conference> result = this.getCurrentSession()
				.createCriteria(Conference.class).setCacheable(true).list();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("findAll() persistentClass={}, result={}",
					new Object[] { Conference.class, result.size() });
		}
		return result;
	}
}
