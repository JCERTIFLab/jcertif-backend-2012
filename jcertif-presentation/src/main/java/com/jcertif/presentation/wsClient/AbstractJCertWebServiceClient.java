/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.wsClient;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.ResourceBundle;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.ui.util.UIConst;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

/**
 * 
 * @author Douneg
 */
public abstract class AbstractJCertWebServiceClient<T, PK extends Serializable> {

	/**
	 * The Logger.
	 */
	private Logger LOGGER = LoggerFactory.getLogger(AbstractJCertWebServiceClient.class);
	private Client client;
	private WebResource webResource;
	private Class<T> responseType;
	private final String ressourceBasePath;
	protected static final String CREATE_SUFFIX = "create";
	protected static final String FINDBYID_SUFFIX = "{0}";
	protected static final String FINDALL_SUFFIX = "list";
	protected static final String UPDATE_SUFFIX = "update";
	protected static final String DELETE_SUFFIX = "delete";
	private final Class<T> boClass;

	public ClientResponse checkConnection() {
		ClientResponse response = null;
		try {
			response = getWebResource().accept("text/plain").get(ClientResponse.class);
			LOGGER.debug("Response after Calling Web Service" + getWebResource(), response);
			Integer code = response.getStatus();
			LOGGER.debug("--- Response Code after Calling Web Service" + getWebResource(), code);
			String codeDescription = "";
			if (Response.Status.fromStatusCode(code) != null) {
				codeDescription = Response.Status.fromStatusCode(code).getReasonPhrase();
			}
			if (codeDescription == null) {
				codeDescription = "";
			}
			LOGGER.debug("--- Response Code Description " + getWebResource(), codeDescription);

		} catch (UniformInterfaceException uniformInterfaceException) {
			return null;
		} catch (ClientHandlerException clientHandlerException) {
			return null;
		}
		return response;
	}

	public boolean isServerOK() {
		return checkConnection().getStatus() < 400;
	}

	public void setWebResource(WebResource webResource) {
		this.webResource = webResource;
	}

	public AbstractJCertWebServiceClient(String ressourceBasePath) {
		this.ressourceBasePath = ressourceBasePath;
		final ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.boClass = (Class<T>) type.getActualTypeArguments()[0];
		init();
	}

	private void init() {
		com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
		client = Client.create(config);
		webResource = client.resource(getBaseURI()).path("api").path(this.ressourceBasePath);
		final ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.responseType = (Class<T>) type.getActualTypeArguments()[0];
	}

	public static String getBaseURI() {
		ResourceBundle bundle = ResourceBundle.getBundle(UIConst.WEBAPP_PROPERTIES_FILE);
		return bundle.getString(UIConst.FACADE_URL_PROP);
	}

	public void close() {
		client.destroy();
	}

	public WebResource getWebResource() {
		return webResource;
	}

	public <T> T update_XML(T requestEntity) throws UniformInterfaceException,
			ClientHandlerException {

		return (T) getWebResource().path(UPDATE_SUFFIX)
				.type(javax.ws.rs.core.MediaType.APPLICATION_XML).put(responseType, requestEntity);

	}

	public <T> T update_JSON(T requestEntity) throws UniformInterfaceException,
			ClientHandlerException {

		return (T) getWebResource().path(UPDATE_SUFFIX)
				.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(responseType, requestEntity);

	}

	public <T> T get_XML(PK id) throws UniformInterfaceException, ClientHandlerException {

		return (T) getWebResource()
				.path(java.text.MessageFormat.format(FINDBYID_SUFFIX, new Object[] { id }))
				.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(boClass);

	}

	public <T> T get_JSON(PK id) throws UniformInterfaceException, ClientHandlerException {

		return (T) getWebResource()
				.path(java.text.MessageFormat.format(FINDBYID_SUFFIX, new Object[] { id }))
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);

	}

	public <T> T create_XML(T requestEntity) throws UniformInterfaceException,
			ClientHandlerException {

		return (T) getWebResource().path(CREATE_SUFFIX)
				.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).post(boClass, requestEntity);

	}

	public <T> T create_JSON(T requestEntity) throws UniformInterfaceException,
			ClientHandlerException {

		return (T) getWebResource().path(CREATE_SUFFIX)
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(boClass, requestEntity);

	}

	public abstract List<T> findAllXML() throws UniformInterfaceException, ClientHandlerException;

	public abstract List<T> findAll_JSON() throws UniformInterfaceException, ClientHandlerException;

	public void delete_XML(T requestEntity) throws UniformInterfaceException,
			ClientHandlerException {
		getWebResource().path(DELETE_SUFFIX).type(javax.ws.rs.core.MediaType.APPLICATION_XML)
				.post(requestEntity);
	}
}
