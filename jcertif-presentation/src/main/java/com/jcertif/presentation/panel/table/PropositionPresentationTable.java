/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel.table;

import com.jcertif.presentation.action.PropositionPresentationAction;
import com.jcertif.presentation.container.PropositionPresentationContainer;

/**
 *
 * @author Douneg
 */
public class PropositionPresentationTable extends AbstractTable<PropositionPresentationAction, PropositionPresentationContainer> {

    public PropositionPresentationTable(PropositionPresentationAction propositionPresentationAction) {
        super(propositionPresentationAction);
        // set column headers
        setVisibleColumns(PropositionPresentationContainer.NATURAL_COL_ORDER);
        setColumnHeaders(PropositionPresentationContainer.COL_HEADERS_FRENCH);

    }
}
