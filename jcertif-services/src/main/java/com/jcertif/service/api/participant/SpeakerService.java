/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.service.api.participant;

import com.jcertif.bo.participant.Participant;
import java.util.Set;


/**
 *
 * @author rossi.oddet
 */
public interface SpeakerService {
    
    Set<Participant> findAll();
    
}
