package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.participant.ProfilUtilisateur;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import java.util.List;



/** Jersey REST client generated for REST resource:ProfilUtilisateurFacade [/profilUtilisateurs]<br>
 *  USAGE:<pre>
 *        ProfilUtilisateurClient client = new ProfilUtilisateurClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 *  </pre>
 * @author Douneg
 */

public class ProfilUtilisateurClient extends AbstractJCertWebServiceClient<ProfilUtilisateur, Long> {

    /**
     * The unique instance.
     */
    private ProfilUtilisateurClient() {
        super("profilutilisateur");
    }
    private static ProfilUtilisateurClient instance;

    public static synchronized ProfilUtilisateurClient getInstance() {
        if (instance == null) {
            instance = new ProfilUtilisateurClient();
        }
        return instance;
    }

        @Override
    public List<ProfilUtilisateur> findAll_JSON() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<ProfilUtilisateur>>() {
        });

    }

    @Override
    public List<ProfilUtilisateur> findAll_XML() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(new GenericType<List<ProfilUtilisateur>>() {
        });
    }
}
