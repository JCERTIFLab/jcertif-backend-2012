package com.jcertif.presentation.ui.calendar;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import com.jcertif.presentation.JCertifWebApplication;
import com.jcertif.presentation.data.RestApiFacade;
import com.jcertif.presentation.data.domain.JCertifPresentation;
import com.jcertif.presentation.data.domain.MyScheduleUser;

import com.vaadin.addon.calendar.event.BasicEventProvider;
import com.vaadin.addon.calendar.event.CalendarEvent;

public class JCertifEventProvider extends BasicEventProvider {

    private static final long serialVersionUID = -6066313242075569496L;

    private transient final Logger logger = Logger.getLogger(getClass());
    private boolean eventsLoaded;
    private JCertifPresentation selectedEvent;

    private static final long SHORT_EVENT_THRESHOLD_MS = 1000 * 60 * 30;

    @Override
    public List<CalendarEvent> getEvents(final Date startDate, final Date endDate) {
        loadEventsFromBackendIfNeeded();

        final List<CalendarEvent> result = super.getEvents(startDate, endDate);

        // Update the selected style name.
        for (final CalendarEvent event : eventList) {
            if (event instanceof JCertifCalendarEvent) {
                final JCertifCalendarEvent jcertifCalEvent = ((JCertifCalendarEvent) event);
                if (jcertifCalEvent.getJcertifEvent().equals(selectedEvent)) {
                    jcertifCalEvent.addStyleName("selected");
                } else {
                    jcertifCalEvent.removeStyleName("selected");
                }
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("Returning " + result.size() + " events for " + startDate + " - " + endDate);
        }

        return result;
    }

    public CalendarEvent getEvent(final int id) {
        loadEventsFromBackendIfNeeded();

        for (final CalendarEvent event : eventList) {
            if (event instanceof JCertifCalendarEvent && ((JCertifCalendarEvent) event).getJcertifEvent().getId() == id) {
                return event;
            }
        }

        return null;
    }

    public void refreshAttendingStyles() {
        final MyScheduleUser user = (MyScheduleUser) JCertifWebApplication.getCurrentInstance().getUser();

        for (final CalendarEvent event : eventList) {
            if (event instanceof JCertifCalendarEvent) {
                final JCertifCalendarEvent jcertifEvent = (JCertifCalendarEvent) event;
                if (user != null && user.hasFavourited(jcertifEvent.getJcertifEvent())) {
                    jcertifEvent.addStyleName("attending");
                } else {
                    jcertifEvent.removeStyleName("attending");
                }
            }
        }
    }

    @SuppressWarnings("unused")
	private void loadEventsFromBackendIfNeeded() {
        if(true){return;}//FIXME: Juste to avoid crash due to call to facade
    	
    	if (eventsLoaded) {
            // already loaded -> do nothing
            return;
        }

        final RestApiFacade facade = JCertifWebApplication.getCurrentInstance().getBackendFacade();
        final List<JCertifPresentation> schedule = facade.getFullSchedule();

        // wrap data from the model into CalendarEvents for UI
        for (final JCertifPresentation event : schedule) {
            final JCertifCalendarEvent calEvent = new JCertifCalendarEvent();
            calEvent.setStyleName(event.getKind().name().toLowerCase());
            calEvent.addStyleName("at-" + event.getRoom().toLowerCase().replaceAll(" ", ""));
            if (isShortEvent(event)) {
                calEvent.addStyleName("short-event");
            }
            calEvent.setJcertifEvent(event);
            calEvent.addListener(this);
            super.addEvent(calEvent);
        }
        eventsLoaded = true;
        refreshAttendingStyles();

        if (logger.isDebugEnabled()) {
            logger.debug("Fetched schedule from backend (total " + schedule.size() + " events).");
        }
    }

    private static boolean isShortEvent(final JCertifPresentation event) {
        return event.getToTime().getTime() - event.getFromTime().getTime() < SHORT_EVENT_THRESHOLD_MS;
    }

    public void setSelectedPresentation(final JCertifPresentation event) {
        selectedEvent = event;
    }
}
