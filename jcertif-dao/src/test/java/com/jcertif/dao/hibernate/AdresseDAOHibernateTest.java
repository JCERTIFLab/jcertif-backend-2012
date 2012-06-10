package com.jcertif.dao.hibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.Adresse;
import com.jcertif.dao.api.AdresseDAO;

/**
 * Test de l'implementation Hibernate de l'acces aux donnees Adresse.
 * 
 * @author Douneg
 * 
 */
@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class AdresseDAOHibernateTest extends AbstractDAOTestCase {

	/**
	 * DAO Adresse.
	 */
	@Autowired
	private AdresseDAO adresseDAO;

	/**
	 * Test de la methode getReference().
	 */
	@Test
	public void testGetReference() {
		Adresse adresse1 = adresseDAO.getReference(Long.valueOf(1));
		assertEquals("RDC", adresse1.getPays());
		assertEquals("Kinshasa 1", adresse1.getProvince());
		assertEquals("Kinshasa 1", adresse1.getVille());
		assertEquals("ligne1 1", adresse1.getLigne1());
		assertEquals("ligne2 1", adresse1.getLigne2());
		assertEquals("code_postal 1", adresse1.getCodePostal());
		assertEquals("fax", adresse1.getFax());
		assertEquals("telephone_fixe 1", adresse1.getTelephoneFixe());
		assertEquals("telephone_mobile 1", adresse1.getTelephoneMobile());
		
	}

	/**
	 * Test de la methode findById().
	 */
	@Test
	public void testFindById() {
		Adresse adresse1 = adresseDAO.findById((Long.valueOf(1)));
		assertEquals("RDC", adresse1.getPays());
		assertEquals("Kinshasa 1", adresse1.getProvince());
		assertEquals("Kinshasa 1", adresse1.getVille());
		assertEquals("ligne1 1", adresse1.getLigne1());
		assertEquals("ligne2 1", adresse1.getLigne2());
		assertEquals("code_postal 1", adresse1.getCodePostal());
		assertEquals("fax", adresse1.getFax());
		assertEquals("telephone_fixe 1", adresse1.getTelephoneFixe());
		assertEquals("telephone_mobile 1", adresse1.getTelephoneMobile());
	}

	/**
	 * Test de la methode findAll().
	 */
	@Test
	public void testFindAll() {
		assertEquals(8, adresseDAO.findAll().size());
	}

	/**
	 * Test de la methode findAllWithSort().
	 */
	@Test
	public void testFindAllWithSort() {
		assertEquals("ligne1 8", adresseDAO.findAllWithSort("ligne1", false)
				.iterator().next().getLigne1());
	}

	/**
	 * Test de la methode persist().
	 */
	@Test
	public void testPersist() {
		// Persistence
		Adresse adresse1 = new Adresse();
		adresse1.setLigne1("ligne 345");
		adresse1.setDetails("details 345");
		adresseDAO.persist(adresse1);

		// Verification
		Adresse adresseV = adresseDAO.findById(adresse1.getId());
		assertEquals("ligne 345", adresseV.getLigne1());
		assertEquals("details 345", adresseV.getDetails());
		
	}

	/**
	 * Test de la methode merge().
	 */
	@Test
	public void testMerge() {
		// Persistence
		Adresse adresse = new Adresse();
		adresse.setLigne1("ligne1 1000");
		adresse.setLigne2("ligne2 1000");
		adresse.setDetails("details 1000");
		adresseDAO.persist(adresse);
		Adresse savedAdresse = adresseDAO.merge(adresse);

		// Verification
		Adresse adresse1 = adresseDAO.findById(savedAdresse.getId());
		assertEquals("ligne1 1000", adresse1.getLigne1());
		assertEquals("ligne2 1000", adresse1.getLigne2());
		assertEquals("details 1000", adresse1.getDetails());
	}

	/**
	 * Test de la methode remove().
	 */
	@Test
	public void testRemove() {
		Adresse entity = adresseDAO.findById(Long.valueOf(1l));
		adresseDAO.remove(entity);
		assertEquals(7, adresseDAO.findAll().size());
	}
}
