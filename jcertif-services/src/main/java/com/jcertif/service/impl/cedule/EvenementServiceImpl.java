/**
 * 
 */
package com.jcertif.service.impl.cedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.cedule.Evenement;
import com.jcertif.bo.presentation.PropositionPresentation;
import com.jcertif.dao.api.cedule.EvenementDAO;
import com.jcertif.service.AbstractService;
import com.jcertif.service.api.cedule.EvenementService;

/**
 * service de gestion des évènements
 * 
 * @author thierry.balla
 * 
 */
@Service
public class EvenementServiceImpl extends AbstractService<Evenement, Long, EvenementDAO> implements
		EvenementService {

	@Autowired
	private EvenementDAO evenementDAO;

	@Override
	public EvenementDAO getDAO() {
		return evenementDAO;
	}

	@Override
	public void setDAO(EvenementDAO dao) {
		this.evenementDAO = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcertif.service.AbstractService#findAll()
	 */
	@Override
	public List<Evenement> findAll() {
		List<Evenement> events = evenementDAO.findAll();

		if (events != null && !events.isEmpty()) {
			for (Evenement event : events) {
				PropositionPresentation propo = event.getPropositionPresentation();

				if (propo != null && propo.getParticipants() != null
						&& !propo.getParticipants().isEmpty()) {
					propo.getParticipants().iterator().next();
				}
			}
		}
		return events;
	}

}
