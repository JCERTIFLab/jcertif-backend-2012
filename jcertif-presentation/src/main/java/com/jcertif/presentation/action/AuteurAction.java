package com.jcertif.presentation.action;

import com.jcertif.presentation.container.AuteurContainer;
import com.jcertif.presentation.data.bo.presentation.Auteur;
import com.jcertif.presentation.wsClient.AuteurClient;

/**
 *
 * @author Douneg
 */
public class AuteurAction extends AbstractAction<AuteurContainer, Auteur, AuteurClient> {

//    @Autowired
//   private AuteurClient participantClient;
    public AuteurAction() {
        super(new AuteurContainer(), AuteurClient.getInstance());
    }
}
