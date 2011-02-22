package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.presentation.PropositionPresentation;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import java.util.List;

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
        @Override
    public List<PropositionPresentation> findAll_JSON() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<PropositionPresentation>>() {
        });

    }

    @Override
    public List<PropositionPresentation> findAll_XML() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(new GenericType<List<PropositionPresentation>>() {
        });
    }
}
