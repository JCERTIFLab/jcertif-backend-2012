package com.jcertif.webapp.utilities;

import org.vaadin.googleanalytics.tracking.GoogleAnalyticsTracker;

public class ScheduleGATracker extends GoogleAnalyticsTracker {

    private static final long serialVersionUID = 7361545770417805481L;

    private static final String TRACKER_ID = "UA-19506472-1";
    private static final String DOMAIN = "none";

    public ScheduleGATracker() {
        super(TRACKER_ID, DOMAIN);
    }

}
