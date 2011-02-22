package com.jcertif.presentation.action;

import com.jcertif.presentation.container.AuteurContainer;
import com.jcertif.presentation.data.bo.presentation.Auteur;
import com.jcertif.presentation.wsClient.AuteurClient;

/**
 *
 * @author Douneg
 */
public class AuteurAction extends AbstractAction<AuteurContainer, Auteur, AuteurClient> {

    private AuteurContainer auteurContainer;

    public AuteurAction() {
        super();
        auteurContainer = new AuteurContainer();
    }

    @Override
    public AuteurClient getWebServiceClient() {
        return AuteurClient.getInstance();
    }

    @Override
    public AuteurContainer getPrincipalContainer() {
        return auteurContainer;
    }


}
