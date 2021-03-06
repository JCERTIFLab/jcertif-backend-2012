package com.jcertif.dao.hibernate.participant;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.participant.TypeParticipant;
import com.jcertif.dao.api.participant.TypeParticipantDAO;
import com.jcertif.dao.hibernate.AbstractDAOTestCase;
import com.jcertif.dao.hibernate.participant.TypeParticipantDAOHibernate;

/**
 * Test de la classe {@link TypeParticipantDAOHibernate}.
 * 
 * @author rossi.oddet
 * 
 */
@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class TypeParticipantDAOHibernateTest extends AbstractDAOTestCase {

	/**
	 * DAO Type Evenement.
	 */
	@Autowired
	private TypeParticipantDAO typeParticipantDAO;

	/**
	 * Test de la methode findById().
	 */
	@Test
	public void testFindById() {
		TypeParticipant typeEvent = typeParticipantDAO.findById(Long.valueOf(1));
		assertEquals("code type_participant 1", typeEvent.getCode());
		assertEquals("description type_participant 1", typeEvent.getDescription());
	}

}