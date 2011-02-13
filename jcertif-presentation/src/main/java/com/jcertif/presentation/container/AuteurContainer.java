package com.jcertif.presentation.container;

import com.jcertif.presentation.data.bo.presentation.Auteur;

public class AuteurContainer extends AbstractJCertifBeanItemContainer<Auteur> {

    public static Object[] NATURAL_COL_ORDER = new Object[]{"prenom", "nom", "sexe", "salutation", "specialite", "details", "email", "website", "photo",
        "biographieSommaire", "adresse"};
    public static String[] COL_HEADERS_FRENCH = new String[]{"Prenom", "Nom", "Sexe", "Salutation", "Specialite", "Details", "Adresse Electronique", "Site Web", "Photo",
        "Biographie Sommaire", "Adresse"};

    public static Object[] SHORT_NATURAL_COL_ORDER = new Object[]{"photo",
        "biographieSommaire"};
    public static String[] SHORT_COL_HEADERS_FRENCH = new String[]{"Photo",
        "Biographie Sommaire"};

    public AuteurContainer() {
        super(Auteur.class);
    }

    @Override
    public String getCaptionField() {
        return "id";
    }

}
