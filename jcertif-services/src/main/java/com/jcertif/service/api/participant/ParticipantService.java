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

	List<Participant> findAllWithProposition();

	void saveInFile(InputStream fileStream, Long idParticipant, String codeRole, String ext)
			throws IOException;

	Participant connect(String email, String password, Long conferenceId);

	Participant generateNewPassword(String email, Long conferenceId);

	Participant updateBio(String bio, String email, Long conferenceId);

	Participant findByEmail(String email, Long conferenceId);

    void modifyPassword(String email, String oldPassword, String newPassword, Long conferenceId);

}
