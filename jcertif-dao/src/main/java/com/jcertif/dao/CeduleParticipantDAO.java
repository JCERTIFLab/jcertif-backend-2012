package com.jcertif.dao;

import java.util.List;

import com.jcertif.bo.CeduleParticipant;

/**
 * @author rossi.oddet
 * 
 */
public interface CeduleParticipantDAO extends
		GenericDAO<CeduleParticipant, Long> {

	/**
	 * Recherche les cedules d'un participant.
	 * 
	 * @param idParticipant
	 * @return un cedule participant
	 */
	List<CeduleParticipant> findByParticipant(Long idParticipant);

}
