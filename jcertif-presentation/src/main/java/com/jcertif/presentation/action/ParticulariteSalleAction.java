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

    public ParticulariteSalleAction() {
        super(new ParticulariteSalleContainer(), ParticulariteSalleClient.getInstance());
    }
}
