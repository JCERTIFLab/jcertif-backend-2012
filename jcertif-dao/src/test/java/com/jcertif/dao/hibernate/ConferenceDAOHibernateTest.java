/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.dao.hibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.Conference;
import com.jcertif.dao.ConferenceDAO;

/**
 * @author chrisbel
 */
@ContextConfiguration(locations = {"classpath:jcertif-dao-test-beans.xml"})
public class ConferenceDAOHibernateTest extends AbstractDAOTestCase{
	
	/**
	 * DAO Presentation.
	 */
	@Autowired
	private ConferenceDAO  conferenceDAO;

	/**
	 * Test de la méthode findById().
	 */
	@Test
	public void testFindById() {
     Conference conference = conferenceDAO.findById(Long.valueOf(7));
		assertEquals("JCertif 2011", conference.getNom());
		assertEquals("2", String.valueOf((conference.getOrganisateurs()).size()));
		assertEquals(Long.valueOf(7), conference.getId());
//		assertEquals("mot_cle 5", organisateur.getMotCle().getMotCle());
//		assertEquals("description 5", organisateur.getMotCle().getDescription());
		
	}

}
