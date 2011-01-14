package com.jcertif.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jcertif.bo.CeduleParticipant;
import com.jcertif.dao.CeduleParticipantDAO;

/**
 * Implémentation Hibernate de {@link CeduleParticipantDAO}.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class CeduleParticipantDAOHibernate extends
		AbstractHibernateGenericDAO<CeduleParticipant, Long> implements
		CeduleParticipantDAO {

	/**
	 * @see com.jcertif.dao.CeduleParticipantDAO#findByParticipant(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CeduleParticipant> findByParticipant(Long idParticipant) {
		return getCurrentSession().createCriteria(CeduleParticipant.class)
				.add(Restrictions.eq("participant.id", idParticipant)).list();
	}

}
