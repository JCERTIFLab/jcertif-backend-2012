/**
 * 
 */
package com.jcertif.service.api.participant;

import java.util.List;

import com.jcertif.bo.participant.Participant;
import com.jcertif.dao.api.participant.ParticipantDAO;
import com.jcertif.service.GenericService;

/**
 * Service Layer for the {@link Participant}.
 * 
 * @author Bernard Adanlessossi
 * 
 */
public interface ParticipantService extends GenericService<Participant, Long, ParticipantDAO> {

	/**
	 * Return true if email adress is already used, false otherwise.
	 * 
	 * @param email
	 *            a email adress
	 * @return true if email exist
	 */
	List<Participant> findByEmail(String email);

}
