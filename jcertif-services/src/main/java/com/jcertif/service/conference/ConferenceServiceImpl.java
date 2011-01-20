package com.jcertif.service.conference;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcertif.bo.conference.Conference;
import com.jcertif.dao.api.conference.ConferenceDAO;

/**
 * roland.amour@chrisbel.net
 */

/**
 * @ Chrisbel
 */
@Service
public class ConferenceServiceImpl implements ConferenceService {

	@Autowired
	private ConferenceDAO conferenceDAO;

	@Override
	public List<Conference> findAll() {
		return conferenceDAO.findAll();
	}

	@Override
	public Conference findById(Long key) {
		return conferenceDAO.findById(key);
	}

	@Override
	@Transactional
	public Conference save(Conference conference) {
		return conferenceDAO.merge(conference);
	}

	@Override
	@Transactional
	public Conference update(Conference conference) {
		return conferenceDAO.merge(conference);
	}

	@Override
	@Transactional
	public void remove(Conference conference) {
		conferenceDAO.remove(conference);
	}

	/**
	 * 
	 * @param conferenceDAO
	 */
	public void setConferenceDAO(ConferenceDAO conferenceDAO) {
		this.conferenceDAO = conferenceDAO;
	}

}
