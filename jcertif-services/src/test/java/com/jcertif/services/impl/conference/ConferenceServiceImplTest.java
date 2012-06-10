package com.jcertif.services.impl.conference;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jcertif.bo.conference.Conference;
import com.jcertif.dao.api.conference.ConferenceDAO;
import com.jcertif.service.impl.conference.ConferenceServiceImpl;

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
        conferenceServiceimpl.setDAO(conferenceDAO);
    }

    /**
     * Test de la methode Save().
     */
    @Test
    public void testSave() {
        // Conference que l'on desire sauvegarder
        Conference conf = new Conference();
        conf.setId(Long.valueOf(1));
        conf.setNom("Jcertif");
        conf.setDateFin(Calendar.getInstance());

        // Conference sauvee renvoye par le DAO
        Conference conf2 = new Conference();
        conf.setId(Long.valueOf(1));
        conf.setNom("Jcertif");
        conf.setDateFin(Calendar.getInstance());

        /**
         * Specification du comportement du DAO. Lorsque le DAO sera appele avec
         * la methode merge(article1), il retournera article2
         */
        Mockito.when(conferenceDAO.merge(conf)).thenReturn(conf2);

        // Verification de la methode save
        // Le service doit bien appele le DAO avec article 1. Si ce n'est pas le
        // cas le test sera en erreur
        conferenceServiceimpl.save(conf);
    }
}
