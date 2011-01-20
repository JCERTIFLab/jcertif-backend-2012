/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.dao.hibernate.participant;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.participant.RoleParticipant;
import com.jcertif.dao.api.participant.RoleParticipantDAO;
import com.jcertif.dao.hibernate.AbstractDAOTestCase;

/**
 * @author chrisbel
 */
@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class RoleParticipantDAOHibernateTest extends AbstractDAOTestCase{

	
	/**
	 * DAO Presentation.
	 */
	@Autowired
	private RoleParticipantDAO roleParticipantDAO;

	/**
	 * Test de la méthode getReference().
	 */
	@Test
	public void testGetReference() {
		RoleParticipant roleparticipant= roleParticipantDAO.getReference(Long.valueOf(4));
		assertEquals("JCertif 2012", roleparticipant.getCodeRole());
		assertEquals("speaker", roleparticipant.getDescription());
		
		
	}
}
