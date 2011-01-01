package com.jcertif.bo;

import org.junit.Test;

import com.evasion.framework.test.AccessorTesterImpl;
import com.evasion.framework.test.EqualsTester;

/**
 * Test du BO {@link StatutCedule}
 * 
 * @author rossi.oddet
 * 
 */
public class StatutCeduleTest {

	/**
	 * Test de tous les accesseurs du Bo {@link StatutCedule}.
	 */
	@Test
	public void testAllAccessors() {
		final StatutCedule motCle = new StatutCedule();
		final AccessorTesterImpl accessorTester = new AccessorTesterImpl(motCle);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link StatutCedule}.
	 */
	@Test
	public void testtestEqualsAndHashCode() {
		final StatutCedule statut = new StatutCedule(
				"statut 1", "desc 1");
		final StatutCedule equivalentStatutCedule1 = new StatutCedule(
				"statut 1", "desc 1");
		final StatutCedule differentStatutCedule1 = new StatutCedule(
				"statut 3", "desc 1");
		final StatutCedule deriveStatutCedule1 = new StatutCedule(
				"statut 1", "desc 1") {
		};
		final EqualsTester vEqualTester = new EqualsTester();
		vEqualTester.testEqualsAndHashCode(statut,
				equivalentStatutCedule1, differentStatutCedule1,
				deriveStatutCedule1);
	}
}
