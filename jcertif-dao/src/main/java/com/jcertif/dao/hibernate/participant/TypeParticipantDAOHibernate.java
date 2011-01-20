package com.jcertif.dao.hibernate.participant;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.participant.TypeParticipant;
import com.jcertif.dao.api.participant.TypeParticipantDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * Implémentation Hibernate pour l'accès aux données {@link TypeParticipant}.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class TypeParticipantDAOHibernate extends
		AbstractHibernateGenericDAO<TypeParticipant, Long> implements
		TypeParticipantDAO {

}
