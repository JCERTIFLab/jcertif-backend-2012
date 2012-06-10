package com.jcertif.dao.hibernate.comite;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang.time.DateFormatUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.comite.ComiteRevisionPresentation;
import com.jcertif.bo.comite.ComiteRevisionPresentationPK;
import com.jcertif.dao.api.comite.ComiteRevisionPresentationDAO;
import com.jcertif.dao.hibernate.AbstractDAOTestCase;

/**
 * Test de la classe ComiteRevisionPresentationDAOHibernate.
 * 
 * @author rossi.oddet
 * 
 */
@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class ComiteRevisionPresentationDAOHibernateTest extends
		AbstractDAOTestCase {

	/**
	 * DAO ComiteRevisionPresentation.
	 */
	@Autowired
	private ComiteRevisionPresentationDAO comiteRevisionPresentationDAO;

	/**
	 * Test de la methode getReference().
	 */
	@Test
	public void testGetReference() {
		ComiteRevisionPresentationPK pk = new ComiteRevisionPresentationPK();
		pk.setComiteOrganisationId(Long.valueOf(1));
		pk.setPresentationId(Long.valueOf(1));
		ComiteRevisionPresentation comite = comiteRevisionPresentationDAO
				.getReference(pk);
		assertEquals("11-02-2011",
				DateFormatUtils.format(comite.getDateRevision(), "dd-MM-yyyy"));
	}

	/**
	 * Test de la methode findById().
	 */
	@Test
	public void testFindById() {
		ComiteRevisionPresentationPK pk = new ComiteRevisionPresentationPK();
		pk.setComiteOrganisationId(Long.valueOf(1));
		pk.setPresentationId(Long.valueOf(1));
		ComiteRevisionPresentation comite = comiteRevisionPresentationDAO
				.findById(pk);
		assertEquals("11-02-2011",
				DateFormatUtils.format(comite.getDateRevision(), "dd-MM-yyyy"));
	}

	/**
	 * Test de la methode findAll().
	 */
	@Test
	public void testFindAll() {
		assertEquals(4, comiteRevisionPresentationDAO.findAll().size());
	}

	/**
	 * Test de la methode findAllWithSort().
	 */
	@Test
	public void testFindAllWithSort() {
		assertEquals(Long.valueOf(4),
				comiteRevisionPresentationDAO.findAllWithSort("dateRevision", false)
						.iterator().next().getComiteRevisionPresentationPK().getPresentationId());
	}

	/**
	 * Test de la methode persist().
	 */
	@Test
	public void testPersist() {
		ComiteRevisionPresentationPK pk = new ComiteRevisionPresentationPK();
		pk.setComiteOrganisationId(Long.valueOf(100));
		pk.setPresentationId(Long.valueOf(100));
		ComiteRevisionPresentation comite = new ComiteRevisionPresentation();
		comite.setComiteRevisionPresentationPK(pk);
		comiteRevisionPresentationDAO.persist(comite);

		ComiteRevisionPresentation comiteRecup = comiteRevisionPresentationDAO
				.findById(comite.getComiteRevisionPresentationPK());
		assertEquals(Long.valueOf(100), comiteRecup.getComiteRevisionPresentationPK().getComiteOrganisationId());
		assertEquals(Long.valueOf(100), comiteRecup.getComiteRevisionPresentationPK().getPresentationId());
	}

	/**
	 * Test de la methode merge().
	 */
	@Test
	public void testMerge() {
		ComiteRevisionPresentationPK pk = new ComiteRevisionPresentationPK();
		pk.setComiteOrganisationId(Long.valueOf(1000));
		pk.setPresentationId(Long.valueOf(1000));
		ComiteRevisionPresentation comite = new ComiteRevisionPresentation();
		comite.setComiteRevisionPresentationPK(pk);
		ComiteRevisionPresentation persistedComiteRevisionPresentation = comiteRevisionPresentationDAO
				.merge(comite);

		ComiteRevisionPresentation comiteRecup = comiteRevisionPresentationDAO
				.findById(persistedComiteRevisionPresentation.getComiteRevisionPresentationPK());
		assertEquals(Long.valueOf(1000), comiteRecup.getComiteRevisionPresentationPK().getComiteOrganisationId());
		assertEquals(Long.valueOf(1000), comiteRecup.getComiteRevisionPresentationPK().getPresentationId());
	}

	/**
	 * Test de la methode remove().
	 */
	@Test
	public void testRemove() {
		ComiteRevisionPresentationPK pk = new ComiteRevisionPresentationPK();
		pk.setComiteOrganisationId(Long.valueOf(1));
		pk.setPresentationId(Long.valueOf(1));
		ComiteRevisionPresentation entity = comiteRevisionPresentationDAO
				.findById(pk);
		comiteRevisionPresentationDAO.remove(entity);
		assertEquals(3, comiteRevisionPresentationDAO.findAll().size());
	}
}