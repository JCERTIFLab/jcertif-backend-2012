/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.principal;

import com.vaadin.data.Item;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Upload;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 *
 * @author Douneg
 */
public abstract class JCertifForm extends Form {

    private boolean newContactMode = false;
    private Button saveButton = new Button("Sauver");
    private Button cancelButton = new Button("Annuler");
    private Button editButton = new Button("Modifier");
    private CRUDListener cRUDListener = new CRUDListener();

    CRUDListener getcRUDListener() {
        return cRUDListener;
    }

    public boolean isNewContactMode() {
        return newContactMode;
    }

    public void addFooter() {
        HorizontalLayout footer = getJCertifFooter();
        setFooter(footer);
    }

    public HorizontalLayout getJCertifFooter() {
        HorizontalLayout footer = new HorizontalLayout();
        footer.setSpacing(true);
        footer.addComponent(getSaveButton());
        footer.addComponent(getCancelButton());
        footer.addComponent(getEditButton());
        footer.setVisible(false);
        return footer;
    }

    public void setNewContactMode(boolean newContactMode) {
        this.newContactMode = newContactMode;
    }

    public JCertifForm() {
        getCancelButton().addListener(getcRUDListener());
        getEditButton().addListener(getcRUDListener());
        getSaveButton().addListener(getcRUDListener());
        setSizeFull();
    }

    public abstract Item effectiveSaveNewItem();

    public Button getCancelButton() {
        return cancelButton;
    }

    public Button getEditButton() {
        return editButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public void setCancelButton(Button cancelButton) {
        this.cancelButton = cancelButton;
    }

    public void setEditButton(Button editButton) {
        this.editButton = editButton;
    }

    @Override
    public void setReadOnly(boolean readOnly) {
        super.setReadOnly(readOnly);
        getSaveButton().setVisible(!readOnly);
        getCancelButton().setVisible(!readOnly);
        getEditButton().setVisible(readOnly);
    }

    public void setSaveButton(Button saveButton) {
        this.saveButton = saveButton;

    }

    class CRUDListener implements Button.ClickListener {

        @Override
        public void buttonClick(ClickEvent event) {
            Button source = event.getButton();

            if (source == getSaveButton()) {
                /* If the given input is not valid there is no point in continuing */
                if (!isValid()) {
                    return;
                }
                commit();
                if (isNewContactMode()) {
                    Item addedItem = effectiveSaveNewItem();
                    /*
                     * We must update the form to use the Item from our datasource
                     * as we are now in edit mode (no longer in add mode)
                     */
                    setItemDataSource(addedItem);
                    setNewContactMode(false);
                }

                setReadOnly(true);
            } else if (source == getCancelButton()) {
                if (isNewContactMode()) {
                    setNewContactMode(false);
                    /* Clear the form and make it invisible */
                    setItemDataSource(null);

                } else {
                    discard();
                }

            } else if (source == getEditButton()) {
                
                setReadOnly(false);
            }
        }
    }




}
