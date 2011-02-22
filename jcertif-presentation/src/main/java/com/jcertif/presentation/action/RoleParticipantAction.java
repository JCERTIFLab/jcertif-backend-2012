package com.jcertif.presentation.action;

import com.jcertif.presentation.container.RoleParticipantContainer;
import com.jcertif.presentation.data.bo.participant.RoleParticipant;
import com.jcertif.presentation.wsClient.RoleParticipantClient;

/**
 *
 * @author Douneg
 */
public class RoleParticipantAction extends AbstractAction<RoleParticipantContainer, RoleParticipant, RoleParticipantClient> {

    private RoleParticipantContainer roleParticipantContainer;

    public RoleParticipantAction() {
        super();
        roleParticipantContainer = new RoleParticipantContainer();
    }

    @Override
    public RoleParticipantClient getWebServiceClient() {
        return RoleParticipantClient.getInstance();
    }

    @Override
    public RoleParticipantContainer getPrincipalContainer() {
        return roleParticipantContainer;
    }
}
