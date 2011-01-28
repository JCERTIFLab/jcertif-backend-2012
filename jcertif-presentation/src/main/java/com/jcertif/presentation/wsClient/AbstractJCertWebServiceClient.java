/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.wsClient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ResourceBundle;

/**
 *
 * @author Douneg
 */
public abstract class AbstractJCertWebServiceClient<T, PK extends Serializable> {

    private Client client;
    private WebResource webResource;
    private Class<T> responseType;
    private final String ressourceBasePath;
    public static String FACADE_URL_PROP = "facade.url";
    public static String WEBAPP_PROPERTIES_FILE = "jcertif-presentation";
    protected static final String CREATE_SUFFIX = "create";
    protected static final String FINDBYID_SUFFIX = "{0}";
    protected static final String FINDALL_SUFFIX = "list";
    protected static final String UPDATE_SUFFIX = "update";
    protected static final String DELETE_SUFFIX = "delete";

    public void setWebResource(WebResource webResource) {
        this.webResource = webResource;
    }

    public AbstractJCertWebServiceClient(String ressourceBasePath) {
        this.ressourceBasePath = ressourceBasePath;
        init();
    }

    private void init() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(getBaseURI()).path(this.ressourceBasePath);
        final ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.responseType = (Class<T>) type.getActualTypeArguments()[0];
    }

    public static String getBaseURI() {
        ResourceBundle bundle = ResourceBundle.getBundle(WEBAPP_PROPERTIES_FILE);
        return bundle.getString(FACADE_URL_PROP);
    }

    public void close() {
        client.destroy();
    }

    public WebResource getWebResource() {
        return webResource;
    }

    public <T> T update_XML(T requestEntity) throws UniformInterfaceException {
        return (T) getWebResource().path(UPDATE_SUFFIX).type(javax.ws.rs.core.MediaType.APPLICATION_XML).put(responseType, requestEntity);
    }

    public <T> T update_JSON(T requestEntity) throws UniformInterfaceException {
        return (T) getWebResource().path(UPDATE_SUFFIX).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(responseType, requestEntity);
    }

    public <T> T get_XML(PK id) throws UniformInterfaceException {
        return (T) getWebResource().path(java.text.MessageFormat.format(FINDBYID_SUFFIX, new Object[]{id})).accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T get_JSON(PK id) throws UniformInterfaceException {
        return (T) getWebResource().path(java.text.MessageFormat.format(FINDBYID_SUFFIX, new Object[]{id})).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T create_XML(T requestEntity) throws UniformInterfaceException {
        return (T) webResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).put(responseType, requestEntity);
    }

    public <T> T create_JSON(T requestEntity) throws UniformInterfaceException {
        return (T) webResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(responseType, requestEntity);
    }

    public <T> T findAll_XML() throws UniformInterfaceException {
        return (T) getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findAll_JSON() throws UniformInterfaceException {
        return (T) getWebResource().path(FINDALL_SUFFIX).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void delete_XML(T requestEntity) throws UniformInterfaceException {
        webResource.path(DELETE_SUFFIX).type(javax.ws.rs.core.MediaType.APPLICATION_XML).delete(requestEntity);
    }

    public void delete_JSON(T requestEntity) throws UniformInterfaceException {
        webResource.path(DELETE_SUFFIX).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).delete(requestEntity);
    }
}
