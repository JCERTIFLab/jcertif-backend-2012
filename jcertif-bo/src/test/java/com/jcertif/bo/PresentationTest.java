package com.jcertif.bo;

import org.junit.Test;

import com.evasion.framework.test.EqualsTester;

/**
 * Test du BO présentation.
 * 
 * @author rossi.oddet
 * 
 */
public class PresentationTest {

	/**
	 * Test de tous les accesseurs du Bo {@link Presentation}.
	 */
	@Test
	public void testAllAccessors() {
		final Presentation presentation = new Presentation();
		final JCertifAccessorTesterImpl accessorTester = new JCertifAccessorTesterImpl(
				presentation);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link Presentation}.
	 */
	@Test
	public void testtestEqualsAndHashCode() {
		final Presentation presentation1 = getPresentation("titre 1", "desc 1",
				"details 1");
		final Presentation equivalentPresentation1 = getPresentation("titre 1",
				"desc 1", "details 1");
		final Presentation differentPresentation1 = getPresentation("titre 2",
				"desc 1", "details 1");
		final Presentation derivePresentation1 = new Presentation() {
		};
		derivePresentation1.setTitre("titre 1");
		derivePresentation1.setDescription("desc 1");
		derivePresentation1.setDetails("details 1");
		final EqualsTester vEqualTester = new EqualsTester();
		vEqualTester.testEqualsAndHashCode(presentation1,
				equivalentPresentation1, differentPresentation1,
				derivePresentation1);
	}

	/**
	 * @param titre
	 *            un titre
	 * @param desc
	 *            une description
	 * @param details
	 *            les détails
	 * @return un objet présentation.
	 */
	private Presentation getPresentation(final String titre, final String desc,
			final String details) {
		Presentation pres = new Presentation();
		pres.setTitre(titre);
		pres.setDescription(desc);
		pres.setDetails(details);
		return pres;
	}
}
