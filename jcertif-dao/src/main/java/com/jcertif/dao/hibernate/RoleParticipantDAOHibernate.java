/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.RoleParticipant;
import com.jcertif.dao.RoleParticipantDAO;

/**
 * @author chrisbel
 */
@Repository
public class RoleParticipantDAOHibernate extends
		AbstractHibernateGenericDAO<RoleParticipant, Long> implements RoleParticipantDAO {

	
}
