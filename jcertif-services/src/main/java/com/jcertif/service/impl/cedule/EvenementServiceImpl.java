/**
 * 
 */
package com.jcertif.service.impl.cedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.cedule.Evenement;
import com.jcertif.dao.api.cedule.EvenementDAO;
import com.jcertif.service.api.cedule.EvenementService;

/**
 * service de gestion des évènements
 * @author thierry.balla
 *
 */
@Service
public class EvenementServiceImpl implements EvenementService {
	
	@Autowired
	private EvenementDAO evenementDAO;

	public void setEvenementDAO(EvenementDAO evenementDAO) {
		this.evenementDAO = evenementDAO;
	}

	@Override
	public List<Evenement> findAll() {
		return evenementDAO.findAll();
	}

	@Override
	public Evenement findById(Long key) {		
		return evenementDAO.findById(key);
	}

	@Override
	public Evenement save(Evenement evenement) {
		evenementDAO.persist(evenement);
		
		return evenement;
	}

	@Override
	public Evenement update(Evenement evenement) {
		return evenementDAO.merge(evenement);
	}

	@Override
	public void remove(Evenement evenement) {
		evenementDAO.remove(evenement);		
	}

	@Override
	public Evenement createEvenement(Evenement evenement) {
		
		return evenementDAO.merge(evenement);
	}
}
