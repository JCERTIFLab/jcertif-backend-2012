package com.jcertif.presentation.action;

import com.jcertif.presentation.container.StatutCeduleContainer;
import com.jcertif.presentation.data.bo.cedule.StatutCedule;
import com.jcertif.presentation.wsClient.StatutCeduleClient;

/**
 *
 * @author Douneg
 */
public class StatutCeduleAction extends AbstractAction<StatutCeduleContainer, StatutCedule, StatutCeduleClient> {

    public StatutCeduleAction() {
       super(new StatutCeduleContainer(), StatutCeduleClient.getInstance());
    }
}
