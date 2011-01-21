package com.jcertif.presentation.ui.calendar;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.jcertif.presentation.data.domain.JCertifPresentation;
import com.jcertif.presentation.util.StringUtil;

import com.vaadin.addon.calendar.event.BasicEvent;

public class JCertifCalendarEvent extends BasicEvent {

    private static final long serialVersionUID = -5372113758406385246L;

    private JCertifPresentation jcertifEvent;
    private Set<String> additionalStyles = new HashSet<String>();
    private String speakers;
    //TODO
    /*@Override
    public Date getStart() {
        return jcertifEvent.getFromTime();
    }

    @Override
    public Date getEnd() {
        return jcertifEvent.getToTime();
    }

    @Override
    public String getCaption() {
        if (speakers == null) {
            speakers = StringUtil.getSpeakersString(jcertifEvent);
        }
        return jcertifEvent.getTitle() + " " + speakers;
    }*/

    public JCertifPresentation getJcertifEvent() {
        return jcertifEvent;
    }

    public void setJcertifEvent(final JCertifPresentation jcertifEvent) {
        this.jcertifEvent = jcertifEvent;
    }

    /**
     * Overridden to allow multiple CSS class names.
     */
    //TODO
   /* @Override
    public String getStyleName() {
        final  StringBuilder sb = new StringBuilder(100);
        sb.append(super.getStyleName());
        for (String styleName : additionalStyles) {
            sb.append(" ");
            sb.append(styleName);
        }
        return sb.toString();
    }

    public void addStyleName(final String styleName) {
        boolean added = additionalStyles.add(styleName);
        if (added) {
            fireEventChange();
        }
    }

    public void removeStyleName(final String styleName) {
        boolean removed = additionalStyles.remove(styleName);
        if (removed) {
            fireEventChange();
        }
    }*/
}
