package com.jcertif.presentation.panel.form;

import com.jcertif.presentation.action.CeduleParticipantAction;
import com.jcertif.presentation.container.CeduleParticipantContainer;
import com.jcertif.presentation.data.bo.cedule.CeduleParticipant;
import com.jcertif.presentation.util.CalendarField;
import com.vaadin.data.Item;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextField;
import java.util.Arrays;
import java.util.List;

public class CeduleParticipantForm extends AbstractForm<CeduleParticipant, CeduleParticipantAction> {

    private ComboBox evenement = new ComboBox();
    private ComboBox statutCedule = new ComboBox();
    private CalendarField dateCedule = new CalendarField();
    private GridLayout ourLayout;

    public CeduleParticipantForm(CeduleParticipantAction action) {
        super(action);
        setCaption("Cedule Participant");

        // Create our layout (3x3 GridLayout)
        ourLayout = new GridLayout(2, 3);

        // Use top-left margin and spacing
        ourLayout.setMargin(true, false, false, true);
        ourLayout.setSpacing(true);
        setLayout(ourLayout);
        /*
         * Enable buffering so that commit() must be called for the form before
         * input is written to the data. (Form input is not written immediately
         * through to the underlying object.)
         */
        setWriteThrough(false);


        setFormFieldFactory(new DefaultFieldFactory() {

            @Override
            public Field createField(Item item, Object propertyId,
                    Component uiContext) {
                if (propertyId.equals("evenement")) {
                    evenement.setCaption("evenement");
                    evenement.setRequired(true);
                    evenement.setRequiredError("Veuillez choisir un evenement");
                    return evenement;
                } else if (propertyId.equals("statutCedule")) {
                    statutCedule.setCaption("Statut");
                    statutCedule.setRequired(true);
                    statutCedule.setRequiredError("Veuillez choisir un statut");
                    return statutCedule;
                } else if (propertyId.equals("dateCedule")) {
                    dateCedule.setCaption("Date");
                    dateCedule.setRequired(true);
                    dateCedule.setRequiredError("Veuillez choisir une Date de Cedule");
                    return dateCedule;
                }

                Field field = super.createField(item, propertyId, uiContext);
                if (propertyId.equals("details")) {
                    TextField f = (TextField) field;
                    f.setCaption("Details");
                    f.setWidth("100%");
                    f.setNullRepresentation("");
                }
                return field;
            }
        });

    }

    @Override
    protected void attachField(Object propertyId, Field field) {
        if (propertyId.equals("id")) {
            ourLayout.addComponent(field, 0, 0);
        } else if (propertyId.equals("evenement")) {
            ourLayout.addComponent(field, 1, 0);
        } else if (propertyId.equals("statutCedule")) {
            ourLayout.addComponent(field, 0, 1);
        } else if (propertyId.equals("dateCedule")) {
            ourLayout.addComponent(field, 1, 1);
        } else if (propertyId.equals("details")) {
            ourLayout.addComponent(field, 0, 2, 1, 2);
        }

    }

    @Override
    public List<Object> getColumnOrder() {
        return Arrays.asList(CeduleParticipantContainer.NATURAL_COL_ORDER);
    }
}
