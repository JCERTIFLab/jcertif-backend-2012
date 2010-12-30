package com.jcertif.dao.hibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.MotCle;
import com.jcertif.dao.MotCleDAO;

/**
 * Test de l'implémentation Hibernate de DAO MotCle.
 * 
 * @author rossi.oddet
 * 
 */
@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class MotCleDAOHibernateTest extends AbstractDAOTestCase {

	/**
	 * DAO MotCle.
	 */
	@Autowired
	private MotCleDAO motCleDAO;

	/**
	 * Test de la méthode getReference().
	 */
	@Test
	public void testGetReference() {
		MotCle motCle1 = motCleDAO.getReference(Long.valueOf(1));
		assertEquals("mot_cle  1", motCle1.getMotCle());
		assertEquals("description  1", motCle1.getDescription());

		MotCle motCle8 = motCleDAO.getReference(Long.valueOf(8));
		assertEquals("mot_cle  8", motCle8.getMotCle());
		assertEquals("description  8", motCle8.getDescription());
	}

	/**
	 * Test de la méthode findById().
	 */
	@Test
	public void testFindById() {
		MotCle motCle2 = motCleDAO.findById(Long.valueOf(2));
		assertEquals("mot_cle  2", motCle2.getMotCle());
		assertEquals("description  2", motCle2.getDescription());

		MotCle motCle5 = motCleDAO.findById(Long.valueOf(5));
		assertEquals("mot_cle  5", motCle5.getMotCle());
		assertEquals("description  5", motCle5.getDescription());
	}

	/**
	 * Test de la méthode findAll().
	 */
	@Test
	public void testFindAll() {
		assertEquals(8, motCleDAO.findAll().size());
	}

	/**
	 * Test de la méthode findAllWithSort().
	 */
	@Test
	public void testFindAllWithSort() {
		assertEquals("mot_cle  8", motCleDAO.findAllWithSort("motCle", false)
				.iterator().next().getMotCle());
	}

	/**
	 * Test de la méthode persist().
	 */
	@Test
	public void testPersist() {
		MotCle motCle = new MotCle();
		motCle.setMotCle("mot_cle 100");
		motCle.setDescription("description 100");
		motCleDAO.persist(motCle);

		MotCle motCle1 = motCleDAO.findById(motCle.getId());
		assertEquals("mot_cle 100", motCle1.getMotCle());
		assertEquals("description 100", motCle1.getDescription());
	}

	/**
	 * Test de la méthode merge().
	 */
	@Test
	public void testMerge() {
		MotCle motCle = new MotCle();
		motCle.setMotCle("mot_cle 1000");
		motCle.setDescription("description 1000");
		MotCle persistedMotCle = motCleDAO.merge(motCle);

		MotCle motCle1 = motCleDAO.findById(persistedMotCle.getId());
		assertEquals("mot_cle 1000", motCle1.getMotCle());
		assertEquals("description 1000", motCle1.getDescription());
	}

	/**
	 * Test de la méthode remove().
	 */
	@Test
	public void testRemove() {
		MotCle entity = motCleDAO.findById(Long.valueOf(1l));
		motCleDAO.remove(entity);
		assertEquals(7, motCleDAO.findAll().size());
	}

}
