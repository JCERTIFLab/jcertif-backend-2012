package com.jcertif.presentation.ui.calendar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.cedule.Evenement;
import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.data.bo.presentation.PropositionPresentation;
import com.jcertif.presentation.internationalisation.Messages;
import com.jcertif.presentation.ui.util.UIConst;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

/**
 * Calendar details Panel.
 * 
 * @author rossi
 * 
 */
public class CalendarDetailComponent extends Panel {

	private static final long serialVersionUID = 1L;

	/**
	 * A Logger for class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CalendarDetailComponent.class);

	/**
	 * Participate Button.
	 */
	private Button participateButton;

	/**
	 * Cancel Button.
	 */
	private Button cancelButton;

	/**
	 * A constructor.
	 */
	public CalendarDetailComponent() {
		super();
	}

	/**
	 * A constructor.
	 * 
	 * @param event
	 *            a event
	 */
	public CalendarDetailComponent(Evenement event) {
		super();
		update(event, true);
		this.addStyleName("event_details_panel");
	}

	/**
	 * Update de details.
	 * 
	 * @param event
	 *            a event
	 */
	public void update(final Evenement event, final boolean showButton) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Updating Detail Panel with event {} and showbutton={}",
					event.getNomEvenement(), showButton);
		}
		this.removeAllComponents();
		CustomLayout htmlLayout = new CustomLayout(UIConst.CALENDAR_DETAIL_LAYOUT);
		htmlLayout.addStyleName("details_event_layout");

		// Use it as the layout of the Panel.
		this.setContent(htmlLayout);

		// Room
		String room = event.getCeduleSalles().iterator().next().getSalle().getLibelle();
		htmlLayout.addComponent(
				new Label(Messages.getString("calendar.details.room") + " " + room), "ou");

		// When
		Date debut = event.getDateDebutPrevue().getTime();
		Date fin = event.getDateFinPrevue().getTime();
		htmlLayout.addComponent(new Label(buildFormattedWhen(debut, fin)), "quand");

		// Sujet
		htmlLayout.addComponent(new Label(findSujet(event)), "categorie");

		Set<Participant> participantSet = event.getPropositionPresentation().getParticipants();

		// TODO G�rer le cas de plusieurs participant
		Participant participant = participantSet.iterator().next();

		// Presentation title
		htmlLayout.addComponent(new Label(event.getPropositionPresentation().getTitre()), "titre");

		// Participate button
		if (showButton) {
			htmlLayout.addComponent(getParticipateButton(), "participer");
		} else {
			htmlLayout.addComponent(getCancelButton(), "participer");
		}

		// Lastname + firstname
		htmlLayout.addComponent(new Label(participant.getNom() + " " + participant.getPrenom()),
				"presentateur");

		// Participant photo
		if (participant.getProfilUtilisateur() != null
				&& participant.getProfilUtilisateur().getPhoto() != null) {
			ExternalResource res = new ExternalResource(getFacadeURL() + UIConst.URL_SPEAKER_IMG
					+ participant.getProfilUtilisateur().getPhoto());
			Embedded embedded = new Embedded("", res);
			htmlLayout.addComponent(embedded, "photo");
		}

		// Participant Bio
		htmlLayout.addComponent(new Label(participant.getDetails()), "details");

		// Key
		htmlLayout.addComponent(new Label(event.getPropositionPresentation().getMotCle()
				.getMotCle()), "motcle");
		;

	}

	public static String getFacadeURL() {
		ResourceBundle bundle = ResourceBundle.getBundle(UIConst.WEBAPP_PROPERTIES_FILE);
		return bundle.getString(UIConst.FACADE_URL_PROP);
	}

	/**
	 * @return Participate Button.
	 */
	public Button getParticipateButton() {
		if (participateButton == null) {
			participateButton = new Button(Messages.getString("calendar.details.participatebutton"));
		}
		return participateButton;
	}

	/**
	 * @return Participate Button.
	 */
	public Button getCancelButton() {
		if (cancelButton == null) {
			cancelButton = new Button(Messages.getString("calendar.details.cancelbutton"));
		}
		return cancelButton;
	}

	private String buildFormattedWhen(Date debut, Date fin) {
		return new SimpleDateFormat("EEEEEEEE").format(debut) + " de "
				+ new SimpleDateFormat("HH:mm").format(debut) + " � "
				+ new SimpleDateFormat("HH:mm").format(fin);
	}

	/**
	 * Find event sujet.
	 * 
	 * @param event
	 *            a event
	 * @return sujet
	 */
	private String findSujet(final Evenement event) {
		String sujet = "<Aucun>";
		PropositionPresentation pres = event.getPropositionPresentation();
		// TODO Manage several sujet case
		sujet = pres.getSujets().iterator().next().getLibelle();
		return sujet;
	}

}
