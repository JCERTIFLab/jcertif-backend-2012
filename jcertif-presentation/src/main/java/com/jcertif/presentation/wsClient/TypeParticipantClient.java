package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.participant.TypeParticipant;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import java.util.List;


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

        @Override
    public List<TypeParticipant> findAll_JSON() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<TypeParticipant>>() {
        });

    }

    @Override
    public List<TypeParticipant> findAll_XML() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(new GenericType<List<TypeParticipant>>() {
        });
    }
}
