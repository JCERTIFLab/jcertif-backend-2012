package com.jcertif.presentation.wsClient;

import java.util.List;

import com.jcertif.presentation.cache.UICacheManager;
import com.jcertif.presentation.data.bo.participant.RoleParticipant;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;

/**
 * Jersey REST client generated for REST resource:RoleParticipantFacade
 * [/roleRoleParticipants]<br>
 * USAGE:
 * 
 * <pre>
 *        RoleParticipantClient client = new RoleParticipantClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 * 
 * @author Douneg
 */
public class RoleParticipantClient extends
		AbstractJCertWebServiceClient<RoleParticipant, Long> {

	/**
	 * The unique instance.
	 */
	private RoleParticipantClient() {
		super("roleparticipant");
	}

	private static RoleParticipantClient instance;

	public static synchronized RoleParticipantClient getInstance() {
		if (instance == null) {
			instance = new RoleParticipantClient();
		}
		return instance;
	}

	@Override
	public List<RoleParticipant> findAll_JSON()
			throws UniformInterfaceException, ClientHandlerException {
		return getWebResource().path(FINDALL_SUFFIX)
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON)
				.get(new GenericType<List<RoleParticipant>>() {
				});

	}

	@Override
	public List<RoleParticipant> findAllXML() throws UniformInterfaceException,
			ClientHandlerException {
		List<RoleParticipant> roles = UICacheManager.getInstance()
				.getRoleParticipant();

		if (roles == null) {
			roles = getWebResource().path(FINDALL_SUFFIX)
					.accept(javax.ws.rs.core.MediaType.APPLICATION_XML)
					.get(new GenericType<List<RoleParticipant>>() {
					});
			UICacheManager.getInstance().putRoleParticipant(roles);
		}
		return roles;
	}
}
