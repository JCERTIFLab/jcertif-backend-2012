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
	 * Test de la m�thode Save().
	 */
	@Test
	public void testSave() {
		// Conference que l'on d�sire sauvegarder
		Conference conf = new Conference();
		conf.setId(Long.valueOf(1));
        conf.setNom("Jcertif");
        conf.setDateFin(Calendar.getInstance());
        
		// Conference sauv�e renvoy� par le DAO
        Conference conf2 = new Conference();
		conf.setId(Long.valueOf(1));
        conf.setNom("Jcertif");
        conf.setDateFin(Calendar.getInstance());

        /**
         * Sp�cification du comportement du DAO. Lorsque le DAO sera appel� avec
         * la m�thode merge(article1), il retournera article2
         */
	
		Mockito.when(conferenceDAO.merge(conf)).thenReturn(conf2);

		// V�rification de la m�thode save
		// Le service doit bien appel� le DAO avec article 1. Si ce n'est pas le
		// cas le test sera en erreur
		conferenceServiceimpl.save(conf);
	}
}
