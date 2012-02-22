/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.service.api.participant;

import java.util.Set;

import com.jcertif.bo.participant.Participant;

/**
 * 
 * @author rossi.oddet
 */
public interface SpeakerService {

	Set<Participant> findAll(Long idConference);

}
