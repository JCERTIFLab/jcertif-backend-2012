package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.cedule.StatutCedule;

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
}
