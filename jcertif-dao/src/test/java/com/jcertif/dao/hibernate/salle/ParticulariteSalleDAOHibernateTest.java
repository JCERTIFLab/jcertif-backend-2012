/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.dao.hibernate.salle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.salle.ParticulariteSalle;
import com.jcertif.dao.api.salle.ParticulariteSalleDAO;
import com.jcertif.dao.hibernate.AbstractDAOTestCase;

/**
 * @author chrisbel
 */
@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class ParticulariteSalleDAOHibernateTest extends AbstractDAOTestCase {
	
	/**
	 * DAO Particularite Salle.
	 */
	@Autowired
	private ParticulariteSalleDAO particularitesalleDAO;

	/**
	 * Test de la méthode findById().
	 */
	@Test
	public void testFindById() {
		ParticulariteSalle particularitesalle = particularitesalleDAO.findById(Long.valueOf(1));
		assertEquals("ABCD", particularitesalle.getCode());
		assertEquals("petite", particularitesalle.getDescription());
		assertEquals(Long.valueOf(1), particularitesalle.getId());
		//assertEquals("3", String.valueOf((particularitesalle.getSalles()).size()));
//		assertEquals(Long.valueOf(5), organisateur.getMotCle().getId());
//		assertEquals("mot_cle 5", organisateur.getMotCle().getMotCle());
//		assertEquals("description 5", organisateur.getMotCle().getDescription());
		
	}
	
	

}
