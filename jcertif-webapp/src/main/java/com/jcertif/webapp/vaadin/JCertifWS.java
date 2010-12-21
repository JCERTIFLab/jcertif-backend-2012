package com.jcertif.webapp.vaadin;

import java.util.ResourceBundle;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * @author rossi.oddet
 * 
 */
public class JCertifWS {

	/**
	 * Facade URL property.
	 */
	private static final String FACADE_URL_PROP = "facade.url";

	/**
	 * WEBAPP properties file name.
	 */
	private static final String WEBAPP_PROPERTIES_FILE = "jcertif-webapp";

	/**
	 * The unique instance.
	 */
	private static JCertifWS instance;

	/**
	 * The constructor.
	 */
	private JCertifWS() {
	}

	/**
	 * @return the unique instance of JCertifWS.
	 */
	public static JCertifWS getInstance() {
		if (instance == null) {
			instance = new JCertifWS();
		}
		return instance;
	}

	/**
	 * Add a title.
	 * 
	 * @param title
	 *            a title
	 */
	public void addTitle(String title) {
		getWebResource().path("ArticleWS").path("AddTitle").path(title)
				.accept(MediaType.TEXT_PLAIN).get(String.class);
	}

	/**
	 * @return all titles by calling ArticleWS/Alltitles web service.
	 */
	public String findAllTitles() {
		return getWebResource().path("ArticleWS").path("AllTitles")
				.accept(MediaType.TEXT_PLAIN).get(String.class);

	}

	/**
	 * @return a web resource jersey.
	 */
	private WebResource getWebResource() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		return client.resource(getBaseURI());
	}

	/**
	 * @return the base URI
	 */
	private String getBaseURI() {
		ResourceBundle bundle = ResourceBundle
				.getBundle(WEBAPP_PROPERTIES_FILE);
		return bundle.getString(FACADE_URL_PROP);
	}

}
