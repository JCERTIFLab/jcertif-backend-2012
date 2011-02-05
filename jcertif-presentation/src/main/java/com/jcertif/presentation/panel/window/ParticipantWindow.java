/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel.window;

import com.jcertif.presentation.action.ParticipantAction;
import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.panel.form.ParticipantForm;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 *
 * @author Douneg
 */
public class ParticipantWindow extends Window {

    public ParticipantWindow(String caption, ParticipantAction participantAction) {
        /*
         * Make the window modal, which will disable all other components while
         * it is visible
         */
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        setContent(layout);
        setModal(true);
        /* Make the sub window 70% the size of the browser window */
        setWidth("70%");
        /*
         * Center the window both horizontally and vertically in the browser
         * window
         */
        center();
        setCaption(caption);
        setScrollable(true);
        ParticipantForm participantForm = new ParticipantForm(participantAction);
        HorizontalLayout footer = participantForm.getInitialFooter();
        participantForm.setBOForEdit(new Participant(), true);
        layout.addComponent(participantForm);
        layout.addComponent(footer);
        layout.setComponentAlignment(footer, Alignment.MIDDLE_RIGHT);
    }
}
