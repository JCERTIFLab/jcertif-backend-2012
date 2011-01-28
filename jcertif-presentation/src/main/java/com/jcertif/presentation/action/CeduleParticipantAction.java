package com.jcertif.presentation.action;

import com.jcertif.presentation.container.CeduleParticipantContainer;
import com.jcertif.presentation.data.bo.AbstractBO;
import com.jcertif.presentation.data.bo.cedule.CeduleParticipant;
import com.vaadin.data.util.BeanItem;

/**
 *
 * @author Douneg
 */
public class CeduleParticipantAction extends AbstractAction {

    private CeduleParticipantContainer ceduleParticipantContainer;
//    @Autowired
//   private CeduleParticipantClient ceduleParticipantClient;

    public CeduleParticipantAction() throws InstantiationException, IllegalAccessException {
        this.ceduleParticipantContainer = new CeduleParticipantContainer();
    }

    public BeanItem<AbstractBO> addItem(CeduleParticipant ceduleParticipant) throws UnsupportedOperationException {
        //  ceduleParticipant = ceduleParticipantClient.create_XML(ceduleParticipant);
        return ceduleParticipantContainer.addItem(ceduleParticipant);
    }

    public CeduleParticipantContainer getCeduleParticipantContainer() {
        return ceduleParticipantContainer;
    }
}
