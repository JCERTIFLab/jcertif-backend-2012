/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel.table;

import com.jcertif.presentation.action.AbstractAction;
import com.jcertif.presentation.action.CeduleParticipantAction;
import com.jcertif.presentation.container.CeduleParticipantContainer;
import java.beans.PropertyChangeEvent;

/**
 *
 * @author Douneg
 */
public class CeduleParticipantTable extends AbstractTable<CeduleParticipantAction, CeduleParticipantContainer> {

    public CeduleParticipantTable(CeduleParticipantAction ceduleParticipantAction) {
        super(ceduleParticipantAction);
        
        // set column headers
        setVisibleColumns(CeduleParticipantContainer.NATURAL_COL_ORDER);
        setColumnHeaders(CeduleParticipantContainer.COL_HEADERS_FRENCH);

    }

   
}
