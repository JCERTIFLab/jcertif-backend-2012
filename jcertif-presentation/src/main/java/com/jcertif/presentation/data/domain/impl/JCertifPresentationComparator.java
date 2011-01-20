package com.jcertif.presentation.data.domain.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


import com.jcertif.presentation.data.domain.JCertifPresentation;

/**
 * Compares the JCertifPresentations so that they are in chronological order
 * according to the start time and ordered by the room size (from smallest to
 * the largest) when having the same starting time.
 */
public class JCertifPresentationComparator implements Comparator<JCertifPresentation> {

    /** Predefined room order of JCertif */
    private static final List<String> jcertifRoomOrder;

    static {
        jcertifRoomOrder = new ArrayList<String>();
        jcertifRoomOrder.add("Room 8");
        jcertifRoomOrder.add("Room 5");
        jcertifRoomOrder.add("Room 4");
        jcertifRoomOrder.add("Room 9");
        jcertifRoomOrder.add("Room 6");
        jcertifRoomOrder.add("Room 7");
        jcertifRoomOrder.add("BOF 1");
        jcertifRoomOrder.add("BOF 2");
    }

    public int compare(final JCertifPresentation o1, final JCertifPresentation o2) {
        final int dateCompare = o1.getFromTime().compareTo(o2.getFromTime());
        if (dateCompare == 0) {
            // compare against the predefined room ordering
            return jcertifRoomOrder.indexOf(o2.getRoom()) - jcertifRoomOrder.indexOf(o1.getRoom());
        }
        return dateCompare;
    }
}
