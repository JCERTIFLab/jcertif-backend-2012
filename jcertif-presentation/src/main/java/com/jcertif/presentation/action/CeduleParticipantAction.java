package com.jcertif.presentation.action;

import com.jcertif.presentation.container.CeduleParticipantContainer;
import com.jcertif.presentation.data.bo.cedule.CeduleParticipant;
import com.jcertif.presentation.wsClient.CeduleParticipantClient;

/**
 *
 * @author Douneg
 */
public class CeduleParticipantAction extends AbstractAction<CeduleParticipantContainer, CeduleParticipant, CeduleParticipantClient> {

    private CeduleParticipantContainer ceduleParticipantContainer;

    public CeduleParticipantAction() {
        super();
        ceduleParticipantContainer = new CeduleParticipantContainer();
    }

    @Override
    public CeduleParticipantClient getWebServiceClient() {
        return CeduleParticipantClient.getInstance();
    }

    @Override
    public CeduleParticipantContainer getPrincipalContainer() {
        return ceduleParticipantContainer;
    }
}
