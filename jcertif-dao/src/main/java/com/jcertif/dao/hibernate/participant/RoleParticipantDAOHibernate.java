/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.dao.hibernate.participant;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.participant.RoleParticipant;
import com.jcertif.dao.api.participant.RoleParticipantDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * @author chrisbel
 */
@Repository
public class RoleParticipantDAOHibernate extends
		AbstractHibernateGenericDAO<RoleParticipant, Long> implements RoleParticipantDAO {

	
}
