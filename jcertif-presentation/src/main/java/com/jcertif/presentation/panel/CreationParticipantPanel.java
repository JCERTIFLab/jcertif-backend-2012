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
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Douneg
 */
public class CreationParticipantPanel extends MasterDetailsPanel<ParticipantAction> implements Button.ClickListener, Property.ValueChangeListener {

    private ParticipantForm participantForm;
    private Button validate = new Button("Valider", this);

    public CreationParticipantPanel(ParticipantAction participantAction) {
        super(participantAction);
        VerticalLayout verticalLayout = (VerticalLayout) getContent();
        participantForm = new ParticipantForm(participantAction);
        participantForm.setBOForEdit(new Participant(), true);
        HorizontalLayout footer = new HorizontalLayout();
        footer.setSpacing(true);

        footer.addComponent(validate);
        footer.setVisible(true);
        Panel all = buildPanel(null, participantForm);
        verticalLayout.setWidth("100%");
        verticalLayout.addComponent(all);
        verticalLayout.setExpandRatio(all, 1);
        verticalLayout.addComponent(footer);
        verticalLayout.setComponentAlignment(footer, Alignment.BOTTOM_CENTER);
    }

    @Override
    public void buttonClick(ClickEvent event) {
        if (event.getButton() == validate) {
            if (participantForm.isValid()) {
                participantForm.commit();
                getAction().addItem(participantForm.getBeanItem().getBean());
            } else {
                participantForm.validate();
            }
        }
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        Property property = event.getProperty();
        if (property == participantForm) {
            Participant participant = (Participant) participantForm.getValue();

        }
    }
}
