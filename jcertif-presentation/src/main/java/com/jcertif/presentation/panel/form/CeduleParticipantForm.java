package com.jcertif.presentation.panel.form;

import com.jcertif.presentation.action.CeduleParticipantAction;
import com.jcertif.presentation.container.CeduleParticipantContainer;
import com.jcertif.presentation.data.bo.cedule.CeduleParticipant;
import com.jcertif.presentation.util.CalendarField;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CeduleParticipantForm extends Form implements ClickListener {

    private Button save = new Button("Sauver", (ClickListener) this);
    private Button cancel = new Button("Annuler", (ClickListener) this);
    private Button edit = new Button("Modifier", (ClickListener) this);
    private CeduleParticipantAction action;
    private boolean newContactMode = false;
    private CeduleParticipant ceduleParticipant = null;
    private BeanItem<CeduleParticipant> beanItem;
    private ComboBox evenement = new ComboBox();
    private ComboBox statutCedule = new ComboBox();
    private CalendarField dateCedule = new CalendarField();
    private GridLayout ourLayout;

    public CeduleParticipantForm(CeduleParticipantAction action) {
        this.action = action;

        setCaption("Cedule Participant");

        // Create our layout (3x3 GridLayout)
        ourLayout = new GridLayout(2, 3);

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
                if (propertyId.equals("evenement")) {
                    evenement.setCaption("evenement");
                    evenement.setRequired(true);
                    evenement.setRequiredError("Veuillez choisir un evenement");
                    return evenement;
                } else if (propertyId.equals("statutCedule")) {
                    statutCedule.setCaption("Statut");
                    statutCedule.setRequired(true);
                    statutCedule.setRequiredError("Veuillez choisir un statut");
                    return statutCedule;
                } else if (propertyId.equals("dateCedule")) {
                    dateCedule.setCaption("Date");
                    dateCedule.setRequired(true);
                    dateCedule.setRequiredError("Veuillez choisir une Date de Cedule");
                    return dateCedule;
                }

                Field field = super.createField(item, propertyId, uiContext);
                if (propertyId.equals("details")) {
                    field.setCaption("Details");
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
        } else if (propertyId.equals("evenement")) {
            ourLayout.addComponent(field, 1, 0);
        } else if (propertyId.equals("statutCedule")) {
            ourLayout.addComponent(field, 0, 1);
        } else if (propertyId.equals("dateCedule")) {
            ourLayout.addComponent(field, 1, 1);
        } else if (propertyId.equals("details")) {
            ourLayout.addComponent(field, 0, 2, 1, 2);
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
                /* We need to add the new ceduleParticipant to the container */
                Item addedItem = action.addItem(ceduleParticipant);
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
            List<Object> orderedProperties = Arrays.asList(CeduleParticipantContainer.NATURAL_COL_ORDER);
            for (Iterator<Object> it = orderedProperties.iterator(); it.hasNext();) {
                Object object = it.next();
                System.out.println("Field = " + object);
            }

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

    public final void setCeduleParticipantForEdit(CeduleParticipant ceduleParticipant) {
        this.ceduleParticipant = ceduleParticipant;
        beanItem = new BeanItem(ceduleParticipant);
        setItemDataSource(beanItem);
        newContactMode = true;
        setReadOnly(false);
    }

    public final void setCeduleParticipantForRead(CeduleParticipant ceduleParticipant) {
        this.ceduleParticipant = ceduleParticipant;
        beanItem = new BeanItem(ceduleParticipant);
        setItemDataSource(beanItem);
        newContactMode = true;
        setReadOnly(true);
    }

    public void addNewCeduleParticipant() {
        // Create a temporary item for the form
        ceduleParticipant = new CeduleParticipant();
        beanItem = new BeanItem(ceduleParticipant);
        setItemDataSource(beanItem);
        newContactMode = true;
        setReadOnly(false);
    }
}
