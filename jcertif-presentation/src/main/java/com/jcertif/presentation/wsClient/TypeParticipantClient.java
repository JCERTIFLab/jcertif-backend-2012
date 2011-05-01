package com.jcertif.presentation.wsClient;

import java.util.List;

import com.jcertif.presentation.cache.UICacheManager;
import com.jcertif.presentation.data.bo.participant.TypeParticipant;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;

/**
 * Jersey REST client generated for REST resource:TypeParticipantFacade
 * [/typeParticipants]<br>
 * USAGE:
 * 
 * <pre>
 *         TypeParticipantClient client = new  TypeParticipantClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 * 
 * @author Douneg
 */

public class TypeParticipantClient extends
		AbstractJCertWebServiceClient<TypeParticipant, Long> {

	/**
	 * The unique instance.
	 */
	private TypeParticipantClient() {
		super("typeparticipant");
	}

	private static TypeParticipantClient instance;

	public static synchronized TypeParticipantClient getInstance() {
		if (instance == null) {
			instance = new TypeParticipantClient();
		}
		return instance;
	}

	@Override
	public List<TypeParticipant> findAll_JSON()
			throws UniformInterfaceException, ClientHandlerException {
		return getWebResource().path(FINDALL_SUFFIX)
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON)
				.get(new GenericType<List<TypeParticipant>>() {
				});

	}

	@Override
	public List<TypeParticipant> findAllXML() throws UniformInterfaceException,
			ClientHandlerException {

		List<TypeParticipant> types = UICacheManager.getInstance()
				.getTypeParticipant();
		if (types == null) {
			types = getWebResource().path(FINDALL_SUFFIX)
					.accept(javax.ws.rs.core.MediaType.APPLICATION_XML)
					.get(new GenericType<List<TypeParticipant>>() {
					});
			UICacheManager.getInstance().putTypeParticipant(types);
		}
		return types;
	}
}
