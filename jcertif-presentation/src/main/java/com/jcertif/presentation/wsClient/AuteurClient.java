package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.presentation.Auteur;





/** Jersey REST client generated for REST resource:AuteurFacade [/participants]<br>
 *  USAGE:<pre>
 *        AuteurClient client = new AuteurClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 *  </pre>
 * @author Douneg
 */

public class AuteurClient extends AbstractJCertWebServiceClient<Auteur, Long> {

    /**
     * The unique instance.
     */
    private AuteurClient() {
        super("auteur");
    }
    private static AuteurClient instance;

    public static synchronized AuteurClient getInstance() {
        if (instance == null) {
            instance = new AuteurClient();
        }
        return instance;
    }

}
