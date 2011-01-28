/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel;

import com.jcertif.presentation.action.ParticipantAction;
import com.vaadin.ui.Table;

/**
 *
 * @author Douneg
 */
public class ParticipantTable extends Table {

   private ParticipantAction participantAction;

    public ParticipantTable(ParticipantAction participantAction) {
        this.participantAction = participantAction;
    }
    
}
