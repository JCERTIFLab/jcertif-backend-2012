package com.jcertif.presentation.action;

import com.jcertif.presentation.container.PropositionPresentationContainer;
import com.jcertif.presentation.data.bo.presentation.PropositionPresentation;
import com.jcertif.presentation.wsClient.PropositionPresentationClient;

/**
 *
 * @author Douneg
 */
public class PropositionPresentationAction extends AbstractAction<PropositionPresentationContainer, PropositionPresentation, PropositionPresentationClient> {

//    @Autowired
//   private PropositionPresentationClient propositionPresentationClient;
    public PropositionPresentationAction() {
        setPrincipalContainer(new PropositionPresentationContainer());
    }
}
