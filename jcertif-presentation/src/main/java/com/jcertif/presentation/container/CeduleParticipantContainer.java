package com.jcertif.presentation.container;

import com.jcertif.presentation.data.bo.cedule.CeduleParticipant;
import java.util.List;

public class CeduleParticipantContainer extends AbstractJCertifBeanItemContainer<CeduleParticipant> {

    public static Object[] NATURAL_COL_ORDER = new Object[]{"id", "statutCedule",
        "dateCedule", "details"};
    public static String[] COL_HEADERS_ENGLISH = new String[]{"ID",
        "Statut", "Date", "Details"};

    public CeduleParticipantContainer() throws InstantiationException, IllegalAccessException {
        super(CeduleParticipant.class);

    }

    public static CeduleParticipantContainer createWithTestData() {
        CeduleParticipantContainer c = null;

        return c;
    }

    @Override
    public void loadData(List<CeduleParticipant> datas) {
    }
}
