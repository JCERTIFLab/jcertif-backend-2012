package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.participant.RoleParticipant;

/** Jersey REST client generated for REST resource:RoleParticipantFacade [/roleRoleParticipants]<br>
 *  USAGE:<pre>
 *        RoleParticipantClient client = new RoleParticipantClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 *  </pre>
 * @author Douneg
 */
public class RoleParticipantClient extends AbstractJCertWebServiceClient<RoleParticipant, Long> {

    /**
     * The unique instance.
     */
    private RoleParticipantClient() {
        super("roleparticipant");
    }
    private static RoleParticipantClient instance;

    public static synchronized RoleParticipantClient getInstance() {
        if (instance == null) {
            instance = new RoleParticipantClient();
        }
        return instance;
    }
}
