package com.jcertif.bo;


/**
 * Test du Bo CentreConference.
 * 
 * @author Mamadou
 * 
 */
public class CentreConferenceTest {

	/**
	 * Test de tous les accesseurs du Bo {@link CentreConference}.
	 */
	@Test
	public void testAllAccessors() {
		final CentreConference cc = new CentreConference();
		final AccessorTesterImpl accessorTester = new AccessorTesterImpl(cc);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link CentreConference}.
	 */
	@Test
	public void testtestEqualsAndHashCode() {
		final CentreConference centreConference1 = new CentreConference(
				new Long(1000), "nom1", "description", "adresse", "email",
				"website", "nomContact", "prenomContact", "telephoneContact",
				"details");
		final CentreConference equivalentCentreConference1 = new CentreConference(
				new Long(1000), "nom1", "description", "adresse", "email",
				"website", "nomContact", "prenomContact", "telephoneContact",
				"details");
		final CentreConference differentCentreConference1 = new CentreConference(new Long(
				1010), "nom2", "description", "adresse", "email", "website",
				"nomContact", "prenomContact", "telephoneContact", "details");
		final CentreConference deriveCentreConference1 = new CentreConference(new Long(
				1000), "nom1", "description", "adresse", "email", "website",
				"nomContact", "prenomContact", "telephoneContact", "details") {
		};
		final EqualsTester vEqualTester = new EqualsTester();
		vEqualTester.testEqualsAndHashCode(centreConference1,
				equivalentCentreConference1, differentCentreConference1,
				deriveCentreConference1);
	}
}
