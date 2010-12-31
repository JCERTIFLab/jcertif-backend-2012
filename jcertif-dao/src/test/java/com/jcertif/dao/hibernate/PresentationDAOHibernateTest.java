package com.jcertif.dao.hibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.MotCle;
import com.jcertif.bo.Presentation;
import com.jcertif.bo.StatutApprobation;
import com.jcertif.dao.PresentationDAO;

/**
 * Test de l'implémentation Hibernate de l'accès aux données Presentation.
 * 
 * @author rossi.oddet
 * 
 */
@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class PresentationDAOHibernateTest extends AbstractDAOTestCase {

	/**
	 * DAO Presentation.
	 */
	@Autowired
	private PresentationDAO presentationDAO;

	/**
	 * Test de la méthode getReference().
	 */
	@Test
	public void testGetReference() {
		Presentation presentation1 = presentationDAO.getReference(Long.valueOf(1));
		assertEquals("titre 1", presentation1.getTitre());
		assertEquals("description 1", presentation1.getDescription());
		assertEquals("details 1", presentation1.getDetails());
		assertEquals(Long.valueOf(4), presentation1.getMotCle().getId());
		assertEquals("mot_cle 4", presentation1.getMotCle().getMotCle());
		assertEquals("description 4", presentation1.getMotCle().getDescription());
		assertEquals(3, presentation1.getSujets().size());
	}

	/**
	 * Test de la méthode findById().
	 */
	@Test
	public void testFindById() {
		Presentation presentation1 = presentationDAO.findById(Long.valueOf(2));
		assertEquals("titre 2", presentation1.getTitre());
		assertEquals("description 2", presentation1.getDescription());
		assertEquals("details 2", presentation1.getDetails());
		assertEquals(Long.valueOf(5), presentation1.getMotCle().getId());
		assertEquals("mot_cle 5", presentation1.getMotCle().getMotCle());
		assertEquals("description 5", presentation1.getMotCle().getDescription());
		
	}

	/**
	 * Test de la méthode findAll().
	 */
	@Test
	public void testFindAll() {
		assertEquals(3, presentationDAO.findAll().size());
	}

	/**
	 * Test de la méthode findAllWithSort().
	 */
	@Test
	public void testFindAllWithSort() {
		assertEquals("titre 3", presentationDAO.findAllWithSort("titre", false)
				.iterator().next().getTitre());
	}

	/**
	 * Test de la méthode persist().
	 */
	@Test
	public void testPersist() {
		// Persistence
		Presentation presentation = new Presentation();
		presentation.setTitre("titre 100");
		presentation.setDescription("description 100");
		presentation.setDetails("details 100");
		MotCle motCle = new MotCle();
		motCle.setMotCle("mot_cle 1");
		motCle.setDescription("description 1");
		presentation.setMotCle(motCle);
		StatutApprobation statut = new StatutApprobation();
		statut.setCodeStatut("code_statut 100");
		statut.setDescription("description 100");
		presentation.setStatutApprobation(statut);
		presentationDAO.persist(presentation);

		// Vérification
		Presentation presentation1 = presentationDAO.findById(presentation.getId());
		assertEquals("titre 100", presentation1.getTitre());
		assertEquals("description 100", presentation1.getDescription());
		assertEquals("details 100", presentation1.getDetails());
		assertEquals("mot_cle 1", presentation1.getMotCle().getMotCle());
		assertEquals("description 1", presentation1.getMotCle().getDescription());
		assertEquals("code_statut 100", presentation1.getStatutApprobation().getCodeStatut());
		assertEquals("description 100", presentation1.getStatutApprobation().getDescription());
	}

	/**
	 * Test de la méthode merge().
	 */
	@Test
	public void testMerge() {
		// Persistence
		Presentation presentation = new Presentation();
		presentation.setTitre("titre 1000");
		presentation.setDescription("description 1000");
		presentation.setDetails("details 1000");
		MotCle motCle = new MotCle();
		motCle.setMotCle("mot_cle 2");
		motCle.setDescription("description 2");
		presentation.setMotCle(motCle);
		StatutApprobation statut = new StatutApprobation();
		statut.setCodeStatut("code_statut 1000");
		statut.setDescription("description 1000");
		presentation.setStatutApprobation(statut);
		Presentation savedPresentation = presentationDAO.merge(presentation);

		// Vérification
		Presentation presentation1 = presentationDAO.findById(savedPresentation.getId());
		assertEquals("titre 1000", presentation1.getTitre());
		assertEquals("description 1000", presentation1.getDescription());
		assertEquals("details 1000", presentation1.getDetails());
		assertEquals("mot_cle 2", presentation1.getMotCle().getMotCle());
		assertEquals("description 2", presentation1.getMotCle().getDescription());
		assertEquals("code_statut 1000", presentation1.getStatutApprobation().getCodeStatut());
		assertEquals("description 1000", presentation1.getStatutApprobation().getDescription());
	}

	/**
	 * Test de la méthode remove().
	 */
	@Test
	public void testRemove() {
		Presentation entity = presentationDAO.findById(Long.valueOf(1l));
		presentationDAO.remove(entity);
		assertEquals(2, presentationDAO.findAll().size());
	}
	
	

}
