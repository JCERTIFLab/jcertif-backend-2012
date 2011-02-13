/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel;

import com.jcertif.presentation.action.PropositionPresentationAction;
import com.jcertif.presentation.data.bo.presentation.PropositionPresentation;
import com.jcertif.presentation.panel.form.PropositionPresentationForm;
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
public class CreationPropositionPresentationPanel extends MasterDetailsPanel<PropositionPresentationAction> implements Button.ClickListener, Property.ValueChangeListener {

    private PropositionPresentationForm propositionPresentationForm;
    private Button validate = new Button("Valider", this);

    public CreationPropositionPresentationPanel(PropositionPresentationAction propositionPresentationAction) {
        super(propositionPresentationAction);
        VerticalLayout verticalLayout = (VerticalLayout) getContent();
        propositionPresentationForm = new PropositionPresentationForm(propositionPresentationAction);
        propositionPresentationForm.setBOForEdit(new PropositionPresentation(), true);
        HorizontalLayout footer = new HorizontalLayout();
        footer.setSpacing(true);
        footer.addComponent(validate);
        footer.setVisible(true);
        Panel all = buildPanel(null, propositionPresentationForm);
        verticalLayout.setWidth("100%");
        verticalLayout.addComponent(all);
        verticalLayout.setExpandRatio(all, 1);
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
        }
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        Property property = event.getProperty();
        if (property == propositionPresentationForm) {
            PropositionPresentation propositionPresentation = (PropositionPresentation) propositionPresentationForm.getValue();

        }
    }
}
