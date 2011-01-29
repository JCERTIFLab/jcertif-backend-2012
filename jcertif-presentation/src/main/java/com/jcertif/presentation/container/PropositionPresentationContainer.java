package com.jcertif.presentation.container;

import com.jcertif.presentation.data.bo.participant.ProfilUtilisateur;

public class PropositionPresentationContainer extends AbstractJCertifBeanItemContainer<ProfilUtilisateur> {

    public static Object[] NATURAL_COL_ORDER = new Object[]{"id", "titre",
        "statutApprobation", "sommaire", "details", "description", "besoinsSpecifiques", "motCle"};
    public static String[] COL_HEADERS_FRENCH = new String[]{"ID",
        "Titre", "Statut Approbation", "Sommaire", "Details", "Description", "Besoins Specifiques", "Mot Cle"};

    public PropositionPresentationContainer() throws InstantiationException, IllegalAccessException {
        super(ProfilUtilisateur.class);
    }
}
