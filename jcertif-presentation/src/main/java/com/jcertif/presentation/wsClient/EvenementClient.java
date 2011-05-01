/**
 * 
 */
package com.jcertif.presentation.wsClient;

import java.util.List;

import com.jcertif.presentation.cache.UICacheManager;
import com.jcertif.presentation.data.bo.cedule.Evenement;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;

/**
 * @author rossi.oddet
 * 
 */
public class EvenementClient extends
		AbstractJCertWebServiceClient<Evenement, Long> {

	/**
	 * The unique instance.
	 */
	private EvenementClient() {
		super("evenement");
	}

	private static EvenementClient instance;

	public static synchronized EvenementClient getInstance() {
		if (instance == null) {
			instance = new EvenementClient();
		}
		return instance;
	}

	@Override
	public List<Evenement> findAll_JSON() throws UniformInterfaceException,
			ClientHandlerException {
		return getWebResource().path(FINDALL_SUFFIX)
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Evenement>>() {
				});

	}

	@Override
	public List<Evenement> findAllXML() throws UniformInterfaceException,
			ClientHandlerException {
		List<Evenement> events = UICacheManager.getInstance().getEvenement();

		if (events == null) {
			events = getWebResource().path(FINDALL_SUFFIX)
					.accept(javax.ws.rs.core.MediaType.APPLICATION_XML)
					.get(new GenericType<List<Evenement>>() {
					});
			UICacheManager.getInstance().putEvenement(events);
		}
		return events;
	}
}