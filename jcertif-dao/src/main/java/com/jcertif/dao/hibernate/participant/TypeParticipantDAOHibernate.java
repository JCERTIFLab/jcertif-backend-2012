package com.jcertif.dao.hibernate.participant;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jcertif.bo.participant.TypeParticipant;
import com.jcertif.dao.api.participant.TypeParticipantDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * Implementation Hibernate pour l'acces aux donnees {@link TypeParticipant}.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class TypeParticipantDAOHibernate extends
		AbstractHibernateGenericDAO<TypeParticipant, Long> implements
		TypeParticipantDAO {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(TypeParticipantDAOHibernate.class);

	@SuppressWarnings("unchecked")
	public List<TypeParticipant> findAll() {
		final List<TypeParticipant> result = this.getCurrentSession()
				.createCriteria(TypeParticipant.class).setCacheable(true)
				.list();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("findAll() persistentClass={}, result={}",
					new Object[] { TypeParticipant.class, result.size() });
		}
		return result;
	}

}
