/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel;

import com.vaadin.ui.Table;
import java.beans.PropertyChangeListener;

/**
 *
 * @author UNHCRUser
 */
public abstract class AbstractTable extends Table implements PropertyChangeListener {

    public AbstractTable() {
    }

    public void init() {
        // selectable
        setSelectable(true);
        setMultiSelect(true);
        setImmediate(true); // react at once when something is selected
        // turn on column reordering and collapsing
        setColumnReorderingAllowed(true);
        setColumnCollapsingAllowed(true);
    }
}
