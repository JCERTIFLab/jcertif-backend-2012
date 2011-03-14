package com.jcertif.dao.hibernate.participant;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jcertif.bo.participant.Participant;
import com.jcertif.dao.api.participant.ParticipantDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * Implémentation Hibernate du DAO pour Participant.
 * 
 * @author Douneg
 * 
 */
@Repository
public class ParticipantDAOHibernate extends AbstractHibernateGenericDAO<Participant, Long>
		implements ParticipantDAO {

	@Override
	public List<Participant> findByEmail(String email) {
		return this.getCurrentSession().createCriteria(Participant.class)
				.add(Restrictions.eq("email", email)).list();
	}

}
