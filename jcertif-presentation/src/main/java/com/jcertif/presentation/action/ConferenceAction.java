package com.jcertif.presentation.action;

import com.jcertif.presentation.container.ConferenceContainer;
import com.jcertif.presentation.data.bo.conference.Conference;
import com.jcertif.presentation.wsClient.ConferenceClient;

/**
 *
 * @author Douneg
 */
public class ConferenceAction extends AbstractAction<ConferenceContainer, Conference, ConferenceClient> {

    public ConferenceAction() {
       super(new ConferenceContainer(), ConferenceClient.getInstance());
    }
}
