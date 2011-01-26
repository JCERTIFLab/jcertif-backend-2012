package com.jcertif.presentation.container;

import com.jcertif.bo.participant.ProfilUtilisateur;

public class ProfilUtilisateurContainer extends AbstractJCertifBeanItemContainer {

    static {
        NATURAL_COL_ORDER = new Object[]{"id", "nomProfil",
                    "email", "password", "langueCorrespondance", "codeConfirmation"};
        COL_HEADERS_ENGLISH = new String[]{"ID",
                    "Nom Profil", "Email", "Password", "Langue Correspondance", "Code Confirmation"};
    }

    public ProfilUtilisateurContainer() throws InstantiationException, IllegalAccessException {
        super(ProfilUtilisateur.class);

    }

    public static ProfilUtilisateurContainer createWithTestData() {
        ProfilUtilisateurContainer c = null;

        return c;
    }
}
