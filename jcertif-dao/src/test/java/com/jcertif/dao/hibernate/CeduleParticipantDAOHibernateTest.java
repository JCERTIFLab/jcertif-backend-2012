package com.jcertif.dao.hibernate;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.CeduleParticipant;
import com.jcertif.dao.CeduleParticipantDAO;



@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class CeduleParticipantDAOHibernateTest extends AbstractDAOTestCase{
	/**
	 * DAO CeduleSalle.
	 */
	
	@Autowired
	private CeduleParticipantDAO ceduleParticipantDAO;

	/**
	 * Test de la méthode getReference().
	 * 
	 * @throws ParseException
	 */
	@Test
	public void testGetReference() throws ParseException {
		CeduleParticipant ceduleParticipant = ceduleParticipantDAO.getReference(Long.valueOf(1));
		
		assertEquals("ceduleparticipant", ceduleParticipant.getDetails());
		assertEquals("JCertif 2011", ceduleParticipant.getConference().getNom());
		
	}

	/**
	 * Test de la méthode findById().
	 */
	@Test
	public void testFindById() {
		CeduleParticipant ceduleParticipant = ceduleParticipantDAO.findById(Long.valueOf(2));
		assertEquals("ceduleparticipant2",ceduleParticipant.getDetails()	);
		
		
	}


}
