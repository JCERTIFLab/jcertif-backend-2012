/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel;

import com.jcertif.presentation.action.AuteurAction;
import com.jcertif.presentation.data.bo.presentation.Auteur;
import com.jcertif.presentation.panel.table.AuteurTable;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Douneg
 */
public class AuteursPanel extends MasterDetailsPanel<AuteurAction> implements Button.ClickListener, Property.ValueChangeListener {

    private AuteurTable auteurTable;

    public AuteursPanel(AuteurAction auteurAction) {
        super(auteurAction);
        VerticalLayout verticalLayout = (VerticalLayout) getContent();
        auteurTable = new AuteurTable(auteurAction);

        Panel all = buildPanel(null, auteurTable);
        verticalLayout.addComponent(all);

    }

    @Override
    public void buttonClick(ClickEvent event) {
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        Property property = event.getProperty();
        if (property == auteurTable) {
            Auteur auteur = (Auteur) auteurTable.getValue();

        }
    }
}
