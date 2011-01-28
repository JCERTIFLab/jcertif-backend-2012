package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.participant.TypeParticipant;


/** Jersey REST client generated for REST resource:TypeParticipantFacade [/typeParticipants]<br>
 *  USAGE:<pre>
 *         TypeParticipantClient client = new  TypeParticipantClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 *  </pre>
 * @author Douneg
 */

public class TypeParticipantClient extends AbstractJCertWebServiceClient<TypeParticipant, Long> {

    /**
     * The unique instance.
     */
    private TypeParticipantClient() {
        super("typeparticipant");
    }
    private static TypeParticipantClient instance;

    public static synchronized TypeParticipantClient getInstance() {
        if (instance == null) {
            instance = new TypeParticipantClient();
        }
        return instance;
    }
}
