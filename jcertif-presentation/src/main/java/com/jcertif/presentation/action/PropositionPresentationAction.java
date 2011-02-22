package com.jcertif.presentation.action;

import com.jcertif.presentation.container.PropositionPresentationContainer;
import com.jcertif.presentation.data.bo.presentation.PropositionPresentation;
import com.jcertif.presentation.wsClient.PropositionPresentationClient;

/**
 *
 * @author Douneg
 */
public class PropositionPresentationAction extends AbstractAction<PropositionPresentationContainer, PropositionPresentation, PropositionPresentationClient> {

    private PropositionPresentationContainer propositionPresentationContainer;

//    @Autowired
//   private PropositionPresentationClient propositionPresentationClient;
    public PropositionPresentationAction() {
        super();
        propositionPresentationContainer = new PropositionPresentationContainer();
    }

    @Override
    public PropositionPresentationClient getWebServiceClient() {
        return PropositionPresentationClient.getInstance();
    }

    @Override
    public PropositionPresentationContainer getPrincipalContainer() {
        return propositionPresentationContainer;
    }
}
