/**
 * 
 */
package com.jcertif.service.participant;

import com.jcertif.bo.participant.RoleParticipant;
import com.jcertif.dao.api.participant.RoleParticipantDAO;
import org.springframework.stereotype.Service;

import com.jcertif.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implementation of the {@link ParticipantService}.
 * @author Douneg
 *
 */
@Service
public class RoleParticipantServiceImpl extends AbstractService<RoleParticipant, Long, RoleParticipantDAO> implements RoleParticipantService {

    @Autowired
    RoleParticipantDAO service;

    @Override
    public RoleParticipantDAO getService() {
        return service;
    }

    @Override
    public void setService(RoleParticipantDAO service) {
        this.service = service;
    }
}
