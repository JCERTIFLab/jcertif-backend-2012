package com.jcertif.dao.api.participant;

import java.util.List;

import com.jcertif.bo.participant.Participant;
import com.jcertif.dao.api.GenericDAO;

/**
 * DAO Interface for Participant.
 * 
 * @author Douneg
 * 
 */
public interface ParticipantDAO extends GenericDAO<Participant, Long> {

	/**
	 * Find Participant by Email.
	 * 
	 * @param email
	 *            email criteria
	 * @return the participant 
	 */
	List<Participant> findByEmail(String email);
}
