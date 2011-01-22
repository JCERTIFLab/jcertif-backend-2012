package com.jcertif.webapp.container;

import com.jcertif.bo.participant.Participant;

public class ParticipantContainer extends AbstractJCertifBeanItemContainer {

    public ParticipantContainer() throws InstantiationException, IllegalAccessException {
        super(Participant.class);
        NATURAL_COL_ORDER = new Object[]{"prenom", "nom", "sexe", "salutation", "specialite", "details", "email", "website", "conference",
                    "dateInscription", "cvSoumis", "compagnie", "roleparticipant", "typeParticipant","adresse"};
        COL_HEADERS_ENGLISH = new String[]{"Prenom", "Nom", "Sexe", "Salutation", "Specialite", "Details", "Adresse Electronique", "Site Web", "Conference",
                    "Date Inscription", "CV Soumis", "Compagnie", "Role", "Type","Adresse"};
    }

    /**
     * "Human readable" captions for properties in same order as in
     * NATURAL_COL_ORDER.
     */
    public static ParticipantContainer createWithTestData() {
        ParticipantContainer c = null;

        return c;
    }
}
