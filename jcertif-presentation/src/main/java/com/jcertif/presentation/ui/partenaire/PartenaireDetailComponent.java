package com.jcertif.presentation.ui.partenaire;

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
public class PartenaireDetailComponent extends Panel {

	private static final long serialVersionUID = 1L;

	/**
	 * A Logger for class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PartenaireDetailComponent.class);


	/**
	 * A constructor.
	 * 
	 * @param event
	 *            a event
	 */
	public PartenaireDetailComponent() {
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
			LOGGER.debug("Updating Detail Panel with Participant");
		}
//		this.removeAllComponents();

		for (Participant participant : getPartnersListsList()) {

			CustomLayout htmlLayout = new CustomLayout(UIConst.CALENDAR_DETAIL_LAYOUT);
			htmlLayout.addStyleName("details_event_layout");
	
			// Use it as the layout of the Panel.
			this.setContent(htmlLayout);
	
	
			// Sujet
			htmlLayout.addComponent(new Label("Presentateurs"));
	
			// Lastname + firstname
			htmlLayout.addComponent(new Label(participant.getNom() + " " + participant.getPrenom()),
					"presentateur");
	
			// Participant photo
			if (participant.getProfilUtilisateur() != null
					&& participant.getProfilUtilisateur().getPhoto() != null) {
				ExternalResource res = new ExternalResource(getFacadeURL() + UIConst.URL_PARTNER_IMG
						+ participant.getProfilUtilisateur().getPhoto());
				Embedded embedded = new Embedded("", res);
				htmlLayout.addComponent(embedded, "photo");
			}
			// Participant Bio
			htmlLayout.addComponent(new Label(participant.getDetails()), "details");			
		}

	}

	public static String getFacadeURL() {
		ResourceBundle bundle = ResourceBundle.getBundle(UIConst.WEBAPP_PROPERTIES_FILE);
		return bundle.getString(UIConst.FACADE_URL_PROP);
	}
	
//	Set<Evenement> boEvents = new HashSet<Evenement>(EvenementClient.getInstance()
//			.findAllXML());

	// Récupération des partenaires
	private List<Participant> getPartnersListsList() {
		List<Participant> partnersList = new ArrayList<Participant>(); 
		Set<Participant> participants = new HashSet<Participant>(ParticipantClient.getInstance().findAllXML());

		for (Participant participant : participants) {
			if (participant.getRoleparticipant() != null && "Partenaire".equalsIgnoreCase(participant.getRoleparticipant().getCode()) ) {
				partnersList.add(participant);
			}
		}
		return partnersList;
	}


}
