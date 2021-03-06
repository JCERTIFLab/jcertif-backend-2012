package com.jcertif.bo.conference;

import org.junit.Test;

import com.evasion.framework.test.EqualsTester;
import com.jcertif.bo.JCertifAccessorTesterImpl;

/**
 * Test BO {@link Conference}.
 * 
 * @author rossi.oddet
 * 
 */
public class ConferenceTest {

	/**
	 * Test de tous les accesseurs du Bo {@link Conference}.
	 */
	@Test
	public void testAllAccessors() {
		final Conference conf = new Conference();
		final JCertifAccessorTesterImpl accessorTester = new JCertifAccessorTesterImpl(conf);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méthodes Equals et Hashcode du Bo {@link Conference}.
	 */
	@Test
	public void testtestEqualsAndHashCode() {
		final Conference conf1 = new Conference();
		conf1.setId(1l);
		final Conference equivalentConference1 = new Conference();
		equivalentConference1.setId(1l);
		final Conference differentConference1 = new Conference();
		differentConference1.setId(2l);
		final Conference deriveConference1 = new Conference() {
		};
		deriveConference1.setId(1l);
		final EqualsTester vEqualTester = new EqualsTester();
		vEqualTester.testEqualsAndHashCode(conf1, equivalentConference1, differentConference1,
				deriveConference1);
	}
}
