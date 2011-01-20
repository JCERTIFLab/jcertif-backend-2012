package com.jcertif.bo.presentation;

import org.junit.Test;

import com.evasion.framework.test.AccessorTesterImpl;
import com.evasion.framework.test.EqualsTester;
import com.jcertif.bo.presentation.StatutApprobation;

/**
 * Test du BO Statut Approbation.
 * 
 * @author rossi.oddet
 * 
 */
public class StatutApprobationTest {


	/**
	 * Test de tous les accesseurs du Bo {@link StatutApprobation}.
	 */
	@Test
	public void testAllAccessors() {
		final StatutApprobation motCle = new StatutApprobation();
		final AccessorTesterImpl accessorTester = new AccessorTesterImpl(motCle);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link StatutApprobation}.
	 */
	@Test
	public void testtestEqualsAndHashCode() {
		final StatutApprobation statutApprobation = new StatutApprobation("statut 1", "desc 1");
		final StatutApprobation equivalentStatutApprobation1 = new StatutApprobation("statut 1", "desc 1");
		final StatutApprobation differentStatutApprobation1 = new StatutApprobation("statut 3", "desc 1");
		final StatutApprobation deriveStatutApprobation1 = new StatutApprobation("statut 1", "desc 1") {
		};
		final EqualsTester vEqualTester = new EqualsTester();
		vEqualTester.testEqualsAndHashCode(statutApprobation, equivalentStatutApprobation1,
				differentStatutApprobation1, deriveStatutApprobation1);
	}
}
