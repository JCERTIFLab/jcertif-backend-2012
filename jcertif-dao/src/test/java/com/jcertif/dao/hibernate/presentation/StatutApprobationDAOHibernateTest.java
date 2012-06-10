package com.jcertif.dao.hibernate.presentation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.presentation.StatutApprobation;
import com.jcertif.dao.api.presentation.StatutApprobationDAO;
import com.jcertif.dao.hibernate.AbstractDAOTestCase;

/**
 * Test de l'implementation Hibernate de l'acces aux donnees statut
 * d'approbation.
 * 
 * @author rossi.oddet
 * 
 */
@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class StatutApprobationDAOHibernateTest extends AbstractDAOTestCase {

	/**
	 * DAO StatutApprobation.
	 */
	@Autowired
	private StatutApprobationDAO statutApprobationDAO;

	/**
	 * Test de la methode getReference().
	 */
	@Test
	public void testGetReference() {
		StatutApprobation statut1 = statutApprobationDAO.getReference(Long.valueOf(1));
		assertEquals("code_statut statut_approbation 1", statut1.getCodeStatut());
		assertEquals("description statut_approbation 1", statut1.getDescription());
	}

	/**
	 * Test de la methode findById().
	 */
	@Test
	public void testFindById() {
		StatutApprobation statut2 = statutApprobationDAO.findById(Long.valueOf(2));
		assertEquals("code_statut statut_approbation 2", statut2.getCodeStatut());
		assertEquals("description statut_approbation 2", statut2.getDescription());
	}

	/**
	 * Test de la methode findAll().
	 */
	@Test
	public void testFindAll() {
		assertEquals(8, statutApprobationDAO.findAll().size());
	}

	/**
	 * Test de la methode findAllWithSort().
	 */
	@Test
	public void testFindAllWithSort() {
		assertEquals("code_statut statut_approbation 8", statutApprobationDAO.findAllWithSort("codeStatut", false)
				.iterator().next().getCodeStatut());
	}

	/**
	 * Test de la methode persist().
	 */
	@Test
	public void testPersist() {
		StatutApprobation statut = new StatutApprobation();
		statut.setCodeStatut("code_statut statut_approbation 100");
		statut.setDescription("description statut_approbation 100");
		
		statutApprobationDAO.persist(statut);

		StatutApprobation statut1 = statutApprobationDAO.findById(statut.getId());
		assertEquals("code_statut statut_approbation 100", statut1.getCodeStatut());
		assertEquals("description statut_approbation 100", statut1.getDescription());
	}

	/**
	 * Test de la methode merge().
	 */
	@Test
	public void testMerge() {
		StatutApprobation statut = new StatutApprobation();
		statut.setCodeStatut("code_statut statut_approbation 1000");
		statut.setDescription("description statut_approbation 1000");
		StatutApprobation persistedStatut = statutApprobationDAO.merge(statut);

		StatutApprobation statut1 = statutApprobationDAO
				.findById(persistedStatut.getId());
		assertEquals("code_statut statut_approbation 1000", statut1.getCodeStatut());
		assertEquals("description statut_approbation 1000", statut1.getDescription());
	}

	/**
	 * Test de la methode remove().
	 */
	@Test
	public void testRemove() {
		StatutApprobation statut = statutApprobationDAO.findById(Long.valueOf(1l));
		statutApprobationDAO.remove(statut);
		assertEquals(7, statutApprobationDAO.findAll().size());
	}
	
	/**
	 * Test de la methode findByCode().
	 */
	@Test
	public void testFindByCode() {
		StatutApprobation statut = statutApprobationDAO.findByCode("code_statut statut_approbation 2").iterator().next();
		assertEquals("description statut_approbation 2", statut.getDescription());
	}
	
}
