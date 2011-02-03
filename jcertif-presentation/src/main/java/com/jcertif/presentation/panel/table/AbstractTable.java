/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel.table;

import com.vaadin.ui.Table;
import com.vaadin.ui.themes.Runo;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Douneg
 */
public abstract class AbstractTable extends Table implements PropertyChangeListener {

    public AbstractTable() {
    }

    public void init() {
        // selectable
        setSelectable(true);
        setMultiSelect(false);
        setImmediate(true); // react at once when something is selected
        // turn on column reordering and collapsing
        setSizeFull();
        setStyleName(Runo.TABLE_SMALL);
        setColumnReorderingAllowed(true);
        setColumnCollapsingAllowed(true);
    }
}
