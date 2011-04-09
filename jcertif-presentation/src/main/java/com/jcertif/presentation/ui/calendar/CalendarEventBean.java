package com.jcertif.presentation.ui.calendar;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.cedule.Evenement;
import com.vaadin.addon.calendar.event.BasicEvent;

/**
 * Bean for calendar event.
 * 
 * @author rossi
 * 
 */
public class CalendarEventBean extends BasicEvent {

	private static final long serialVersionUID = -5372113758406385246L;

	/**
	 * A Logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CalendarEventBean.class);

	/**
	 * Facade event.
	 */
	private Evenement event;

	/**
	 * Styles list.
	 */
	private Set<String> styles = new HashSet<String>();

	/**
	 * @return the facade event
	 */
	public Evenement getFacadeEvent() {
		return event;
	}

	/**
	 * @param jcertifEvent
	 */
	public void setFacadeEvent(final Evenement jcertifEvent) {
		this.event = jcertifEvent;
	}

	/**
	 * @see com.vaadin.addon.calendar.event.BasicEvent#getStyleName()
	 */
	@Override
	public String getStyleName() {
		StringBuilder sb = new StringBuilder();
		for (String style : styles) {
			sb.append(" ").append(style);
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Getting StyleName = {} for event {}", sb.toString(),
					event.getNomEvenement());
		}
		return sb.toString();
	}

	/**
	 * @see com.vaadin.addon.calendar.event.BasicEvent#setStyleName(java.lang.String)
	 */
	@Override
	public void setStyleName(String styleName) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Adding style {} for event {}", styleName, event.getNomEvenement());
		}
		styles.add(styleName);
		fireEventChange();
	}

	public void removeStyle(String style) {
		styles.remove(style);
		fireEventChange();
	}

}
