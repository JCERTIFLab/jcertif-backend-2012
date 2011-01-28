package com.jcertif.presentation.container;

import com.jcertif.presentation.data.bo.Adresse;
import java.util.List;

public class AdresseContainer extends AbstractJCertifBeanItemContainer<Adresse> {

    public static Object[] NATURAL_COL_ORDER = new Object[]{"ligne1", "ligne2", "codePostal", "ville", "province", "pays", "details", "telephoneFixe", "telephoneMobile", "fax"};
    public static String[] COL_HEADERS_ENGLISH = new String[]{"Ligne 1", "Ligne 2", "Code Postal", "Ville", "Province", "Pays", "Details", "Telephone Fixe", "Telephone Mobile", "Fax"};

    public AdresseContainer() throws InstantiationException, IllegalAccessException {
        super(Adresse.class);

    }

    public static AdresseContainer createWithTestData() {
        AdresseContainer c = null;

        return c;
    }

    @Override
    public void loadData(List<Adresse> datas) {
    }
}
