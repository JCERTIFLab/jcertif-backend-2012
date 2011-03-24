/**
 * 
 */
package com.jcertif.dao.hibernate.conference;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.dao.api.conference.FaqDAO;
import com.jcertif.dao.hibernate.AbstractDAOTestCase;

/**
 * @author rossi
 *
 */
@ContextConfiguration(locations = {"classpath:jcertif-dao-test-beans.xml"})
public class FaqDAOHibernateTest extends AbstractDAOTestCase {
	
	/**
	 * DAO FAQ.
	 */
	@Autowired
	private FaqDAO faqDAO;
	
	
	/**
	 * Test de la méthode findAll().
	 */
	@Test
	public void testFindAll() {
		Assert.assertEquals(3,faqDAO.findAll().size());
	}

}
