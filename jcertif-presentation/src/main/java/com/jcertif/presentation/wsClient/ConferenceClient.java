package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.conference.Conference;

/** Jersey REST client generated for REST resource:ParticipantFacade [/participants]<br>
 *  USAGE:<pre>
 *        ParticipantClient client = new ParticipantClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 *  </pre>
 * @author Douneg
 */
public class ConferenceClient extends AbstractJCertWebServiceClient<Conference, Long> {

    /**
     * The unique instance.
     */
    private ConferenceClient() {
        super("conference");
    }
    private static ConferenceClient instance;

    public static synchronized ConferenceClient getInstance() {
        if (instance == null) {
            instance = new ConferenceClient();
        }
        return instance;
    }
}
