package com.jcertif.dao.hibernate.participant;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.participant.TypeParticipant;
import com.jcertif.dao.api.participant.TypeParticipantDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * Impl�mentation Hibernate pour l'acc�s aux donn�es {@link TypeParticipant}.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class TypeParticipantDAOHibernate extends
		AbstractHibernateGenericDAO<TypeParticipant, Long> implements
		TypeParticipantDAO {

}
