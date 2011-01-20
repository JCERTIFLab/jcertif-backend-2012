/**
 * 
 */
package com.jcertif.bo.participant;

import org.junit.Test;

import com.evasion.framework.test.AccessorTesterImpl;
import com.evasion.framework.test.EqualsTester;
import com.jcertif.bo.participant.TypeParticipant;

/**
 * @author rossi.oddet
 *
 */
public class TypeParticipantTest {

	/**
	 * Test de tous les accesseurs du Bo {@link TypeParticipant}.
	 */
	@Test
	public void testAllAccessors() {
		final TypeParticipant typeEvent = new TypeParticipant();
		final AccessorTesterImpl accessorTester = new AccessorTesterImpl(typeEvent);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link TypeParticipant}.
	 */
	@Test
	public void testtestEqualsAndHashCode() {
		final TypeParticipant type = new TypeParticipant(
				"type 1", "desc 1");
		final TypeParticipant equivalentTypeParticipant1 = new TypeParticipant(
				"type 1", "desc 1");
		final TypeParticipant differentTypeParticipant1 = new TypeParticipant(
				"type 3", "desc 1");
		final TypeParticipant deriveTypeParticipant1 = new TypeParticipant(
				"type 1", "desc 1") {
		};
		final EqualsTester vEqualTester = new EqualsTester();
		vEqualTester.testEqualsAndHashCode(type,
				equivalentTypeParticipant1, differentTypeParticipant1,
				deriveTypeParticipant1);
	}
}
