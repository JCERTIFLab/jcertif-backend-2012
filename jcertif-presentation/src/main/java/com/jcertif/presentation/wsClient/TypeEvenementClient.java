/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.cedule.TypeEvenement;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import java.util.List;

/**
 *
 * @author Douneg
 */
public class TypeEvenementClient extends AbstractJCertWebServiceClient<TypeEvenement, Long> {

    /**
     * The unique instance.
     */
    private TypeEvenementClient() {
        super("typeevenement");
    }
    private static TypeEvenementClient instance;

    public static synchronized TypeEvenementClient getInstance() {
        if (instance == null) {
            instance = new TypeEvenementClient();
        }
        return instance;
    }

        @Override
    public List<TypeEvenement> findAll_JSON() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<TypeEvenement>>() {
        });

    }

    @Override
    public List<TypeEvenement> findAll_XML() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(new GenericType<List<TypeEvenement>>() {
        });
    }
}
