/**
 * Chrisbel Malonga
 * roland.amour@chrisbel.net
 */
package com.jcertif.bo.participant;

import org.junit.Test;

import com.evasion.framework.test.EqualsTester;
import com.jcertif.bo.JCertifAccessorTesterImpl;
import com.jcertif.bo.conference.CentreConference;

/**
 * @author chrisbel
 */
public class ParticipantTest {
	/**
	 * Test de tous les accesseurs du Bo {@link CentreConference}.
	 */
	@Test
	public void testAllAccessors() {
		final Participant cc = new Participant(new Long(1), "malonga@yahoo.fr", null);
		final JCertifAccessorTesterImpl accessorTester = new JCertifAccessorTesterImpl(cc);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link CentreConference}.
	 */
	@Test
	public void testEqualsAndHashCode() {
		final Participant a = new Participant(new Long(1), "malonga@yahoo.fr", null);
		final Participant b = new Participant(new Long(1), "malonga@yahoo.fr", null);
		final Participant c = new Participant(new Long(2), "malonga2008@yahoo.fr", null);
		final Participant d = new Participant(new Long(1), "malonga@yahoo.fr", null) {
			private static final long serialVersionUID = 1L;
		};

		final EqualsTester equalsTester = new EqualsTester();
		equalsTester.testEqualsAndHashCode(a, b, c, d);

	}
}
