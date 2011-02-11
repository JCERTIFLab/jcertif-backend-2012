package com.jcertif.presentation.container;

import com.jcertif.presentation.data.bo.participant.ProfilUtilisateur;

public class ProfilUtilisateurContainer extends AbstractJCertifBeanItemContainer<ProfilUtilisateur> {

    public static Object[] NATURAL_COL_ORDER = new Object[]{"id", "nomProfil",
        "email", "password", "langueCorrespondance", "codeConfirmation","confirmPassword"};
    public static String[] COL_HEADERS_FRENCH = new String[]{"ID",
        "Nom Profil", "Email", "Password", "Langue Correspondance", "Code Confirmation","Confirme Mot de Passe"};

    public ProfilUtilisateurContainer() {
        super(ProfilUtilisateur.class);
    }

    @Override
    public String getCaptionField() {
        return "nomProfil";
    }


}
