/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel.window;

import com.jcertif.presentation.action.TypeParticipantAction;
import com.jcertif.presentation.data.bo.participant.TypeParticipant;
import com.jcertif.presentation.panel.form.TypeParticipantForm;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 *
 * @author Douneg
 */
public class TypeParticipantWindow extends Window {

    public TypeParticipantWindow(String caption, TypeParticipantAction typeParticipantAction) {
        /*
         * Make the window modal, which will disable all other components while
         * it is visible
         */
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        setContent(layout);
        setModal(true);
        /* Make the sub window 40% the size of the browser window */
        setWidth("40%");
        /*
         * Center the window both horizontally and vertically in the browser
         * window
         */
        center();
        setCaption(caption);
        setScrollable(true);
        TypeParticipantForm typeParticipantForm = new TypeParticipantForm(new TypeParticipantAction());
        typeParticipantForm.setBOForEdit(new TypeParticipant(), true);
        layout.addComponent(typeParticipantForm);
    }
}
