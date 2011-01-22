package com.jcertif.webapp.ui.panel;

import com.jcertif.bo.participant.Participant;
import com.jcertif.webapp.action.ParticipantAction;
import com.jcertif.webapp.container.ParticipantContainer;
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
import com.vaadin.ui.DateField;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
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
    private DateField dateInscription = new DateField();

    public ParticipantForm(ParticipantAction action) {
        this.action = action;
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
                    return conference;
                } else if (propertyId.equals("roleparticipant")) {
                    return role;
                } else if (propertyId.equals("typeParticipant")) {
                    return type;
                } else if (propertyId.equals("dateInscription")) {
                    return dateInscription;
                } else if (propertyId.equals("sexe")) {
                    return sexe;
                } else if (propertyId.equals("salutation")) {
                    return salutation;
                }
                Field field = super.createField(item, propertyId, uiContext);
                if (propertyId.equals("cvSoumis")) {
                    field.setRequired(true);
                } else if (propertyId.equals("compagnie")) {
                    field.setRequired(true);
                } else if (propertyId.equals("email")) {
                    /* Add a validator for email and make it required */
                    field.addValidator(new EmailValidator(
                            "L'addresse electronique doit contenir '@' et un nom de domaine complet."));
                    field.setRequired(true);
                } else if ("address".equals(propertyId)) {
                    // create a custom field for the Address object
                    field = new AddressField(beanItem.getBean().getAdresse());
                }
                return field;
            }
        });

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
