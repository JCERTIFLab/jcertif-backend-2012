package com.jcertif.presentation.ui.calendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.jcertif.presentation.JCertifWebApplication;
import com.jcertif.presentation.data.RestApiFacade;
import com.jcertif.presentation.data.domain.JCertifPresentation;
import com.jcertif.presentation.data.domain.MyScheduleUser;
import com.jcertif.presentation.data.domain.impl.JCertifPresentationEventImpl;

import com.vaadin.addon.calendar.event.BasicEventProvider;
import com.vaadin.addon.calendar.event.CalendarEvent;

public class JCertifEventProvider extends BasicEventProvider {

    private static final long serialVersionUID = -6066313242075569496L;

    private transient final Logger logger = LoggerFactory.getLogger(getClass());
    private boolean eventsLoaded;
    private JCertifPresentation selectedEvent;

    private static final long SHORT_EVENT_THRESHOLD_MS = 1000 * 60 * 30;

    @Override
    public List<CalendarEvent> getEvents(final Date startDate, final Date endDate) {
    	//TODO
       /* loadEventsFromBackendIfNeeded();

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

        return result;*/
    	
    	List<CalendarEvent> events = new ArrayList<CalendarEvent>();
		GregorianCalendar calendar = new GregorianCalendar();
		calendar = new GregorianCalendar(Locale.getDefault());
        calendar.setTime(JCertifCalendar.JCERTIF_DATE);
        calendar.add(GregorianCalendar.DATE, 0);
        calendar.set(GregorianCalendar.HOUR_OF_DAY, 8);
        calendar.set(GregorianCalendar.MINUTE, 0);
        Date start = calendar.getTime();
        calendar.add(GregorianCalendar.HOUR_OF_DAY, 2);
        Date end = calendar.getTime();
        JCertifPresentationEventImpl event = new JCertifPresentationEventImpl();
        event.setCode("ev1");
        event.setType("Acceuil");
        event.setFromTime(start);
        event.setToTime(end);
        event.setRoom("Grande Salle");
        event.setTitle("Inscription et acceuil");
        JCertifCalendarEvent jCertifEvent = new JCertifCalendarEvent();
        jCertifEvent.setStart(start);
        jCertifEvent.setEnd(end);
        jCertifEvent.setCaption(event.getTitle() + "( "+ event.getRoom() + ")" );
        
        jCertifEvent.setJcertifEvent(event);
        events.add(jCertifEvent);
        
        
        calendar.add(GregorianCalendar.DATE, 0);
        calendar.set(GregorianCalendar.HOUR_OF_DAY, 10);
        calendar.set(GregorianCalendar.MINUTE, 0);
        start = calendar.getTime();
        calendar.add(GregorianCalendar.HOUR_OF_DAY, 2);
        end = calendar.getTime();
        JCertifPresentationEventImpl event1 = new JCertifPresentationEventImpl();
        event1.setCode("ev2");
        event1.setType("Formation");
        event1.setFromTime(start);
        event1.setToTime(end);
        event1.setRoom("Sale 1");
        event1.setTitle("Formation SCJP");
        JCertifCalendarEvent jCertifEvent1 = new JCertifCalendarEvent();
        jCertifEvent1.setStart(start);
        jCertifEvent1.setEnd(end);
        jCertifEvent1.setCaption(event1.getTitle() + "( "+ event1.getRoom() + ")" );
        
        jCertifEvent1.setJcertifEvent(event1);
        events.add(jCertifEvent1);
        
        
        JCertifPresentationEventImpl event2 = new JCertifPresentationEventImpl();
        JCertifCalendarEvent jCertifEvent2 = new JCertifCalendarEvent();
        calendar.add(GregorianCalendar.DATE, 0);
        calendar.set(GregorianCalendar.HOUR_OF_DAY, 10);
        calendar.set(GregorianCalendar.MINUTE, 0);
        start = calendar.getTime();
        calendar.add(GregorianCalendar.HOUR_OF_DAY, 2);
        end = calendar.getTime();
        event2.setCode("ev3");
        event2.setType("Formation");
        event2.setFromTime(start);
        event2.setToTime(end);
        event2.setRoom("Sale 2");
        event2.setTitle("Formation SCJD");
        
        jCertifEvent2.setStart(start);
        jCertifEvent2.setEnd(end);
        jCertifEvent2.setCaption(event2.getTitle() + "( "+ event2.getRoom() + ")" );
        
        jCertifEvent2.setJcertifEvent(event2);
        events.add(jCertifEvent2);
        
        JCertifPresentationEventImpl event3 = new JCertifPresentationEventImpl();
        JCertifCalendarEvent jCertifEvent3 = new JCertifCalendarEvent();
        calendar.add(GregorianCalendar.DATE, 0);
        calendar.set(GregorianCalendar.HOUR_OF_DAY, 14);
        calendar.set(GregorianCalendar.MINUTE, 0);
        start = calendar.getTime();
        calendar.add(GregorianCalendar.HOUR_OF_DAY, 2);
        end = calendar.getTime();
        event3.setCode("ev4");
        event3.setType("Presentation");
        event3.setFromTime(start);
        event3.setToTime(end);
        event3.setRoom("Grande salle");
        event3.setTitle("Strategie d'Oracle en Afrique");
        
        jCertifEvent3.setStart(start);
        jCertifEvent3.setEnd(end);
        jCertifEvent3.setCaption(event3.getTitle() + "( "+ event3.getRoom() + ")" );
        
        jCertifEvent3.setJcertifEvent(event3);
        events.add(jCertifEvent3);
        
        JCertifPresentationEventImpl event4 = new JCertifPresentationEventImpl();
        JCertifCalendarEvent jCertifEvent4 = new JCertifCalendarEvent();
        calendar.add(GregorianCalendar.DATE, 1);
        calendar.set(GregorianCalendar.HOUR_OF_DAY, 9);
        calendar.set(GregorianCalendar.MINUTE, 0);
        start = calendar.getTime();
        calendar.add(GregorianCalendar.HOUR_OF_DAY, 3);
        end = calendar.getTime();
        event4.setCode("ev5");
        event4.setType("Table ronde");
        event4.setFromTime(start);
        event4.setToTime(end);
        event4.setRoom("Grande salle");
        event4.setTitle("Table ronde sur le future de JAVA en Afrique !");
        
        jCertifEvent4.setStart(start);
        jCertifEvent4.setEnd(end);
        jCertifEvent4.setCaption(event4.getTitle() + "( "+ event4.getRoom() + ")" );
        
        jCertifEvent4.setJcertifEvent(event4);
        events.add(jCertifEvent4);
        
    	return events;
    	
    	
    }
    
    //TODO

    /*
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
    }*/
}
