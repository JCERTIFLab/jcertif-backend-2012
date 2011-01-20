package com.jcertif.dao.hibernate.presentation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.presentation.Auteur;
import com.jcertif.dao.api.presentation.AuteurDAO;
import com.jcertif.dao.hibernate.AbstractDAOTestCase;

/**
 * Test de l'implémentation Hibernate de l'accès aux données Auteur.
 * 
 * @author rossi.oddet
 * 
 */
@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class AuteurDAOHibernateTest extends AbstractDAOTestCase {

	/**
	 * DAO Auteur.
	 */
	@Autowired
	private AuteurDAO auteurDAO;

	/**
	 * Test de la méthode getReference().
	 */
	@Test
	public void testGetReference() {
		Auteur auteur1 = auteurDAO.getReference(Long.valueOf(1));
		assertEquals("nom 1", auteur1.getNom());
		assertEquals("prenom 1", auteur1.getPrenom());
		assertEquals("details 1", auteur1.getDetails());
		assertEquals(2, auteur1.getPresentations().size());
		assertEquals(Long.valueOf(1), auteur1.getAdresse().getId());
		assertEquals("1@jcertif.com", auteur1.getEmail());
		assertEquals(Character.valueOf('M'), auteur1.getSexe());
	}

	/**
	 * Test de la méthode findById().
	 */
	@Test
	public void testFindById() {
		Auteur auteur1 = auteurDAO.findById(Long.valueOf(1));
		assertEquals("nom 1", auteur1.getNom());
		assertEquals("prenom 1", auteur1.getPrenom());
		assertEquals("details 1", auteur1.getDetails());
		assertEquals(2, auteur1.getPresentations().size());
		assertEquals(Long.valueOf(1), auteur1.getAdresse().getId());
		assertEquals("1@jcertif.com", auteur1.getEmail());
		assertEquals(Character.valueOf('M'), auteur1.getSexe());
	}

	/**
	 * Test de la méthode findAll().
	 */
	@Test
	public void testFindAll() {
		assertEquals(5, auteurDAO.findAll().size());
	}

	/**
	 * Test de la méthode findAllWithSort().
	 */
	@Test
	public void testFindAllWithSort() {
		assertEquals("nom 5", auteurDAO.findAllWithSort("nom", false)
				.iterator().next().getNom());
	}

	/**
	 * Test de la méthode persist().
	 */
	@Test
	public void testPersist() {
		// Persistence
		Auteur auteur = new Auteur();
		auteur.setNom("nom 100");
		auteur.setPrenom("prenom 100");
		auteur.setDetails("details 100");
		auteurDAO.persist(auteur);

		// Vérification
		Auteur auteur1 = auteurDAO.findById(auteur.getId());
		assertEquals("nom 100", auteur1.getNom());
		assertEquals("prenom 100", auteur1.getPrenom());
		assertEquals("details 100", auteur1.getDetails());
	}

	/**
	 * Test de la méthode merge().
	 */
	@Test
	public void testMerge() {
		// Persistence
		Auteur auteur = new Auteur();
		auteur.setNom("nom 1000");
		auteur.setPrenom("prenom 1000");
		auteur.setDetails("details 1000");
		auteurDAO.persist(auteur);
		Auteur savedAuteur = auteurDAO.merge(auteur);

		// Vérification
		Auteur auteur1 = auteurDAO.findById(savedAuteur.getId());
		assertEquals("nom 1000", auteur1.getNom());
		assertEquals("prenom 1000", auteur1.getPrenom());
		assertEquals("details 1000", auteur1.getDetails());
	}

	/**
	 * Test de la méthode remove().
	 */
	@Test
	public void testRemove() {
		Auteur entity = auteurDAO.findById(Long.valueOf(1l));
		auteurDAO.remove(entity);
		assertEquals(4, auteurDAO.findAll().size());
	}
}
