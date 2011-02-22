package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.presentation.Auteur;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import java.util.List;



/** Jersey REST client generated for REST resource:ParticipantFacade [/participants]<br>
 *  USAGE:<pre>
 *        ParticipantClient client = new ParticipantClient();
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


    @Override
    public List<Auteur> findAll_JSON() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Auteur>>() {
        });

    }

    @Override
    public List<Auteur> findAll_XML() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(new GenericType<List<Auteur>>() {
        });
    }
}
