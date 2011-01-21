/**
 * 
 */
package com.jcertif.service.participant;

import com.jcertif.bo.participant.TypeParticipant;
import com.jcertif.dao.api.participant.TypeParticipantDAO;
import org.springframework.stereotype.Service;

import com.jcertif.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implementation of the {@link ParticipantService}.
 * @author Douneg
 *
 */
@Service
public class TypeParticipantServiceImpl extends AbstractService<TypeParticipant, Long, TypeParticipantDAO> implements TypeParticipantService {

    @Autowired
    private TypeParticipantDAO service;

    @Override
    public TypeParticipantDAO getService() {
        return service;
    }

    @Override
    public void setService(TypeParticipantDAO service) {
        this.service = service;
    }
}
