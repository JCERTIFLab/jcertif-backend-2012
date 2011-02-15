/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel;

import com.jcertif.presentation.action.AuteurAction;
import com.jcertif.presentation.action.PropositionPresentationAction;
import com.jcertif.presentation.data.bo.presentation.Auteur;
import com.jcertif.presentation.data.bo.presentation.PropositionPresentation;
import com.jcertif.presentation.panel.form.AuteurForm;
import com.jcertif.presentation.panel.form.PropositionPresentationForm;
import com.jcertif.presentation.panel.table.AuteurTable;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Douneg
 */
public class CreationPropositionPresentationPanel extends MasterDetailsPanel<PropositionPresentationAction> implements Button.ClickListener, Property.ValueChangeListener {

    private PropositionPresentationForm propositionPresentationForm;
    private AuteurAction auteurAction = new AuteurAction();
    private AuteurForm auteurForm = new AuteurForm(auteurAction);
    private AuteurTable auteurTable = new AuteurTable(auteurAction);
    private Button validate = new Button("Valider", this);
    private Button ajouterAuteur = new Button("+ Ajouter un nouvrel auteur", this);
    private Button ajouterAuteurParCode = new Button("+ Ajouter un auteur par son code", this);

    public CreationPropositionPresentationPanel(PropositionPresentationAction propositionPresentationAction) {
        super(propositionPresentationAction);
        VerticalLayout verticalLayout = (VerticalLayout) getContent();
        propositionPresentationForm = new PropositionPresentationForm(propositionPresentationAction);
        propositionPresentationForm.setBOForEdit(new PropositionPresentation(), true);
        HorizontalLayout footer = new HorizontalLayout();
        footer.setSpacing(true);
        auteurTable.setPageLength(5);
        footer.addComponent(validate);
        footer.setVisible(true);
        Set<Button> mainButtons = new HashSet<Button>();
        mainButtons.add(ajouterAuteur);
        mainButtons.add(ajouterAuteurParCode);
        Layout buttonLayout = buildButtonPanel(mainButtons);
        verticalLayout.setSpacing(true);
        verticalLayout.addComponent(buttonLayout);
        verticalLayout.setComponentAlignment(buttonLayout, Alignment.TOP_RIGHT);
        verticalLayout.addComponent(propositionPresentationForm);
        verticalLayout.addComponent(auteurTable);
        verticalLayout.setExpandRatio(propositionPresentationForm, 1);
        verticalLayout.addComponent(footer);
        verticalLayout.setComponentAlignment(footer, Alignment.BOTTOM_CENTER);
    }

    @Override
    public void buttonClick(ClickEvent event) {
        if (event.getButton() == validate) {
            if (propositionPresentationForm.isValid()) {
                propositionPresentationForm.commit();
                getAction().addItem(propositionPresentationForm.getBeanItem().getBean());
            } else {
                propositionPresentationForm.validate();
            }
        } else if (event.getButton() == ajouterAuteur) {
            AuteurWindow auteurWindow = new AuteurWindow("Nouvel Auteur", auteurAction);
            auteurWindow.addNewBO();
            getApplication().getMainWindow().addWindow(auteurWindow);
        } else if (event.getButton() == ajouterAuteurParCode) {
        }
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        Property property = event.getProperty();
        if (property == propositionPresentationForm) {
            PropositionPresentation propositionPresentation = (PropositionPresentation) propositionPresentationForm.getValue();

        }
    }

    private class AuteurWindow extends Window implements Button.ClickListener {

        VerticalLayout layout;

        public AuteurWindow(String caption, AuteurAction auteurAction) {
            /*
             * Make the window modal, which will disable all other components while
             * it is visible
             */
            layout = new VerticalLayout();
            layout.setSizeFull();
            setContent(layout);

            setModal(true);
            /* Make the sub window 70% the size of the browser window */
            setWidth("75%");
            /*
             * Center the window both horizontally and vertically in the browser
             * window
             */
            center();
            setCaption(caption);
            // setScrollable(true);
            HorizontalLayout footer = auteurForm.getInitialFooter();
            layout.addComponent(auteurForm);
            layout.addComponent(footer);
            layout.setComponentAlignment(footer, Alignment.MIDDLE_RIGHT);

        }

        public void addNewBO() {
            auteurForm.setBOForEdit(new Auteur(), true);
        }

        public void editBO(Auteur auteur) {
            auteurForm.setBOForEdit(auteur, false);
        }

        @Override
        public void buttonClick(ClickEvent event) {
            Button source = event.getButton();
            if (source == auteurForm.getSaveButton()) {
                /* If the given input is not valid there is no point in continuing */
                if (!auteurForm.isValid()) {
                    auteurForm.commit();
                    return;
                }
                auteurForm.commit();
                if (auteurForm.isNewContactMode()) {
                    auteurAction.addItem(auteurForm.getAbstractBO());
                } else {
                }

            } else if (source == auteurForm.getCancelButton()) {
                if (auteurForm.isNewContactMode()) {
                    auteurForm.setNewContactMode(false);
                    /* Clear the form and make it invisible */
                    auteurForm.setItemDataSource(null);
                } else {
                    auteurForm.discard();
                }
                auteurForm.setReadOnly(true);
                getApplication().getMainWindow().removeWindow(this);
            } else if (source == auteurForm.getEditButton()) {
                auteurForm.setReadOnly(false);
            } else if (source == auteurForm.getCloseButton()) {
                getApplication().getMainWindow().removeWindow(this);
            }
        }
    }
}
