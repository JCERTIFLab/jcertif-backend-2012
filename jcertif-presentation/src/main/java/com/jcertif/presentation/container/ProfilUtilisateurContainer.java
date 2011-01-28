package com.jcertif.presentation.container;

import com.jcertif.presentation.data.bo.participant.ProfilUtilisateur;
import java.util.List;

public class ProfilUtilisateurContainer extends AbstractJCertifBeanItemContainer<ProfilUtilisateur> {

    public static Object[] NATURAL_COL_ORDER = new Object[]{"id", "nomProfil",
        "email", "password", "langueCorrespondance", "codeConfirmation"};
    public static String[] COL_HEADERS_ENGLISH = new String[]{"ID",
        "Nom Profil", "Email", "Password", "Langue Correspondance", "Code Confirmation"};

    public ProfilUtilisateurContainer() throws InstantiationException, IllegalAccessException {
        super(ProfilUtilisateur.class);

    }

    public static ProfilUtilisateurContainer createWithTestData() {
        ProfilUtilisateurContainer c = null;

        return c;
    }

    @Override
    public void loadData(List<ProfilUtilisateur> datas) {
    }
}
