package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.cedule.StatutCedule;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import java.util.List;

/** Jersey REST client generated for REST resource:ConferenceFacade [/participants]<br>
 *  USAGE:<pre>
 *       StatutCeduleClient client = new StatutCeduleClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 *  </pre>
 * @author Douneg
 */
public class StatutCeduleClient extends AbstractJCertWebServiceClient<StatutCedule, Long> {

    /**
     * The unique instance.
     */
    private StatutCeduleClient() {
        super("statutcedule");
    }
    private static StatutCeduleClient instance;

    public static synchronized StatutCeduleClient getInstance() {
        if (instance == null) {
            instance = new StatutCeduleClient();
        }
        return instance;
    }
        @Override
    public List<StatutCedule> findAll_JSON() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<StatutCedule>>() {
        });

    }

    @Override
    public List<StatutCedule> findAllXML() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(new GenericType<List<StatutCedule>>() {
        });
    }
}
