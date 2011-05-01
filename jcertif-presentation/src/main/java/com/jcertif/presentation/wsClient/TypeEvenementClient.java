/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcertif.presentation.wsClient;

import java.util.List;

import com.jcertif.presentation.cache.UICacheManager;
import com.jcertif.presentation.data.bo.cedule.TypeEvenement;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;

/**
 * 
 * @author Douneg
 */
public class TypeEvenementClient extends
		AbstractJCertWebServiceClient<TypeEvenement, Long> {

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
	public List<TypeEvenement> findAll_JSON() throws UniformInterfaceException,
			ClientHandlerException {
		return getWebResource().path(FINDALL_SUFFIX)
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON)
				.get(new GenericType<List<TypeEvenement>>() {
				});

	}

	@Override
	public List<TypeEvenement> findAllXML() throws UniformInterfaceException,
			ClientHandlerException {
		List<TypeEvenement> types = UICacheManager.getInstance()
				.getTypeEvenement();

		if (types == null) {
			types = getWebResource().path(FINDALL_SUFFIX)
					.accept(javax.ws.rs.core.MediaType.APPLICATION_XML)
					.get(new GenericType<List<TypeEvenement>>() {
					});
			UICacheManager.getInstance().putTypeEvenement(types);
		}
		return types;
	}
}
