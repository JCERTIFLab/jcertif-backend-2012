package com.jcertif.presentation.ui.calendar;

import java.util.GregorianCalendar;
import java.util.Locale;

import com.jcertif.presentation.data.domain.MyScheduleUser;
import com.jcertif.presentation.data.domain.MyScheduleUser.UserFavouritesChangedListener;
import com.vaadin.Application.UserChangeEvent;
import com.vaadin.Application.UserChangeListener;
import com.vaadin.addon.calendar.ui.Calendar;

/**
 * JCertifCalendar is a Calendar UI component for displaying the JCertif
 * conference schedule.
 */
public class JCertifCalendar extends Calendar implements UserChangeListener,
		UserFavouritesChangedListener {

	/**
	 * Nombre de jours de l'évènement.
	 */
	private static final int NOMBRE_JOUR = 1;

	private static final long serialVersionUID = -3068684747425348483L;

	/**
	 * A Constructor.
	 */
	public JCertifCalendar() {
		super();
		configureCalendar();
	}

	/**
	 * Configure JCertifCalendar.
	 */
	private void configureCalendar() {
		GregorianCalendar dateDebutJCERTIF = new GregorianCalendar();
		dateDebutJCERTIF.set(GregorianCalendar.YEAR, 2011);
		dateDebutJCERTIF.set(GregorianCalendar.MONTH, 8);
		dateDebutJCERTIF.set(GregorianCalendar.DATE, 3);
		dateDebutJCERTIF.set(GregorianCalendar.HOUR_OF_DAY, 0);
		dateDebutJCERTIF.set(GregorianCalendar.MINUTE, 0);
		dateDebutJCERTIF.set(GregorianCalendar.SECOND, 0);
		dateDebutJCERTIF.set(GregorianCalendar.MILLISECOND, 0);

		// set up the appearance
		setTimeFormat(TimeFormat.Format24H);
		setVisibleHoursOfDay(8, 21);
		setWidth("100%");
		setHeight("1500px");
		setLocale(Locale.getDefault());
		setReadOnly(true);
		setStartDate(dateDebutJCERTIF.getTime());

		java.util.Calendar dateFin = java.util.Calendar.getInstance();
		dateFin.setTime(dateDebutJCERTIF.getTime());
		dateFin.add(java.util.Calendar.DATE, NOMBRE_JOUR);

		setEndDate(dateFin.getTime());
	}


	@Override
	public void favouritesChanged(MyScheduleUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void applicationUserChanged(UserChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
