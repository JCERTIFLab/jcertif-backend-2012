/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.participant.ProfilUtilisateur;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import java.util.ResourceBundle;

/**
 *
 * @author Douneg
 */
public class MailSenderClient {

    private Client client;
    private WebResource webResource;
    private final String ressourceBasePath;
    public static String FACADE_URL_PROP = "facade.url";
    public static String WEBAPP_PROPERTIES_FILE = "jcertif-presentation";

    public MailSenderClient(String ressourceBasePath) {
        this.ressourceBasePath = ressourceBasePath;
        init();
    }

    private void init() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(getBaseURI()).path("api").path(this.ressourceBasePath);

    }

    public static String getBaseURI() {
        ResourceBundle bundle = ResourceBundle.getBundle(WEBAPP_PROPERTIES_FILE);
        return bundle.getString(FACADE_URL_PROP);
    }

    public WebResource getWebResource() {
        return webResource;
    }

    public Boolean sendConfirmation_XML(ProfilUtilisateur profilUtilisateur) throws UniformInterfaceException {
        return getWebResource().type(javax.ws.rs.core.MediaType.APPLICATION_XML).post(Boolean.class, profilUtilisateur);
    }

    public Boolean sendConfirmation_JSON(ProfilUtilisateur profilUtilisateur) throws UniformInterfaceException {
        return getWebResource().type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(Boolean.class, profilUtilisateur);
    }

    public void close() {
        client.destroy();
    }

 



}
