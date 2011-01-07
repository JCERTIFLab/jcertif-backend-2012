package com.jcertif.bo;

import org.junit.Test;

import com.evasion.framework.test.EqualsTester;

/**
 * Test des auteurs.
 * 
 * @author rossi.oddet
 * 
 */
public class AuteurTest {

	/**
	 * Test de tous les accesseurs du Bo {@link Auteur}.
	 */
	@Test
	public void testAllAccessors() {
		final Auteur auteur = new Auteur();
		final JCertifAccessorTesterImpl accessorTester = new JCertifAccessorTesterImpl(auteur);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link Auteur}.
	 */
	@Test
	public void testEqualsAndHashCode() {
		final Auteur auteur1 = getAuteur("a@jcertif.com", "a", "a");
		final Auteur equivalentAuteur1 = getAuteur("a@jcertif.com", "a", "a");
		final Auteur differentAuteur1 = getAuteur("b@jcertif.com", "a", "a");
		final Auteur deriveAuteur1 = new Auteur() {
		};
		deriveAuteur1.setEmail("a@jcertif.com");
		deriveAuteur1.setNom("a");
		deriveAuteur1.setPrenom("a");
		final EqualsTester vEqualTester = new EqualsTester();
		vEqualTester.testEqualsAndHashCode(auteur1, equivalentAuteur1,
				differentAuteur1, deriveAuteur1);
	}

	/**
	 * Retourne un objet auteur.
	 * 
	 * @param email
	 *            un email
	 * @param nom
	 *            un nom
	 * @param prenom
	 *            un prénom
	 * @return un objet auteur
	 */
	private Auteur getAuteur(String email, String nom, String prenom) {
		final Auteur auteur1 = new Auteur();
		auteur1.setEmail(email);
		auteur1.setNom(nom);
		auteur1.setPrenom(prenom);
		return auteur1;
	}
}
