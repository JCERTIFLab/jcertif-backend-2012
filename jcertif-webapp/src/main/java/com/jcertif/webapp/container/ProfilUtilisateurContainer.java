package com.jcertif.webapp.container;

import com.jcertif.bo.participant.ProfilUtilisateur;

public class ProfilUtilisateurContainer extends AbstractJCertifBeanItemContainer {

    public ProfilUtilisateurContainer() throws InstantiationException, IllegalAccessException {
        super(ProfilUtilisateur.class);
        NATURAL_COL_ORDER = new Object[]{"nomProfil",
                    "email", "password", "cvSoumis", "compagnie", "roleparticipant", "typeParticipant"};
        COL_HEADERS_ENGLISH = new String[]{"Conference",
                    "Date Inscription", "Presentation Soumise", "CV Soumis", "Compagnie", "Role", "Type"};
    }

    public static ProfilUtilisateurContainer createWithTestData() {
        ProfilUtilisateurContainer c = null;

        return c;
    }
}
