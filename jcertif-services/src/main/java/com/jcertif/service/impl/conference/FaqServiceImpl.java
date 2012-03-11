package com.jcertif.service.impl.conference;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.conference.Faq;
import com.jcertif.dao.api.conference.FaqDAO;
import com.jcertif.service.AbstractService;
import com.jcertif.service.api.conference.FaqService;

/**
 * @author rossi
 * 
 */
@Service
public class FaqServiceImpl extends AbstractService<Faq, Long, FaqDAO> implements FaqService {

	@Autowired
	private FaqDAO faqDAO;

	@Override
	public FaqDAO getDAO() {
		return faqDAO;
	}

	@Override
	public void setDAO(FaqDAO dao) {
		this.faqDAO = dao;
	}

	@Override
	public List<Faq> findByConferenceId(Long idConference) {
		return faqDAO.findByProperty("conferenceId", idConference);
	}

}
