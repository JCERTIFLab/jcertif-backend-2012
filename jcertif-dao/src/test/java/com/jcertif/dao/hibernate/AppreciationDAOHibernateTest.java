package com.jcertif.dao.hibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.Appreciation;
import com.jcertif.dao.AppreciationDAO;

/**
 * Test de l'impl�mentation Hibernate de l'acc�s aux donn�es Appreciation.
 * 
 * @author rossi.oddet
 * 
 */
@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class AppreciationDAOHibernateTest extends AbstractDAOTestCase {

	/**
	 * DAO Appreciation.
	 */
	@Autowired
	private AppreciationDAO appreciationDAO;

	/**
	 * Test de la m�thode getReference().
	 */
	@Test
	public void testGetReference() {
		Appreciation appreciation1 = appreciationDAO.getReference(Long.valueOf(1));
		assertEquals("code_appreciation 1", appreciation1.getCodeAppreciation());
		assertEquals("description 1", appreciation1.getDescription());
		assertEquals("titre 1", appreciation1.getPresentations().iterator().next().getTitre());
	}

	/**
	 * Test de la m�thode findById().
	 */
	@Test
	public void testFindById() {
		Appreciation appreciation1 = appreciationDAO.findById(Long.valueOf(2));
		assertEquals("code_appreciation 2", appreciation1.getCodeAppreciation());
		assertEquals("description 2", appreciation1.getDescription());	
	}

	/**
	 * Test de la m�thode findAll().
	 */
	@Test
	public void testFindAll() {
		assertEquals(6, appreciationDAO.findAll().size());
	}

	/**
	 * Test de la m�thode findAllWithSort().
	 */
	@Test
	public void testFindAllWithSort() {
		assertEquals("code_appreciation 6", appreciationDAO.findAllWithSort("codeAppreciation", false)
				.iterator().next().getCodeAppreciation());
	}

	/**
	 * Test de la m�thode persist().
	 */
	@Test
	public void testPersist() {
		// Persistence
		Appreciation appreciation = new Appreciation();
		appreciation.setCodeAppreciation("code 100");
		appreciation.setDescription("description 100");
		appreciationDAO.persist(appreciation);

		// V�rification
		Appreciation appreciation1 = appreciationDAO.findById(appreciation.getId());
		assertEquals("code 100", appreciation1.getCodeAppreciation());
		assertEquals("description 100", appreciation1.getDescription());
	}

	/**
	 * Test de la m�thode merge().
	 */
	@Test
	public void testMerge() {
		// Persistence
		Appreciation appreciation = new Appreciation();
		appreciation.setCodeAppreciation("code 1000");
		appreciation.setDescription("description 1000");
		Appreciation savedAppreciation = appreciationDAO.merge(appreciation);

		// V�rification
		Appreciation appreciation1 = appreciationDAO.findById(savedAppreciation.getId());
		assertEquals("code 1000", appreciation1.getCodeAppreciation());
		assertEquals("description 1000", appreciation1.getDescription());
	}

	/**
	 * Test de la m�thode remove().
	 */
	@Test
	public void testRemove() {
		Appreciation entity = appreciationDAO.findById(Long.valueOf(1l));
		appreciationDAO.remove(entity);
		assertEquals(5, appreciationDAO.findAll().size());
	}
}
