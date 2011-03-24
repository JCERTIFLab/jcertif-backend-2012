package com.jcertif.presentation.action;

import com.jcertif.presentation.container.AuteurContainer;
import com.jcertif.presentation.container.SujetContainer;
import com.jcertif.presentation.data.bo.presentation.Auteur;
import com.jcertif.presentation.data.bo.presentation.Sujet;
import com.jcertif.presentation.wsClient.AuteurClient;
import com.jcertif.presentation.wsClient.SujetClient;

/**
 *
 * @author Max
 */
public class SujetAction extends AbstractAction<SujetContainer, Sujet, SujetClient> {

    private SujetContainer sujetContainer;

    public SujetAction() {
        super();
        sujetContainer = new SujetContainer();
    }

    @Override
    public SujetClient getWebServiceClient() {
        return SujetClient.getInstance();
    }

    @Override
    public SujetContainer getPrincipalContainer() {
        return sujetContainer;
    }


}
