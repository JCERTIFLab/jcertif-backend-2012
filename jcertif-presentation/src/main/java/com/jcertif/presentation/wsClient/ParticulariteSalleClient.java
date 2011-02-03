package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.salle.ParticulariteSalle;

/** Jersey REST client generated for REST resource:ParticulariteSalleFacade [/typeParticipants]<br>
 *  USAGE:<pre>
 *         ParticulariteSalleClient client = new  ParticulariteSalleClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 *  </pre>
 * @author Douneg
 */
public class ParticulariteSalleClient extends AbstractJCertWebServiceClient<ParticulariteSalle, Long> {

    /**
     * The unique instance.
     */
    private ParticulariteSalleClient() {
        super("particularitesalle");
    }
    private static ParticulariteSalleClient instance;

    public static synchronized ParticulariteSalleClient getInstance() {
        if (instance == null) {
            instance = new ParticulariteSalleClient();
        }
        return instance;
    }
}
