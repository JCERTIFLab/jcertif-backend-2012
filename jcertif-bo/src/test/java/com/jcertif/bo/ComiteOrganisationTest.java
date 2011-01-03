package com.jcertif.bo;

import org.junit.Test;

import com.evasion.framework.test.AccessorTesterImpl;
import com.evasion.framework.test.EqualsTester;

/**
 * Test du BO ComiteOrganisation.
 * 
 * @author rossi.oddet
 * 
 */
public class ComiteOrganisationTest {

	/**
	 * Test de tous les accesseurs du Bo {@link ComiteOrganisation}.
	 */
	@Test
	public void testAllAccessors() {
		final ComiteOrganisation comite = new ComiteOrganisation();
		final AccessorTesterImpl accessorTester = new AccessorTesterImpl(comite);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link ComiteOrganisation}.
	 */
	@Test
	public void testEqualsAndHashCode() {
		final ComiteOrganisation a = new ComiteOrganisation();
		a.setEmail("a@jcertif.com");
		a.setNom("nom_a");
		a.setPrenom("prenom_a");
		final ComiteOrganisation b = new ComiteOrganisation();
		b.setEmail("a@jcertif.com");
		b.setNom("nom_a");
		b.setPrenom("prenom_a");
		final ComiteOrganisation c = new ComiteOrganisation();
		c.setEmail("c@jcertif.com");
		c.setNom("nom_a");
		c.setPrenom("prenom_a");
		final ComiteOrganisation d = new ComiteOrganisation() {
		};
		d.setEmail("a@jcertif.com");
		d.setNom("nom_a");
		d.setPrenom("prenom_a");
		final EqualsTester equalsTester = new EqualsTester();
		equalsTester.testEqualsAndHashCode(a, b, c, d);

	}
}
