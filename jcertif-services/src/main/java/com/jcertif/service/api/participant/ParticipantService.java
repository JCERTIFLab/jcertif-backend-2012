/**
 * 
 */
package com.jcertif.service.api.participant;

import java.io.IOException;
import java.io.InputStream;
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

	/**
	 * return one participant with the email. WARNING : if the participant is
	 * not found => RuntimeException WARNING : if many participant have this
	 * email => RuntimeException
	 * 
	 * @param email
	 *            the email
	 * @return the unique participant
	 */
	Participant findUniqueByEmail(String email);

	List<Participant> findAllWithProposition();

	void saveInFile(InputStream fileStream, Long idParticipant, String codeRole, String ext)
			throws IOException;

	/**
	 * 
	 * @param email
	 * @param password
	 * @return null if password is wrong
	 */
	Participant connect(String email, String password);

	Participant generateNewPassword(String email);

}
