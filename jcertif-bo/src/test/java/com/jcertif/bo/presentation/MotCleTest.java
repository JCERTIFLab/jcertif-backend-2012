package com.jcertif.bo.presentation;

import org.junit.Test;

import com.evasion.framework.test.AccessorTesterImpl;
import com.evasion.framework.test.EqualsTester;
import com.jcertif.bo.presentation.MotCle;

/**
 * Test du Bo {@link MotCle}.
 * 
 * @author rossi.oddet
 * 
 */
public class MotCleTest {

	/**
	 * Test de tous les accesseurs du Bo {@link MotCle}.
	 */
	@Test
	public void testAllAccessors() {
		final MotCle motCle = new MotCle();
		final AccessorTesterImpl accessorTester = new AccessorTesterImpl(motCle);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link MotCle}.
	 */
	@Test
	public void testtestEqualsAndHashCode() {
		final MotCle motCle1 = new MotCle("mot cle 1", null);
		final MotCle equivalentMotCle1 = new MotCle("mot cle 1", null);
		final MotCle differentMotCle1 = new MotCle("mot cle 3", null);
		final MotCle deriveMotCle1 = new MotCle("mot cle 1", null) {
		};
		final EqualsTester vEqualTester = new EqualsTester();
		vEqualTester.testEqualsAndHashCode(motCle1, equivalentMotCle1,
				differentMotCle1, deriveMotCle1);
	}

}
