package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.conference.Conference;

/** Jersey REST client generated for REST resource:ConferenceFacade [/participants]<br>
 *  USAGE:<pre>
 *        ConferenceClient client = new ConferenceClient();
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
