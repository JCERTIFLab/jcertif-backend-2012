
package com.jcertif.webapp.action;

import com.jcertif.bo.AbstractBO;
import com.jcertif.bo.participant.Participant;
import com.jcertif.webapp.container.ParticipantContainer;
import com.vaadin.data.util.BeanItem;

/**
 *
 * @author Douneg
 */
public class ParticipantAction {

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
