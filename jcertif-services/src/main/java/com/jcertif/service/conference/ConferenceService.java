package com.jcertif.service.conference;

import java.util.List;

import com.jcertif.bo.conference.Conference;
/**
 * 
 * @author Chrisbel
 *
 */
public interface ConferenceService {

	/**
	 * 
	 * @return list des conferences
	 */
	public List<Conference> findAll();
	/**
	 * 
	 * @param key
	 * @return une Conférence
	 */
	public Conference findById(Long key);
	/**
	 * 
	 * @param conference
	 * @return
	 */
	public Conference save(Conference conference);
	/**
	 * 
	 * @param conference
	 * @return
	 */
	public Conference update(Conference conference);
	/**
	 * @param conference
	 */
	public void remove(Conference conference);

}
