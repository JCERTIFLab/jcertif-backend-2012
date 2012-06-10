package com.jcertif.bo.cedule;

import org.junit.Test;

import com.evasion.framework.test.AccessorTesterImpl;
import com.evasion.framework.test.EqualsTester;
import com.jcertif.bo.cedule.CeduleSalle;

/**
 * Test unitaire du BO CeduleCeduleSalle.
 * 
 * @author rossi.oddet
 * 
 */
public class CeduleSalleTest {


	/**
	 * Test de tous les accesseurs du Bo {@link CeduleSalle}.
	 */
	@Test
	public void testAllAccessors() {
		final CeduleSalle motCle = new CeduleSalle();
		final AccessorTesterImpl accessorTester = new AccessorTesterImpl(motCle);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méthodes Equals et Hashcode du Bo {@link CeduleSalle}.
	 */
	@Test
	public void testtestEqualsAndHashCode() {
		final CeduleSalle CeduleSalle1 = new CeduleSalle();
		CeduleSalle1.setId(Long.valueOf(1));
		final CeduleSalle equivalentCeduleSalle1 = new CeduleSalle();
		equivalentCeduleSalle1.setId(Long.valueOf(1));
		final CeduleSalle differentCeduleSalle1 = new CeduleSalle();
		differentCeduleSalle1.setId(Long.valueOf(2));
		final CeduleSalle deriveCeduleSalle1 = new CeduleSalle() {
		};
		deriveCeduleSalle1.setId(Long.valueOf(1));
		final EqualsTester vEqualTester = new EqualsTester();
		vEqualTester.testEqualsAndHashCode(CeduleSalle1, equivalentCeduleSalle1,
				differentCeduleSalle1, deriveCeduleSalle1);
	}
	
	
}
