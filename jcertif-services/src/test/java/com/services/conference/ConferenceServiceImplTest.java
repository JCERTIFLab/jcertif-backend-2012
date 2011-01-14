package com.services.conference;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jcertif.bo.Conference;
import com.jcertif.dao.ConferenceDAO;
import com.jcertif.service.conference.ConferenceServiceImpl;

/**
 * roland.amour@chrisbel.net
 */

/**
 * @ Chrisbel 
 */
public class ConferenceServiceImplTest {
	
	@Mock
	private ConferenceDAO conferenceDAO;
	
	private ConferenceServiceImpl conferenceServiceimpl;
	
	@Before
	public void setUp() {
		// Let mockito create nice objet for us
		MockitoAnnotations.initMocks(this);
		conferenceServiceimpl = new ConferenceServiceImpl();
		conferenceServiceimpl.setConferenceDAO(conferenceDAO);
	}
	
	
	/**
	 * Test de la méthode Save().
	 */
	@Test
	public void testSave() {
		// Conference que l'on désire sauvegarder
		Conference conf = new Conference();
		conf.setId(Long.valueOf(1));
        conf.setNom("Jcertif");
        conf.setDateFin(Calendar.getInstance());
        
		// Conference sauvée renvoyé par le DAO
        Conference conf2 = new Conference();
		conf.setId(Long.valueOf(1));
        conf.setNom("Jcertif");
        conf.setDateFin(Calendar.getInstance());

        /**
         * Spécification du comportement du DAO. Lorsque le DAO sera appelé avec
         * la méthode merge(article1), il retournera article2
         */
	
		Mockito.when(conferenceDAO.merge(conf)).thenReturn(conf2);

		// Vérification de la méthode save
		// Le service doit bien appelé le DAO avec article 1. Si ce n'est pas le
		// cas le test sera en erreur
		conferenceServiceimpl.save(conf);
	}
}
