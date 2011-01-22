package com.jcertif.webapp.ui.panel;

import com.jcertif.webapp.action.ParticipantAction;
import com.jcertif.webapp.container.ParticipantContainer;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Table;

public class ParticipantList extends Table {

    public ParticipantList(ParticipantAction participantAction) {
        setSizeFull();
        setContainerDataSource(participantAction.getParticipantContainer());
        setVisibleColumns(ParticipantContainer.NATURAL_COL_ORDER);
        setColumnHeaders(ParticipantContainer.COL_HEADERS_ENGLISH);

        /*
         * Make table selectable, react immediatedly to user events, and pass
         * events to the controller (our main application)
         */
        setSelectable(true);
        setImmediate(true);
        addListener((ValueChangeListener) participantAction.getParticipantContainer());
        /* We don't want to allow users to de-select a row */
        setNullSelectionAllowed(false);

    }
}
