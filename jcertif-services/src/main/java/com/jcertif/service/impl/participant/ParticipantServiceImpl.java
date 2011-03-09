/**
 * 
 */
package com.jcertif.service.impl.participant;

import com.jcertif.bo.conference.Conference;
import org.springframework.stereotype.Service;

import com.jcertif.bo.participant.Participant;
import com.jcertif.bo.participant.RoleParticipant;
import com.jcertif.bo.participant.TypeParticipant;
import com.jcertif.dao.api.conference.ConferenceDAO;
import com.jcertif.dao.api.participant.ParticipantDAO;
import com.jcertif.dao.api.participant.ProfilUtilisateurDAO;
import com.jcertif.dao.api.participant.RoleParticipantDAO;
import com.jcertif.dao.api.participant.TypeParticipantDAO;
import com.jcertif.service.AbstractService;
import com.jcertif.service.api.participant.ParticipantService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implementation of the {@link ParticipantService}.
 * @author Bernard Adanlessossi
 *
 */
@Service
public class ParticipantServiceImpl extends AbstractService<Participant, Long, ParticipantDAO> implements ParticipantService {

    @Autowired
    ParticipantDAO participantDAO;

    @Override
    public ParticipantDAO getDAO() {
        return participantDAO;
    }

    @Override
    public void setDAO(ParticipantDAO participantDAO) {
        this.participantDAO = participantDAO;
    }
}
