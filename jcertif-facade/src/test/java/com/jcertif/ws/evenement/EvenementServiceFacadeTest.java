/**
 * 
 */
package com.jcertif.ws.evenement;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jcertif.bo.cedule.Evenement;
import com.jcertif.service.evenement.EvenementServiceImpl;

/**
 * @author Chrisbel
 *
 */
public class EvenementServiceFacadeTest {
	
	@Mock
	private EvenementServiceImpl evenementServiceImpl;
	
	private EvenementServiceFacade evenementWebServicefacade;
	
	@Before
    public void setUp() {
		//Let mockito create nice objet for us
        MockitoAnnotations.initMocks(this);
        evenementWebServicefacade = new EvenementServiceFacade();
        evenementWebServicefacade.setEvenementService(evenementServiceImpl);
	}
	
	@Test
	public void testCreateEvenementFacade()
	{
				
		Evenement anevenement = new Evenement();
		anevenement.setNomEvenement("Jcertif conference 2011");
		Evenement anevenement2 = new Evenement();
		anevenement2.setNomEvenement("Jcertif conference 2011");
		anevenement2.setId(Long.valueOf(1));
		// Spécification du comportement de l'implémentation du service.
		//Lorsque le service  EvenementServiceImpl sera appelé avec
		// la méthode createEvenement(anevenement), il retournera anevenement2
		Mockito.when(evenementServiceImpl.createEvenement(anevenement)).thenReturn(anevenement2);

		// Vérification de la méthode createEvenement
		// Le service facade doit appeler le serviceImpl avec anevenement
		// si ce n'est l ecas cas le test en erreur
	 Evenement eventretourn=	evenementWebServicefacade.createEvenementFacade(anevenement);
	 Assert.assertNotNull(eventretourn);
	 Assert.assertEquals(eventretourn, anevenement2);
	}
	
	@Test
	public void testFindAll()
	{
		List<Evenement> evenementslist = new ArrayList<Evenement>();
		Evenement anevenement = new Evenement();
		anevenement.setNomEvenement("Jcertif conference 2011");
		
		Evenement anOtherEvent = new Evenement();
		anOtherEvent.setNomEvenement("Jcertif 2012");
		
		evenementslist.add(anevenement);
		evenementslist.add(anOtherEvent);
		
		Mockito.when(evenementServiceImpl.findAll()).thenReturn(evenementslist);
		
		List<Evenement> returnedList = evenementWebServicefacade.findAll();
		Assert.assertNotNull(returnedList);
		Assert.assertEquals(returnedList.size(), 2);
		Assert.assertEquals(returnedList, evenementslist);
	}
}
