package com.jcertif.presentation.ui.calendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.cedule.Evenement;
import com.jcertif.presentation.wsClient.EvenementClient;
import com.vaadin.addon.calendar.event.BasicEventProvider;
import com.vaadin.addon.calendar.event.CalendarEvent;

/**
 * Provider for calendar event bean.
 * 
 * @author rossi
 * 
 */
public class CalendarEventBeanProvider extends BasicEventProvider {

	private static final long serialVersionUID = 1L;

	/**
	 * A Logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CalendarEventBeanProvider.class);

	/**
	 * Facade event.
	 */
	private List<CalendarEvent> eventBeans = new ArrayList<CalendarEvent>();

	/**
	 * Facade event validator.
	 */
	private CalendarEventValidator validator = new CalendarEventValidator();

	/**
	 * A constructor.
	 */
	public CalendarEventBeanProvider() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CalendarEvent> getEvents(final Date startDate, final Date endDate) {

		// retrieve all events from facade only if boEvents is null. One call
		// per session to retrieve the events
		if (eventBeans == null || eventBeans.isEmpty()) {
			eventBeans = new ArrayList<CalendarEvent>();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Retrieving all events from facade.");
			}
			long start = System.currentTimeMillis();
			Set<Evenement> boEvents = new HashSet<Evenement>(EvenementClient.getInstance()
					.findAllXML());

			if (LOGGER.isDebugEnabled()) {
				long end = System.currentTimeMillis();
				LOGGER.debug("{} events from facade in {} ms", boEvents.size(), end - start);
			}
			for (Evenement dataEvent : boEvents) {

				// We can show in the calendar only the valid event
				if (validator.isValid(dataEvent)) {

					CalendarEventBean jCertifEvent = new CalendarEventBean();

					// Storing the planned date
					jCertifEvent.setStart(dataEvent.getDateDebutPrevue().getTime());
					jCertifEvent.setEnd(dataEvent.getDateFinPrevue().getTime());

					// Caption of event
					jCertifEvent.setCaption(dataEvent.getNomEvenement());

					// Facade event
					jCertifEvent.setFacadeEvent(dataEvent);

					// Adding room style
					String room = dataEvent.getCeduleSalles().iterator().next().getSalle()
							.getLibelle();
					jCertifEvent.setStyleName(room);

					eventBeans.add(jCertifEvent);
				}
			}
		}

		return eventBeans;

	}
}
