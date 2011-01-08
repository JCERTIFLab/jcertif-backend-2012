package com.jcertif.bo;

import org.junit.Test;

import com.evasion.framework.test.EqualsTester;

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
	 * Test des méhodes Equals et Hashcode du Bo {@link Conference}.
	 */
	@Test
	public void testtestEqualsAndHashCode() {
		final Conference conf1 = new Conference();
		conf1.setNom("aa");
		final Conference equivalentConference1 = new Conference();
		equivalentConference1.setNom("aa");
		final Conference differentConference1 = new Conference();
		differentConference1.setNom("bb");
		final Conference deriveConference1 = new Conference() {
		};
		deriveConference1.setNom("aa");
		final EqualsTester vEqualTester = new EqualsTester();
		vEqualTester.testEqualsAndHashCode(conf1, equivalentConference1,
				differentConference1, deriveConference1);
	}
}
