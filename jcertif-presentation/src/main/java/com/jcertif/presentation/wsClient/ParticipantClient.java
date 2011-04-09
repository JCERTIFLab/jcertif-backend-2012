package com.jcertif.presentation.wsClient;

import java.util.List;

import com.jcertif.presentation.data.bo.participant.Participant;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;

/**
 * Jersey REST client generated for REST resource:ParticipantFacade
 * [/participants]<br>
 * USAGE:
 * 
 * <pre>
 *        ParticipantClient client = new ParticipantClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 * 
 * @author Douneg
 */

public class ParticipantClient extends AbstractJCertWebServiceClient<Participant, Long> {

	/**
	 * The unique instance.
	 */
	private ParticipantClient() {
		super("participant");
	}

	private static ParticipantClient instance;

	public static synchronized ParticipantClient getInstance() {
		if (instance == null) {
			instance = new ParticipantClient();
		}
		return instance;
	}

	@Override
	public List<Participant> findAll_JSON() throws UniformInterfaceException,
			ClientHandlerException {
		return getWebResource().path(FINDALL_SUFFIX)
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Participant>>() {
				});

	}

	@Override
	public List<Participant> findAllXML() throws UniformInterfaceException, ClientHandlerException {
		return getWebResource().path(FINDALL_SUFFIX)
				.accept(javax.ws.rs.core.MediaType.APPLICATION_XML)
				.get(new GenericType<List<Participant>>() {
				});
	}

	/**
	 * Return true if this email is already used.
	 * 
	 * @param email
	 *            a email adress
	 */
	public boolean isEmailExist(String email) {
		boolean isEmailExist = false;
		List<Participant> participantList = getWebResource().path("/listByEmail/" + email).get(
				new GenericType<List<Participant>>() {
				});
		isEmailExist = !participantList.isEmpty();
		return isEmailExist;
	}

	public Participant findByEmail(String email) {
		Participant participant = null;
		List<Participant> participantList = getWebResource().path("/listByEmail/" + email).get(
				new GenericType<List<Participant>>() {
				});

		if (!participantList.isEmpty()) {
			participant = participantList.iterator().next();
		}
		return participant;
	}
}
