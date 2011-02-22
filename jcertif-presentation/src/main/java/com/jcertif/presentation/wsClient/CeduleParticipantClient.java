package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.cedule.CeduleParticipant;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import java.util.List;

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

    @Override
    public List<CeduleParticipant> findAll_JSON() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<CeduleParticipant>>() {
        });

    }

    @Override
    public List<CeduleParticipant> findAll_XML() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(new GenericType<List<CeduleParticipant>>() {
        });
    }
}
