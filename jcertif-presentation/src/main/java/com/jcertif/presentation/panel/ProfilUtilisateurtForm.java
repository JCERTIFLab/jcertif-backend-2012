package com.jcertif.presentation.panel;

import com.jcertif.bo.participant.ProfilUtilisateur;
import com.jcertif.presentation.action.ProfilUtilisateurAction;
import com.jcertif.presentation.container.ProfilUtilisateurContainer;
import com.jcertif.presentation.util.JCertifUploader;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.FailedEvent;
import com.vaadin.ui.Upload.SucceededEvent;
import java.util.Arrays;
import java.util.List;

public class ProfilUtilisateurtForm extends Form implements ClickListener {

    private Button save = new Button("Sauver", (ClickListener) this);
    private Button cancel = new Button("Annuler", (ClickListener) this);
    private Button edit = new Button("Modifier", (ClickListener) this);
    private ProfilUtilisateurAction action;
    private boolean newContactMode = false;
    private ProfilUtilisateur profilUtilisateur = null;
    private BeanItem<ProfilUtilisateur> beanItem;
    private TextField confirmPassword = new TextField("Confirmez le mot de passe");
    private GridLayout ourLayout;
    private Upload upload = JCertifUploader.createUplaod("Photo", "Chargez la photo", new PhotoLoader());

    public ProfilUtilisateurtForm(ProfilUtilisateurAction action) {
        this.action = action;
        setCaption("Profil Utilisateur");

        // Create our layout (3x3 GridLayout)
        ourLayout = new GridLayout(2, 5);

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

                Field field = super.createField(item, propertyId, uiContext);
                if (propertyId.equals("id")) {
                    TextField f = (TextField) field;
                    f.setCaption("ID");
                    return f;
                } else if (propertyId.equals("nomProfil")) {
                    TextField f = (TextField) field;
                    f.setCaption("Nom Profil");
                    f.setNullRepresentation("");
                    f.setRequired(true);
                    return f;
                } else if (propertyId.equals("password")) {
                    TextField f = (TextField) field;
                    f.setCaption("Mot de passe");
                    f.setNullRepresentation("");
                    f.setSecret(true);
                    if (newContactMode) {
                        f.setRequired(true);
                    }
                    return f;
                } else if (propertyId.equals("codeConfirmation")) {
                    TextField f = (TextField) field;
                    f.setCaption("Code Confirmation");
                    f.setNullRepresentation("");
                    if (newContactMode) {
                        f.setRequired(true);
                    }
                    return f;
                } else if (propertyId.equals("langueCorrespondance")) {
                    TextField f = (TextField) field;
                    f.setCaption("Langue Correspondance");
                    f.setNullRepresentation("");
                    if (newContactMode) {
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
            ourLayout.addComponent(confirmPassword, 1, 1);
        } else if (propertyId.equals("email")) {
            ourLayout.addComponent(field, 0, 2);
        } else if (propertyId.equals("langueCorrespondance")) {
            ourLayout.addComponent(field, 1, 2);
        } else if (propertyId.equals("codeConfirmation")) {
            ourLayout.addComponent(field, 0, 3, 1, 3);
            ourLayout.addComponent(upload, 0, 4, 1, 4);
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
                /* We need to add the new profilUtilisateur to the container */
                Item addedItem = action.addItem(profilUtilisateur);
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
            List<Object> orderedProperties = Arrays.asList(ProfilUtilisateurContainer.NATURAL_COL_ORDER);
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
        Field field = getField("id");
        if (field != null) {
            field.setReadOnly(true);
        }
        field = getField("nomProfil");
        if (field != null && !newContactMode) {
            field.setReadOnly(true);
        }
    }

    public final void setProfilUtilisateurForEdit(ProfilUtilisateur profilUtilisateur) {
        this.profilUtilisateur = profilUtilisateur;
        beanItem = new BeanItem(profilUtilisateur);
        setItemDataSource(beanItem);
        newContactMode = true;
        setReadOnly(false);
    }

    public final void setProfilUtilisateurForRead(ProfilUtilisateur profilUtilisateur) {
        this.profilUtilisateur = profilUtilisateur;
        beanItem = new BeanItem(profilUtilisateur);
        setItemDataSource(beanItem);
        newContactMode = true;
        setReadOnly(true);

    }

    public void addNewProfilUtilisateur() {
        // Create a temporary item for the form
        profilUtilisateur = new ProfilUtilisateur();
        beanItem = new BeanItem(profilUtilisateur);
        setItemDataSource(beanItem);
        newContactMode = true;
        setReadOnly(false);
    }

    private class PhotoLoader extends JCertifUploader {

        @Override
        public void uploadSucceeded(SucceededEvent event) {
            beanItem.getBean().setPhoto(event.getFilename());
        }

        @Override
        public void uploadFailed(FailedEvent event) {
        }
    }
}
