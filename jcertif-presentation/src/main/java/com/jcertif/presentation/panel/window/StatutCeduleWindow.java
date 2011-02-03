/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel.window;

import com.jcertif.presentation.action.StatutCeduleAction;
import com.jcertif.presentation.data.bo.cedule.StatutCedule;
import com.jcertif.presentation.panel.form.StatutCeduleForm;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 *
 * @author Douneg
 */
public class StatutCeduleWindow extends Window {

    public StatutCeduleWindow(String caption, StatutCeduleAction statutCeduleAction) {
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
        StatutCeduleForm statutCeduleForm = new StatutCeduleForm(statutCeduleAction);
        statutCeduleForm.setBOForEdit(new StatutCedule(), true);
        layout.addComponent(statutCeduleForm);
    }
}
