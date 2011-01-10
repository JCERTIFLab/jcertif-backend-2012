package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.TypeParticipant;
import com.jcertif.dao.TypeParticipantDAO;

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
