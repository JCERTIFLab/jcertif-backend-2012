package com.jcertif.presentation.action;

import com.jcertif.presentation.container.CeduleParticipantContainer;
import com.jcertif.presentation.data.bo.cedule.CeduleParticipant;
import com.jcertif.presentation.wsClient.CeduleParticipantClient;

/**
 *
 * @author Douneg
 */
public class CeduleParticipantAction extends AbstractAction<CeduleParticipantContainer, CeduleParticipant, CeduleParticipantClient> {

    public CeduleParticipantAction() {
        super(new CeduleParticipantContainer(), CeduleParticipantClient.getInstance());
    }
}
