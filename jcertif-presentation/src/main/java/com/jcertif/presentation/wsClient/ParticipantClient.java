package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.participant.Participant;



/** Jersey REST client generated for REST resource:ParticipantFacade [/participants]<br>
 *  USAGE:<pre>
 *        ParticipantClient client = new ParticipantClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 *  </pre>
 * @author Douneg
 */

public class ParticipantClient extends AbstractJCertWebServiceClient<Participant, Long> {

    /**
     * The unique instance.
     */
    private ParticipantClient() {
        super("participant");
    }
    private static ParticipantClient instance;

    public static synchronized ParticipantClient getInstance() {
        if (instance == null) {
            instance = new ParticipantClient();
        }
        return instance;
    }

}
