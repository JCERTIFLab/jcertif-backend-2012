package com.jcertif.dao.hibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.ComiteOrganisation;
import com.jcertif.dao.ComiteOrganisationDAO;

/**
 * Test de la classe ComiteOrganisationDAOHibernate.
 * 
 * @author rossi.oddet
 * 
 */
@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class ComiteOrganisationDAOHibernateTest extends AbstractDAOTestCase {

	/**
	 * DAO ComiteOrganisation.
	 */
	@Autowired
	private ComiteOrganisationDAO comiteOrganisationDAO;

	/**
	 * Test de la m�thode getReference().
	 */
	@Test
	public void testGetReference() {
		ComiteOrganisation comite = comiteOrganisationDAO.getReference(Long
				.valueOf(1));
		assertEquals("nom 1", comite.getNom());
		assertEquals("prenom 1", comite.getPrenom());
		assertEquals("1@jcertif.com", comite.getEmail());
		assertEquals("details 1", comite.getDetails());
		assertEquals(Character.valueOf('M'), comite.getSexeMf());
		assertEquals("111111", comite.getTelephone());
	}

	/**
	 * Test de la m�thode findById().
	 */
	@Test
	public void testFindById() {
		ComiteOrganisation comite = comiteOrganisationDAO.findById(Long
				.valueOf(1));
		assertEquals("nom 1", comite.getNom());
		assertEquals("prenom 1", comite.getPrenom());
		assertEquals("1@jcertif.com", comite.getEmail());
		assertEquals("details 1", comite.getDetails());
		assertEquals(Character.valueOf('M'), comite.getSexeMf());
		assertEquals("111111", comite.getTelephone());
	}

	/**
	 * Test de la m�thode findAll().
	 */
	@Test
	public void testFindAll() {
		assertEquals(4, comiteOrganisationDAO.findAll().size());
	}

	/**
	 * Test de la m�thode findAllWithSort().
	 */
	@Test
	public void testFindAllWithSort() {
		assertEquals("nom 4",
				comiteOrganisationDAO.findAllWithSort("nom", false).iterator()
						.next().getNom());
	}

	/**
	 * Test de la m�thode persist().
	 */
	@Test
	public void testPersist() {
		ComiteOrganisation comite = new ComiteOrganisation();
		comite.setNom("nom 100");
		comite.setPrenom("prenom 100");
		comiteOrganisationDAO.persist(comite);

		ComiteOrganisation comiteRecup = comiteOrganisationDAO.findById(comite
				.getId());
		assertEquals("nom 100", comiteRecup.getNom());
		assertEquals("prenom 100", comiteRecup.getPrenom());
	}

	/**
	 * Test de la m�thode merge().
	 */
	@Test
	public void testMerge() {
		ComiteOrganisation comite = new ComiteOrganisation();
		comite.setNom("nom 1000");
		comite.setPrenom("prenom 1000");
		ComiteOrganisation persistedComiteOrganisation = comiteOrganisationDAO
				.merge(comite);

		ComiteOrganisation comiteRecup = comiteOrganisationDAO
				.findById(persistedComiteOrganisation.getId());
		assertEquals("nom 1000", comiteRecup.getNom());
		assertEquals("prenom 1000", comiteRecup.getPrenom());
	}

	/**
	 * Test de la m�thode remove().
	 */
	@Test
	public void testRemove() {
		ComiteOrganisation entity = comiteOrganisationDAO.findById(Long
				.valueOf(1l));
		comiteOrganisationDAO.remove(entity);
		assertEquals(3, comiteOrganisationDAO.findAll().size());
	}
}