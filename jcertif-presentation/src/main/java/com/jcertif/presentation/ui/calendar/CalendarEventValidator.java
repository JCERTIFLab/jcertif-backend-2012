package com.jcertif.presentation.ui.calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.cedule.Evenement;

/**
 * Calendar event validator.
 * 
 * @author rossi
 * 
 */
public class CalendarEventValidator {

	/**
	 * A Logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CalendarEventValidator.class);

	/**
	 * Log at ERROR level if the event is not valid.
	 * 
	 * @param event
	 *            a event
	 * @return true if the event is valid
	 */
	public boolean isValid(Evenement event) {
		boolean isValid = true;

		if (event.getNomEvenement() == null) {
			isValid = false;
			LOGGER.error("Event id={} is not valid. nomEvenement is null", event.getId());
		}

		if (event.getCeduleSalles() == null || event.getCeduleSalles().isEmpty()) {
			isValid = false;
			LOGGER.error("Event id={} is not valid. ceduleSalle is null or empty", event.getId());
		}

		// TODO Complete the validator
		return isValid;
	}

}
