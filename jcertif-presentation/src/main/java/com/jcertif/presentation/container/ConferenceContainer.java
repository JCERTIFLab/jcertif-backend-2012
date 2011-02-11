package com.jcertif.presentation.container;

import com.jcertif.presentation.data.bo.conference.Conference;

public class ConferenceContainer extends AbstractJCertifBeanItemContainer<Conference> {

    public static Object[] NATURAL_COL_ORDER = new Object[]{"nom", "dateDebut",
        "dateFin", "website", "details"};
    public static String[] COL_HEADERS_FRENCH = new String[]{"Nom",
        "Date Debut", "Date Fin", "Site Web", "Details"};

    public ConferenceContainer() {
        super(Conference.class);
    }

    @Override
    public String getCaptionField() {
        return "nom";
    }
}
