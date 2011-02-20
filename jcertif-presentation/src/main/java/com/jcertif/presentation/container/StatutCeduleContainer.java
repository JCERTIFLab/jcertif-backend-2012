package com.jcertif.presentation.container;

import com.jcertif.presentation.data.bo.cedule.StatutCedule;

public class StatutCeduleContainer extends AbstractJCertifBeanItemContainer<StatutCedule> {

    public static Object[] NATURAL_COL_ORDER = new Object[]{"id", "code",
        "description"};
    public static String[] COL_HEADERS_FRENCH = new String[]{"ID",
        "Code", "Description"};

    public StatutCeduleContainer() {
        super(StatutCedule.class);
    }

    @Override
    public String getCaptionField() {
        return "description";
    }
}