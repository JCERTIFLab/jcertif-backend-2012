package com.jcertif.presentation.ui.calendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.cedule.Evenement;
import com.jcertif.presentation.wsClient.EvenementClient;
import com.vaadin.addon.calendar.event.BasicEventProvider;
import com.vaadin.addon.calendar.event.CalendarEvent;

public class JCertifEventProvider extends BasicEventProvider {

	private static final long serialVersionUID = -6066313242075569496L;

	private static final Logger LOGGER = LoggerFactory.getLogger(JCertifEventProvider.class);

	public JCertifEventProvider() {
		super();
	}

	@Override
	public List<CalendarEvent> getEvents(final Date startDate, final Date endDate) {

		List<CalendarEvent> events = new ArrayList<CalendarEvent>();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Retrieving all events");
		}
		List<Evenement> evenementList = EvenementClient.getInstance().findAllXML();

		for (Evenement dataEvent : evenementList) {
			Date startDateEvent = dataEvent.getDateDebutPrevue().getTime();
			Date endDateEvent = dataEvent.getDateFinPrevue().getTime();

			JCertifCalendarEvent jCertifEvent = new JCertifCalendarEvent();
			jCertifEvent.setStart(startDateEvent);
			jCertifEvent.setEnd(endDateEvent);
			jCertifEvent.setCaption(dataEvent.getNomEvenement());
			jCertifEvent.setJcertifEvent(dataEvent);

			String libelleSalle = dataEvent.getCeduleSalles().iterator().next().getSalle()
					.getLibelle();
			jCertifEvent.setStyleName(libelleSalle);
			events.add(jCertifEvent);

		}

		return events;

	}
}
