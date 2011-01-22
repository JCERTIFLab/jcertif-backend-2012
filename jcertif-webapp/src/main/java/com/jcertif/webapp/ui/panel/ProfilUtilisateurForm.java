package com.jcertif.webapp.ui.panel;


import com.jcertif.bo.participant.ProfilUtilisateur;
import com.jcertif.webapp.action.ProfilUtilisateurAction;
import com.jcertif.webapp.container.ProfilUtilisateurContainer;
import java.util.Arrays;
import java.util.List;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.TextField;

public class ProfilUtilisateurForm extends Form implements ClickListener {

    private Button save = new Button("Save", (ClickListener) this);
    private Button cancel = new Button("Cancel", (ClickListener) this);
    private Button edit = new Button("Edit", (ClickListener) this);
    private ProfilUtilisateurAction action;
    private boolean newContactMode = false;
    private ProfilUtilisateur newProfilUtilisateur = null;
    private ComboBox conference = new ComboBox();


    public ProfilUtilisateurForm(ProfilUtilisateurAction action) {
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


        /*
         * Field factory for overriding how the component for city selection is
         * created
         */
        setFormFieldFactory(new DefaultFieldFactory() {

            @Override
            public Field createField(Item item, Object propertyId,
                    Component uiContext) {
                if (propertyId.equals("photo")) {
                    return conference;
                }

                Field field = super.createField(item, propertyId, uiContext);
                if (propertyId.equals("postalCode")) {
                    TextField tf = (TextField) field;
                    /*
                     * We do not want to display "null" to the user when the
                     * field is empty
                     */
                    tf.setNullRepresentation("");

                    /* Add a validator for postalCode and make it required */
                    tf.addValidator(new RegexpValidator("[1-9][0-9]{4}",
                            "Postal code must be a five digit number and cannot start with a zero."));
                    tf.setRequired(true);
                } else if (propertyId.equals("email")) {
                    /* Add a validator for email and make it required */
                    field.addValidator(new EmailValidator(
                            "Email must contain '@' and have full domain."));
                    field.setRequired(true);
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
                /* We need to add the new person to the container */
                Item addedItem = action.addItem(newProfilUtilisateur);
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

    public void customizeForm(){

    }

    @Override
    public void setItemDataSource(Item newDataSource) {
        newContactMode = false;
        if (newDataSource != null) {
            List<Object> orderedProperties = Arrays.asList(ProfilUtilisateurContainer.NATURAL_COL_ORDER);
            super.setItemDataSource(newDataSource, orderedProperties);
            setReadOnly(true);
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

    public void addNew() {
        // Create a temporary item for the form
        newProfilUtilisateur = new ProfilUtilisateur();
        setItemDataSource(new BeanItem(newProfilUtilisateur));
        newContactMode = true;
        setReadOnly(false);
    }
}
