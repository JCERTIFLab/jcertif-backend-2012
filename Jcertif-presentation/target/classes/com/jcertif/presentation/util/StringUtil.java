package com.jcertif.presentation.util;

import com.jcertif.presentation.data.domain.JCertifPresentation;
import com.jcertif.presentation.data.domain.JCertifSpeaker;

public class StringUtil {

    /**
     * Returns the duration of given {@link JCertifPresentation} as hours and
     * minutes (for example "1h 20min") or just in minutes if the duration is
     * under one hour (for example "35min").
     * 
     * @param event
     * @return
     */
    public static String getEventDuration(final JCertifPresentation event) {
        String duration;
        long durationInMinutes = (event.getToTime().getTime() - event
                .getFromTime().getTime()) / 1000 / 60;
        if (durationInMinutes >= 60) {
            final long durationInFullHours = (durationInMinutes / 60);
            duration = durationInFullHours + "h";
            if (durationInMinutes % 60 != 0) {
                duration += " " + (durationInMinutes - 60 * durationInFullHours) + "min";
            }
        } else {
            duration = durationInMinutes + "min";
        }

        return duration;
    }

    /**
     * Returns the speakers of the event as a String in parenthesis separated
     * with a comma or an empty String if there are no speakers for the event.
     * 
     * @param event
     * @return the speakers of the event as a String in parenthesis separated
     *         with a comma or an empty String.
     */
    public static String getSpeakersString(final JCertifPresentation event) {
        final StringBuilder speakers = new StringBuilder(100);
        if (!event.getSpeakers().isEmpty()) {
            speakers.append('(');
            for (final JCertifSpeaker speaker : event.getSpeakers()) {
                if (speakers.length() > 1) {
                    speakers.append(", ");
                }
                speakers.append(speaker.getName());
            }
            speakers.append(')');
        }
        return speakers.toString();
    }
}
