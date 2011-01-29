package com.jcertif.presentation.panel;

import com.jcertif.presentation.action.PropositionPresentationAction;
import com.jcertif.presentation.container.PropositionPresentationContainer;
import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.data.bo.presentation.PropositionPresentation;
import com.vaadin.data.Item;
import com.vaadin.data.validator.AbstractValidator;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextField;
import java.util.Arrays;
import java.util.List;

public class PropositionPresentationForm extends AbstractForm<PropositionPresentation, PropositionPresentationAction> {

    private GridLayout ourLayout;
    private ComboBox participants = new ComboBox("Participant");

    public PropositionPresentationForm(PropositionPresentationAction action) {
        super(action);
        setCaption("Proposition Presentation");
        // Create our layout (2x5 GridLayout)
        ourLayout = new GridLayout(2, 5);
        // Use top-left margin and spacing
        ourLayout.setMargin(false, true, false, true);
        ourLayout.setSpacing(true);
        ourLayout.setSizeFull();
        setSizeFull();
        setLayout(ourLayout);



        setFormFieldFactory(new DefaultFieldFactory() {

            @Override
            public Field createField(Item item, Object propertyId,
                    Component uiContext) {

                if (propertyId.equals("participant")) {
                    participants.addValidator(new AbstractValidator("Ce participant possede deja une Proposition Presentation") {

                        @Override
                        public boolean isValid(Object value) {
                            Object valueSelected = participants.getValue();
                            if (valueSelected instanceof Participant) {
                                Participant participant = (Participant) valueSelected;
                                return (participant.getPresentationSoumise() == null);
                            }
                            return false;
                        }
                    });
                    participants.setRequired(true);
                    participants.setRequiredError("Veuillez choisir un participant");
                    participants.setWidth("100%");
                    return participants;
                }

                Field field = super.createField(item, propertyId, uiContext);
                if (propertyId.equals("id")) {
                    TextField f = (TextField) field;
                    f.setCaption("ID");
                    f.setWidth("100%");
                    return f;
                } else if (propertyId.equals("titre")) {
                    TextField f = (TextField) field;
                    f.setCaption("Titre");
                    f.setNullRepresentation("");
                    f.setWidth("100%");
                    f.setRequired(true);
                    return f;
                } else if (propertyId.equals("sommaire")) {
                    TextField f = (TextField) field;
                    f.setCaption("Sommaire");
                    f.setNullRepresentation("");
                    f.setRows(3);
                    f.setWidth("100%");
                    f.setRequired(true);
                    return f;
                } else if (propertyId.equals("details")) {
                    TextField f = (TextField) field;
                    f.setCaption("Details");
                    f.setNullRepresentation("");
                    f.setRows(3);
                    f.setWidth("100%");
                    return f;
                } else if (propertyId.equals("description")) {
                    TextField f = (TextField) field;
                    f.setCaption("Description");
                    f.setNullRepresentation("");
                    f.setRows(3);
                    f.setWidth("100%");
                    return f;
                } else if (propertyId.equals("besoinsSpecifiques")) {
                    TextField f = (TextField) field;
                    f.setCaption("Besoins Specifiques");
                    f.setNullRepresentation("");
                    f.setRows(3);
                    f.setRequired(true);
                    f.setWidth("100%");
                } else if (propertyId.equals("motCle")) {
                    TextField f = (TextField) field;
                    f.setCaption("Mot Cle");
                    f.setNullRepresentation("");
                    f.setRows(3);
                    f.setRequired(true);
                    f.setWidth("100%");
                }
                return field;
            }
        });

    }

    @Override
    protected void attachField(Object propertyId, Field field) {
        if (propertyId.equals("id")) {
            ourLayout.addComponent(field, 0, 0);
        } else if (propertyId.equals("participant")) {
            ourLayout.addComponent(field, 1, 0);
        } else if (propertyId.equals("titre")) {
            ourLayout.addComponent(field, 0, 1, 1, 1);
        } else if (propertyId.equals("sommaire")) {
            ourLayout.addComponent(field, 0, 2);
        } else if (propertyId.equals("description")) {
            ourLayout.addComponent(field, 1, 2);
        } else if (propertyId.equals("details")) {
            ourLayout.addComponent(field, 0, 3, 1, 3);
        } else if (propertyId.equals("besoinsSpecifiques")) {
            ourLayout.addComponent(field, 0, 4);
        } else if (propertyId.equals("motCle")) {
            ourLayout.addComponent(field, 1, 4);
        }
    }

    @Override
    public List<Object> getColumnOrder() {
        return Arrays.asList(PropositionPresentationContainer.NATURAL_COL_ORDER);
    }
}
