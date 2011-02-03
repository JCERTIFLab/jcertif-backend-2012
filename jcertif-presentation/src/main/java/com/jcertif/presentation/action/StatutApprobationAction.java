package com.jcertif.presentation.action;

import com.jcertif.presentation.container.StatutApprobationContainer;
import com.jcertif.presentation.data.bo.presentation.StatutApprobation;
import com.jcertif.presentation.wsClient.StatutApprobationClient;

/**
 *
 * @author Douneg
 */
public class StatutApprobationAction extends AbstractAction<StatutApprobationContainer, StatutApprobation, StatutApprobationClient> {

    public StatutApprobationAction() {
        setPrincipalContainer(new StatutApprobationContainer());
    }
}
