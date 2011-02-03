/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.wsClient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * @author UNHCRUser
 */
public class MailSenderClient {

    static class MailSender_JerseyClient {

        private WebResource webResource;
        private Client client;
        private static final String BASE_URI = "http://localhost:8080//resources";

        public MailSender_JerseyClient() {
            com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
            client = Client.create(config);
            webResource = client.resource(BASE_URI).path("mail");
        }

        public <T> T sendConfirmation_XML(Class<T> responseType, Object requestEntity) throws UniformInterfaceException {
            return webResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).post(responseType, requestEntity);
        }

        public <T> T sendConfirmation_JSON(Class<T> responseType, Object requestEntity) throws UniformInterfaceException {
            return webResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(responseType, requestEntity);
        }

        public void close() {
            client.destroy();
        }
    }
}
