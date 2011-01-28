package com.jcertif.presentation.container;

import com.jcertif.presentation.data.bo.participant.Participant;
import java.util.List;

public class ParticipantContainer extends AbstractJCertifBeanItemContainer<Participant> {

    public static Object[] NATURAL_COL_ORDER = new Object[]{"id", "prenom", "nom", "sexe", "salutation", "specialite", "details", "email", "website", "conference",
        "dateInscription", "cvSoumis", "compagnie", "roleparticipant", "typeParticipant", "adresse"};
    public static String[] COL_HEADERS_ENGLISH = new String[]{"ID", "Prenom", "Nom", "Sexe", "Salutation", "Specialite", "Details", "Adresse Electronique", "Site Web", "Conference",
        "Date Inscription", "CV Soumis", "Compagnie", "Role", "Type", "Adresse"};

    public ParticipantContainer() throws InstantiationException, IllegalAccessException {
        super(Participant.class);
    }

    /**
     * "Human readable" captions for properties in same order as in
     * NATURAL_COL_ORDER.
     */
    public static ParticipantContainer createWithTestData() {
        ParticipantContainer c = null;

        return c;
    }

    @Override
    public void loadData(List<Participant> datas) {
    }
}
