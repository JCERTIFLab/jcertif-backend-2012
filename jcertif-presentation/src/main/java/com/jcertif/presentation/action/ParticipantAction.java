package com.jcertif.presentation.action;

import com.jcertif.presentation.container.ParticipantContainer;
import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.wsClient.ParticipantClient;

/**
 *
 * @author Douneg
 */
public class ParticipantAction extends AbstractAction<ParticipantContainer, Participant, ParticipantClient> {

    private ParticipantContainer participantContainer;

//    @Autowired
//   private ParticipantClient participantClient;
    public ParticipantAction() {
        super();
        participantContainer = new ParticipantContainer();
    }

    @Override
    public ParticipantClient getWebServiceClient() {
        return ParticipantClient.getInstance();
    }

    @Override
    public ParticipantContainer getPrincipalContainer() {
        return participantContainer;
    }
}
