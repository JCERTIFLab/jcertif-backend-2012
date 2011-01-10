package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.TypeParticipant;
import com.jcertif.dao.TypeParticipantDAO;

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
