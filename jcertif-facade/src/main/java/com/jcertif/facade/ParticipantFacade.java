/**
 * 
 */
package com.jcertif.facade;

import java.util.Iterator;
import java.util.List;

import com.jcertif.bo.Participant;
import com.jcertif.dao.ParticipantDAO;
import com.jcertif.facade.exception.ItemAlreadyExistsException;
import com.jcertif.facade.exception.ItemNotFoundException;
import com.jcertif.services.participant.ParticipantService;
import com.jcertif.util.XMLUtil;
import com.sun.jersey.api.core.InjectParam;

/**
 * Facade for the {@link ParticipantDAO}.
 * 
 * @author Bernard Adanlessossi
 *
 */
public class ParticipantFacade {
	
	@InjectParam
	private static ParticipantService service;
	
	public static String create(String xml) throws ItemAlreadyExistsException {
		Participant participant = XMLUtil.getParticipantVOFromXML(xml);
        if (participant != null) {
        	// Check if participant exists in our DB: if not, create; else, throw
        	// exception
        	if (service.findById(participant.getId()) == null){
        		service.save(participant);
        	}

        		return participant.toXML();
        	} else {
        		throw new ItemAlreadyExistsException();
        	}
	}

	/**
	 * Gets all participant as an xml file.
	 * <p>Note: this method should be moved to the DAO
	 * @return the xml
	 */
	public static String getAllXML() {
		// Retrieve the participants list
		List<Participant> result = service.findAll();
		StringBuilder participants = new StringBuilder();
		participants.append("<participants>");
		participants.append("<count>").append(result.size()).append("</count>");
		while (result.iterator().hasNext()) {
			participants.append(result.iterator().next().toXML());
		}
		participants.append("</participants>");
		return participants.toString();
	}
	
	public static String getAllJSON() {
		StringBuilder participants = new StringBuilder();
		
		List<Participant> result = service.findAll();

		participants.append("{\"participants-result\":{\"count\":\"").append(result.size()).append("\", \"participants\":[");
		
		Iterator<Participant> iter = result.iterator();
		while (iter.hasNext()) {
			participants.append(iter.next().toJSON());

			if (iter.hasNext()) {
				participants.append(",");
			}
		}

		participants.append("]}}");

		return participants.toString();
	}
	
	public static String update(String xml) throws ItemNotFoundException {
		Participant tmpParticipant = null;
		
		Participant participant = XMLUtil.getParticipantVOFromXML(xml);
		if (participant != null) {
			// Check that user exists in our DB: if so, update; else, throw
			// exception
			tmpParticipant = query(participant.getId());
			
			if (tmpParticipant != null) {
				// We only let the user update the email
				tmpParticipant.setEmail(participant.getEmail());
				service.update(tmpParticipant);
				
			} else {
				throw new ItemNotFoundException();
			}
		}
		return tmpParticipant.toXML();
	}
	
	public static void delete(Long id) throws ItemNotFoundException {
		
		Participant participant = query(id);
		
		if (participant != null){
			service.remove(participant);
		}else{
			throw new ItemNotFoundException();
		}
	}
	
	public static String getXML(Long key) {
		Participant participant = query(key);

		return (participant != null) ? participant.toXML() : null;
	}
	
	public static String getJSON(Long key) {
		Participant participant = query(key);

		return (participant != null) ? participant.toJSON() : null;
	}
	
	private static Participant query (Long key){
		return service.findById(key);		
	}
}
