package com.jcertif.dao.hibernate.cedule;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.cedule.TypeEvenement;
import com.jcertif.dao.api.cedule.TypeEvenementDAO;
import com.jcertif.dao.hibernate.AbstractDAOTestCase;

/**
 * @author rossi.oddet
 * 
 */
@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class TypeEvenementDAOHibernateTest extends AbstractDAOTestCase {

	/**
	 * DAO Type Evenement.
	 */
	@Autowired
	private TypeEvenementDAO typeEvenementDAO;

	/**
	 * Test de la méthode findById().
	 */
	@Test
	public void testFindById() {
		TypeEvenement typeEvent = typeEvenementDAO.findById(Long.valueOf(1));
		assertEquals("code type_evenement 1", typeEvent.getCode());
		assertEquals("description type_evenement 1", typeEvent.getDescription());
	}

}
