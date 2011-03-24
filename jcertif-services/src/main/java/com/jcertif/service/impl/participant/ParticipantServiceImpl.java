/**
 * 
 */
package com.jcertif.service.impl.participant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.participant.Participant;
import com.jcertif.dao.api.participant.ParticipantDAO;
import com.jcertif.exception.ExistingEmailException;
import com.jcertif.service.AbstractService;
import com.jcertif.service.api.participant.ParticipantService;

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

	@Override
	public Participant save(Participant entite) {
		List<Participant> partList = participantDAO.findByEmail(entite.getEmail());
		if(partList.size() != 0){
			throw new ExistingEmailException();
		}
		return super.save(entite);
		
	}

	@Override
	public Participant update(Participant entite) {
		return super.update(entite);
	}

	@Override
	public List<Participant> findByEmail(String email) {
		return participantDAO.findByEmail(email);
	}
    
    
}
