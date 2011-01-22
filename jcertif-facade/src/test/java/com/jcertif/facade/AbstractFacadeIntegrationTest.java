package com.jcertif.facade;

import java.util.ResourceBundle;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * Base class for integration test.
 * 
 * @author rossi.oddet
 * 
 */
public abstract class AbstractFacadeIntegrationTest {
	
	/**
	 * Facade URL property.
	 */
	private static final String FACADE_URL_PROP = "facade.url";

	/**
	 * WEBAPP properties file name.
	 */
	private static final String WEBAPP_PROPERTIES_FILE = "jcertif-facade";
	
	/**
	 * @return a web resource jersey.
	 */
	protected WebResource getWebResource() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		return client.resource(getBaseURI());
	}

	/**
	 * @return the base URI
	 */
	protected String getBaseURI() {
		ResourceBundle bundle = ResourceBundle
				.getBundle(WEBAPP_PROPERTIES_FILE);
		return bundle.getString(FACADE_URL_PROP);
	}

}
