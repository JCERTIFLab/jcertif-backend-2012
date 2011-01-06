/**
 * 
 */
package com.jcertif.services.participant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcertif.bo.Participant;
import com.jcertif.dao.ParticipantDAO;

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
	 * @see com.jcertif.services.participant.ParticipantService#findAll()
	 */
	@Override
	public List<Participant> findAll() {
		// TODO Auto-generated method stub
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

}
