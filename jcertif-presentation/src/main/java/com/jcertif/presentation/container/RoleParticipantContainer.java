package com.jcertif.presentation.container;

import com.jcertif.presentation.data.bo.participant.RoleParticipant;

public class RoleParticipantContainer extends AbstractJCertifBeanItemContainer<RoleParticipant> {

    public static Object[] NATURAL_COL_ORDER = new Object[]{"id", "code",
        "description"};
    public static String[] COL_HEADERS_FRENCH = new String[]{"ID",
        "Code", "Description"};

    public RoleParticipantContainer() {
        super(RoleParticipant.class);
    }

    @Override
    public String getCaptionField() {
        return "description";
    }
}
