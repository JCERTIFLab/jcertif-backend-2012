/**
 * 
 */
package com.jcertif.presentation.wsClient;

import java.util.List;

import com.jcertif.presentation.cache.UICacheManager;
import com.jcertif.presentation.data.bo.conference.Faq;
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

public class FaqClient extends AbstractJCertWebServiceClient<Faq, Long> {

	/**
	 * The unique instance.
	 */
	private FaqClient() {
		super("faq");
	}

	private static FaqClient instance;

	public static synchronized FaqClient getInstance() {
		if (instance == null) {
			instance = new FaqClient();
		}
		return instance;
	}

	@Override
	public List<Faq> findAll_JSON() throws UniformInterfaceException,
			ClientHandlerException {
		return getWebResource().path(FINDALL_SUFFIX)
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Faq>>() {
				});

	}

	@Override
	public List<Faq> findAllXML() throws UniformInterfaceException,
			ClientHandlerException {
		List<Faq> faqs = UICacheManager.getInstance().getFaq();

		if (faqs == null) {
			faqs = getWebResource().path(FINDALL_SUFFIX)
					.accept(javax.ws.rs.core.MediaType.APPLICATION_XML)
					.get(new GenericType<List<Faq>>() {
					});
			UICacheManager.getInstance().putFaq(faqs);
		}
		return faqs;
	}
}
