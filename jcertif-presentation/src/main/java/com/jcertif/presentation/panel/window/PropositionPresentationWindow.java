/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel.window;

import com.jcertif.presentation.action.PropositionPresentationAction;
import com.jcertif.presentation.data.bo.presentation.PropositionPresentation;
import com.jcertif.presentation.panel.form.PropositionPresentationForm;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 *
 * @author Douneg
 */
public class PropositionPresentationWindow extends Window {

    public PropositionPresentationWindow(String caption, PropositionPresentationAction propositionPresentationAction) {
        PropositionPresentationForm propositionPresentationForm;

        /*
         * Make the window modal, which will disable all other components while
         * it is visible
         */
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        setContent(layout);
        setModal(true);
        setScrollable(true);
        /* Make the sub window 50% the size of the browser window */
        setWidth("50%");
        /*
         * Center the window both horizontally and vertically in the browser
         * window
         */
        center();
        setCaption(caption);
        propositionPresentationForm = new PropositionPresentationForm(propositionPresentationAction);
        propositionPresentationForm.addInitialFooter();
        propositionPresentationForm.setBOForEdit(new PropositionPresentation(), true);
        layout.addComponent(propositionPresentationForm);

    }
}
