/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel.window;

import com.jcertif.presentation.action.RoleParticipantAction;
import com.jcertif.presentation.data.bo.participant.RoleParticipant;
import com.jcertif.presentation.panel.form.RoleParticipantForm;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 *
 * @author UNHCRUser
 */
public class RoleParticipantWindow extends Window {

    public RoleParticipantWindow(String caption,RoleParticipantAction roleParticipantAction) {
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
        RoleParticipantForm roleParticipantForm = new RoleParticipantForm(roleParticipantAction);
        roleParticipantForm.setBOForEdit(new RoleParticipant(), true);
        layout.addComponent(roleParticipantForm);
    }
}
