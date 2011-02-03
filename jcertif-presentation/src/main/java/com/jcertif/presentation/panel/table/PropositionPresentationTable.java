/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel.table;

import com.jcertif.presentation.action.PropositionPresentationAction;
import com.jcertif.presentation.container.PropositionPresentationContainer;
import java.beans.PropertyChangeEvent;

/**
 *
 * @author Douneg
 */
public class PropositionPresentationTable extends AbstractTable {

    private PropositionPresentationAction propositionPresentationAction;

    public PropositionPresentationTable(PropositionPresentationAction propositionPresentationAction) {
        init();
        this.propositionPresentationAction = propositionPresentationAction;
        // connect data source
        setContainerDataSource(this.propositionPresentationAction.getPrincipalContainer());
        propositionPresentationAction.addPropertyChangeListener(this);
        // set column headers
        setVisibleColumns(PropositionPresentationContainer.NATURAL_COL_ORDER);
        setColumnHeaders(PropositionPresentationContainer.COL_HEADERS_FRENCH);
        
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(PropositionPresentationAction.PROP_PRINCIPALCONTAINER)) {
            setContainerDataSource(propositionPresentationAction.getPrincipalContainer());
        }
    }
}
