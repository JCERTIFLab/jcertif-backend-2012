package com.jcertif.dao.hibernate.cedule;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jcertif.bo.cedule.CeduleParticipant;
import com.jcertif.dao.api.cedule.CeduleParticipantDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * Implémentation Hibernate de {@link CeduleParticipantDAO}.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class CeduleParticipantDAOHibernate extends
		AbstractHibernateGenericDAO<CeduleParticipant, Long> implements CeduleParticipantDAO {

	/**
	 * @see com.jcertif.dao.api.cedule.CeduleParticipantDAO#findByParticipant(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CeduleParticipant> findByParticipant(Long idParticipant) {
		return getCurrentSession().createCriteria(CeduleParticipant.class)
				.add(Restrictions.eq("participantId", idParticipant)).list();
	}

}
