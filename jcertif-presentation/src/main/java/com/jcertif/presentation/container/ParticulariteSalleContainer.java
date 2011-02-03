package com.jcertif.presentation.container;

import com.jcertif.presentation.data.bo.salle.ParticulariteSalle;

public class ParticulariteSalleContainer extends AbstractJCertifBeanItemContainer<ParticulariteSalle> {

    public static Object[] NATURAL_COL_ORDER = new Object[]{"id", "code",
        "description"};
    public static String[] COL_HEADERS_FRENCH = new String[]{"ID",
        "Code", "Description"};

    public ParticulariteSalleContainer() {
        super(ParticulariteSalle.class);
    }
}
