package com.jcertif.dao.hibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.OrganisateurCentreConf;
import com.jcertif.dao.OrganisteurCentreConfDAO;

/**
 * @author rossi.oddet
 *
 */
@ContextConfiguration(locations = {"classpath:jcertif-dao-test-beans.xml"})
public class OrganisteurCentreConfDAOHibernateTest extends AbstractDAOTestCase {
	
	/**
	 * DAO OrganisteurCentreConf.
	 */
	@Autowired
	private OrganisteurCentreConfDAO organisateurCentreConfDAO;

	/**
	 * Test de la méthode findById().
	 */
	@Test
	public void testFindById() {
		OrganisateurCentreConf organisateur = organisateurCentreConfDAO.findById(Long.valueOf(1));
		assertEquals("roland.amour@chrisbel.net", organisateur.getEmail());
		assertEquals("detailsorganisateurs 1", organisateur.getDetails());
		assertEquals("malonga", organisateur.getNom());	
	}
}