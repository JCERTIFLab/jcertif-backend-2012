package com.jcertif.service.impl.cedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.cedule.CeduleParticipant;
import com.jcertif.dao.api.cedule.CeduleParticipantDAO;
import com.jcertif.service.AbstractService;
import com.jcertif.service.api.cedule.CeduleParticipantService;

/**
 * Service CeduleParticipant.
 * 
 * @author rossi.oddet
 * 
 */
@Service
public class CeduleParticipantServiceImpl extends AbstractService<CeduleParticipant, Long, CeduleParticipantDAO> implements CeduleParticipantService {

	/**
	 * DAO cedule participant.
	 */
	@Autowired
	private CeduleParticipantDAO ceduleParticipantDAO;

	@Override
	public CeduleParticipantDAO getDAO() {
		return ceduleParticipantDAO;
	}

	@Override
	public void setDAO(CeduleParticipantDAO dao) {
		this.ceduleParticipantDAO = dao;		
	}



}
