package com.jcertif.presentation.action;

import com.jcertif.presentation.container.StatutApprobationContainer;
import com.jcertif.presentation.data.bo.presentation.StatutApprobation;
import com.jcertif.presentation.wsClient.StatutApprobationClient;

/**
 *
 * @author Douneg
 */
public class StatutApprobationAction extends AbstractAction<StatutApprobationContainer, StatutApprobation, StatutApprobationClient> {

    private StatutApprobationContainer statutApprobationContainer;

    public StatutApprobationAction() {
        super();
        statutApprobationContainer = new StatutApprobationContainer();
    }

    @Override
    public StatutApprobationClient getWebServiceClient() {
        return StatutApprobationClient.getInstance();
    }

    @Override
    public StatutApprobationContainer getPrincipalContainer() {
        return statutApprobationContainer;
    }
}
