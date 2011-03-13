package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.salle.ParticulariteSalle;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import java.util.List;

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

        @Override
    public List<ParticulariteSalle> findAll_JSON() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<ParticulariteSalle>>() {
        });

    }

    @Override
    public List<ParticulariteSalle> findAllXML() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(new GenericType<List<ParticulariteSalle>>() {
        });
    }
}
