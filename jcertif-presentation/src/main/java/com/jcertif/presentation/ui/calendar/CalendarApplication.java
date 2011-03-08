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
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Runo;

/**
 * @author rossi
 * 
 */
public class CalendarApplication extends Application implements EventClickHandler {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(CalendarApplication.class);
	private JCertifCalendar calendar;
	private Panel detailPanel;
	private Window mainWindow;

	@Override
	public void init() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Building Calendar Application");
		}
		setTheme("jcertifruno");
		mainWindow = new Window();

		
		

		mainWindow.getContent().addComponent(getCalendarComponent());
		setMainWindow(mainWindow);

	}

	private JCertifCalendar getCalendarComponent() {
		if (calendar == null) {
			calendar = new JCertifCalendar();
			calendar.setEventProvider(new JCertifEventProvider());
			calendar.setStyleName(Runo.LAYOUT_DARKER);
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
		event.setStyleName("selected");
		getDetailPanel().removeAllComponents();
//		VerticalLayout layout = new VerticalLayout();
//		layout.setStyleName("details_event");
		
		CustomLayout custom = new CustomLayout("details_event_layout");
		custom.addStyleName("customlayoutexample");

		// Use it as the layout of the Panel.
		getDetailPanel().setContent(custom);
		

		Button ok = new Button("Login");
		custom.addComponent(ok, "participer");
		custom.addComponent(
				new Label(event.getJcertifEvent().getCeduleSalles().iterator().next().getSalle().getLibelle()), "ou");
		Date debut = event.getJcertifEvent().getDateDebutPrevue().getTime();
		custom.addComponent(
				new Label(new SimpleDateFormat("EEEEEEEE dd MMMMMMMMMMMMMM").format(debut) + " de " + new SimpleDateFormat("HH:mm").format(debut)
						+ " à " + new SimpleDateFormat("HH:mm").format(event.getJcertifEvent().getDateFinPrevue().getTime())), "quand");
		custom.addComponent(
				new Label(findSujet(event.getJcertifEvent())), "categorie");
		Participant participant = findParticipant(event.getJcertifEvent());
		
		if(participant == null){
			LOGGER.warn("Pas de présentation pour cet évènement");
		} else {
			custom.addComponent(
					new Label(participant.getPresentationSoumise().getTitre()),"titre");
			
			custom.addComponent(
					new Label(participant.getNom() + " " + participant.getPrenom()),"presentateur");
			
			custom.addComponent(
					new Label(participant.getDetails()), "details");
			
			custom.addComponent(
					new Label(participant.getPresentationSoumise().getMotCle().getMotCle()),"motcle");	
		}
		
		final HorizontalLayout layoutH = new HorizontalLayout();
		layoutH.setSizeFull();
		
		layoutH.addComponent(getCalendarComponent());
		layoutH.setExpandRatio(getCalendarComponent(),2);
		layoutH.addComponent(getDetailPanel());
		layoutH.setExpandRatio(getDetailPanel(),1);
		mainWindow.getContent().removeAllComponents();
		mainWindow.getContent().addComponent(layoutH);
		


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
