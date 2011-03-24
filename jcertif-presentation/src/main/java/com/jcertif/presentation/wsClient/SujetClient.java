/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.presentation.Sujet;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import java.util.List;

/**
 *
 * @author Max
 */
public class SujetClient extends AbstractJCertWebServiceClient<Sujet, Long> {

    /**
     * The unique instance.
     */
    private SujetClient() {
        super("typeevenement");
    }
    private static SujetClient instance;

    public static synchronized SujetClient getInstance() {
        if (instance == null) {
            instance = new SujetClient();
        }
        return instance;
    }

        @Override
    public List<Sujet> findAll_JSON() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Sujet>>() {
        });

    }

    @Override
    public List<Sujet> findAllXML() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(new GenericType<List<Sujet>>() {
        });
    }
}
