/**
 * 
 */
package com.jcertif.service.impl.presentation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcertif.bo.participant.Participant;
import com.jcertif.bo.presentation.PropositionPresentation;
import com.jcertif.bo.presentation.StatutApprobation;
import com.jcertif.bo.presentation.Sujet;
import com.jcertif.dao.api.participant.ParticipantDAO;
import com.jcertif.dao.api.presentation.PropositionPresentationDAO;
import com.jcertif.dao.api.presentation.StatutApprobationDAO;
import com.jcertif.dao.api.presentation.SujetDAO;
import com.jcertif.service.AbstractService;
import com.jcertif.service.api.presentation.PropositionPresentationService;

/**
 * @author rossi
 * 
 */
@Service
public class PropositionPresentationServiceImpl extends
		AbstractService<PropositionPresentation, Long, PropositionPresentationDAO> implements
		PropositionPresentationService {

	private static final String CODE_EN_TRAITEMENT = "T";

	@Autowired
	private PropositionPresentationDAO propositionPresentationDAO;

	@Autowired
	private StatutApprobationDAO stDao;

	@Autowired
	private SujetDAO sujetDao;

	@Autowired
	private ParticipantDAO participantDAO;

	@Override
	public PropositionPresentationDAO getDAO() {
		return propositionPresentationDAO;
	}

	@Override
	public void setDAO(PropositionPresentationDAO propositionPresentationDAO) {
		this.propositionPresentationDAO = propositionPresentationDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcertif.service.AbstractService#save(java.lang.Object)
	 */
	@Override
	@Transactional
	public PropositionPresentation save(PropositionPresentation proposition) {
		StatutApprobation statut = stDao.findByCode(CODE_EN_TRAITEMENT).iterator().next();

		if (proposition.getSujets() != null) {
			List<Sujet> sujets = new ArrayList<Sujet>();
			for (Sujet sujet : proposition.getSujets()) {
				sujets.add(sujetDao.findById(sujet.getId()));
			}
			proposition.setSujetsInternal(sujets);
		}

		if (proposition.getParticipants() != null) {
			Set<Participant> participants = new HashSet<Participant>();
			for (Participant participant : proposition.getParticipants()) {
				participants.add(participantDAO.findById(participant.getId()));
			}
			proposition.setParticipants(participants);

		}

		proposition.setStatutApprobation(statut);
		return propositionPresentationDAO.merge(proposition);
	}

}
