package com.jcertif.presentation.container;

import com.jcertif.presentation.data.bo.presentation.Sujet;

public class SujetContainer extends AbstractJCertifBeanItemContainer<Sujet> {

    public static Object[] NATURAL_COL_ORDER = new Object[]{"libelle", "description"};
    public static String[] COL_HEADERS_FRENCH = new String[]{"Titre", "Description"};

    public SujetContainer() {
        super(Sujet.class);
    }

    @Override
    public String getCaptionField() {
        return "id";
    }
}
