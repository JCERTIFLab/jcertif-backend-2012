package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.participant.ProfilUtilisateur;



/** Jersey REST client generated for REST resource:ParticipantFacade [/profilUtilisateurs]<br>
 *  USAGE:<pre>
 *        ParticipantClient client = new ParticipantClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 *  </pre>
 * @author Douneg
 */

public class ProfilUtilisateurClient extends AbstractJCertWebServiceClient<ProfilUtilisateur, Long> {

    /**
     * The unique instance.
     */
    private ProfilUtilisateurClient() {
        super("profilutilisateur");
    }
    private static ProfilUtilisateurClient instance;

    public static synchronized ProfilUtilisateurClient getInstance() {
        if (instance == null) {
            instance = new ProfilUtilisateurClient();
        }
        return instance;
    }
}
