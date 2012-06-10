package com.jcertif.bo.cedule;

import org.junit.Test;

import com.evasion.framework.test.AccessorTesterImpl;
import com.evasion.framework.test.EqualsTester;
import com.jcertif.bo.cedule.TypeEvenement;

/**
 * @author rossi.oddet
 *
 */
public class TypeEvenementTest {

	/**
	 * Test de tous les accesseurs du Bo {@link TypeEvenement}.
	 */
	@Test
	public void testAllAccessors() {
		final TypeEvenement typeEvent = new TypeEvenement();
		final AccessorTesterImpl accessorTester = new AccessorTesterImpl(typeEvent);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méthodes Equals et Hashcode du Bo {@link TypeEvenement}.
	 */
	@Test
	public void testtestEqualsAndHashCode() {
		final TypeEvenement type = new TypeEvenement(
				"type 1", "desc 1");
		final TypeEvenement equivalentTypeEvenement1 = new TypeEvenement(
				"type 1", "desc 1");
		final TypeEvenement differentTypeEvenement1 = new TypeEvenement(
				"type 3", "desc 1");
		final TypeEvenement deriveTypeEvenement1 = new TypeEvenement(
				"type 1", "desc 1") {
		};
		final EqualsTester vEqualTester = new EqualsTester();
		vEqualTester.testEqualsAndHashCode(type,
				equivalentTypeEvenement1, differentTypeEvenement1,
				deriveTypeEvenement1);
	}
}
