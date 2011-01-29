/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel;

import com.jcertif.presentation.action.AbstractAction;
import com.jcertif.presentation.data.bo.AbstractBO;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import java.util.List;

/**
 *
 * @author Douneg
 */
public abstract class AbstractForm<BO extends AbstractBO, A extends AbstractAction> extends Form implements ClickListener {

    private Button saveButton = new Button("Sauver", (ClickListener) this);
    private Button cancelButton = new Button("Annuler", (ClickListener) this);
    private Button editButton = new Button("Modifier", (ClickListener) this);
    private AbstractAction action;
    private boolean newContactMode = false;
    private BO abstractBO;
    private BeanItem<BO> beanItem;

    public AbstractForm(AbstractAction action) {

        this.action = action;
        // Create our layout (2x5 GridLayout)

        /*
         * Enable buffering so that commit() must be called for the form before
         * input is written to the data. (Form input is not written immediately
         * through to the underlying object.)
         */
        setWriteThrough(false);
        addInitialFooter();
    }

    public void addInitialFooter() {
        saveButton = new Button("Sauver", (ClickListener) this);
        cancelButton = new Button("Annuler", (ClickListener) this);
        editButton = new Button("Modifier", (ClickListener) this);
        HorizontalLayout footer = getInitialFooter();
        setFooter(footer);
    }

    public HorizontalLayout getInitialFooter() {
        HorizontalLayout footer = new HorizontalLayout();
        footer.setSpacing(true);
        footer.addComponent(getSaveButton());
        footer.addComponent(getCancelButton());
        footer.addComponent(getEditButton());
        footer.setVisible(false);
        return footer;
    }

    public BO getAbstractBO() {
        return abstractBO;
    }

    public AbstractAction getAction() {
        return action;
    }

    public BeanItem<BO> getBeanItem() {
        return beanItem;
    }

    public boolean isNewContactMode() {
        return newContactMode;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public Button getEditButton() {
        return editButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public void setNewContactMode(boolean newContactMode) {
        this.newContactMode = newContactMode;
    }

    public AbstractForm() {
    }

    @Override
    public void buttonClick(ClickEvent event) {
        Button source = event.getButton();
        if (source == getSaveButton()) {
            /* If the given input is not valid there is no point in continuing */
            if (!isValid()) {
                commit();
                return;
            }
            commit();
            if (isNewContactMode()) {
                /* We need to add the new abstractBO to the container */
                Item addedItem = getAction().addItem(abstractBO);
                /*
                 * We must update the form to use the Item from our datasource
                 * as we are now in edit mode (no longer in add mode)
                 */
                setItemDataSource(addedItem);
                setNewContactMode(false);
            }
            setReadOnly(true);
            getApplication().getMainWindow().removeWindow(this.getWindow());
        } else if (source == getCancelButton()) {
            if (isNewContactMode()) {
                setNewContactMode(false);
                /* Clear the form and make it invisible */
                setItemDataSource(null);
            } else {
                discard();
            }
            setReadOnly(true);
            getApplication().getMainWindow().removeWindow(this.getWindow());
        } else if (source == getEditButton()) {
            setReadOnly(false);
        }
    }

    public abstract List<Object> getColumnOrder();

    @Override
    public void setItemDataSource(Item newDataSource) {
        setNewContactMode(false);
        if (newDataSource != null) {
            List<Object> orderedProperties = getColumnOrder();
            super.setItemDataSource(newDataSource, orderedProperties);
            getFooter().setVisible(true);
        } else {
            super.setItemDataSource(null);
            getFooter().setVisible(false);
        }
    }

    public final void setBOForEdit(BO abstractBO, boolean newBO) {
        this.abstractBO = abstractBO;
        beanItem = new BeanItem(abstractBO);
        setItemDataSource(beanItem);
        setNewContactMode(newBO);
        setReadOnly(false);
        getFooter().setVisible(true);
    }

    public final void setBOForRead(BO abstractBO) {
        this.abstractBO = abstractBO;
        beanItem = new BeanItem(abstractBO);
        setItemDataSource(beanItem);
        setNewContactMode(false);
        setReadOnly(true);
        getFooter().setVisible(false);
    }

    @Override
    public void setReadOnly(boolean readOnly) {
        super.setReadOnly(readOnly);
        getSaveButton().setVisible(!readOnly);
        getCancelButton().setVisible(!readOnly);
        getEditButton().setVisible(readOnly);
        Field field = getField("id");
        if (field != null) {
            field.setReadOnly(true);
        }
    }
}
