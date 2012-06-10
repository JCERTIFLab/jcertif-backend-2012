package com.jcertif.dao.hibernate.presentation;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.presentation.Sujet;
import com.jcertif.dao.api.presentation.SujetDAO;
import com.jcertif.dao.hibernate.AbstractDAOTestCase;

import static org.junit.Assert.*;

/**
 * Test de l'implémentation Hibernate SujetDAOHibernate.
 * 
 * @author rossi.oddet
 * 
 */
@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class SujetDAOHibernateTest extends AbstractDAOTestCase {

	/**
	 * DAO Sujet.
	 */
	@Autowired
	private SujetDAO sujetDAO;

	/**
	 * Test de la methode getReference().
	 */
	@Test
	public void testGetReference() {
		// Test recuperation sujet dont id=1
		Sujet sujet1 = sujetDAO.getReference(Long.valueOf(1));
		assertEquals("libelle sujet 1", sujet1.getLibelle());
		assertEquals("description sujet 1", sujet1.getDescription());

		// Test recuperation sujet dont id=2
		Sujet sujet2 = sujetDAO.getReference(Long.valueOf(2));
		assertEquals("libelle sujet 2", sujet2.getLibelle());
		assertEquals("description sujet 2", sujet2.getDescription());

		// Test recuperation sujet dont id=3
		Sujet sujet3 = sujetDAO.getReference(Long.valueOf(3));
		assertEquals("libelle sujet 3", sujet3.getLibelle());
		assertEquals("description sujet 3", sujet3.getDescription());
		
		// Test du cas d'une recherche oe l'identifiant n'existe pas en base
		try{
			sujetDAO.getReference(Long.valueOf(100)).getId();
			fail("L'exception ObjectNotFoundException aurait du etre lance");
		} catch(ObjectNotFoundException ex){
			// Exception attendue car l'identifiant n'existe pas
		}
		
	}

	/**
	 * Test de la methode findById().
	 */
	@Test
	public void testFindById() {
		// Test recuperation sujet dont id=1
		Sujet sujet1 = sujetDAO.findById(Long.valueOf(1));
		assertEquals("libelle sujet 1", sujet1.getLibelle());
		assertEquals("description sujet 1", sujet1.getDescription());

		// Test recuperation sujet dont id=2
		Sujet sujet2 = sujetDAO.findById(Long.valueOf(2));
		assertEquals("libelle sujet 2", sujet2.getLibelle());
		assertEquals("description sujet 2", sujet2.getDescription());

		// Test recuperation sujet dont id=3
		Sujet sujet3 = sujetDAO.findById(Long.valueOf(3));
		assertEquals("libelle sujet 3", sujet3.getLibelle());
		assertEquals("description sujet 3", sujet3.getDescription());

		// Test recuperation d'un sujet dont l'id n'existe pas, la methode doit
		// renvoyer null
		assertNull(sujetDAO.findById(Long.valueOf(10)));
	}

	/**
	 * Test de la methode findAll().
	 */
	@Test
	public void testFindAll() {
		// Recuperation de tous les sujets, 8 elements soivent etre remontes
		List<Sujet> sujetList = sujetDAO.findAll();
		assertEquals(8, sujetList.size());
	}

	/**
	 * Test de la methode findAllWithSort().
	 */
	@Test
	public void testFindAllWithSort() {
		// Recuperation de tous les elements en triant par ordre decroissant, le
		// premier element aura l'id 8
		List<Sujet> sujetList = sujetDAO.findAllWithSort("libelle", false);
		Sujet firstSujet = sujetList.iterator().next();
		assertEquals(firstSujet.getId(), Long.valueOf(8));
	}

	/**
	 * Test de la methode persist().
	 */
	@Test
	public void testPersist() {
		// Persistance d'un nouveau sujet
		Sujet sujet = new Sujet();
		sujet.setLibelle("Libelle 10");
		sujet.setDescription("Description 10");
		sujetDAO.persist(sujet);

		Sujet sujet1 = sujetDAO.findById(sujet.getId());
		assertEquals("Libelle 10", sujet1.getLibelle());
		assertEquals("Description 10", sujet1.getDescription());

	}

	/**
	 * Test de la methode merge().
	 */
	@Test
	public void testMerge() {
		// Test 1 : modification d'un sujet existant
		Sujet sujet1 = sujetDAO.findById(Long.valueOf(1));
		sujet1.setLibelle("Libelle 10X");
		sujet1.setDescription("Description 10X");
		sujetDAO.merge(sujet1);

		Sujet updatedSujet = sujetDAO.findById(Long.valueOf(1));
		assertEquals("Libelle 10X", updatedSujet.getLibelle());
		assertEquals("Description 10X", updatedSujet.getDescription());

		// Test 2 : Sauvegarde d'un nouveau sujet
		Sujet sujet = new Sujet();
		sujet.setLibelle("Libelle 100");
		sujet.setDescription("Description 100");
		Sujet persistedSujet = sujetDAO.merge(sujet);

		Sujet sujet10 = sujetDAO.findById(persistedSujet.getId());
		assertEquals("Libelle 100", sujet10.getLibelle());
		assertEquals("Description 100", sujet10.getDescription());
	}

	/**
	 * Test de la methode remove().
	 */
	@Test
	public void testRemove() {
		// Test de suppression d'un sujet, il ne doit y rester que 7.
		Sujet entity = sujetDAO.findById(Long.valueOf(1l));
		sujetDAO.remove(entity);
		assertEquals(7, sujetDAO.findAll().size());
	}

}
