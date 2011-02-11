package com.jcertif.presentation.container;

import com.jcertif.presentation.data.bo.participant.Participant;

public class ParticipantContainer extends AbstractJCertifBeanItemContainer<Participant> {

    public static Object[] NATURAL_COL_ORDER = new Object[]{"prenom", "nom", "sexe", "salutation", "specialite", "details", "email", "website", "conference",
        "dateInscription", "cvSoumis", "compagnie", "roleparticipant", "typeParticipant", "adresse"};
    public static String[] COL_HEADERS_FRENCH = new String[]{"Prenom", "Nom", "Sexe", "Salutation", "Specialite", "Details", "Adresse Electronique", "Site Web", "Conference",
        "Date Inscription", "CV Soumis", "Compagnie", "Role", "Type", "Adresse"};

    public ParticipantContainer() {
        super(Participant.class);
    }

    @Override
    public String getCaptionField() {
        return "id";
    }

}
