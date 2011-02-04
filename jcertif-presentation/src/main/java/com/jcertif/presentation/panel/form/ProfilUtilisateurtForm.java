package com.jcertif.presentation.panel.form;

import com.jcertif.presentation.action.ProfilUtilisateurAction;
import com.jcertif.presentation.container.ProfilUtilisateurContainer;
import com.jcertif.presentation.data.bo.participant.ProfilUtilisateur;

import com.vaadin.data.Item;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextField;
import java.util.Arrays;
import java.util.List;

public class ProfilUtilisateurtForm extends AbstractForm<ProfilUtilisateur, ProfilUtilisateurAction> {

    private GridLayout ourLayout;

    public ProfilUtilisateurtForm(ProfilUtilisateurAction action) {
        super(action);
        setCaption("Profil Utilisateur");

        // Create our layout (3x3 GridLayout)
        ourLayout = new GridLayout(2, 5);

        // Use top-left margin and spacing
        ourLayout.setMargin(true, true, true, true);
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

        setFormFieldFactory(new DefaultFieldFactory() {

            @Override
            public Field createField(Item item, Object propertyId,
                    Component uiContext) {

                Field field = super.createField(item, propertyId, uiContext);
                if (propertyId.equals("id")) {
                    TextField f = (TextField) field;
                    f.setCaption("ID");
                    f.setWidth("100%");
                    return f;
                } else if (propertyId.equals("nomProfil")) {
                    TextField f = (TextField) field;
                    f.setCaption("Nom Profil");
                    f.setNullRepresentation("");
                    f.setWidth("100%");
                    f.setRequired(true);
                    return f;
                } else if (propertyId.equals("password")) {
                    TextField f = (TextField) field;
                    f.setCaption("Mot de passe");
                    f.setNullRepresentation("");
                    f.setWidth("100%");
                    f.setSecret(true);
                    if (isNewContactMode()) {
                        f.setRequired(true);
                    }
                    return f;
                } else if (propertyId.equals("confirmPassword")) {
                    TextField f = (TextField) field;
                    f.setCaption("Confirmer Mot de passe");
                    f.setNullRepresentation("");
                    f.setWidth("100%");
                    f.setSecret(true);
                    if (isNewContactMode()) {
                        f.setRequired(true);
                    }
                    return f;
                } else if (propertyId.equals("codeConfirmation")) {
                    TextField f = (TextField) field;
                    f.setCaption("Code Confirmation");
                    f.setNullRepresentation("");
                    f.setWidth("100%");
                    if (isNewContactMode()) {
                        f.setRequired(true);
                    }
                    return f;
                } else if (propertyId.equals("langueCorrespondance")) {
                    TextField f = (TextField) field;
                    f.setCaption("Langue Correspondance");
                    f.setNullRepresentation("");
                    f.setWidth("100%");
                    if (isNewContactMode()) {
                        f.setRequired(true);
                    }
                    return f;
                } else if (propertyId.equals("email")) {
                    TextField f = (TextField) field;
                    f.setCaption("Adresse electronique");
                    f.setNullRepresentation("");
                    f.setRequired(true);
                    /* Add a validator for email and make it required */
                    f.addValidator(new EmailValidator(
                            "L'addresse electronique doit contenir '@' et un nom de domaine complet."));
                    f.setRequired(true);
                    f.setWidth("100%");
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
        } else if (propertyId.equals("nomProfil")) {
            ourLayout.addComponent(field, 1, 0);
        } else if (propertyId.equals("password")) {
            ourLayout.addComponent(field, 0, 1);
        } else if (propertyId.equals("confirmPassword")) {
            ourLayout.addComponent(field, 1, 1);
        } else if (propertyId.equals("email")) {
            ourLayout.addComponent(field, 0, 2);
        } else if (propertyId.equals("langueCorrespondance")) {
            ourLayout.addComponent(field, 1, 2);
        } else if (propertyId.equals("codeConfirmation")) {
            ourLayout.addComponent(field, 0, 3, 1, 3);
        }
    }

    @Override
    public List<Object> getColumnOrder() {
        return Arrays.asList(ProfilUtilisateurContainer.NATURAL_COL_ORDER);
    }
}
