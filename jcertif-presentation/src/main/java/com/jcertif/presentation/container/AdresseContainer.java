package com.jcertif.presentation.container;

import com.jcertif.bo.Adresse;

public class AdresseContainer extends AbstractJCertifBeanItemContainer {

    static {
        NATURAL_COL_ORDER = new Object[]{"ligne1", "ligne2", "codePostal", "ville", "province", "pays", "details", "telephoneFixe", "telephoneMobile", "fax"};
        COL_HEADERS_ENGLISH = new String[]{"Ligne 1", "Ligne 2", "Code Postal", "Ville", "Province", "Pays", "Details", "Telephone Fixe", "Telephone Mobile", "Fax"};
    }

    public AdresseContainer() throws InstantiationException, IllegalAccessException {
        super(Adresse.class);

    }

    public static AdresseContainer createWithTestData() {
        AdresseContainer c = null;

        return c;
    }
}
