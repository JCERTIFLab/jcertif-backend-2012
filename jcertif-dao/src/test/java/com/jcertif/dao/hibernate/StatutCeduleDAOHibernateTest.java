package com.jcertif.dao.hibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.StatutCedule;
import com.jcertif.dao.StatutCeduleDAO;

/**
 * Test de l'implémentation Hibernate d'accès aux données du statut cedule.
 * 
 * @author rossi.oddet
 * 
 */
@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class StatutCeduleDAOHibernateTest extends AbstractDAOTestCase {

	/**
	 * DAO StatutCedule.
	 */
	@Autowired
	private StatutCeduleDAO statutCeduleDAO;

	/**
	 * Test de la méthode getReference().
	 */
	@Test
	public void testGetReference() {
		StatutCedule statut1 = statutCeduleDAO.getReference(Long.valueOf(1));
		assertEquals("code_statut statut_cedule 1", statut1.getCode());
		assertEquals("description statut_cedule 1", statut1.getDescription());
	}

	/**
	 * Test de la méthode findById().
	 */
	@Test
	public void testFindById() {
		StatutCedule statut2 = statutCeduleDAO.findById(Long.valueOf(2));
		assertEquals("code_statut statut_cedule 2", statut2.getCode());
		assertEquals("description statut_cedule 2", statut2.getDescription());
	}

	/**
	 * Test de la méthode findAll().
	 */
	@Test
	public void testFindAll() {
		assertEquals(8, statutCeduleDAO.findAll().size());
	}

	/**
	 * Test de la méthode findAllWithSort().
	 */
	@Test
	public void testFindAllWithSort() {
		assertEquals("code_statut statut_cedule 8", statutCeduleDAO.findAllWithSort("code", false)
				.iterator().next().getCode());
	}

	/**
	 * Test de la méthode persist().
	 */
	@Test
	public void testPersist() {
		StatutCedule statut = new StatutCedule();
		statut.setCode("code_statut statut_cedule 100");
		statut.setDescription("description statut_cedule 100");
		
		statutCeduleDAO.persist(statut);

		StatutCedule statut1 = statutCeduleDAO.findById(statut.getId());
		assertEquals("code_statut statut_cedule 100", statut1.getCode());
		assertEquals("description statut_cedule 100", statut1.getDescription());
	}

	/**
	 * Test de la méthode merge().
	 */
	@Test
	public void testMerge() {
		StatutCedule statut = new StatutCedule();
		statut.setCode("code_statut statut_cedule 1000");
		statut.setDescription("description statut_cedule 1000");
		StatutCedule persistedStatut = statutCeduleDAO.merge(statut);

		StatutCedule statut1 = statutCeduleDAO
				.findById(persistedStatut.getId());
		assertEquals("code_statut statut_cedule 1000", statut1.getCode());
		assertEquals("description statut_cedule 1000", statut1.getDescription());
	}

	/**
	 * Test de la méthode remove().
	 */
	@Test
	public void testRemove() {
		StatutCedule statut = statutCeduleDAO.findById(Long.valueOf(1l));
		statutCeduleDAO.remove(statut);
		assertEquals(7, statutCeduleDAO.findAll().size());
	}
}
