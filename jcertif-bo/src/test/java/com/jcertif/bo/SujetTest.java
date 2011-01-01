package com.jcertif.bo;

import org.junit.Test;

import com.evasion.framework.test.AccessorTesterImpl;
import com.evasion.framework.test.EqualsTester;

/**
 * Test du Bo Sujet.
 * 
 * @author rossi.oddet
 * 
 */
public class SujetTest {
	
	/**
	 * Test de tous les accesseurs du Bo {@link Sujet}.
	 */
	@Test
	public void testAllAccessors() {
		final Sujet motCle = new Sujet();
		final AccessorTesterImpl accessorTester = new AccessorTesterImpl(motCle);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link Sujet}.
	 */
	@Test
	public void testtestEqualsAndHashCode() {
		final Sujet motCle1 = new Sujet("sujet 1", "desc 1");
		final Sujet equivalentSujet1 = new Sujet("sujet 1", "desc 1");
		final Sujet differentSujet1 = new Sujet("sujet 3", "desc 1");
		final Sujet deriveSujet1 = new Sujet("sujet 1", "desc 1") {
		};
		final EqualsTester vEqualTester = new EqualsTester();
		vEqualTester.testEqualsAndHashCode(motCle1, equivalentSujet1,
				differentSujet1, deriveSujet1);
	}
}
