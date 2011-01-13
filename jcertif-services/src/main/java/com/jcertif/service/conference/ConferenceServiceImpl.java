package com.jcertif.service.conference;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jcertif.bo.Conference;
import com.jcertif.dao.ConferenceDAO;

/**
 * roland.amour@chrisbel.net
 */

/**
 * @ Chrisbel
 */
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
	public Conference save(Conference conference) {
		// TODO Auto-generated method stub
		return conferenceDAO.merge(conference);
	}

	@Override
	public Conference update(Conference conference) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Conference conference) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @param conferenceDAO
	 */
	public void setConferenceDAO(ConferenceDAO conferenceDAO) {
		this.conferenceDAO = conferenceDAO;
	}

}
