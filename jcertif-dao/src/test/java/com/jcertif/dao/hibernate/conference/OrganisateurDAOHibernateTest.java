/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.dao.hibernate.conference;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.conference.Organisateur;
import com.jcertif.dao.api.conference.OrganisateurDAO;
import com.jcertif.dao.hibernate.AbstractDAOTestCase;

/**
 * @author chrisbel
 */
@ContextConfiguration(locations = {"classpath:jcertif-dao-test-beans.xml"})
public class OrganisateurDAOHibernateTest extends AbstractDAOTestCase {
	
	/**
	 * DAO Presentation.
	 */
	@Autowired
	private OrganisateurDAO organisateurDAO;

	/**
	 * Test de la methode findById().
	 */
	@Test
	public void testFindById() {
		Organisateur organisateur = organisateurDAO.findById(Long.valueOf(1));
		assertEquals("roland.amour@chrisbel.net", organisateur.getEmail());
		assertEquals("detailsorganisateurs 1", organisateur.getDetails());
		assertEquals("3", String.valueOf((organisateur.getConferences()).size()));
//		assertEquals(Long.valueOf(5), organisateur.getMotCle().getId());
//		assertEquals("mot_cle 5", organisateur.getMotCle().getMotCle());
//		assertEquals("description 5", organisateur.getMotCle().getDescription());
		
	}
	

}
