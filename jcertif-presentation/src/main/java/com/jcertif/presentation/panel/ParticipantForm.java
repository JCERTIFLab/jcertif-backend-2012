package com.jcertif.presentation.panel;

import com.jcertif.bo.participant.Participant;
import com.jcertif.presentation.action.ParticipantAction;
import com.jcertif.presentation.container.ParticipantContainer;
import com.jcertif.presentation.util.CalendarField;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextField;
import java.util.Arrays;
import java.util.List;

public class ParticipantForm extends Form implements ClickListener {

    private Button save = new Button("Sauver", (ClickListener) this);
    private Button cancel = new Button("Annuler", (ClickListener) this);
    private Button edit = new Button("Modifier", (ClickListener) this);
    private ParticipantAction action;
    private boolean newContactMode = false;
    private Participant participant = null;
    private BeanItem<Participant> beanItem;
    private ComboBox conference = new ComboBox();
    private ComboBox role = new ComboBox();
    private ComboBox sexe = new ComboBox();
    private ComboBox salutation = new ComboBox();
    private ComboBox type = new ComboBox();
    private CalendarField dateInscription = new CalendarField();
    private GridLayout ourLayout;

    public ParticipantForm(ParticipantAction action) {
        this.action = action;

        setCaption("Participant");

        // Create our layout (3x3 GridLayout)
        ourLayout = new GridLayout(4, 8);

        // Use top-left margin and spacing
        ourLayout.setMargin(true, false, false, true);
        ourLayout.setSpacing(true);
        ourLayout.setSizeFull();
        setSizeFull();
        setLayout(ourLayout);
        /*
         * Enable buffering so that commit() must be called for the form before
         * input is written to the data. (Form input is not written immediately
         * through to the underlying object.)
         */
        setWriteThrough(false);
        HorizontalLayout footer = new HorizontalLayout();
        footer.setSpacing(true);
        footer.addComponent(save);
        footer.addComponent(cancel);
        footer.addComponent(edit);
        footer.setVisible(false);
        setFooter(footer);

        setFormFieldFactory(new DefaultFieldFactory() {

            @Override
            public Field createField(Item item, Object propertyId,
                    Component uiContext) {
                if (propertyId.equals("conference")) {
                    conference.setCaption("Conference");
                    conference.setRequired(true);
                    conference.setRequiredError("Veuillez choisir une conference");
                    return conference;
                } else if (propertyId.equals("roleparticipant")) {
                    role.setCaption("Role");
                    role.setRequired(true);
                    role.setRequiredError("Veuillez choisir un role");
                    return role;
                } else if (propertyId.equals("typeParticipant")) {
                    type.setCaption("Type");
                    type.setRequired(true);
                    type.setRequiredError("Veuillez choisir un type pour le participant");
                    return type;
                } else if (propertyId.equals("dateInscription")) {
                    dateInscription.setCaption("Date Inscription");
                    dateInscription.setRequired(true);
                    return dateInscription;
                } else if (propertyId.equals("sexe")) {
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
                if (propertyId.equals("cvSoumis")) {
                    TextField f = new TextField("CV Soumis");
                    f.setRows(5);
                    f.setWidth("100%");
                    return f;
                } else if (propertyId.equals("compagnie")) {
                    TextField f = new TextField("Compagnie");
                    f.setWidth("100%");
                    return f;
                } else if (propertyId.equals("email")) {
                    /* Add a validator for email and make it required */
                    field.addValidator(new EmailValidator(
                            "L'addresse electronique doit contenir '@' et un nom de domaine complet."));
                    field.setRequired(true);
                } else if ("adresse".equals(propertyId)) {
                    // create a custom field for the Address object
                    field.setCaption("Adresse");
                    field = new AdresseField(beanItem.getBean().getAdresse());
                } else if (propertyId.equals("details")) {
                    field.setWidth("100%");
                }
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
        } else if (propertyId.equals("cvSoumis")) {
            ourLayout.addComponent(field, 0, 5, 2, 5);
        } else if (propertyId.equals("role")) {
            ourLayout.addComponent(field, 0, 6);
        } else if (propertyId.equals("type")) {
            ourLayout.addComponent(field, 1, 6);
        } else if (propertyId.equals("adresse")) {
            ourLayout.addComponent(field, 3, 0, 3, 6);
        }
    }

    @Override
    public void buttonClick(ClickEvent event) {
        Button source = event.getButton();

        if (source == save) {
            /* If the given input is not valid there is no point in continuing */
            if (!isValid()) {
                return;
            }

            commit();
            if (newContactMode) {
                /* We need to add the new participant to the container */
                Item addedItem = action.addItem(participant);
                /*
                 * We must update the form to use the Item from our datasource
                 * as we are now in edit mode (no longer in add mode)
                 */
                setItemDataSource(addedItem);
                newContactMode = false;
            }
            setReadOnly(true);
        } else if (source == cancel) {
            if (newContactMode) {
                newContactMode = false;
                /* Clear the form and make it invisible */
                setItemDataSource(null);
            } else {
                discard();
            }
            setReadOnly(true);
        } else if (source == edit) {
            setReadOnly(false);
        }
    }

    @Override
    public void setItemDataSource(Item newDataSource) {
        newContactMode = false;
        if (newDataSource != null) {
            List<Object> orderedProperties = Arrays.asList(ParticipantContainer.NATURAL_COL_ORDER);
            super.setItemDataSource(newDataSource, orderedProperties);
            getFooter().setVisible(true);
        } else {
            super.setItemDataSource(null);
            getFooter().setVisible(false);
        }
    }

    @Override
    public void setReadOnly(boolean readOnly) {
        super.setReadOnly(readOnly);
        save.setVisible(!readOnly);
        cancel.setVisible(!readOnly);
        edit.setVisible(readOnly);
    }

    public final void setParticipantForEdit(Participant participant) {
        this.participant = participant;
        beanItem = new BeanItem(participant);
        setItemDataSource(beanItem);
        newContactMode = true;
        setReadOnly(false);
    }

    public final void setParticipantForRead(Participant participant) {
        this.participant = participant;
        beanItem = new BeanItem(participant);
        setItemDataSource(beanItem);
        newContactMode = true;
        setReadOnly(true);
    }

    public void addNewParticipant() {
        // Create a temporary item for the form
        participant = new Participant();
        beanItem = new BeanItem(participant);
        setItemDataSource(beanItem);
        newContactMode = true;
        setReadOnly(false);
    }
}
