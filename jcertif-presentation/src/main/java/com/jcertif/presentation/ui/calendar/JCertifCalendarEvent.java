package com.jcertif.presentation.ui.calendar;

import com.jcertif.presentation.data.bo.cedule.Evenement;
import com.vaadin.addon.calendar.event.BasicEvent;

public class JCertifCalendarEvent extends BasicEvent {

    private static final long serialVersionUID = -5372113758406385246L;

    private Evenement event;


    public Evenement getJcertifEvent() {
        return event;
    }

    public void setJcertifEvent(final Evenement jcertifEvent) {
        this.event = jcertifEvent;
    }

}
