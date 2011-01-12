package com.jcertif.dao.hibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.ProfilUtilisateur;
import com.jcertif.dao.ProfilUtilisateurDAO;

/**
 * Test de l'impl�mentation Hibernate de l'acc�s aux donn�es ProfilUtilisateur.
 * 
 * @author Douneg
 * 
 */
@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class ProfilUtilisateurDAOHibernateTest extends AbstractDAOTestCase {

	/**
	 * DAO ProfilUtilisateur.
	 */
	@Autowired
	private ProfilUtilisateurDAO profilUtilisateurDAO;

	/**
	 * Test de la m�thode getReference().
	 */
	@Test
	public void testGetReference() {
		ProfilUtilisateur profilUtilisateur1 = profilUtilisateurDAO.getReference(Long.valueOf(5));
		assertEquals("malonga", profilUtilisateur1.getNomProfil());
		assertEquals("malonga@JCertif2011.kin", profilUtilisateur1.getEmail());
		assertEquals("diouf", profilUtilisateur1.getPhoto());
		assertEquals("mamadou", profilUtilisateur1.getLangueCorrespondance());
		assertEquals("m", profilUtilisateur1.getCodeConfirmation());

		
	}

	/**
	 * Test de la m�thode findById().
	 */
	@Test
	public void testFindById() {
		ProfilUtilisateur profilUtilisateur1 = profilUtilisateurDAO.findById((Long.valueOf(5)));
		assertEquals("malonga", profilUtilisateur1.getNomProfil());
		assertEquals("malonga@JCertif2011.kin", profilUtilisateur1.getEmail());
		assertEquals("diouf", profilUtilisateur1.getPhoto());
		assertEquals("mamadou", profilUtilisateur1.getLangueCorrespondance());
		assertEquals("m", profilUtilisateur1.getCodeConfirmation());
	}

	/**
	 * Test de la m�thode findAll().
	 */
	@Test
	public void testFindAll() {
		assertEquals(4, profilUtilisateurDAO.findAll().size());
	}

	/**
	 * Test de la m�thode findAllWithSort().
	 */
	@Test
	public void testFindAllWithSort() {
		assertEquals("pitBaccardi", profilUtilisateurDAO.findAllWithSort("nomProfil", false)
				.iterator().next().getNomProfil());
	}

	/**
	 * Test de la m�thode persist().
	 */
	@Test
	public void testPersist() {
		// Persistence
		ProfilUtilisateur profilUtilisateur1 = new ProfilUtilisateur();
		profilUtilisateur1.setNomProfil("UNForce");
		profilUtilisateur1.setEmail("UNForce@JCertif2001.kin");
		profilUtilisateurDAO.persist(profilUtilisateur1);

		// V�rification
		ProfilUtilisateur profilUtilisateurV = profilUtilisateurDAO.findById(profilUtilisateur1.getId());
		assertEquals("UNForce", profilUtilisateurV.getNomProfil());
		assertEquals("UNForce@JCertif2001.kin", profilUtilisateurV.getEmail());
		
	}

	/**
	 * Test de la m�thode merge().
	 */
	@Test
	public void testMerge() {
		// Persistence
		ProfilUtilisateur profilUtilisateur = new ProfilUtilisateur();
		profilUtilisateur.setNomProfil("UNForce");
		profilUtilisateur.setEmail("UNForce@JCertif2001.kin");
		profilUtilisateurDAO.persist(profilUtilisateur);
		ProfilUtilisateur savedProfilUtilisateur = profilUtilisateurDAO.merge(profilUtilisateur);

		// V�rification
		ProfilUtilisateur profilUtilisateur1 = profilUtilisateurDAO.findById(savedProfilUtilisateur.getId());
		assertEquals("UNForce", profilUtilisateur1.getNomProfil());
		assertEquals("UNForce@JCertif2001.kin", profilUtilisateur1.getEmail());
	}

	/**
	 * Test de la m�thode remove().
	 */
	@Test
	public void testRemove() {
		ProfilUtilisateur entity = profilUtilisateurDAO.findById(Long.valueOf(8));
		profilUtilisateurDAO.remove(entity);
		assertEquals(3, profilUtilisateurDAO.findAll().size());
	}
}
