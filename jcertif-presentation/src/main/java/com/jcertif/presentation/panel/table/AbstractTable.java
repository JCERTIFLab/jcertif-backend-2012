/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel.table;

import com.jcertif.presentation.action.AbstractAction;
import com.jcertif.presentation.container.AbstractJCertifBeanItemContainer;
import com.vaadin.ui.Table;
import com.vaadin.ui.themes.Runo;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Douneg
 */
public abstract class AbstractTable<A extends AbstractAction, PC extends AbstractJCertifBeanItemContainer> extends Table {

    private A action;

    public final A getAction() {
        return action;
    }

    public AbstractTable(A a) {
        this.action = a;
        setContainerDataSource(this.getAction().getPrincipalContainer());
        getAction().addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals(AbstractAction.PROP_PRINCIPALCONTAINER)) {
                    setContainerDataSource(getAction().getPrincipalContainer());
                }
            }
        });
        init();
    }

    public final void init() {
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
