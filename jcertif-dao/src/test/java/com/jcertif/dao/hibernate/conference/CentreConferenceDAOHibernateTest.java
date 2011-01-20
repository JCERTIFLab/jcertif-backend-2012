package com.jcertif.dao.hibernate.conference;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.conference.CentreConference;
import com.jcertif.dao.api.conference.CentreConferenceDAO;
import com.jcertif.dao.hibernate.AbstractDAOTestCase;

/**
 * Test de la classe CentreConferenceDAOHibernate.
 * 
 * @author Mamadou
 * 
 */
@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class CentreConferenceDAOHibernateTest extends AbstractDAOTestCase {

	/**
	 * DAO CentreConference.
	 */
	@Autowired
	private CentreConferenceDAO centreConferenceDAO;

	/**
	 * Test de la méthode getReference().
	 */
	@Test
	public void testGetReference() {
		CentreConference centreConference = centreConferenceDAO.getReference(Long.valueOf(1));
		assertEquals("nom", centreConference.getNom());
		assertEquals(Long.valueOf(1), centreConference.getAdresse().getId());
		assertEquals("ccf@jcertif.com", centreConference.getEmail());
		assertEquals("website", centreConference.getWebsite());
		assertEquals("Nom Contact", centreConference.getNomContact());
		assertEquals("Prenom Contact", centreConference.getPrenomContact());
	}

	/**
	 * Test de la méthode findById().
	 */
	@Test
	public void testFindById() {
		CentreConference centreConference = centreConferenceDAO.findById(Long.valueOf(1));
		assertEquals("nom", centreConference.getNom());
		assertEquals(Long.valueOf(1), centreConference.getAdresse().getId());
		assertEquals("ccf@jcertif.com", centreConference.getEmail());
		assertEquals("website", centreConference.getWebsite());
		assertEquals("Nom Contact", centreConference.getNomContact());
		assertEquals("Prenom Contact", centreConference.getPrenomContact());
	}

	/**
	 * Test de la méthode findAll().
	 */
	@Test
	public void testFindAll() {
		assertEquals(2, centreConferenceDAO.findAll().size());
	}

	/**
	 * Test de la méthode findAllWithSort().
	 */
	@Test
	public void testFindAllWithSort() {
		assertEquals("nom", centreConferenceDAO.findAllWithSort("nom", false).iterator().next().getNom());
	}

	/**
	 * Test de la méthode persist().
	 */
	@Test
	public void testPersist() {
		CentreConference centreConference = new CentreConference();
		centreConference.setNom("nom");
		centreConference.setNomContact("Nom Contact");
		centreConference.setPrenomContact("Prenom Contact");
		centreConferenceDAO.persist(centreConference);

		CentreConference centreConferenceRecup = centreConferenceDAO.findById(centreConference.getId());
		assertEquals("Nom Contact", centreConferenceRecup.getNomContact());
		assertEquals("Prenom Contact", centreConferenceRecup.getPrenomContact());
	}

	/**
	 * Test de la méthode merge().
	 */
	@Test
	public void testMerge() {
		CentreConference centreConference = new CentreConference();
		centreConference.setNom("nom");
		centreConference.setNomContact("Nom Contact");
		centreConference.setPrenomContact("Prenom Contact");
		CentreConference persistedCentreConference = centreConferenceDAO.merge(centreConference);

		CentreConference centreConferenceRecup = centreConferenceDAO.findById(persistedCentreConference.getId());
		assertEquals("Nom Contact", centreConferenceRecup.getNomContact());
		assertEquals("Prenom Contact", centreConferenceRecup.getPrenomContact());
	}

	/**
	 * Test de la méthode remove().
	 */
//	@Test
//	public void testRemove() {
//		CentreConference entity = centreConferenceDAO.findById(Long.valueOf(1));
//		centreConferenceDAO.remove(entity);
//		assertEquals(1, centreConferenceDAO.findAll().size());
//	}

}
