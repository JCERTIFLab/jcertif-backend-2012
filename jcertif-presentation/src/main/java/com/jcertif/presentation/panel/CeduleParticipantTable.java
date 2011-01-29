/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel;

import com.jcertif.presentation.action.CeduleParticipantAction;
import com.jcertif.presentation.container.CeduleParticipantContainer;
import java.beans.PropertyChangeEvent;

/**
 *
 * @author Douneg
 */
public class CeduleParticipantTable extends AbstractTable {

    private CeduleParticipantAction ceduleParticipantAction;

    public CeduleParticipantTable(CeduleParticipantAction ceduleParticipantAction) {
        init();
        this.ceduleParticipantAction = ceduleParticipantAction;
        // connect data source
        setContainerDataSource(this.ceduleParticipantAction.getPrincipalContainer());
        ceduleParticipantAction.addPropertyChangeListener(this);
        // set column headers
        setColumnHeaders(CeduleParticipantContainer.COL_HEADERS_FRENCH);
        setVisibleColumns(CeduleParticipantContainer.NATURAL_COL_ORDER);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(CeduleParticipantAction.PROP_PRINCIPALCONTAINER)) {
            setContainerDataSource(ceduleParticipantAction.getPrincipalContainer());
        }
    }
}
