package com.jcertif.presentation.ui.presentateur;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.data.bo.presentation.PropositionPresentation;
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
import com.vaadin.ui.PopupView;
import com.vaadin.ui.PopupView.PopupVisibilityEvent;
import com.vaadin.ui.VerticalLayout;

/**
 * Presentateur details Panel.
 * 
 * @author Max
 * 
 */
public class PresentateurDetailComponent extends Panel {

	private static final long serialVersionUID = 1L;
	private boolean isFirsTime = true;

	/**
	 * A Logger for class.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PresentateurDetailComponent.class);

	/**
	 * A constructor.
	 * 
	 * @param event
	 *            a event
	 */
	public PresentateurDetailComponent() {
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

		List<Participant> participantList = ParticipantClient.getInstance()
				.getSpeakersValid();
		for (Participant participant : participantList) {

			CustomLayout htmlLayout = new CustomLayout(
					UIConst.COMMUN_DETAIL_LAYOUT);
			htmlLayout.addStyleName("details_commun_layout");

			// Entete
			if (isFirsTime) {
				htmlLayout.addComponent(
						new Label(Msg.get("ui.presentateur.title")), "caption");
				htmlLayout.addComponent(
						new Label(Msg.get("ui.presentateur.description")),
						"captionDetail");
			}

			// Lastname + firstname
			Label nameLabel = new Label("<a name=\"" + participant.getId()
					+ "\"></a>" + participant.getPrenom() + " "
					+ participant.getNom(), Label.CONTENT_XHTML);
			htmlLayout.addComponent(nameLabel, "presentateur");

			// Participant photo
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
			htmlLayout.addComponent(new Label(participant.getDetails()),
					"details");

			// Affichage des présentations associees au participant
			createPopup(htmlLayout, participant);

			// Use it as the layout of the Panel.
			this.addComponent(htmlLayout);
			isFirsTime = false;

		}

	}

	private void createPopup(CustomLayout htmlLayout, Participant participant) {

		int idx = 1;

		if (participant.getPropositionPresentations() != null) {
			for (PropositionPresentation propositionPresentation : participant
					.getPropositionPresentations()) {

				Label content = new Label("<h2>"
						+ propositionPresentation.getTitre() + "</h2>" + "<p>"
						+ propositionPresentation.getDescription() + "</p>");
				content.setContentMode(Label.CONTENT_XHTML);

				// The PopupView popup will be as large as needed by the content
				content.setWidth("400px");

				// Construct the PopupView with simple HTML text representing
				// the
				// minimized view
				PopupView popup = new PopupView(
						propositionPresentation.getTitre(), content);
				popup.setHideOnMouseOut(true);
				// popup.addListener((PopupVisibilityListener) htmlLayout);
				htmlLayout.addComponent(popup, "papersList" + idx++);

			}
		}

		// Create the content for the popup

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
