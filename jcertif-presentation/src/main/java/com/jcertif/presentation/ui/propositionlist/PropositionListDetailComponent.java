package com.jcertif.presentation.ui.propositionlist;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.data.bo.presentation.PropositionPresentation;
import com.jcertif.presentation.internationalisation.Msg;
import com.jcertif.presentation.ui.util.JCertifProps;
import com.jcertif.presentation.ui.util.UIConst;
import com.jcertif.presentation.ui.util.UIStyle;
import com.jcertif.presentation.wsClient.PropositionPresentationClient;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.PopupView.PopupVisibilityEvent;
import com.vaadin.ui.VerticalLayout;

/**
 * @author rossi.oddet
 * 
 */
public class PropositionListDetailComponent extends Panel {

	private static final long serialVersionUID = 1L;
	private boolean isFirsTime = true;

	/**
	 * A Logger for class.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PropositionListDetailComponent.class);

	/**
	 * A constructor.
	 * 
	 * @param event
	 *            a event
	 */
	public PropositionListDetailComponent() {
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
			LOGGER.debug("Updating Detail Panel with Presentateur");
		}

		List<PropositionPresentation> participantList = PropositionPresentationClient
				.getInstance().findAllXML();

		for (PropositionPresentation proposition : participantList) {

			if (proposition.getStatutApprobation() != null
					&& ("C".equalsIgnoreCase(proposition.getStatutApprobation()
							.getCodeStatut()) || "A"
							.equalsIgnoreCase(proposition
									.getStatutApprobation().getCodeStatut()))) {

				CustomLayout htmlLayout = new CustomLayout(
						UIConst.COMMUN_DETAIL_LAYOUT);
				htmlLayout.addStyleName("details_commun_layout");

				// Entete
				if (isFirsTime) {
					htmlLayout.addComponent(
							new Label(Msg.get("ui.propositionlist.title")),
							"caption");
					htmlLayout
							.addComponent(
									new Label(
											Msg.get("ui.propositionlist.description")),
									"captionDetail");
				}

				Label nameLabel = new Label(proposition.getTitre() + " ("
						+ proposition.getStatutApprobation().getDescription()
						+ ")", Label.CONTENT_XHTML);
				htmlLayout.addComponent(nameLabel, "presentateur");

				// TODO gérer le cas de plusieurs participant, pour le moment on
				// prend le premier
				Participant participant = proposition.getParticipants()
						.iterator().next();
				if (participant.getProfilUtilisateur() != null
						&& participant.getProfilUtilisateur().getPhoto() != null) {
					ExternalResource res = new ExternalResource(JCertifProps
							.getInstance().getPicsUrl()
							+ UIConst.URL_SPEAKER_IMG
							+ participant.getProfilUtilisateur().getPhoto());
					Embedded embedded = new Embedded("", res);
					embedded.setStyleName(UIStyle.PHOTO_SPEAKER);
					htmlLayout.addComponent(embedded, "photo");
				}

				// Participant Bio
				htmlLayout.addComponent(
						new Label(proposition.getDescription()), "details");

				// Affichage des présentations associees au participant
				createPopup(htmlLayout, proposition.getParticipants());

				// Use it as the layout of the Panel.
				this.addComponent(htmlLayout);
				isFirsTime = false;
			}
		}

	}

	private void createPopup(CustomLayout htmlLayout,
			Set<Participant> participants) {

		int idx = 1;
		for (Participant participant : participants) {
			String prenomNom = participant.getPrenom() + " "
					+ participant.getNom();
			Label content = new Label("<h2>" + prenomNom + "</h2>" + "<p>"
					+ participant.getDetails() + "</p>");
			content.setContentMode(Label.CONTENT_XHTML);

			// The PopupView popup will be as large as needed by the content
			content.setWidth("400px");

			// Construct the PopupView with simple HTML text representing
			// the
			// minimized view
			PopupView popup = new PopupView(prenomNom, content);
			popup.setHideOnMouseOut(true);
			// popup.addListener((PopupVisibilityListener) htmlLayout);
			htmlLayout.addComponent(popup, "papersList" + idx++);
		}

	}
}

@SuppressWarnings("serial")
class PopupViewClosingExample extends VerticalLayout implements
		PopupView.PopupVisibilityListener {

	public PopupViewClosingExample() {

		setSpacing(true);

		// Create the content for the popup
		Label content = new Label(
				"This popup will close as soon as you move the mouse cursor outside of the popup area.");
		// The PopupView popup will be as large as needed by the content
		content.setWidth("300px");

		// Construct the PopupView with simple HTML text representing the
		// minimized view
		PopupView popup = new PopupView("Default popup", content);
		popup.setHideOnMouseOut(true);
		popup.addListener(this);
		addComponent(popup);

		content = new Label(
				"This popup will only close if you click the mouse outside the popup area.");
		// The PopupView popup will be as large as needed by the content
		content.setWidth("300px");

		popup = new PopupView("Popup that won't auto-close", content);
		popup.setHideOnMouseOut(false);
		popup.addListener(this);
		addComponent(popup);
	}

	public void popupVisibilityChange(PopupVisibilityEvent event) {
		if (!event.isPopupVisible()) {
			getWindow().showNotification("Popup closed");
		}
	}
}
