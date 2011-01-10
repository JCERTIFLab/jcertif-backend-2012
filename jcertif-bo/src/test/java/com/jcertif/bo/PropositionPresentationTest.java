package com.jcertif.bo;

import org.junit.Test;

import com.evasion.framework.test.EqualsTester;

/**
 * Test du BO présentation.
 * 
 * @author rossi.oddet
 * 
 */
public class PropositionPresentationTest {

	/**
	 * Test de tous les accesseurs du Bo {@link PropositionPresentation}.
	 */
	@Test
	public void testAllAccessors() {
		final PropositionPresentation presentation = new PropositionPresentation();
		final JCertifAccessorTesterImpl accessorTester = new JCertifAccessorTesterImpl(
				presentation);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link PropositionPresentation}.
	 */
	@Test
	public void testtestEqualsAndHashCode() {
		final PropositionPresentation presentation1 = getPresentation("titre 1", "desc 1",
				"details 1");
		final PropositionPresentation equivalentPresentation1 = getPresentation("titre 1",
				"desc 1", "details 1");
		final PropositionPresentation differentPresentation1 = getPresentation("titre 2",
				"desc 1", "details 1");
		final PropositionPresentation derivePresentation1 = new PropositionPresentation() {
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
	private PropositionPresentation getPresentation(final String titre, final String desc,
			final String details) {
		PropositionPresentation pres = new PropositionPresentation();
		pres.setTitre(titre);
		pres.setDescription(desc);
		pres.setDetails(details);
		return pres;
	}
}
