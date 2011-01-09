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
public class OrganisateurTest {
	
	/**
	 * Test de tous les accesseurs du Bo {@link CentreConference}.
	 */
	@Test
	public void testAllAccessors() {
		final Organisateur cc =new Organisateur(new Long(1), "Chrisbel","Malonga",null,null,null,null,null);
		final JCertifAccessorTesterImpl accessorTester = new JCertifAccessorTesterImpl(cc);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link CentreConference}.
	 */
	@Test
	public void testEqualsAndHashCode() {
		final Organisateur a= new Organisateur(new Long(1), "Chrisbel","Malonga",null,null,null,null,null);
		
		final Organisateur b = new Organisateur(new Long(1), "Chrisbel","Malonga",null,null,null,null,null);
		
		final Organisateur c = new Organisateur(new Long(2), "La Reine","Silya",null,null,null,null,null);
		
		final Organisateur d =new Organisateur(new Long(1), "Chrisbel","Malonga",null,null,null,null,null){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
		};

		final EqualsTester equalsTester = new EqualsTester();
        equalsTester.testEqualsAndHashCode(a, b, c,d);
	}		

}
