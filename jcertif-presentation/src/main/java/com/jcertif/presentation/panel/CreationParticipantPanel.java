/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel;

import com.jcertif.presentation.action.ParticipantAction;
import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.panel.form.ParticipantForm;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Panel;

/**
 *
 * @author Douneg
 */
public class CreationParticipantPanel extends MasterDetailsPanel<ParticipantAction> implements Button.ClickListener, Property.ValueChangeListener {

    private ParticipantForm participantForm;

    public CreationParticipantPanel(ParticipantAction participantAction) {
        super(participantAction);
        participantForm = new ParticipantForm(participantAction);
        participantForm.setBOForEdit(new Participant(), true);
        participantForm.addInitialFooter();
        Panel all = buildPanel("Creation d'un participant", participantForm);
        getContent().addComponent(all);
    }

    @Override
    public void buttonClick(ClickEvent event) {
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        Property property = event.getProperty();
        if (property == participantForm) {
            Participant participant = (Participant) participantForm.getValue();

        }
    }
}
