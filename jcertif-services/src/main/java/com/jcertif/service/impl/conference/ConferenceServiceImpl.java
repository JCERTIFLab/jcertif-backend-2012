package com.jcertif.service.impl.conference;

import org.springframework.stereotype.Service;

import com.jcertif.bo.conference.Conference;
import com.jcertif.dao.api.conference.ConferenceDAO;
import com.jcertif.service.AbstractService;
import com.jcertif.service.api.conference.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * roland.amour@chrisbel.net
 */
/**
 * @ Chrisbel
 */
@Service
public class ConferenceServiceImpl extends AbstractService<Conference, Long, ConferenceDAO> implements ConferenceService {

    @Autowired
    private ConferenceDAO conferenceDAO;

    @Override
    public ConferenceDAO getDAO() {
        return conferenceDAO;
    }

    @Override
    public void setDAO(ConferenceDAO conferenceDAO) {
        this.conferenceDAO = conferenceDAO;
    }
}
