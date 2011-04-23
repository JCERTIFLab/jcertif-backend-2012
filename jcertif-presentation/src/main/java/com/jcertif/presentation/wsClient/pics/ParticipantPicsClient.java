package com.jcertif.presentation.wsClient.pics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.jcertif.presentation.ui.util.JCertifProps;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

/**
 * @author rossi.oddet
 * 
 */
public class ParticipantPicsClient {

	private Client client;
	private WebResource webResource;
	private static ParticipantPicsClient instance;

	public static ParticipantPicsClient getInstance() {
		if (instance == null) {
			instance = new ParticipantPicsClient();
		}
		return instance;
	}

	private ParticipantPicsClient() {
		com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
		client = Client.create(config);
		webResource = client.resource(JCertifProps.getInstance().getPicsUrl()).path("pics")
				.path("participant");
	}

	public void store(File file, String role, Long idParticipant, String ext)
			throws UniformInterfaceException, FileNotFoundException {
		webResource.path("/store/" + role + "/" + idParticipant + "/" + ext).post(
				new FileInputStream(file));
	}
}
