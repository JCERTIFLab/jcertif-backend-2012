package com.jcertif.dao.hibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.TypeParticipant;
import com.jcertif.dao.TypeParticipantDAO;

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
	 * Test de la méthode findById().
	 */
	@Test
	public void testFindById() {
		TypeParticipant typeEvent = typeParticipantDAO.findById(Long.valueOf(1));
		assertEquals("code type_participant 1", typeEvent.getCode());
		assertEquals("description type_participant 1", typeEvent.getDescription());
	}

}