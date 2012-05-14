/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.service.impl.participant;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.conference.Conference;
import com.jcertif.bo.participant.Participant;
import com.jcertif.bo.participant.RoleParticipant;
import com.jcertif.bo.presentation.PropositionPresentation;
import com.jcertif.dao.api.conference.ConferenceDAO;
import com.jcertif.dao.api.participant.ParticipantDAO;
import com.jcertif.dao.api.participant.RoleParticipantDAO;
import com.jcertif.service.api.participant.SpeakerService;

/**
 * 
 * @author rossi.oddet
 */
@Service
public class SpeakerServiceImpl implements SpeakerService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ParticipantServiceImpl.class);

	@Autowired
	private ParticipantDAO participantDAO;
	@Autowired
	private RoleParticipantDAO roleParticipantDAO;
	@Autowired
	private ConferenceDAO conferenceDAO;

	@Override
	public Set<Participant> findAll(Long idConference) {
		List<RoleParticipant> roleSpeakerList = roleParticipantDAO
				.findByProperty("code", RoleParticipant.CODE_SPEAKER);

		Conference conf = conferenceDAO.findById(idConference);

		if (roleSpeakerList.isEmpty()) {
			LOGGER.error("No sponsor in RoleParticipant List");
		}

		Map<String, Object> criterias = new HashMap<String, Object>();
		criterias.put("roleparticipant", roleSpeakerList.iterator().next());
		criterias.put("conference", conf);

		Set<Participant> participants = new HashSet<Participant>(
				participantDAO.findByProperties(criterias));

		Iterator<Participant> participantIt = participants.iterator();
		
		boolean isValidSpeaker = false;

		while (participantIt.hasNext()) {
			Participant participant = participantIt.next();
			isValidSpeaker = false;
			if (participant.getPropositionPresentations() != null && !participant.getPropositionPresentations().isEmpty()) {
				for (PropositionPresentation suggest : participant.getPropositionPresentations()) {
					if("A".equalsIgnoreCase(suggest.getStatutApprobation().getCodeStatut())){
						isValidSpeaker = true;
						break;
					}
				}
			}
			if(!isValidSpeaker) {
				participantIt.remove();
			}
		}

		return participants;
	}

}
