package com.jcertif.bo.presentation;

import org.junit.Test;

import com.evasion.framework.test.AccessorTesterImpl;
import com.evasion.framework.test.EqualsTester;
import com.jcertif.bo.presentation.Appreciation;

/**
 * Test du BO {@link Appreciation}.
 * 
 * @author rossi.oddet
 * 
 */
public class AppreciationTest {

	/**
	 * Test de tous les accesseurs du Bo {@link Appreciation}.
	 */
	@Test
	public void testAllAccessors() {
		final Appreciation appreciation = new Appreciation();
		final AccessorTesterImpl accessorTester = new AccessorTesterImpl(appreciation);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link Appreciation}.
	 */
	@Test
	public void testtestEqualsAndHashCode() {
		final Appreciation appreciation1 = new Appreciation("appreciation 1", null);
		final Appreciation equivalentAppreciation1 = new Appreciation("appreciation 1", null);
		final Appreciation differentAppreciation1 = new Appreciation("appreciation 3", null);
		final Appreciation deriveAppreciation1 = new Appreciation("appreciation 1", null) {
		};
		final EqualsTester vEqualTester = new EqualsTester();
		vEqualTester.testEqualsAndHashCode(appreciation1, equivalentAppreciation1,
				differentAppreciation1, deriveAppreciation1);
	}
}
