/**
 * 
 */
package com.jcertif.service.impl.participant;

import com.jcertif.bo.participant.RoleParticipant;
import com.jcertif.dao.api.participant.RoleParticipantDAO;
import org.springframework.stereotype.Service;

import com.jcertif.service.AbstractService;
import com.jcertif.service.api.participant.ParticipantService;
import com.jcertif.service.api.participant.RoleParticipantService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implementation of the {@link ParticipantService}.
 * @author Douneg
 *
 */
@Service
public class RoleParticipantServiceImpl extends AbstractService<RoleParticipant, Long, RoleParticipantDAO> implements RoleParticipantService {

    @Autowired
    RoleParticipantDAO roleParticipantDAO;

    @Override
    public RoleParticipantDAO getDAO() {
        return roleParticipantDAO;
    }

    @Override
    public void setDAO(RoleParticipantDAO roleParticipantDAO) {
        this.roleParticipantDAO = roleParticipantDAO;
    }
}
