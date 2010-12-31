package com.jcertif.dao.hibernate;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.Salle;
import com.jcertif.dao.SalleDAO;

/**
 * Test de l'impl�mentation hibernate de l'acc�s aux donn�es salles.
 * 
 * @author rossi.oddet
 * 
 */
@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class SalleDAOHibernateTest extends AbstractDAOTestCase {

	/**
	 * DAO Salle.
	 */
	@Autowired
	private SalleDAO salleDAO;

	/**
	 * Test de la m�thode getReference().
	 */
	@Test
	public void testGetReference() {
		// Test r�cup�ration salle dont id=1
		Salle salle1 = salleDAO.getReference(Long.valueOf(1));
		assertEquals("libelle salle 1", salle1.getLibelle());
		assertEquals("description salle 1", salle1.getDescription());
		assertEquals(Integer.valueOf(1), salle1.getNombrePlace());
		assertEquals("details 1", salle1.getDetails());
		assertEquals(Long.valueOf(10), salle1.getCentreConference().getId());
	}

	/**
	 * Test de la m�thode findById().
	 */
	@Test
	public void testFindById() {
		// Test r�cup�ration salle dont id=2
		Salle salle1 = salleDAO.getReference(Long.valueOf(2));
		assertEquals("libelle salle 2", salle1.getLibelle());
		assertEquals("description salle 2", salle1.getDescription());
		assertEquals(Integer.valueOf(2), salle1.getNombrePlace());
		assertEquals("details 2", salle1.getDetails());
	}

	/**
	 * Test de la m�thode findAll().
	 */
	@Test
	public void testFindAll() {
		// R�cup�ration de tous les salles, 8 �l�ments soivent �tre remont�s
		List<Salle> salleList = salleDAO.findAll();
		assertEquals(8, salleList.size());
	}

	/**
	 * Test de la m�thode findAllWithSort().
	 */
	@Test
	public void testFindAllWithSort() {
		// R�cup�ration de tous les �l�ments en triant par ordre d�croissant, le
		// premier �l�ment aura l'id 8
		List<Salle> salleList = salleDAO.findAllWithSort("libelle", false);
		Salle firstSalle = salleList.iterator().next();
		assertEquals(firstSalle.getId(), Long.valueOf(8));
	}

	/**
	 * Test de la m�thode persist().
	 */
	@Test
	public void testPersist() {
		// Persistance d'un nouveau salle
		Salle salle = new Salle();
		salle.setLibelle("Libelle 10");
		salle.setDescription("Description 10");
		salleDAO.persist(salle);

		Salle salle1 = salleDAO.findById(salle.getId());
		assertEquals("Libelle 10", salle1.getLibelle());
		assertEquals("Description 10", salle1.getDescription());

	}

	/**
	 * Test de la m�thode merge().
	 */
	@Test
	public void testMerge() {
		// Test 1 : modification d'une salle existante
		Salle salle1 = salleDAO.findById(Long.valueOf(1));
		salle1.setLibelle("Libelle 10X");
		salle1.setDescription("Description 10X");
		salleDAO.merge(salle1);

		Salle updatedSalle = salleDAO.findById(Long.valueOf(1));
		assertEquals("Libelle 10X", updatedSalle.getLibelle());
		assertEquals("Description 10X", updatedSalle.getDescription());

		// Test 2 : Sauvegarde d'une nouvelle salle
		Salle salle = new Salle();
		salle.setLibelle("Libelle 100");
		salle.setDescription("Description 100");
		Salle persistedSalle = salleDAO.merge(salle);

		Salle salle10 = salleDAO.findById(persistedSalle.getId());
		assertEquals("Libelle 100", salle10.getLibelle());
		assertEquals("Description 100", salle10.getDescription());
	}

	/**
	 * Test de la m�thode remove().
	 */
	@Test
	public void testRemove() {
		// Test de suppression d'un salle, il ne doit y rester que 7.
		Salle entity = salleDAO.findById(Long.valueOf(1l));
		salleDAO.remove(entity);
		assertEquals(7, salleDAO.findAll().size());
	}

}
