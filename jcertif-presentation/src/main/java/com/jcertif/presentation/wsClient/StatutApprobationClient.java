/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.presentation.StatutApprobation;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import java.util.List;

/**
 *
 * @author Douneg
 */
public class StatutApprobationClient extends AbstractJCertWebServiceClient<StatutApprobation, Long>{
 /**
     * The unique instance.
     */
    private StatutApprobationClient() {
        super("statutapprobation");
    }
    private static StatutApprobationClient instance;

    public static synchronized StatutApprobationClient getInstance() {
        if (instance == null) {
            instance = new StatutApprobationClient();
        }
        return instance;
    }

        @Override
    public List<StatutApprobation> findAll_JSON() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<StatutApprobation>>() {
        });

    }

    @Override
    public List<StatutApprobation> findAllXML() throws UniformInterfaceException, ClientHandlerException {
        return getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(new GenericType<List<StatutApprobation>>() {
        });
    }
}
