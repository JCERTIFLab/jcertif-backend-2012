/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.bo.salle;

import org.junit.Test;

import com.evasion.framework.test.EqualsTester;
import com.jcertif.bo.JCertifAccessorTesterImpl;
import com.jcertif.bo.conference.CentreConference;
import com.jcertif.bo.salle.ParticulariteSalle;

/**
 * @author chrisbel
 */
public class ParticulariteSalleTest {
	/**
	 * Test de tous les accesseurs du Bo {@link CentreConference}.
	 */
	@Test
	public void testAllAccessors() {
		final ParticulariteSalle cc =new ParticulariteSalle(new Long(1), "centreConferenceParis","description");
		final JCertifAccessorTesterImpl accessorTester = new JCertifAccessorTesterImpl(cc);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link CentreConference}.
	 */
	@Test
	public void testEqualsAndHashCode() {
		final ParticulariteSalle a= new ParticulariteSalle(new Long(1), "centreConferenceParis","description");
		
		final ParticulariteSalle b =  new ParticulariteSalle(new Long(1), "centreConferenceParis","description");
		
		final ParticulariteSalle c =  new ParticulariteSalle(new Long(1), "centreConferenceAfrique","descriptionafrique");
		
		final ParticulariteSalle d = new ParticulariteSalle(new Long(1), "centreConferenceParis","description"){
		};

		final EqualsTester equalsTester = new EqualsTester();
        equalsTester.testEqualsAndHashCode(a, b, c,d);
		

	}

}
