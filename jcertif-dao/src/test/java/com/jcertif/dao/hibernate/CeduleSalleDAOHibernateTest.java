package com.jcertif.dao.hibernate;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.CeduleSalle;
import com.jcertif.dao.CeduleSalleDAO;

/**
 * Test de l'implémentation hibernate de l'accès aux données CeduleSalle.
 * 
 * @author rossi.oddet
 * 
 */
@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class CeduleSalleDAOHibernateTest extends AbstractDAOTestCase {

	/**
	 * DAO CeduleSalle.
	 */
	@Autowired
	private CeduleSalleDAO ceduleSalleDAO;

	/**
	 * Test de la méthode getReference().
	 * @throws ParseException 
	 */
	@Test
	public void testGetReference() throws ParseException {
		final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CeduleSalle ceduleSalle1 = ceduleSalleDAO.getReference(Long.valueOf(1));
		assertEquals("2011-02-01", dateFormat.format(ceduleSalle1.getDateCedule()));
		assertEquals("details 1", ceduleSalle1.getDetails());
	}

	/**
	 * Test de la méthode findById().
	 */
	@Test
	public void testFindById() {
		final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CeduleSalle ceduleSalle2 = ceduleSalleDAO.findById(Long.valueOf(2));
		assertEquals("2011-02-02", dateFormat.format(ceduleSalle2.getDateCedule()));
		assertEquals("details 2", ceduleSalle2.getDetails());
		assertEquals("libelle salle 2", ceduleSalle2.getSalle().getLibelle());
		assertEquals("code_statut statut_cedule 8", ceduleSalle2.getStatutCedule().getCode());
	}

	/**
	 * Test de la méthode findAll().
	 */
	@Test
	public void testFindAll() {
		assertEquals(8, ceduleSalleDAO.findAll().size());
	}

	/**
	 * Test de la méthode findAllWithSort().
	 */
	@Test
	public void testFindAllWithSort() {
		assertEquals("details 8", ceduleSalleDAO.findAllWithSort("details", false)
				.iterator().next().getDetails());
	}

	/**
	 * Test de la méthode persist().
	 */
	@Test
	public void testPersist() {
		CeduleSalle ceduleSalle = new CeduleSalle();
		Date date = new Date();
		ceduleSalle.setDateCedule(date);
		ceduleSalle.setDetails("details 100");
		ceduleSalleDAO.persist(ceduleSalle);

		CeduleSalle ceduleSalle1 = ceduleSalleDAO.findById(ceduleSalle.getId());
		assertEquals(date, ceduleSalle1.getDateCedule());
		assertEquals("details 100", ceduleSalle1.getDetails());
	}

	/**
	 * Test de la méthode merge().
	 */
	@Test
	public void testMerge() {
		CeduleSalle ceduleSalle = new CeduleSalle();
		Date date = new Date();
		ceduleSalle.setDateCedule(date);
		ceduleSalle.setDetails("details 1000");
		CeduleSalle persistedCeduleSalle = ceduleSalleDAO.merge(ceduleSalle);

		CeduleSalle ceduleSalle1 = ceduleSalleDAO.findById(persistedCeduleSalle.getId());
		assertEquals(date, ceduleSalle1.getDateCedule());
		assertEquals("details 1000", ceduleSalle1.getDetails());
	}

	/**
	 * Test de la méthode remove().
	 */
	@Test
	public void testRemove() {
		CeduleSalle entity = ceduleSalleDAO.findById(Long.valueOf(3l));
		ceduleSalleDAO.remove(entity);
		assertEquals(7, ceduleSalleDAO.findAll().size());
	}

}
