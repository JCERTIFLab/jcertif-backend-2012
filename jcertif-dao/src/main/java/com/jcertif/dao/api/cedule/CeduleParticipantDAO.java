package com.jcertif.dao.api.cedule;

import java.util.List;

import com.jcertif.bo.cedule.CeduleParticipant;
import com.jcertif.dao.api.GenericDAO;

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
