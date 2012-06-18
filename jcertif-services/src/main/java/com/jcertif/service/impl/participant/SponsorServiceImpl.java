/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.service.impl.participant;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.conference.Conference;
import com.jcertif.bo.participant.Participant;
import com.jcertif.bo.participant.RoleParticipant;
import com.jcertif.dao.api.conference.ConferenceDAO;
import com.jcertif.dao.api.participant.ParticipantDAO;
import com.jcertif.dao.api.participant.RoleParticipantDAO;
import com.jcertif.service.api.participant.SponsorService;

/**
 * 
 * @author rossi.oddet
 */
@Service
public class SponsorServiceImpl implements SponsorService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SponsorServiceImpl.class);

	@Autowired
	private ParticipantDAO participantDAO;
	@Autowired
	private RoleParticipantDAO roleParticipantDAO;
	@Autowired
	private ConferenceDAO conferenceDAO;

	@Override
	public Set<Participant> findAll(Long idConference) {
		List<RoleParticipant> roleSponsorList = roleParticipantDAO.findByProperty("code",
				RoleParticipant.CODE_SPONSOR);
		Conference conf = conferenceDAO.findById(idConference);

		if (roleSponsorList.isEmpty()) {
			LOGGER.error("No sponsor in RoleParticipant List");
		}

		Map<String, Object> criterias = new HashMap<String, Object>();
		criterias.put("roleparticipant", roleSponsorList.iterator().next());
		criterias.put("conference", conf);

        List<Participant> participants = participantDAO.findByProperties(criterias);

        // Removing sponsors without sponsorship level
        Iterator<Participant> itParticipant = participants.iterator();
        while(itParticipant.hasNext()){
            if(itParticipant.next().getNiveauPartenariat() == null) {
                itParticipant.remove();
            }
        }

		return new HashSet<Participant>(participants);
	}

}
