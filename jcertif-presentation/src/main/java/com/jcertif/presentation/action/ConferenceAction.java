package com.jcertif.presentation.action;

import com.jcertif.presentation.container.ConferenceContainer;
import com.jcertif.presentation.data.bo.conference.Conference;
import com.jcertif.presentation.wsClient.ConferenceClient;

/**
 *
 * @author Douneg
 */
public class ConferenceAction extends AbstractAction<ConferenceContainer, Conference, ConferenceClient> {

    private ConferenceContainer conferenceContainer;

    public ConferenceAction() {
        super();
        conferenceContainer = new ConferenceContainer();
    }

    @Override
    public ConferenceClient getWebServiceClient() {
        return ConferenceClient.getInstance();
    }

    @Override
    public ConferenceContainer getPrincipalContainer() {
        return conferenceContainer;
    }
}
