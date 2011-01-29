package com.jcertif.presentation.container;

import com.jcertif.presentation.data.bo.cedule.CeduleParticipant;

public class CeduleParticipantContainer extends AbstractJCertifBeanItemContainer<CeduleParticipant> {

    public static Object[] NATURAL_COL_ORDER = new Object[]{"id", "statutCedule",
        "dateCedule", "details", "evenement"};
    public static String[] COL_HEADERS_FRENCH = new String[]{"ID",
        "Statut", "Date", "Details","Evenement"};

    public CeduleParticipantContainer() throws InstantiationException, IllegalAccessException {
        super(CeduleParticipant.class);

    }

}
