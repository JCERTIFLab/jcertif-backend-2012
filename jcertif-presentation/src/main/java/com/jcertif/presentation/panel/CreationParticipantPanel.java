/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel;

import com.jcertif.presentation.action.ParticipantAction;
import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.panel.form.ParticipantForm;
import com.jcertif.presentation.principal.JCertifVaadinApplication;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * 
 * @author Douneg
 */
public class CreationParticipantPanel extends MasterDetailsPanel<ParticipantAction> implements
		Button.ClickListener, Property.ValueChangeListener {

	private ParticipantForm participantForm;
	private Button validate = new Button("Valider", this);

	public CreationParticipantPanel(ParticipantAction participantAction) {
		super(participantAction);
		VerticalLayout verticalLayout = (VerticalLayout) getContent();
		participantForm = new ParticipantForm(participantAction);
		participantForm.setBOForEdit(new Participant(), true);
		HorizontalLayout footer = new HorizontalLayout();
		footer.setSpacing(true);

		footer.addComponent(validate);
		footer.setVisible(true);
		Panel all = buildPanel(null, participantForm);
		verticalLayout.setWidth("100%");
		verticalLayout.addComponent(all);
		verticalLayout.setExpandRatio(all, 1);
		verticalLayout.addComponent(footer);
		verticalLayout.setComponentAlignment(footer, Alignment.BOTTOM_CENTER);
	}

	public CreationParticipantPanel(ParticipantAction participantAction, Participant participant) {
		super(participantAction);
		VerticalLayout verticalLayout = (VerticalLayout) getContent();
		participantForm = new ParticipantForm(participantAction);
		participantForm.setBOForEdit(participant, true);
		HorizontalLayout footer = new HorizontalLayout();
		footer.setSpacing(true);

		footer.addComponent(validate);
		footer.setVisible(true);
		Panel all = buildPanel(null, participantForm);
		verticalLayout.setWidth("100%");
		verticalLayout.addComponent(all);
		verticalLayout.setExpandRatio(all, 1);
		verticalLayout.addComponent(footer);
		verticalLayout.setComponentAlignment(footer, Alignment.BOTTOM_CENTER);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if (event.getButton() == validate) {
			if (participantForm.isValid()) {
				participantForm.commit();
				getAction().addItem(participantForm.getBeanItem().getBean());
				Window main = getApplication().getMainWindow();
				// Create a notification with default settings for a warning.
				Window.Notification notif = new Window.Notification(
						"L'enregistrement a bien été prise en compte. Vous allez être redirigé vers la page d'accueil.",
						Window.Notification.TYPE_HUMANIZED_MESSAGE);
				// Set the position.
				notif.setPosition(Window.Notification.POSITION_CENTERED_BOTTOM);

				// Let it stay there until the user clicks it
				notif.setDelayMsec(Window.Notification.DELAY_FOREVER);
				// Show it in the main window.
				main.showNotification(notif);
				
				ExternalResource res = new ExternalResource("home.jsp");
				main.open(res);
			} else {
				participantForm.validate();
			}
		}
	}

	@Override
	public void valueChange(ValueChangeEvent event) {
		Property property = event.getProperty();
		if (property == participantForm) {
			Participant participant = (Participant) participantForm.getValue();

		}
	}
}
