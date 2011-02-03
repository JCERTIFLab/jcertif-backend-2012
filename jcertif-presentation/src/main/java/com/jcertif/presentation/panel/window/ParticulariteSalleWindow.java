/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel.window;

import com.jcertif.presentation.action.ParticulariteSalleAction;
import com.jcertif.presentation.data.bo.salle.ParticulariteSalle;
import com.jcertif.presentation.panel.form.ParticulariteSalleForm;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 *
 * @author Douneg
 */
public class ParticulariteSalleWindow extends Window {

    public ParticulariteSalleWindow(String caption, ParticulariteSalleAction particulariteSalleAction) {
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
        ParticulariteSalleForm particulariteSalleForm = new ParticulariteSalleForm(particulariteSalleAction);
        particulariteSalleForm.setBOForEdit(new ParticulariteSalle(), true);
        layout.addComponent(particulariteSalleForm);
    }
}
