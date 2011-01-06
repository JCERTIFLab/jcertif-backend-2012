/**
 * 
 */
package com.jcertif.services.participant;

import java.util.List;

import com.jcertif.bo.Participant;

/**
 * Service Layer for the {@link Participant}.
 * @author Bernard Adanlessossi
 *
 */
public interface ParticipantService {

	public List<Participant> findAll();
	
	public Participant findById(Long key);
	
	public Participant save(Participant participant);
	
	public Participant update(Participant participant);
	
	public void remove(Participant participant);
}
