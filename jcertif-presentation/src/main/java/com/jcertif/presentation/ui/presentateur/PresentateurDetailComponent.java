package com.jcertif.presentation.ui.presentateur;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.data.bo.presentation.PropositionPresentation;
import com.jcertif.presentation.ui.util.UIConst;
import com.jcertif.presentation.wsClient.ParticipantClient;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

/**
 * Presentateur details Panel.
 * 
 * @author Max
 * 
 */
public class PresentateurDetailComponent extends Panel {

	private static final long serialVersionUID = 1L;

	/**
	 * A Logger for class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PresentateurDetailComponent.class);

	/**
	 * A constructor.
	 * 
	 * @param event
	 *            a event
	 */
	public PresentateurDetailComponent() {
		super();
		update();
		this.addStyleName("event_details_panel");
	}

	/**
	 * Update de details.
	 * 
	 * @param event
	 *            a event
	 */
	public void update() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Updating Detail Panel with Presentateur");
		}
		// this.removeAllComponents();

		for (Participant participant : getPresentateursList()) {

			CustomLayout htmlLayout = new CustomLayout(UIConst.CALENDAR_DETAIL_LAYOUT);
			htmlLayout.addStyleName("details_event_layout");

			// Sujet
			htmlLayout.addComponent(new Label("Presentateurs"));

			// Lastname + firstname
			htmlLayout
					.addComponent(new Label(participant.getNom() + " " + participant.getPrenom()),
							"presentateur");

			// Participant photo
			if (participant.getProfilUtilisateur() != null
					&& participant.getProfilUtilisateur().getPhoto() != null) {
				ExternalResource res = new ExternalResource(getFacadeURL()
						+ UIConst.URL_SPEAKER_IMG + participant.getProfilUtilisateur().getPhoto());
				Embedded embedded = new Embedded("", res);
				htmlLayout.addComponent(embedded, "photo");
			}

			// Participant Bio
			htmlLayout.addComponent(new Label(participant.getDetails()), "details");

			// Proposition de présentation
			htmlLayout.addComponent(new Label("Présentations"));

			if (participant.getPropositionPresentations() != null) {
				for (PropositionPresentation propositionPresentation : participant
						.getPropositionPresentations()) {
					// Presentation title
					htmlLayout.addComponent(new Label(propositionPresentation.getTitre()), "titre");
				}
			}

			// Use it as the layout of the Panel.
			this.addComponent(htmlLayout);

		}

	}

	public static String getFacadeURL() {
		ResourceBundle bundle = ResourceBundle.getBundle(UIConst.WEBAPP_PROPERTIES_FILE);
		return bundle.getString(UIConst.FACADE_URL_PROP);
	}

	// Set<Evenement> boEvents = new
	// HashSet<Evenement>(EvenementClient.getInstance()
	// .findAllXML());

	private List<Participant> getPresentateursList() {
		List<Participant> presentateursList = new ArrayList<Participant>();
		Set<Participant> participants = new HashSet<Participant>(ParticipantClient.getInstance()
				.findAllXML());

		for (Participant participant : participants) {
			if (participant.getRoleparticipant() != null
					&& "Speaker".equalsIgnoreCase(participant.getRoleparticipant().getCode())) {
				presentateursList.add(participant);
			}
		}
		return presentateursList;
	}

}
