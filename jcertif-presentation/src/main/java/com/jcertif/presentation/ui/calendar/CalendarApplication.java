package com.jcertif.presentation.ui.calendar;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.cedule.CeduleParticipant;
import com.jcertif.presentation.data.bo.cedule.Evenement;
import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.data.bo.presentation.PropositionPresentation;
import com.vaadin.Application;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventClick;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventClickHandler;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;

/**
 * @author rossi
 * 
 */
public class CalendarApplication extends Application implements EventClickHandler {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(CalendarApplication.class);
	private JCertifCalendar calendar;
	private Panel detailPanel;

	@Override
	public void init() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Building Calendar Application");
		}
		final Window mainWindow = new Window();

		final HorizontalLayout layout = new HorizontalLayout();
		layout.addComponent(getCalendarComponent());
		layout.addComponent(getDetailPanel());

		mainWindow.getContent().addComponent(layout);
		setMainWindow(mainWindow);

	}

	private JCertifCalendar getCalendarComponent() {
		if (calendar == null) {
			calendar = new JCertifCalendar();
			calendar.setEventProvider(new JCertifEventProvider());
			calendar.setHandler(this);
		}
		return calendar;
	}

	private Panel getDetailPanel() {
		if (detailPanel == null) {
			detailPanel = new Panel();
		}
		return detailPanel;
	}

	private void updateDetailPanel(final JCertifCalendarEvent event) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Updating Detail Panel");
		}
		getDetailPanel().removeAllComponents();
		getDetailPanel().addComponent(
				new Label("Où : "
						+ event.getJcertifEvent().getCeduleSalles().iterator().next().getSalle().getLibelle()));
		Date debut = event.getJcertifEvent().getDateDebutPrevue().getTime();
		getDetailPanel().addComponent(
				new Label("Quand : " + new SimpleDateFormat("EEEEEEEE dd MMMMMMMMMMMMMM").format(debut) + " de " + new SimpleDateFormat("HH:mm").format(debut)
						+ " à " + new SimpleDateFormat("HH:mm").format(event.getJcertifEvent().getDateFinPrevue().getTime())));
		getDetailPanel().addComponent(
				new Label("Categorie : " + findSujet(event.getJcertifEvent())));
		Participant participant = findParticipant(event.getJcertifEvent());
		
		if(participant == null){
			LOGGER.warn("Pas de présentation pour cet évènement");
		} else {
			getDetailPanel().addComponent(
					new Label("Titre : " + participant.getPresentationSoumise().getTitre()));
			
			getDetailPanel().addComponent(
					new Label("Présentateur : " + participant.getNom() + " " + participant.getPrenom()));
			
			getDetailPanel().addComponent(
					new Label("Description : " + participant.getDetails()));
			
			getDetailPanel().addComponent(
					new Label("Mot Clé : " + participant.getPresentationSoumise().getMotCle().getMotCle()));	
		}

	}

	private String findSujet(final Evenement event) {
		String sujet = "<Aucun>";
		PropositionPresentation pres = findParticipant(event).getPresentationSoumise();

		if (pres.getSujets() == null || pres.getSujets().isEmpty()) {
			LOGGER.warn("Evenement sans Sujet, Evenement.id={0}", event.getId());
		} else {
			sujet = pres.getSujets().iterator().next().getLibelle();
		}

		return sujet;
	}

	private Participant findParticipant(final Evenement event) {
		Participant pres = null;
		CeduleParticipant cedule = event.getCeduleParticipants().iterator().next();
		if (cedule == null) {
			LOGGER.warn("Evenement sans CeduleParticipant, Evenement.id={0}", event.getId());
		} else {

			pres=  cedule.getParticipant();


		}

		return pres;
	}

	@Override
	public void eventClick(EventClick event) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Event Click on Calendar Application");
		}
		updateDetailPanel((JCertifCalendarEvent) event.getCalendarEvent());
	}

}
