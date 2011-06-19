/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.service.impl.participant;

import com.jcertif.bo.participant.Participant;
import com.jcertif.bo.participant.RoleParticipant;
import com.jcertif.dao.api.participant.ParticipantDAO;
import com.jcertif.dao.api.participant.RoleParticipantDAO;
import com.jcertif.service.api.participant.SpeakerService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rossi.oddet
 */
@Service
public class SpeakerServiceImpl implements SpeakerService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ParticipantServiceImpl.class);
    
    @Autowired
    private ParticipantDAO participantDAO;
    @Autowired
    private RoleParticipantDAO roleParticipantDAO;

    @Override
    public Set<Participant> findAll() {
        List<RoleParticipant> roleSpeakerList = roleParticipantDAO.findByProperty("code", RoleParticipant.CODE_SPEAKER);
        
        if(roleSpeakerList.isEmpty()){
            LOGGER.error("No speaker in RoleParticipant List");
        }
        return new HashSet<Participant>(participantDAO.findByProperty("roleparticipant", roleSpeakerList.iterator().next()));
    }
    
}
