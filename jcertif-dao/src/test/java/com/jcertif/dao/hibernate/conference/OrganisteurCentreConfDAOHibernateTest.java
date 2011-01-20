package com.jcertif.dao.hibernate.conference;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.conference.OrganisateurCentreConf;
import com.jcertif.dao.api.conference.OrganisteurCentreConfDAO;
import com.jcertif.dao.hibernate.AbstractDAOTestCase;

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