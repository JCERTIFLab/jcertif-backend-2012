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
    @Autowired
    private ConferenceDAO conferenceDAO;
    @Autowired
    private RoleParticipantDAO roleParticipantDAO;
    @Autowired
    private TypeParticipantDAO typeParticipantDAO;
    @Autowired
    private ProfilUtilisateurDAO profilUtilisateurDAO;

    @Override
    public Participant save(Participant participant) {
        if (participant.getConference() != null) {
            Conference conference = conferenceDAO.getReference(participant.getConference().getId());
            participant.setConference(conference);
        } else if (participant.getRoleparticipant() != null) {
            RoleParticipant roleParticipant = roleParticipantDAO.getReference(participant.getRoleparticipant().getId());
            participant.setRoleparticipant(roleParticipant);
        } else if (participant.getTypeParticipant() != null) {
            TypeParticipant typeParticipant = typeParticipantDAO.getReference(participant.getTypeParticipant().getId());
            participant.setTypeParticipant(typeParticipant);
        }
        if (participant.getProfilUtilisateur() != null) {
            profilUtilisateurDAO.persist(participant.getProfilUtilisateur());
        } else {
        }
        return super.save(participant);
    }

    @Override
    public ParticipantDAO getDAO() {
        return participantDAO;
    }

    @Override
    public void setDAO(ParticipantDAO participantDAO) {
        this.participantDAO = participantDAO;
    }
}
