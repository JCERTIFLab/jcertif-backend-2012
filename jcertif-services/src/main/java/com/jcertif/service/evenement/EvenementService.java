package com.jcertif.service.evenement;

import java.util.List;

import com.jcertif.bo.Evenement;

/**
 * Business layer interface for Evenement.
 * 
 * @author thierry.balla
 * 
 */
public interface EvenementService {

	public List<Evenement> findAll();
	
	public Evenement findById(Long key);
	
	public Evenement save(Evenement evenement);
	
	public Evenement update(Evenement evenement);
	
	public void remove(Evenement evenement);

}
