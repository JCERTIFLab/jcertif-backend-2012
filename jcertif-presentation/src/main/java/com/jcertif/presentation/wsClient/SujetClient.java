/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcertif.presentation.wsClient;

import java.util.List;

import com.jcertif.presentation.cache.UICacheManager;
import com.jcertif.presentation.data.bo.presentation.Sujet;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;

/**
 * 
 * @author Max
 */
public class SujetClient extends AbstractJCertWebServiceClient<Sujet, Long> {

	/**
	 * The unique instance.
	 */
	private SujetClient() {
		super("sujet");
	}

	private static SujetClient instance;

	public static synchronized SujetClient getInstance() {
		if (instance == null) {
			instance = new SujetClient();
		}
		return instance;
	}

	@Override
	public List<Sujet> findAll_JSON() throws UniformInterfaceException,
			ClientHandlerException {
		return getWebResource().path(FINDALL_SUFFIX)
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Sujet>>() {
				});

	}

	@Override
	public List<Sujet> findAllXML() throws UniformInterfaceException,
			ClientHandlerException {
		List<Sujet> sujets = UICacheManager.getInstance().getSujet();

		if (sujets == null) {
			sujets = getWebResource().path(FINDALL_SUFFIX)
					.accept(javax.ws.rs.core.MediaType.APPLICATION_XML)
					.get(new GenericType<List<Sujet>>() {
					});
			UICacheManager.getInstance().putSujet(sujets);
		}
		return sujets;
	}
}
