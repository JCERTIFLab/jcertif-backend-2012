package com.jcertif.presentation.action;

import com.jcertif.presentation.container.ParticulariteSalleContainer;
import com.jcertif.presentation.container.TypeParticipantContainer;
import com.jcertif.presentation.data.bo.salle.ParticulariteSalle;
import com.jcertif.presentation.wsClient.ParticulariteSalleClient;

/**
 *
 * @author Douneg
 */
public class ParticulariteSalleAction extends AbstractAction<ParticulariteSalleContainer, ParticulariteSalle, ParticulariteSalleClient> {

    private ParticulariteSalleContainer particulariteSalleContainer;

    public ParticulariteSalleAction() {
        super();
        particulariteSalleContainer = new ParticulariteSalleContainer();
    }

    @Override
    public ParticulariteSalleClient getWebServiceClient() {
        return ParticulariteSalleClient.getInstance();
    }

    @Override
    public ParticulariteSalleContainer getPrincipalContainer() {
        return particulariteSalleContainer;
    }
}
