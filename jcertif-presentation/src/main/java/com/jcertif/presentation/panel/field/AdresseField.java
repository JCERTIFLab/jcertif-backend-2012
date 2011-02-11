/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel.field;

import com.jcertif.presentation.container.AdresseContainer;
import com.jcertif.presentation.data.bo.Adresse;
import com.vaadin.data.Buffered;
import com.vaadin.data.Item;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomField;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Runo;
import java.util.Arrays;

/**
 *
 * @author Douneg
 */
public class AdresseField extends CustomField {

    private static final long serialVersionUID = -7303229471599487430L;
    private Form addressForm;
    private VerticalLayout verticalLayout = new VerticalLayout();

    public AdresseField(Adresse address) {

        final GridLayout ourLayout = new GridLayout(3, 6);
        // Use top-left margin and spacing
        ourLayout.setMargin(true, false, false, true);
        ourLayout.setSpacing(true);
        ourLayout.setStyleName(Runo.LAYOUT_DARKER);
        addressForm = new Form() {

            @Override
            protected void attachField(Object propertyId, Field field) {
                if (propertyId.equals("id")) {
                    ourLayout.addComponent(field, 0, 0);
                } else if (propertyId.equals("ligne1")) {
                    ourLayout.addComponent(field, 0, 1, 2, 1);
                } else if (propertyId.equals("ligne2")) {
                    ourLayout.addComponent(field, 0, 2, 2, 2);
                } else if (propertyId.equals("pays")) {
                    ourLayout.addComponent(field, 0, 3);
                } else if (propertyId.equals("province")) {
                    ourLayout.addComponent(field, 1, 3);
                } else if (propertyId.equals("ville")) {
                    ourLayout.addComponent(field, 2, 3);
                } else if (propertyId.equals("codePostal")) {
                    ourLayout.addComponent(field, 0, 4);
                } else if (propertyId.equals("fax")) {
                    ourLayout.addComponent(field, 1, 4);
                } else if (propertyId.equals("telephoneFixe")) {
                    ourLayout.addComponent(field, 0, 5);
                } else if (propertyId.equals("telephoneMobile")) {
                    ourLayout.addComponent(field, 1, 5);
                }
            }
            // Use top-left margin and spacing
        };
        verticalLayout.addComponent(addressForm);
        addressForm.setLayout(ourLayout);
        addressForm.setFormFieldFactory(new DefaultFieldFactory() {

            @Override
            public Field createField(Item item, Object propertyId,
                    Component uiContext) {
                Field field = super.createField(item, propertyId, uiContext);

                if (propertyId.equals("ligne1")) {
                    TextField f = (TextField) field;
                    f.setCaption("Ligne 1");
                    f.setWidth("100%");
                    f.setNullRepresentation("");
                    return f;
                } else if (propertyId.equals("ligne2")) {
                    TextField f = (TextField) field;
                    f.setCaption("Ligne 2");
                    f.setWidth("100%");
                    f.setNullRepresentation("");
                    return f;
                } else if (propertyId.equals("email")) {
                    TextField f = (TextField) field;
                    f.setCaption("Email");
                    /* Add a validator for email and make it required */
                    f.addValidator(new EmailValidator(
                            "L'addresse electronique doit contenir '@' et un nom de domaine complet."));
                    f.setRequired(true);
                    f.setWidth("100%");
                    f.setNullRepresentation("");
                } else if (propertyId.equals("id")) {
                    TextField f = (TextField) field;
                    f.setCaption("ID");
                    f.setReadOnly(true);
                    f.setNullRepresentation("");
                } else if (propertyId.equals("pays")) {
                    TextField f = (TextField) field;
                    f.setCaption("Pays");
                    f.setColumns(12);
                    f.setNullRepresentation("");
                } else if (propertyId.equals("province")) {
                    TextField f = (TextField) field;
                    f.setCaption("Province");
                    f.setColumns(12);
                    f.setNullRepresentation("");
                } else if (propertyId.equals("codePostal")) {
                    TextField f = (TextField) field;
                    f.setCaption("Code Postal");
                    f.setWidth("100%");
                    f.setNullRepresentation("");
                } else if (propertyId.equals("fax")) {
                    TextField f = (TextField) field;
                    f.setCaption("Fax");
                    f.setWidth("100%");
                    f.setNullRepresentation("");
                } else if (propertyId.equals("telephoneFixe")) {
                    TextField f = (TextField) field;
                    f.setCaption("Telephone Fixe");
                    f.setNullRepresentation("");
                    f.setWidth("100%");
                } else if (propertyId.equals("telephoneMobile")) {
                    TextField f = (TextField) field;
                    f.setCaption("Telephone Mobile");
                    f.setNullRepresentation("");
                    f.setWidth("100%");
                } else if (propertyId.equals("ville")) {
                    TextField f = (TextField) field;
                    f.setCaption("Ville");
                     f.setColumns(12);
                    f.setNullRepresentation("");
                    return f;
                }
                return field;
            }
        });
        addressForm.setWriteThrough(false);

        if (address == null) {
            addressForm.setItemDataSource(new BeanItem(
                    new Adresse()), Arrays.asList(AdresseContainer.NATURAL_COL_ORDER));
        } else {
            addressForm.setItemDataSource(new BeanItem(address), Arrays.asList(AdresseContainer.NATURAL_COL_ORDER));
        }
        setCompositionRoot(verticalLayout);
        setSizeFull();
    }

    /**
     * commit changes of the address form
     */
    @Override
    public void commit() throws Buffered.SourceException, InvalidValueException {
        super.commit();
        addressForm.commit();
    }

    /**
     * discard changes of the address form
     */
    @Override
    public void discard() throws Buffered.SourceException {
        super.discard();
        addressForm.discard();
    }

    @Override
    public Class<?> getType() {
        return Adresse.class;
    }
}
