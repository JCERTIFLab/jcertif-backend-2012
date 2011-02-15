/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel.window;

import com.jcertif.presentation.action.AuteurAction;
import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.data.bo.presentation.Auteur;
import com.jcertif.presentation.panel.form.AuteurForm;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 *
 * @author Douneg
 */
public class AuteurWindow extends Window {

    public AuteurWindow(String caption, AuteurAction auteurAction) {
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
        AuteurForm auteurForm = new AuteurForm(auteurAction);
        HorizontalLayout footer = auteurForm.getInitialFooter();
        auteurForm.setBOForEdit(new Auteur(), true);
        layout.addComponent(auteurForm);
        layout.addComponent(footer);
        layout.setComponentAlignment(footer, Alignment.MIDDLE_RIGHT);
    }
}
