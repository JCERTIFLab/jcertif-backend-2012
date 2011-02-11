package com.jcertif.presentation.action;


import com.jcertif.presentation.container.RoleParticipantContainer;
import com.jcertif.presentation.data.bo.participant.RoleParticipant;
import com.jcertif.presentation.wsClient.RoleParticipantClient;

/**
 *
 * @author Douneg
 */
public class RoleParticipantAction extends AbstractAction<RoleParticipantContainer, RoleParticipant, RoleParticipantClient> {

    public RoleParticipantAction() {
        super(new RoleParticipantContainer(), RoleParticipantClient.getInstance());
    }
}
