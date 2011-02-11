package com.jcertif.presentation.container;

import com.jcertif.presentation.data.bo.presentation.StatutApprobation;

public class StatutApprobationContainer extends AbstractJCertifBeanItemContainer<StatutApprobation> {

    public static Object[] NATURAL_COL_ORDER = new Object[]{"id", "code",
        "description"};
    public static String[] COL_HEADERS_FRENCH = new String[]{"ID",
        "Code", "Description"};

    public StatutApprobationContainer() {
        super(StatutApprobation.class);
    }

    @Override
    public String getCaptionField() {
        return "description";
    }
}
