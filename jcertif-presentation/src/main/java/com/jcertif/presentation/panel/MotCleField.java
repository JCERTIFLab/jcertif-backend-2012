/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel;

import com.jcertif.presentation.data.bo.presentation.MotCle;
import com.jcertif.presentation.util.H2;
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
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Runo;

/**
 *
 * @author Douneg
 */
public class MotCleField extends CustomField {

    private static final long serialVersionUID = -7303229471599487430L;
    private Form motCleForm;
    private VerticalLayout verticalLayout = new VerticalLayout();

    public MotCleField(MotCle motCle) {
        Label label = new Label("Mot Cle");
        label.setStyleName(Runo.LABEL_SMALL);
        verticalLayout.addComponentAsFirst(label);

        final GridLayout ourLayout = new GridLayout(1, 1);
        // Use top-left margin and spacing
        ourLayout.setMargin(false, false, false, false);
        ourLayout.setSpacing(false);
        ourLayout.setStyleName(Runo.LAYOUT_DARKER);

        motCleForm = new Form() {

            @Override
            protected void attachField(Object propertyId, Field field) {
                if (propertyId.equals("motCle")) {
                    ourLayout.addComponent(field, 0, 0);
                }
            }
            // Use top-left margin and spacing
        };
        verticalLayout.addComponent(motCleForm);
        motCleForm.setLayout(ourLayout);
        motCleForm.setFormFieldFactory(new DefaultFieldFactory() {

            @Override
            public Field createField(Item item, Object propertyId,
                    Component uiContext) {
                Field field = super.createField(item, propertyId, uiContext);

                if (propertyId.equals("motCle")) {
                    TextField f = (TextField) field;
                    f.setCaption("Mot Cle");
                    f.setWidth("100%");
                    f.setNullRepresentation("");
                    f.setRows(3);
                    return f;
                }
                return field;
            }
        });
        motCleForm.setWriteThrough(false);

        if (motCle == null) {
            motCleForm.setItemDataSource(new BeanItem(
                    new MotCle()));
        } else {
            motCleForm.setItemDataSource(new BeanItem(motCle));
        }
        setCompositionRoot(verticalLayout);
        setSizeFull();
    }

    /**
     * commit changes of the motCle form
     */
    @Override
    public void commit() throws Buffered.SourceException, InvalidValueException {
        super.commit();
        motCleForm.commit();
    }

    /**
     * discard changes of the motCle form
     */
    @Override
    public void discard() throws Buffered.SourceException {
        super.discard();
        motCleForm.discard();
    }

    @Override
    public Class<?> getType() {
        return MotCle.class;
    }
}
