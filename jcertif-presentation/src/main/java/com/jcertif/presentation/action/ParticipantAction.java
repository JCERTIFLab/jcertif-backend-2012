package com.jcertif.presentation.action;

import com.jcertif.presentation.container.ParticipantContainer;
import com.jcertif.presentation.data.bo.AbstractBO;
import com.jcertif.presentation.data.bo.participant.Participant;
import com.vaadin.data.util.BeanItem;

/**
 *
 * @author Douneg
 */
public class ParticipantAction extends AbstractAction {

    private ParticipantContainer participantContainer;
//    @Autowired
//   private ParticipantClient participantClient;

    public ParticipantAction() throws InstantiationException, IllegalAccessException {
        this.participantContainer = new ParticipantContainer();
    }

    public BeanItem<AbstractBO> addItem(Participant participant) throws UnsupportedOperationException {
        //  participant = participantClient.create_XML(participant);

        return participantContainer.addItem(participant);
    }

    public ParticipantContainer getParticipantContainer() {
        return participantContainer;
    }
}
