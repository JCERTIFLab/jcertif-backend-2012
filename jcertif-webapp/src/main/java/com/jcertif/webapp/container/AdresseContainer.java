package com.jcertif.webapp.container;

import com.jcertif.bo.Adresse;

public class AdresseContainer extends AbstractJCertifBeanItemContainer {

    public AdresseContainer() throws InstantiationException, IllegalAccessException {
        super(Adresse.class);
        NATURAL_COL_ORDER = new Object[]{"ligne1", "ligne2", "codePostal", "ville", "province", "pays", "details", "telephoneFixe", "telephoneMobile", "fax"};
        COL_HEADERS_ENGLISH = new String[]{"Ligne 1", "Ligne 2", "Code Postal", "Ville", "Province", "Pays", "Details", "Telephone Fixe", "Telephone Mobile", "Fax"};
    }

    /**
     * "Human readable" captions for properties in same order as in
     * NATURAL_COL_ORDER.
     */
    public static AdresseContainer createWithTestData() {
        AdresseContainer c = null;

        return c;
    }
}
