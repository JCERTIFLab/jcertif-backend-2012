package com.jcertif.service.participant;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcertif.bo.cedule.CeduleParticipant;
import com.jcertif.bo.cedule.Evenement;
import com.jcertif.bo.cedule.StatutCedule;
import com.jcertif.bo.participant.Participant;
import com.jcertif.dao.api.cedule.CeduleParticipantDAO;
import com.jcertif.dao.api.cedule.EvenementDAO;
import com.jcertif.dao.api.cedule.StatutCeduleDAO;
import com.jcertif.dao.api.participant.ParticipantDAO;

/**
 * Service CeduleParticipant.
 * 
 * @author rossi.oddet
 * 
 */
@Service
public class CeduleParticipantServiceImpl implements CeduleParticipantService {

	/**
	 * DAO cedule participant.
	 */
	@Autowired
	private CeduleParticipantDAO ceduleParticipantDAO;

	/**
	 * DAO Participant.
	 */
	@Autowired
	private ParticipantDAO participantDAO;

	/**
	 * DAO Evenement.
	 */
	@Autowired
	private EvenementDAO evenementDAO;
	
	/**
	 * DAO StatutCedule.
	 */
	@Autowired
	private StatutCeduleDAO statutCeduleDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CeduleParticipant> findByParticipant(Long idParticipant) {
		return ceduleParticipantDAO.findByParticipant(idParticipant);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public CeduleParticipant saveOrUpdate(CeduleParticipant cedule) {
		return ceduleParticipantDAO.merge(cedule);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void remove(CeduleParticipant cedule) {
		ceduleParticipantDAO.remove(cedule);

	}

	/**
	 * @see com.jcertif.services.participant.CeduleParticipantService#createCedule(com.jcertif.bo.cedule.CeduleParticipant,
	 *      java.lang.Long, java.lang.Long, java.lang.String)
	 */
	@Override
	@Transactional
	public CeduleParticipant createCedule(Calendar dateCedule, String details,
			Long idParticipant, Long idEvenement, String codeStatut) {

		CeduleParticipant cedule = buildCeduleParticipant(dateCedule, details,
				idParticipant, idEvenement, codeStatut);
		
		return ceduleParticipantDAO.merge(cedule);
	}

	/**
	 * Contruction d'un objet CeduleParticipant.
	 * 
	 * @param dateCedule date du cedule
	 * @param details un d�tails
	 * @param idParticipant un identifiant de participant
	 * @param idEvenement
	 * @return
	 */
	private CeduleParticipant buildCeduleParticipant(Calendar dateCedule,
			String details, Long idParticipant, Long idEvenement, String statutCedule) {
		CeduleParticipant cedule = new CeduleParticipant();
		updateCedule(dateCedule, details, idParticipant, idEvenement,
				statutCedule, cedule);
		
		return cedule;
	}

	private void updateCedule(Calendar dateCedule, String details,
			Long idParticipant, Long idEvenement, String statutCedule,
			CeduleParticipant cedule) {
		cedule.setDateCedule(dateCedule);
		cedule.setDetails(details);

		if (idParticipant != null) {
			Participant participant = participantDAO.findById(idParticipant);
			cedule.setParticipant(participant);
		}

		if (idEvenement != null) {
			Evenement evenement = evenementDAO.findById(idEvenement);
			cedule.setEvenement(evenement);
		}
		
		if(statutCedule !=null){
			StatutCedule statut = statutCeduleDAO.findByCode(statutCedule);
			cedule.setStatutCedule(statut);
		}
	}

	@Override
	@Transactional
	public CeduleParticipant updateCedule(Long idCedule, Calendar dateCedule,
			String details, Long idParticipant, Long idEvent, String codeStatut) {
		CeduleParticipant cedule = ceduleParticipantDAO.findById(idCedule);
		
		updateCedule(dateCedule, details, idParticipant, idEvent,
				codeStatut, cedule);
		ceduleParticipantDAO.persist(cedule);
		return cedule;
	}

	@Override
	public List<CeduleParticipant> findAll() {
		return ceduleParticipantDAO.findAll();
	}

	/**
	 * @param ceduleParticipantDAO
	 *            the ceduleParticipantDAO to set
	 */
	public void setCeduleParticipantDAO(
			CeduleParticipantDAO ceduleParticipantDAO) {
		this.ceduleParticipantDAO = ceduleParticipantDAO;
	}

}
