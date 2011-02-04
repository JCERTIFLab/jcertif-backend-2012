/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel.table;

import com.jcertif.presentation.action.ParticipantAction;
import com.jcertif.presentation.container.ParticipantContainer;

/**
 *
 * @author Douneg
 */
public class ParticipantTable extends AbstractTable<ParticipantAction, ParticipantContainer> {

    public ParticipantTable(ParticipantAction participantAction) {
        super(participantAction);
        // set column headers
        setVisibleColumns(ParticipantContainer.NATURAL_COL_ORDER);
        setColumnHeaders(ParticipantContainer.COL_HEADERS_FRENCH);
       
    }

}
