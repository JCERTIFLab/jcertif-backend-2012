package com.jcertif.bo;

import org.junit.Test;

import com.evasion.framework.test.EqualsTester;
import static junit.framework.TestCase.*;

/**
 * Test du BO {@link RappelEnvoye}.
 * 
 * @author rossi.oddet
 * 
 */
public class RappelEnvoyeTest {

	/**
	 * Test de tous les accesseurs du Bo {@link CentreConference}.
	 */
	@Test
	public void testAllAccessors() {
		final RappelEnvoye rappel = new RappelEnvoye();
		final JCertifAccessorTesterImpl accessorTester = new JCertifAccessorTesterImpl(
				rappel);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link CentreConference}.
	 */
	@Test
	public void testEqualsAndHashCode() {
		final RappelEnvoye a = new RappelEnvoye();
		a.setRappelEnvoyePK(getRappelEnvoyePK(Long.valueOf(1), Long.valueOf(1)));
		final RappelEnvoye b = new RappelEnvoye();
		b.setRappelEnvoyePK(getRappelEnvoyePK(Long.valueOf(1), Long.valueOf(1)));
		assertEquals(a, b);
		final RappelEnvoye c = new RappelEnvoye();
		c.setRappelEnvoyePK(getRappelEnvoyePK(Long.valueOf(2), Long.valueOf(1)));
		final RappelEnvoye d = new RappelEnvoye() {
		};
		d.setRappelEnvoyePK(getRappelEnvoyePK(Long.valueOf(1), Long.valueOf(1)));
		final EqualsTester equalsTester = new EqualsTester();
		equalsTester.testEqualsAndHashCode(a, b, c, d);
	}

	private RappelEnvoyePK getRappelEnvoyePK(Long id1, Long id2) {
		RappelEnvoyePK pk = new RappelEnvoyePK();
		pk.setComiteRvsPrstCmteOrgaId(Long.valueOf(id1));
		pk.setComiteRevisPrestPrestId(Long.valueOf(id2));
		return pk;
	}
}
