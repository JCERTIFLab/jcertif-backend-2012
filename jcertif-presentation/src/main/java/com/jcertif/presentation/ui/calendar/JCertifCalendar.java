package com.jcertif.presentation.ui.calendar;

import java.util.Date;

import org.apache.log4j.Logger;
import com.jcertif.presentation.JCertifWebApplication;
import com.jcertif.presentation.data.domain.JCertifPresentation;
import com.jcertif.presentation.data.domain.MyScheduleUser;
import com.jcertif.presentation.data.domain.MyScheduleUser.UserFavouritesChangedListener;

import com.vaadin.Application.UserChangeEvent;
import com.vaadin.Application.UserChangeListener;
import com.vaadin.addon.calendar.ui.Calendar;

/**
 * JCertifCalendar is a Calendar UI component for displaying the JCertif
 * conference schedule.
 */
public class JCertifCalendar extends Calendar implements UserChangeListener, UserFavouritesChangedListener {

    private static final long serialVersionUID = -3068684747425348483L;

    private final Logger logger = Logger.getLogger(getClass());

    /** First day of JCertif 2010 */
    public static final Date JCERTIF_FIRST_DAY;

    /** Last day of JCertif 2010 */
    public static final Date JCERTIF_LAST_DAY;

    static {
        final java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(2010, 10, 15, 0, 0);
        JCERTIF_FIRST_DAY = cal.getTime();
        cal.set(2010, 10, 19, 23, 59);
        JCERTIF_LAST_DAY = cal.getTime();
    }

    public JCertifCalendar() {
        super();

        // set up the appearance
        setTimeFormat(TimeFormat.Format24H);
        setVisibleHoursOfDay(8, 21);
        setWidth("100%");
        setHeight("1700px");
        setReadOnly(true);

        // set up the event provider
        setEventProvider(new JCertifEventProvider());

        // Attach this Calendar as a UserChangeListener and
        // UserFavouritesChangedListener if there already is a signed in user.
        final JCertifWebApplication app = JCertifWebApplication.getCurrentInstance();
        app.addListener(this);
        if (app.getUser() instanceof MyScheduleUser) {
            ((MyScheduleUser) app.getUser()).addListener(this);
        }
    }

    /**
     * Sets the displayed date to the given date if it's during JCertif,
     * otherwise does nothing.
     * 
     * @param date
     */
    public void setDate(final Date date) {
        if (isDuringJCertif(date)) {
            setStartDate(date);
            setEndDate(date);
        }
    }

    /**
     * Returns the default date, which is the first day of JCertif or the current
     * date if it is during JCertif.
     * 
     * @return the first day of JCertif or the current date.
     */
    public static Date getDefaultDate() {
        Date defaultDate = new Date();
        if (!isDuringJCertif(defaultDate)) {
            defaultDate = JCERTIF_FIRST_DAY;
        }
        return defaultDate;
    }

    private static boolean isDuringJCertif(final Date date) {
        return date != null && date.compareTo(JCERTIF_FIRST_DAY) >= 0 && date.compareTo(JCERTIF_LAST_DAY) <= 0;
    }

    private void refreshCalendarStyles() {
        if (getEventProvider() instanceof JCertifEventProvider) {
            ((JCertifEventProvider) getEventProvider()).refreshAttendingStyles();
        }
    }

    public void setSelectedPresentation(final JCertifPresentation event) {
        if (getEventProvider() instanceof JCertifEventProvider) {
            ((JCertifEventProvider) getEventProvider()).setSelectedPresentation(event);
        }
    }

 
    public void applicationUserChanged(final UserChangeEvent event) {
        if (logger.isDebugEnabled()) {
            logger.debug("User has changed, requesting refresh of the Calendar styles.");
        }

        refreshCalendarStyles();
        if (event.getNewUser() instanceof MyScheduleUser) {
            ((MyScheduleUser) event.getNewUser()).addListener(this);
        }
    }

  
    public void favouritesChanged(final MyScheduleUser user) {
        refreshCalendarStyles();
    }
}
