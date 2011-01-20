package com.jcertif.service.participant;

import java.util.Calendar;
import java.util.List;

import com.jcertif.bo.cedule.CeduleParticipant;

/**
 * Service CeduleParticipant
 * 
 * @author rossi.oddet
 * 
 */
public interface CeduleParticipantService {

	/**
	 * R�cup�rer les cedules des participants.
	 * 
	 * @param idParticipant
	 *            identifiant d'un participant
	 * @return
	 */
	List<CeduleParticipant> findByParticipant(Long idParticipant);

	List<CeduleParticipant> findAll();

	/**
	 * @param cedule
	 * @return
	 */
	CeduleParticipant saveOrUpdate(CeduleParticipant cedule);

	/**
	 * Suppression d'une schedule.
	 * 
	 * @param cedule
	 */
	void remove(CeduleParticipant cedule);

	/**
	 * @param cedule
	 * @return
	 */
	CeduleParticipant createCedule(Calendar dateCedule, String details,
			Long idParticipant, Long idEvent, String codeStatut);
	
	CeduleParticipant updateCedule(Long idCedule,Calendar dateCedule, String details,
			Long idParticipant, Long idEvent, String codeStatut);

}
