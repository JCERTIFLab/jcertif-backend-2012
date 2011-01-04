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
public class CeduleParticipantTest {

	
	/**
	 * Test de tous les accesseurs du Bo {@link CentreConference}.
	 */
	@Test
	public void testAllAccessors() {
		final CeduleParticipant cc =new CeduleParticipant(new Long(1), null,"details", null,null, null);
		final JCertifAccessorTesterImpl accessorTester = new JCertifAccessorTesterImpl(cc);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link CentreConference}.
	 */
	@Test
	public void testEqualsAndHashCode() {
		final CeduleParticipant a= new CeduleParticipant(new Long(1), null,"details", null,null, null);
		
		final CeduleParticipant b = new CeduleParticipant(new Long(1), null,"details", null,null, null);
		
		final CeduleParticipant c =  new CeduleParticipant(new Long(2), null,"le vide", null,null, null);
		
		final CeduleParticipant d = new CeduleParticipant(new Long(1), null,"details", null,null, null){
			
		};

		final EqualsTester equalsTester = new EqualsTester();
        equalsTester.testEqualsAndHashCode(a, b, c,d);
		

	}
}
