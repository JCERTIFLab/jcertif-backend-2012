/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel.table;

import com.jcertif.presentation.action.AuteurAction;
import com.jcertif.presentation.container.AuteurContainer;

/**
 *
 * @author Douneg
 */
public class AuteurTable extends AbstractTable<AuteurAction, AuteurContainer> {

    public AuteurTable(AuteurAction participantAction) {
        super(participantAction);
        // set column headers
        setVisibleColumns(AuteurContainer.SHORT_NATURAL_COL_ORDER);
        setColumnHeaders(AuteurContainer.SHORT_COL_HEADERS_FRENCH);

    }
}
