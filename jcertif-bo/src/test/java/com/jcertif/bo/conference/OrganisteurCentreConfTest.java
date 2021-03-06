package com.jcertif.bo.conference;

import org.junit.Test;

import com.evasion.framework.test.EqualsTester;
import com.jcertif.bo.JCertifAccessorTesterImpl;
import com.jcertif.bo.conference.CentreConference;
import com.jcertif.bo.conference.OrganisateurCentreConf;

/**
 * @author rossi.oddet
 * 
 */
public class OrganisteurCentreConfTest {

	/**
	 * Test de tous les accesseurs du Bo {@link CentreConference}.
	 */
	@Test
	public void testAllAccessors() {
		final OrganisateurCentreConf cc = new OrganisateurCentreConf();
		final JCertifAccessorTesterImpl accessorTester = new JCertifAccessorTesterImpl(
				cc);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méthodes Equals et Hashcode du Bo {@link CentreConference}.
	 */
	@Test
	public void testEqualsAndHashCode() {
		final OrganisateurCentreConf a = new OrganisateurCentreConf();
		a.setNom("noma");
		final OrganisateurCentreConf b = new OrganisateurCentreConf();
		b.setNom("noma");
		final OrganisateurCentreConf c = new OrganisateurCentreConf();
		c.setNom("nomb");
		final OrganisateurCentreConf d = new OrganisateurCentreConf() {
			private static final long serialVersionUID = 1L;
		};
		d.setNom("noma");
		final EqualsTester equalsTester = new EqualsTester();
		equalsTester.testEqualsAndHashCode(a, b, c, d);
	}
}
