package com.jcertif.service.api.participant;

import java.util.Set;

import com.jcertif.bo.participant.Participant;

/**
 * 
 * @author rossi.oddet
 */
public interface SponsorService {

	Set<Participant> findAll(Long idConference);

}
