package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.conference.Conference;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import java.util.List;

/** Jersey REST client generated for REST resource:ConferenceFacade [/participants]<br>
 *  USAGE:<pre>
 *        ConferenceClient client = new ConferenceClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 *  </pre>
 * @author Douneg
 */
public class ConferenceClient extends AbstractJCertWebServiceClient<Conference, Long> {

    /**
     * The unique instance.
     */
    private ConferenceClient() {
        super("conference");
    }
    private static ConferenceClient instance;

    public static synchronized ConferenceClient getInstance() {
        if (instance == null) {
            instance = new ConferenceClient();
        }
        return instance;
    }
      @Override
    public List<Conference> findAll_JSON() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Conference>>() {
        });

    }

    @Override
    public List<Conference> findAll_XML() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(new GenericType<List<Conference>>() {
        });
    }
}
