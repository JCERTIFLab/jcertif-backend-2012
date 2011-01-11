package com.jcertif.bo;

import org.junit.Test;

import com.evasion.framework.test.AccessorTesterImpl;
import com.evasion.framework.test.EqualsTester;

/**
 * Test du BO {@link Adresse}.
 * 
 * @author Douneg
 * 
 */
public class AdresseTest {

	/**
	 * Test de tous les accesseurs du Bo {@link Adresse}.
	 */
	@Test
	public void testAllAccessors() {
		final Adresse adresse = new Adresse();
		final AccessorTesterImpl accessorTester = new AccessorTesterImpl(
				adresse);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link Adresse}.
	 */
	@Test
	public void testtestEqualsAndHashCode() {
		final Adresse adresse1 = new Adresse(new Long(1), null, null,
				null, null, null, null, null, null, null, null);
		final Adresse equivalentadresse1 = new Adresse(new Long(1), null,
				null, null, null, null, null, null, null, null, null);
		final Adresse differentadresse1 = new Adresse(new Long(5), null,
				null, null, null, null, null, null, null, null, null);
		final Adresse deriveadresse1 = new Adresse(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
		};
		deriveadresse1.setId(new Long(1));
		final EqualsTester vEqualTester = new EqualsTester();
		vEqualTester.testEqualsAndHashCode(adresse1,
				equivalentadresse1, differentadresse1,
				deriveadresse1);
	}
}
