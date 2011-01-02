package com.jcertif.bo;

import org.junit.Test;

import com.evasion.framework.test.AccessorTesterImpl;
import com.evasion.framework.test.EqualsTester;

/**
 * Test unitaire du BO Salle.
 * 
 * @author rossi.oddet
 * 
 */
public class SalleTest {

	/**
	 * Test de tous les accesseurs du Bo {@link Salle}.
	 */
	@Test
	public void testAllAccessors() {
		final Salle motCle = new Salle();
		final JCertifAccessorTesterImpl accessorTester = new JCertifAccessorTesterImpl(motCle);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link Salle}.
	 */
	@Test
	public void testtestEqualsAndHashCode() {
		final Salle motCle1 = new Salle("salle 1", "desc 1");
		final Salle equivalentSalle1 = new Salle("salle 1", "desc 1");
		final Salle differentSalle1 = new Salle("salle 3", "desc 1");
		final Salle deriveSalle1 = new Salle("salle 1", "desc 1") {
		};
		final EqualsTester vEqualTester = new EqualsTester();
		vEqualTester.testEqualsAndHashCode(motCle1, equivalentSalle1,
				differentSalle1, deriveSalle1);
	}
}
