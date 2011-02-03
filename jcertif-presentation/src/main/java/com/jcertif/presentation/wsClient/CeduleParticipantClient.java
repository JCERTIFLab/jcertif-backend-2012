package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.cedule.CeduleParticipant;

/** Jersey REST client generated for REST resource:CeduleParticipantFacade [/participants]<br>
 *  USAGE:<pre>
 *        CeduleParticipantClient client = new CeduleParticipantClient();
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
