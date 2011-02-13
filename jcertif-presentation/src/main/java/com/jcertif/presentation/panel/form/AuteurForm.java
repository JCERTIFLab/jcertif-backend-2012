package com.jcertif.presentation.panel.form;

import com.jcertif.presentation.action.ConferenceAction;
import com.jcertif.presentation.action.ParticipantAction;
import com.jcertif.presentation.action.RoleParticipantAction;
import com.jcertif.presentation.action.TypeParticipantAction;
import com.jcertif.presentation.container.ParticipantContainer;
import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.panel.field.AdresseField;
import com.jcertif.presentation.util.CalendarField;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextField;
import java.util.Arrays;
import java.util.List;

public class AuteurForm extends AbstractForm<Participant, ParticipantAction> {

    private ComboBox sexe;
    private ComboBox salutation;
    private CalendarField dateInscription;
    private GridLayout ourLayout;

    public AuteurForm(ParticipantAction action) {
        super(action);
        sexe = new ComboBox();
        salutation = new ComboBox();
        dateInscription = new CalendarField();
        sexe.addItem(Character.valueOf('M'));
        sexe.addItem(Character.valueOf('F'));
        salutation.addItem("M.");
        salutation.addItem("Mme");
        salutation.addItem("Mlle");
        // Create our layout (4x7 GridLayout)
        ourLayout = new GridLayout(4, 7);

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
                if (propertyId.equals("sexe")) {
                    sexe.setCaption("Sexe");
                    sexe.setRequired(true);
                    sexe.setRequiredError("Veuillez choisir un sexe");
                    return sexe;
                } else if (propertyId.equals("salutation")) {
                    salutation.setCaption("Salutation");
                    salutation.setRequired(true);
                    salutation.setRequiredError("Veuillez choisir une salutation");
                    return salutation;
                }
                Field field = super.createField(item, propertyId, uiContext);
                if (propertyId.equals("biographieSommaire")) {
                    TextField f = (TextField) field;
                    f.setCaption("Biographie Sommaire");
                    f.setRows(5);
                    f.setWidth("100%");
                } else if (propertyId.equals("email")) {
                    TextField f = (TextField) field;
                    f.setCaption("Email");
                    f.setColumns(12);
                    /* Add a validator for email and make it required */
                    f.addValidator(new EmailValidator(
                            "L'addresse electronique doit contenir '@' et un nom de domaine complet."));
                    f.setRequired(true);
                } else if ("adresse".equals(propertyId)) {
                    // create a custom field for the Address object
                    field = new AdresseField(((Participant) ((BeanItem) getItemDataSource()).getBean()).getAdresse());
                    field.setCaption("Adresse");

                } else if (propertyId.equals("details")) {
                    TextField f = (TextField) field;
                    f.setCaption("Details");
                    f.setWidth("100%");
                    f.setColumns(12);
                }
                field.setWidth("100%");
                return field;
            }
        });

    }

    @Override
    protected void attachField(Object propertyId, Field field) {
        if (propertyId.equals("id")) {
            ourLayout.addComponent(field, 0, 0);
        } else if (propertyId.equals("sexe")) {
            ourLayout.addComponent(field, 1, 0, 2, 0);
        } else if (propertyId.equals("salutation")) {
            ourLayout.addComponent(field, 0, 1);
        } else if (propertyId.equals("nom")) {
            ourLayout.addComponent(field, 1, 1);
        } else if (propertyId.equals("prenom")) {
            ourLayout.addComponent(field, 2, 1);
        } else if (propertyId.equals("email")) {
            ourLayout.addComponent(field, 0, 2);
        } else if (propertyId.equals("specialite")) {
            ourLayout.addComponent(field, 1, 2);
        } else if (propertyId.equals("website")) {
            ourLayout.addComponent(field, 2, 2);
        } else if (propertyId.equals("details")) {
            ourLayout.addComponent(field, 0, 3, 2, 3);
        } else if (propertyId.equals("conference")) {
            ourLayout.addComponent(field, 0, 4);
        } else if (propertyId.equals("dateInscription")) {
            ourLayout.addComponent(field, 1, 4);
        } else if (propertyId.equals("compagnie")) {
            ourLayout.addComponent(field, 2, 4);
        } else if (propertyId.equals("biographieSommaire")) {
            ourLayout.addComponent(field, 0, 5, 2, 5);
        } else if (propertyId.equals("roleparticipant")) {
            ourLayout.addComponent(field, 0, 6);
        } else if (propertyId.equals("typeParticipant")) {
            ourLayout.addComponent(field, 1, 6);
        } else if (propertyId.equals("adresse")) {
            ourLayout.addComponent(field, 3, 0, 3, 6);
        }

    }

    @Override
    public List<Object> getColumnOrder() {
        return Arrays.asList(ParticipantContainer.NATURAL_COL_ORDER);
    }
}
