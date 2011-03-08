/**
 * 
 */
package com.jcertif.service.impl.cedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.cedule.CeduleParticipant;
import com.jcertif.bo.cedule.Evenement;
import com.jcertif.bo.presentation.Sujet;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcertif.service.AbstractService#findAll()
	 */
	@Override
	public List<Evenement> findAll() {
		List<Evenement> evenements = super.findAll();

		for (Evenement event : evenements) {
			if (event.getCeduleParticipants() != null) {
				for (CeduleParticipant cedule : event.getCeduleParticipants()) {
					if (cedule.getParticipant().getPresentationSoumise() != null) {
						if (cedule.getParticipant().getPresentationSoumise().getSujets() != null) {
							Sujet sujet = cedule.getParticipant().getPresentationSoumise().getSujets().iterator()
									.next();
							sujet.getId();
						}
					}
				}
			}
		}

		return evenements;
	}

	@Override
	public EvenementDAO getDAO() {
		return evenementDAO;
	}

	@Override
	public void setDAO(EvenementDAO dao) {
		this.evenementDAO = dao;
	}
}
