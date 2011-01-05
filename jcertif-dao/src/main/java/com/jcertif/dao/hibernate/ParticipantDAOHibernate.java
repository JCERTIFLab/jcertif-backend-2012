package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.Participant;
import com.jcertif.dao.ParticipantDAO;

/**
 * Implémentation Hibernate du DAO pour Participant.
 * 
 * @author Douneg
 * 
 */
@Repository
public class ParticipantDAOHibernate extends
		AbstractHibernateGenericDAO<Participant, Long> implements ParticipantDAO {

}
