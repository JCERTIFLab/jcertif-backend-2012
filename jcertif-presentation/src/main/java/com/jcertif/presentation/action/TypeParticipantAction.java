package com.jcertif.presentation.action;


import com.jcertif.presentation.container.TypeParticipantContainer;
import com.jcertif.presentation.data.bo.participant.TypeParticipant;
import com.jcertif.presentation.wsClient.TypeParticipantClient;

/**
 *
 * @author Douneg
 */
public class TypeParticipantAction extends AbstractAction<TypeParticipantContainer, TypeParticipant, TypeParticipantClient> {

    public TypeParticipantAction() {
        setPrincipalContainer(new TypeParticipantContainer());
    }
}
