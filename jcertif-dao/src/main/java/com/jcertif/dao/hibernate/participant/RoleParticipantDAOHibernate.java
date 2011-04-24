/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.dao.hibernate.participant;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jcertif.bo.participant.RoleParticipant;
import com.jcertif.dao.api.participant.RoleParticipantDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * @author chrisbel
 */
@Repository
public class RoleParticipantDAOHibernate extends
		AbstractHibernateGenericDAO<RoleParticipant, Long> implements
		RoleParticipantDAO {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(RoleParticipantDAOHibernate.class);

	@SuppressWarnings("unchecked")
	public List<RoleParticipant> findAll() {
		final List<RoleParticipant> result = this.getCurrentSession()
				.createCriteria(RoleParticipant.class).setCacheable(true)
				.list();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("findAll() persistentClass={}, result={}",
					new Object[] { RoleParticipant.class, result.size() });
		}
		return result;
	}

}
