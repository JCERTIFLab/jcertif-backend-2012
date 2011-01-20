/**
 * Douneg
 * MatayoBweta@gmail.com
 */
package com.jcertif.bo.cedule;

import org.junit.Test;

import com.evasion.framework.test.EqualsTester;
import com.jcertif.bo.JCertifAccessorTesterImpl;
import com.jcertif.bo.cedule.Evenement;

/**
 * @author Douneg
 */
public class EvenementTest {
	/**
	 * Test de tous les accesseurs du Bo {@link Evenement}.
	 */
	@Test
	public void testAllAccessors() {
		final Evenement cc = new Evenement(Long.valueOf(1), "vision de loin",
				null, null, null, null, "Rien a dire");
		final JCertifAccessorTesterImpl accessorTester = new JCertifAccessorTesterImpl(
				cc);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link Evenement}.
	 */
	@Test
	public void testEqualsAndHashCode() {
		final Evenement a = new Evenement(new Long(1), "vision de loin",
				null, null, null, null, "Rien a dire");

		final Evenement b = new Evenement(new Long(1), "vision de loin",
				null, null, null, null, "Rien a dire");

		final Evenement c = new Evenement(new Long(3), "vision d'aigle",
				null, null, null, null, "beaucoup a dire");

		final Evenement d = new Evenement() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
		};
		d.setId(new Long(1));
		d.setDetails("Rien a dire");
		d.setNomEvenement("vision de loin");
		final EqualsTester equalsTester = new EqualsTester();
		equalsTester.testEqualsAndHashCode(a, b, c, d);

	}
}
