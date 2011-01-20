/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.bo.participant;

import org.junit.Test;

import com.evasion.framework.test.EqualsTester;
import com.jcertif.bo.JCertifAccessorTesterImpl;
import com.jcertif.bo.conference.CentreConference;
import com.jcertif.bo.participant.Participant;

/**
 * @author chrisbel
 */
public class ParticipantTest {
	/**
	 * Test de tous les accesseurs du Bo {@link CentreConference}.
	 */
	@Test
	public void testAllAccessors() {
		final Participant cc =new Participant(new Long(1), "2011-01-03",null, null,"Malonga",null,null,null,null,null,null,null,null,null);
		final JCertifAccessorTesterImpl accessorTester = new JCertifAccessorTesterImpl(cc);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link CentreConference}.
	 */
	@Test
	public void testEqualsAndHashCode() {
		final Participant a= new Participant(new Long(1), "2011-01-03",null, null,"Malonga",null,null,null,null,null,null,null,null,null);
		
		final Participant b =  new Participant(new Long(1), "2011-01-03",null, null,"Malonga",null,null,null,null,null,null,null,null,null);
		
		final Participant c =  new Participant(new Long(2), "2011-01-03",null, null,"Silya",null,null,null,null,null,null,null,null,null);
		
		final Participant d = new Participant(new Long(1), "2011-01-03",null, null,"Malonga",null,null,null,null,null,null,null,null,null){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
		};

		final EqualsTester equalsTester = new EqualsTester();
        equalsTester.testEqualsAndHashCode(a, b, c,d);
		

	}
}
