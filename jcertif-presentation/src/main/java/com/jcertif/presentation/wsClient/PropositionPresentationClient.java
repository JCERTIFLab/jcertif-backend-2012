package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.presentation.PropositionPresentation;

/** Jersey REST client generated for REST resource:PropositionPresentationFacade [/profilUtilisateurs]<br>
 *  USAGE:<pre>
 *        PropositionPresentationClient client = new PropositionPresentationClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 *  </pre>
 * @author Douneg
 */
public class PropositionPresentationClient extends AbstractJCertWebServiceClient<PropositionPresentation, Long> {

    /**
     * The unique instance.
     */
    private PropositionPresentationClient() {
        super("propositionpresentation");
    }
    private static PropositionPresentationClient instance;

    public static synchronized PropositionPresentationClient getInstance() {
        if (instance == null) {
            instance = new PropositionPresentationClient();
        }
        return instance;
    }
}
