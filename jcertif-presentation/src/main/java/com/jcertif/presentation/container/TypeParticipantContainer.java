package com.jcertif.presentation.container;

import com.jcertif.presentation.data.bo.participant.TypeParticipant;

public class TypeParticipantContainer extends AbstractJCertifBeanItemContainer<TypeParticipant> {

    public static Object[] NATURAL_COL_ORDER = new Object[]{"id", "code",
        "description"};
    public static String[] COL_HEADERS_FRENCH = new String[]{"ID",
        "Code", "Description"};

    public TypeParticipantContainer() {
        super(TypeParticipant.class);
    }

    @Override
    public String getCaptionField() {
        return "description";
    }
}
