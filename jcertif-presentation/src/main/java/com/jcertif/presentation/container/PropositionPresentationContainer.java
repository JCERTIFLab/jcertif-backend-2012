package com.jcertif.presentation.container;

import com.jcertif.presentation.data.bo.presentation.PropositionPresentation;

public class PropositionPresentationContainer extends AbstractJCertifBeanItemContainer<PropositionPresentation> {

    public static Object[] NATURAL_COL_ORDER = new Object[]{"id", "titre",
        "statutApprobation", "sommaire", "details", "description", "besoinsSpecifiques", "motCle", "participant"};
    public static String[] COL_HEADERS_FRENCH = new String[]{"ID",
        "Titre", "Statut Approbation", "Sommaire", "Details", "Description", "Besoins Specifiques", "Mot Cle", "Participant"};

    public PropositionPresentationContainer() {
        super(PropositionPresentation.class);
    }

    @Override
    public String getCaptionField() {
        return "titre";
    }
}
