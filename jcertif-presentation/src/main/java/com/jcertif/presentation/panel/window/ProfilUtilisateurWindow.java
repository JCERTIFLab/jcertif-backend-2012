/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel.window;

import com.jcertif.presentation.action.ProfilUtilisateurAction;
import com.jcertif.presentation.data.bo.participant.ProfilUtilisateur;
import com.jcertif.presentation.panel.form.ProfilUtilisateurtForm;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 *
 * @author Douneg
 */
public class ProfilUtilisateurWindow extends Window {

    public ProfilUtilisateurWindow(String caption, ProfilUtilisateurAction profilUtilisateurAction) {
        ProfilUtilisateurtForm profilUtilisateurtForm;
        /*
         * Make the window modal, which will disable all other components while
         * it is visible
         */
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        setContent(layout);
        setModal(true);
        /* Make the sub window 50% the size of the browser window */
        setWidth("50%");
        /*
         * Center the window both horizontally and vertically in the browser
         * window
         */
        setScrollable(true);
        center();
        setCaption(caption);
        profilUtilisateurtForm = new ProfilUtilisateurtForm(profilUtilisateurAction);
        profilUtilisateurtForm.addInitialFooter();
        profilUtilisateurtForm.setBOForEdit(new ProfilUtilisateur(), true);
        layout.addComponent(profilUtilisateurtForm);

    }
}
