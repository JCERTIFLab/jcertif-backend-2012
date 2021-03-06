package com.jcertif.dao.hibernate.comite;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.apache.commons.lang.time.DateFormatUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.comite.RappelEnvoye;
import com.jcertif.bo.comite.RappelEnvoyePK;
import com.jcertif.dao.api.comite.RappelEnvoyeDAO;
import com.jcertif.dao.hibernate.AbstractDAOTestCase;
import com.jcertif.dao.hibernate.comite.RappelEnvoyeDAOHibernate;

/**
 * Test de la classe {@link RappelEnvoyeDAOHibernate}.
 * 
 * @author rossi.oddet
 * 
 */
@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class RappelEnvoyeDAOHibernateTest extends AbstractDAOTestCase {

	/**
	 * DAO RappelEnvoye.
	 */
	@Autowired
	private RappelEnvoyeDAO rappelEnvoyeDAO;

	/**
	 * Test de la methode getReference().
	 */
	@Test
	public void testGetReference() {
		RappelEnvoyePK pk = new RappelEnvoyePK();
		pk.setComiteRvsPrstCmteOrgaId(Long.valueOf(1));
		pk.setComiteRevisPrestPrestId(Long.valueOf(1));
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(2011, 1, 11,0,0,0);
		System.out.println(calendar.getTime());
		pk.setDateRappel(calendar);
		RappelEnvoye rappel = rappelEnvoyeDAO.getReference(pk);
		assertEquals("11-04-2011",
				DateFormatUtils.format(rappel.getDateReponseRecu(), "dd-MM-yyyy"));
	}

	/**
	 * Test de la methode findById().
	 */
	@Test
	public void testFindById() {
		RappelEnvoyePK pk = new RappelEnvoyePK();
		pk.setComiteRvsPrstCmteOrgaId(Long.valueOf(1));
		pk.setComiteRevisPrestPrestId(Long.valueOf(1));
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(2011, 1, 11,0,0,0);
		pk.setDateRappel(calendar);
		RappelEnvoye rappel = rappelEnvoyeDAO.findById(pk);
		assertEquals("11-04-2011",
				DateFormatUtils.format(rappel.getDateReponseRecu(), "dd-MM-yyyy"));
	}

	/**
	 * Test de la methode findAll().
	 */
	@Test
	public void testFindAll() {
		assertEquals(3, rappelEnvoyeDAO.findAll().size());
	}

	

	/**
	 * Test de la methode persist().
	 */
	@Test
	public void testPersist() {
		RappelEnvoyePK pk = new RappelEnvoyePK();
		pk.setComiteRvsPrstCmteOrgaId(Long.valueOf(100));
		pk.setComiteRevisPrestPrestId(Long.valueOf(100));
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(2011, 1, 11,0,0,0);
		pk.setDateRappel(calendar);
		RappelEnvoye rappel = new RappelEnvoye();
		rappel.setRappelEnvoyePK(pk);
		rappelEnvoyeDAO.persist(rappel);

		RappelEnvoye rappelRecup = rappelEnvoyeDAO.findById(rappel
				.getRappelEnvoyePK());
		assertEquals(Long.valueOf(100), rappelRecup.getRappelEnvoyePK()
				.getComiteRvsPrstCmteOrgaId());
		assertEquals(Long.valueOf(100), rappelRecup.getRappelEnvoyePK()
				.getComiteRevisPrestPrestId());
	}

	/**
	 * Test de la methode merge().
	 */
	@Test
	public void testMerge() {
		RappelEnvoyePK pk = new RappelEnvoyePK();
		pk.setComiteRvsPrstCmteOrgaId(Long.valueOf(1000));
		pk.setComiteRevisPrestPrestId(Long.valueOf(1000));
		Calendar calendar = Calendar.getInstance();
		calendar.set(2011, 01, 11);
		pk.setDateRappel(calendar);
		RappelEnvoye rappel = new RappelEnvoye();
		rappel.setRappelEnvoyePK(pk);
		RappelEnvoye persistedRappelEnvoye = rappelEnvoyeDAO.merge(rappel);

		RappelEnvoye rappelRecup = rappelEnvoyeDAO
				.findById(persistedRappelEnvoye.getRappelEnvoyePK());
		assertEquals(Long.valueOf(1000), rappelRecup.getRappelEnvoyePK()
				.getComiteRvsPrstCmteOrgaId());
		assertEquals(Long.valueOf(1000), rappelRecup.getRappelEnvoyePK()
				.getComiteRevisPrestPrestId());
	}

	/**
	 * Test de la methode remove().
	 */
	@Test
	public void testRemove() {
		RappelEnvoyePK pk = new RappelEnvoyePK();
		pk.setComiteRvsPrstCmteOrgaId(Long.valueOf(1));
		pk.setComiteRevisPrestPrestId(Long.valueOf(1));
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(2011, 1, 11,0,0,0);
		pk.setDateRappel(calendar);
		RappelEnvoye entity = rappelEnvoyeDAO.findById(pk);
		rappelEnvoyeDAO.remove(entity);
		assertEquals(2, rappelEnvoyeDAO.findAll().size());
	}
}
