package com.jcertif.presentation.data;

import java.util.List;

import com.jcertif.presentation.data.bo.cedule.Evenement;
import com.jcertif.presentation.data.domain.JCertifPresentation;
import com.jcertif.presentation.data.domain.MyScheduleUser;
import com.sun.jersey.api.client.WebResource;

/**
 * Facade interface for the JCERTIF REST API. All calls from the UI to the REST
 * API should be made through this interface.
 * 
 * @link http://www.jcertif.com/display/Jcertif/Schedule+REST+interface
 */
public interface RestApiFacade {
	
	

    /**
     * 
     * @param firstName
     * @param lastName
     * @param email
     * @throws RestApiException
     */
    void activateMySchedule(String firstName, String lastName, String email) throws RestApiException;

    /**
     * 
     * @param user
     * @throws RestApiException
     */
    void saveMySchedule(MyScheduleUser user) throws RestApiException;

    /**
     * Returns true if the given user's e-mail and activation code are valid for
     * a user of MySchedule feature.
     * 
     * @param user
     * @return
     * @throws RestApiException
     */
    boolean isValidUser(MyScheduleUser user) throws RestApiException;

    /**
     * 
     * @param user
     */
    void getScheduleForUser(MyScheduleUser user);

    /**
     * 
     * @return
     */
    List<JCertifPresentation> getFullSchedule();

    /**
     * Search for {@link JCertifPresentation}s containing the given tag.
     * 
     * @return List of JCertifPresentations containing the given tag.
     */
    List<JCertifPresentation> search(String tag);
    
    List <Evenement> findAllEvenement();
    Evenement saveEvenement (Evenement evenement);
}
