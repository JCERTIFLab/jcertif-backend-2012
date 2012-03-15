package com.jcertif.dao.hibernate.participant;

import java.util.List;

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
	public List<Participant> find(String email, Long conferenceId) {
		return this
				.getCurrentSession()
				.createQuery(
						"select p from Participant p where p.email=:email and p.conference.id=:conferenceId")
				.setString("email", email).setLong("conferenceId", conferenceId).list();
	}

}
