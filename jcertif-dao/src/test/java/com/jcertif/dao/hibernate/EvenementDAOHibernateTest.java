package com.jcertif.dao.hibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.Evenement;
import com.jcertif.dao.EvenementDAO;

/**
 * Test de l'implémentation Hibernate de l'accès aux données Evenement.
 * 
 * @author Douneg
 * 
 */
@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class EvenementDAOHibernateTest extends AbstractDAOTestCase {

	/**
	 * DAO Evenement.
	 */
	@Autowired
	private EvenementDAO evenementDAO;

	/**
	 * Test de la méthode getReference().
	 */
	@Test
	public void testGetReference() {
		Evenement evenement1 = evenementDAO.getReference(Long.valueOf(1));
		assertEquals("Aucun detail pertinant", evenement1.getDetails());
		assertEquals("nom_evenement 1", evenement1.getNom_evenement());
		assertEquals(Long.valueOf(1), evenement1.getTypeEvenement().getId());

	}

	/**
	 * Test de la méthode findById().
	 */
	@Test
	public void testFindById() {
		Evenement evenement1 = evenementDAO.findById((Long.valueOf(1)));
		assertEquals("Aucun detail pertinant", evenement1.getDetails());
		assertEquals("nom_evenement 1", evenement1.getNom_evenement());
		assertEquals(Long.valueOf(1), evenement1.getTypeEvenement().getId());

	}

	/**
	 * Test de la méthode findAll().
	 */
	@Test
	public void testFindAll() {
		assertEquals(8, evenementDAO.findAll().size());
	}

	/**
	 * Test de la méthode findAllWithSort().
	 */
	@Test
	public void testFindAllWithSort() {
		assertEquals("nom_evenement 8",
				evenementDAO.findAllWithSort("nom_evenement", false).iterator()
						.next().getNom_evenement());
	}

	/**
	 * Test de la méthode persist().
	 */
	@Test
	public void testPersist() {
		// Persistence
		Evenement evenement1 = new Evenement();
		evenement1.setId(Long.valueOf(345));
		evenement1.setNom_evenement("evenement 345");
		evenement1.setDetails("details 345");
		evenementDAO.persist(evenement1);

		// Vérification
		Evenement evenementV = evenementDAO.findById(evenement1.getId());
		assertEquals("evenement 345", evenementV.getNom_evenement());
		assertEquals("details 345", evenementV.getDetails());

	}

	/**
	 * Test de la méthode merge().
	 */
	@Test
	public void testMerge() {
		// Persistence
		Evenement evenement = new Evenement();
		evenement.setId(Long.valueOf(1000));
		evenement.setNom_evenement("evenement 1000");
		evenement.setDetails("details 1000");
		evenementDAO.persist(evenement);
		Evenement savedEvenement = evenementDAO.merge(evenement);

		// Vérification
		Evenement evenement1 = evenementDAO.findById(savedEvenement.getId());
		assertEquals("evenement 1000", evenement1.getNom_evenement());
		assertEquals("details 1000", evenement1.getDetails());
	}

	/**
	 * Test de la méthode remove().
	 */
	@Test
	public void testRemove() {
		Evenement entity = evenementDAO.findById(Long.valueOf(1));
		evenementDAO.remove(entity);
		assertEquals(7, evenementDAO.findAll().size());
	}
}
