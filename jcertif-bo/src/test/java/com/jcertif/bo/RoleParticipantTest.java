/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.bo;

import org.junit.Test;

import com.evasion.framework.test.EqualsTester;

/**
 * @author chrisbel
 */
public class RoleParticipantTest {

	
	/**
	 * Test de tous les accesseurs du Bo {@link CentreConference}.
	 */
	@Test
	public void testAllAccessors() {
		final RoleParticipant cc =new RoleParticipant(new Long(1), "ABCD","communication");
		final JCertifAccessorTesterImpl accessorTester = new JCertifAccessorTesterImpl(cc);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des m�hodes Equals et Hashcode du Bo {@link CentreConference}.
	 */
	@Test
	public void testEqualsAndHashCode() {
		final RoleParticipant a= new RoleParticipant(new Long(1), "ABCD","communication");
		
		final RoleParticipant b = new RoleParticipant(new Long(1), "ABCD","communication");
		
		final RoleParticipant c = new RoleParticipant(new Long(2), "La Reine","Silya");
		
		final RoleParticipant d =new RoleParticipant(new Long(1), "ABCD","communication"){
		};

		final EqualsTester equalsTester = new EqualsTester();
        equalsTester.testEqualsAndHashCode(a, b, c,d);
	}		
}