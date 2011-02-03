package com.jcertif.presentation.container;

import com.jcertif.presentation.data.bo.cedule.TypeEvenement;

public class TypeEvenementContainer extends AbstractJCertifBeanItemContainer<TypeEvenement> {

    public static Object[] NATURAL_COL_ORDER = new Object[]{"id", "code",
        "description"};
    public static String[] COL_HEADERS_FRENCH = new String[]{"ID",
        "Code", "Description"};

    public TypeEvenementContainer() {
        super(TypeEvenement.class);
    }
}
