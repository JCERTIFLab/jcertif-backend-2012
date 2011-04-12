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
import com.jcertif.presentation.ui.util.UIStyle;
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
		// Sujet
		//this.setCaption("Presentateurs");

		for (Participant participant : getPresentateursList()) {

			CustomLayout htmlLayout = new CustomLayout(UIConst.CALENDAR_DETAIL_LAYOUT);
			htmlLayout.addStyleName("details_event_layout");


			// Lastname + firstname
			htmlLayout
					.addComponent(new Label(participant.getNom() + " " + participant.getPrenom()),
							"titre");

			// Participant photo
			if (participant.getProfilUtilisateur() != null
					&& participant.getProfilUtilisateur().getPhoto() != null) {
				ExternalResource res = new ExternalResource(getFacadeURL()
						+ UIConst.URL_SPEAKER_IMG + participant.getProfilUtilisateur().getPhoto());
				Embedded embedded = new Embedded("", res);
				embedded.setStyleName(UIStyle.PHOTO_SPEAKER);
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
					htmlLayout.addComponent(new Label(propositionPresentation.getTitre()), "presentateur");
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
			if ( isApeaker(participant)) {
				presentateursList.add(participant);
			}
		}
		return presentateursList;
	}
	
	// En plus du role Presentateur, un speaker doit avoir au moins une porposition de presentation approuvee en attente de complement
	private boolean isApeaker(Participant part) {
		if(part.getPropositionPresentations() != null && part.getRoleparticipant() != null && "Speaker".equalsIgnoreCase(part.getRoleparticipant().getCode())){
			for (PropositionPresentation popos : part.getPropositionPresentations()) {
				if (  "C".equalsIgnoreCase(popos.getStatutApprobation().getCodeStatut()) || "A".equalsIgnoreCase(popos.getStatutApprobation().getCodeStatut()) ) {
					return true;
				}
			}
		}
		return false;
	}

}
