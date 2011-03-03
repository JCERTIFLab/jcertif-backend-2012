package com.jcertif.presentation.ui.calendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.cedule.Evenement;
import com.jcertif.presentation.data.domain.JCertifPresentation;
import com.jcertif.presentation.data.domain.impl.JCertifPresentationImpl;
import com.jcertif.presentation.wsClient.EvenementClient;
import com.vaadin.addon.calendar.event.BasicEventProvider;
import com.vaadin.addon.calendar.event.CalendarEvent;

public class JCertifEventProvider extends BasicEventProvider {

	private static final long serialVersionUID = -6066313242075569496L;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(JCertifEventProvider.class);
	private boolean eventsLoaded;
	private JCertifPresentation selectedEvent;

	private static final long SHORT_EVENT_THRESHOLD_MS = 1000 * 60 * 30;

	public JCertifEventProvider() {
		super();
	}

	@Override
	public List<CalendarEvent> getEvents(final Date startDate,
			final Date endDate) {

		List<CalendarEvent> events = new ArrayList<CalendarEvent>();

		List<Evenement> evenementList = EvenementClient.getInstance()
				.findAll_XML();

		for (Evenement dataEvent : evenementList) {
			Date startDateEvent = dataEvent.getDateDebutPrevue().getTime();
			Date endDateEvent = dataEvent.getDateFinPrevue().getTime();

			JCertifPresentationImpl event = new JCertifPresentationImpl(
					dataEvent.getId(), startDateEvent, endDateEvent,
					dataEvent.getDetails());

			JCertifCalendarEvent jCertifEvent = new JCertifCalendarEvent();
			jCertifEvent.setStart(startDateEvent);
			jCertifEvent.setEnd(endDateEvent);
			jCertifEvent.setCaption(dataEvent.getDetails());

			jCertifEvent.setJcertifEvent(event);
			events.add(jCertifEvent);

		}

		return events;

	}

	// TODO

	/*
	 * public CalendarEvent getEvent(final int id) {
	 * loadEventsFromBackendIfNeeded();
	 * 
	 * for (final CalendarEvent event : eventList) { if (event instanceof
	 * JCertifCalendarEvent && ((JCertifCalendarEvent)
	 * event).getJcertifEvent().getId() == id) { return event; } }
	 * 
	 * return null; }
	 * 
	 * public void refreshAttendingStyles() { final MyScheduleUser user =
	 * (MyScheduleUser) JCertifWebApplication.getCurrentInstance().getUser();
	 * 
	 * for (final CalendarEvent event : eventList) { if (event instanceof
	 * JCertifCalendarEvent) { final JCertifCalendarEvent jcertifEvent =
	 * (JCertifCalendarEvent) event; if (user != null &&
	 * user.hasFavourited(jcertifEvent.getJcertifEvent())) {
	 * jcertifEvent.addStyleName("attending"); } else {
	 * jcertifEvent.removeStyleName("attending"); } } } }
	 * 
	 * @SuppressWarnings("unused") private void loadEventsFromBackendIfNeeded()
	 * { if(true){return;}//FIXME: Juste to avoid crash due to call to facade
	 * 
	 * if (eventsLoaded) { // already loaded -> do nothing return; }
	 * 
	 * final RestApiFacade facade =
	 * JCertifWebApplication.getCurrentInstance().getBackendFacade(); final
	 * List<JCertifPresentation> schedule = facade.getFullSchedule();
	 * 
	 * // wrap data from the model into CalendarEvents for UI for (final
	 * JCertifPresentation event : schedule) { final JCertifCalendarEvent
	 * calEvent = new JCertifCalendarEvent();
	 * calEvent.setStyleName(event.getKind().name().toLowerCase());
	 * calEvent.addStyleName("at-" +
	 * event.getRoom().toLowerCase().replaceAll(" ", "")); if
	 * (isShortEvent(event)) { calEvent.addStyleName("short-event"); }
	 * calEvent.setJcertifEvent(event); calEvent.addListener(this);
	 * super.addEvent(calEvent); } eventsLoaded = true;
	 * refreshAttendingStyles();
	 * 
	 * if (logger.isDebugEnabled()) {
	 * logger.debug("Fetched schedule from backend (total " + schedule.size() +
	 * " events)."); } }
	 * 
	 * private static boolean isShortEvent(final JCertifPresentation event) {
	 * return event.getToTime().getTime() - event.getFromTime().getTime() <
	 * SHORT_EVENT_THRESHOLD_MS; }
	 * 
	 * public void setSelectedPresentation(final JCertifPresentation event) {
	 * selectedEvent = event; }
	 */
}
