package com.jcertif.presentation.ui.partenaire;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.internationalisation.Msg;
import com.jcertif.presentation.ui.util.JCertifProps;
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
public class PartenaireDetailComponent extends Panel {

	private static final long serialVersionUID = 1L;
	private boolean isFirsTime = true;

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
		this.addStyleName("commun_details_panel");
	}

	/**
	 * Update de details.
	 * 
	 * @param event
	 *            a event
	 */
	public void update() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Updating Detail Panel with Partenaire");
		}
		// this.removeAllComponents();

		for (Participant participant : getPartnersListsList()) {

			CustomLayout htmlLayout = new CustomLayout(UIConst.COMMUN_DETAIL_LAYOUT);
			htmlLayout.addStyleName("details_commun_layout");

			// Entete
			if (isFirsTime) {
				htmlLayout.addComponent(new Label(Msg.get("ui.partenaire.title")), "caption");
				htmlLayout.addComponent(new Label(Msg.get("ui.partenaire.description")),
						"captionDetail");
			}

			// Lastname + firstname
			htmlLayout
					.addComponent(new Label(participant.getNom() + " " + participant.getPrenom()),
							"presentateur");

			// Participant photo
			if (participant.getProfilUtilisateur() != null
					&& participant.getProfilUtilisateur().getPhoto() != null) {
				ExternalResource res = new ExternalResource(JCertifProps.getInstance().getPicsUrl()
						+ UIConst.URL_PARTNER_IMG + participant.getProfilUtilisateur().getPhoto());
				Embedded embedded = new Embedded("", res);
				embedded.setStyleName(UIStyle.PHOTO_PARTENAIRE);
				htmlLayout.addComponent(embedded, "photo");
			}
			// Participant Bio
			htmlLayout.addComponent(new Label(participant.getDetails()), "details");

			// Use it as the layout of the Panel.
			this.addComponent(htmlLayout);
			isFirsTime = false;
		}

	}

	// Récupération des partenaires
	private List<Participant> getPartnersListsList() {
		List<Participant> partnersList = new ArrayList<Participant>();
		Set<Participant> participants = new HashSet<Participant>(ParticipantClient.getInstance()
				.findAllXML());

		for (Participant participant : participants) {
			if (participant.getRoleparticipant() != null
					&& "Partenaire".equalsIgnoreCase(participant.getRoleparticipant().getCode())) {
				partnersList.add(participant);
			}
		}
		return partnersList;
	}

}
