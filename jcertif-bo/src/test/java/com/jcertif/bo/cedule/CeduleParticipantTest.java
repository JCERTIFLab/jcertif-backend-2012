/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.bo.cedule;

import org.junit.Test;

import com.evasion.framework.test.EqualsTester;
import com.jcertif.bo.JCertifAccessorTesterImpl;
import com.jcertif.bo.cedule.CeduleParticipant;
import com.jcertif.bo.conference.CentreConference;

/**
 * @author chrisbel
 */
public class CeduleParticipantTest {

	
	/**
	 * Test de tous les accesseurs du Bo {@link CentreConference}.
	 */
	@Test
	public void testAllAccessors() {
		final CeduleParticipant cc =new CeduleParticipant(new Long(1), new Long(2));
		final JCertifAccessorTesterImpl accessorTester = new JCertifAccessorTesterImpl(cc);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méthodes Equals et Hashcode du Bo {@link CentreConference}.
	 */
	@Test
	public void testEqualsAndHashCode() {
		final CeduleParticipant a= new CeduleParticipant(new Long(1),new Long(2));
		
		final CeduleParticipant b = new CeduleParticipant(new Long(1),new Long(2));
		
		final CeduleParticipant c =  new CeduleParticipant(new Long(1),new Long(3));
		
		final CeduleParticipant d = new CeduleParticipant(new Long(1),new Long(2)){
			
		};

		final EqualsTester equalsTester = new EqualsTester();
        equalsTester.testEqualsAndHashCode(a, b, c,d);
		

	}
}
