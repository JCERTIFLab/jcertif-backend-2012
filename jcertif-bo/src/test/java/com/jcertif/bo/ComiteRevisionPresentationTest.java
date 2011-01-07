package com.jcertif.bo;

import org.junit.Test;

import com.evasion.framework.test.EqualsTester;

/**
 * @author rossi.oddet
 *
 */
public class ComiteRevisionPresentationTest {
	/**
	 * Test de tous les accesseurs du Bo {@link ComiteRevisionPresentation}.
	 */
	@Test
	public void testAllAccessors() {
		final ComiteRevisionPresentation comite = new ComiteRevisionPresentation();
		final JCertifAccessorTesterImpl accessorTester = new JCertifAccessorTesterImpl(comite);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link ComiteRevisionPresentation}.
	 */
	@Test
	public void testEqualsAndHashCode() {
		ComiteRevisionPresentationPK pk = new ComiteRevisionPresentationPK();
		pk.setComiteOrganisationId(Long.valueOf(1));
		pk.setPresentationId(Long.valueOf(1));
		final ComiteRevisionPresentation a = new ComiteRevisionPresentation();
		a.setComiteRevisionPresentationPK(pk);
	
		final ComiteRevisionPresentation b = new ComiteRevisionPresentation();
		b.setComiteRevisionPresentationPK(pk);
		
		final ComiteRevisionPresentation c = new ComiteRevisionPresentation();
		ComiteRevisionPresentationPK pk2 = new ComiteRevisionPresentationPK();
		pk2.setComiteOrganisationId(Long.valueOf(2));
		pk2.setPresentationId(Long.valueOf(2));
		c.setComiteRevisionPresentationPK(pk2);
		
		final ComiteRevisionPresentation d = new ComiteRevisionPresentation() {
		};
		d.setComiteRevisionPresentationPK(pk);
		
		final EqualsTester equalsTester = new EqualsTester();
		equalsTester.testEqualsAndHashCode(a, b, c, d);

	}
}
