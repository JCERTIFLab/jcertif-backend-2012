package com.jcertif.dao.hibernate.cedule;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.cedule.CeduleParticipant;
import com.jcertif.dao.api.cedule.CeduleParticipantDAO;
import com.jcertif.dao.hibernate.AbstractDAOTestCase;

@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class CeduleParticipantDAOHibernateTest extends AbstractDAOTestCase {
	/**
	 * DAO CeduleSalle.
	 */

	@Autowired
	private CeduleParticipantDAO ceduleParticipantDAO;

	/**
	 * Test de la methode getReference().
	 * 
	 * @throws ParseException
	 */
	@Test
	public void testGetReference() throws ParseException {
		CeduleParticipant ceduleParticipant = ceduleParticipantDAO
				.getReference(Long.valueOf(1));

		assertEquals("ceduleparticipant", ceduleParticipant.getDetails());

	}

	/**
	 * Test de la methode findById().
	 */
	@Test
	public void testFindById() {
		CeduleParticipant ceduleParticipant = ceduleParticipantDAO
				.findById(Long.valueOf(2));
		assertEquals("ceduleparticipant2", ceduleParticipant.getDetails());

	}

	/**
	 * Test de la methode findByParticipant().
	 */
	@Test
	public void testFindByParticipant() {
		List<CeduleParticipant> ceduleList = ceduleParticipantDAO
		.findByParticipant(Long.valueOf(7));
		assertEquals(2, ceduleList.size());
	}
	

}
