/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel;

import com.jcertif.presentation.action.ParticipantAction;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Douneg
 */
public class FAQPanel extends MasterDetailsPanel<ParticipantAction> implements Button.ClickListener, Property.ValueChangeListener {

 
 
    public FAQPanel() {
        super(null);
        VerticalLayout verticalLayout=(VerticalLayout) getContent();
      

    }

    @Override
    public void buttonClick(ClickEvent event) {

    }

    @Override
    public void valueChange(ValueChangeEvent event) {

    }
}
