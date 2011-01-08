package com.jcertif.bo;

import org.junit.Test;

import com.evasion.framework.test.EqualsTester;


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
		final CentreConference cc =new CentreConference(new Long(1), "centreConferenceParis","description",null,null,null,null,null,null, null);
		final JCertifAccessorTesterImpl accessorTester = new JCertifAccessorTesterImpl(cc);
		accessorTester.testAllAccessors();
	}

	/**
	 * Test des méhodes Equals et Hashcode du Bo {@link CentreConference}.
	 */
	@Test
	public void testtestEqualsAndHashCode() {
		final CentreConference a= new CentreConference(new Long(1), "centreConferenceParis","description",null,null,null,null,null,null, null);
		
		final CentreConference b =  new CentreConference(new Long(1), "centreConferenceParis","description",null,null,null,null,null,null, null);
		
		final CentreConference c =  new CentreConference(new Long(1), "centreConferenceAfrique","descriptionafrique",null,null,null,null,null,null, null);
		
		final CentreConference d = new CentreConference(new Long(1), "centreConferenceParis","description",null,null,null,null,null,null, null){
		};

		final EqualsTester equalsTester = new EqualsTester();
        equalsTester.testEqualsAndHashCode(a, b, c,d);
		

	}
}
