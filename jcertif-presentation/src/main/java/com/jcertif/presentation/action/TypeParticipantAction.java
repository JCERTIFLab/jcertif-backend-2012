package com.jcertif.presentation.action;

import com.jcertif.presentation.container.TypeParticipantContainer;
import com.jcertif.presentation.data.bo.participant.TypeParticipant;
import com.jcertif.presentation.wsClient.TypeParticipantClient;

/**
 *
 * @author Douneg
 */
public class TypeParticipantAction extends AbstractAction<TypeParticipantContainer, TypeParticipant, TypeParticipantClient> {

    private TypeParticipantContainer typeParticipantContainer;

    public TypeParticipantAction() {
        super();
        typeParticipantContainer = new TypeParticipantContainer();
    }

    @Override
    public TypeParticipantClient getWebServiceClient() {
        return TypeParticipantClient.getInstance();
    }

    @Override
    public TypeParticipantContainer getPrincipalContainer() {
        return typeParticipantContainer;
    }
}
