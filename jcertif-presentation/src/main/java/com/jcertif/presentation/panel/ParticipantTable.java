/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel;

import com.jcertif.presentation.action.ParticipantAction;
import com.jcertif.presentation.container.ParticipantContainer;
import java.beans.PropertyChangeEvent;

/**
 *
 * @author Douneg
 */
public class ParticipantTable extends AbstractTable {

    private ParticipantAction participantAction;

    public ParticipantTable(ParticipantAction participantAction) {
        init();
        this.participantAction = participantAction;
        // connect data source
        setContainerDataSource(this.participantAction.getPrincipalContainer());
        participantAction.addPropertyChangeListener(this);
        // set column headers
        setColumnHeaders(ParticipantContainer.COL_HEADERS_FRENCH);
        setVisibleColumns(ParticipantContainer.NATURAL_COL_ORDER);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(ParticipantAction.PROP_PRINCIPALCONTAINER)) {
            setContainerDataSource(participantAction.getPrincipalContainer());
        }
    }
}
