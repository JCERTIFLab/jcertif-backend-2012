/**
 * 
 */
package com.jcertif.service.impl.participant;

import com.jcertif.bo.participant.TypeParticipant;
import com.jcertif.dao.api.participant.TypeParticipantDAO;
import org.springframework.stereotype.Service;

import com.jcertif.service.AbstractService;
import com.jcertif.service.api.participant.ParticipantService;
import com.jcertif.service.api.participant.TypeParticipantService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implementation of the {@link ParticipantService}.
 * @author Douneg
 *
 */
@Service
public class TypeParticipantServiceImpl extends AbstractService<TypeParticipant, Long, TypeParticipantDAO> implements TypeParticipantService {

    @Autowired
    private TypeParticipantDAO typeParticipantDAO;

    @Override
    public TypeParticipantDAO getDAO() {
        return typeParticipantDAO;
    }

    @Override
    public void setDAO(TypeParticipantDAO typeParticipantDAO) {
        this.typeParticipantDAO = typeParticipantDAO;
    }
}
