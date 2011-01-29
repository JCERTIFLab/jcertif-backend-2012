package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.cedule.CeduleParticipant;
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
public class CeduleParticipantClient extends AbstractJCertWebServiceClient<CeduleParticipant, Long> {

    /**
     * The unique instance.
     */
    private CeduleParticipantClient() {
        super("ceduleparticipant");
    }
    private static CeduleParticipantClient instance;

    public static synchronized CeduleParticipantClient getInstance() {
        if (instance == null) {
            instance = new CeduleParticipantClient();
        }
        return instance;
    }
}
