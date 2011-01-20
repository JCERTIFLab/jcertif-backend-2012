/**
 * 
 */
package com.jcertif.service.participant;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcertif.bo.cedule.CeduleParticipant;
import com.jcertif.bo.conference.Conference;
import com.jcertif.bo.participant.Participant;
import com.jcertif.bo.participant.RoleParticipant;
import com.jcertif.dao.api.participant.ParticipantDAO;

/**
 * Implementation of the {@link ParticipantService}.
 * @author Bernard Adanlessossi
 *
 */
@Service
public class ParticipantServiceImpl implements ParticipantService {
	
	@Autowired
	private ParticipantDAO participantDao;

	/* (non-Javadoc)
     * @see com.jcertif.service.participant.ParticipantService#createParticipant(java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Character, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.jcertif.bo.RoleParticipant, com.jcertif.bo.Conference, java.util.Set)
     */
    @Override
    public Participant createParticipant(Participant participant) {
	    
    	return participantDao.merge(participant);
    }

	/* (non-Javadoc)
	 * @see com.jcertif.services.participant.ParticipantService#findAll()
	 */
	@Override
	public List<Participant> findAll() {
		return participantDao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.jcertif.services.participant.ParticipantService#findById(java.lang.Integer)
	 */
	@Override
	public Participant findById(Long key) {
		return participantDao.findById(key);
	}

	/* (non-Javadoc)
	 * @see com.jcertif.services.participant.ParticipantService#save(com.jcertif.bo.Participant)
	 */
	@Override
	@Transactional
	public Participant save(Participant participant) {
		participantDao.persist(participant);
		return participant;
	}

	/* (non-Javadoc)
	 * @see com.jcertif.services.participant.ParticipantService#update(com.jcertif.bo.Participant)
	 */
	@Override
	@Transactional
	public Participant update(Participant participant) {
		return participantDao.merge(participant);
	}

	/* (non-Javadoc)
	 * @see com.jcertif.services.participant.ParticipantService#delete(com.jcertif.bo.Participant)
	 */
	@Override
	public void remove(Participant participant) {
		participantDao.remove(participant);
	}

	/**
	 * Sets the DAO for this service.
	 * @param participantDAO the dao
	 */
	public void setParticipantDAO(ParticipantDAO participantDAO){
		this.participantDao = participantDAO;
	}
}
