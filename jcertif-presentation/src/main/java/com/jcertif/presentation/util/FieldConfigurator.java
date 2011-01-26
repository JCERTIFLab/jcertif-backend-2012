/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.util;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Field;
import com.vaadin.ui.TextField;

/**
 *
 * @author UNHCRUser
 */
public class FieldConfigurator {

    public static ComboBox configureComboBox(ComboBox comboBox) {
        /* Allow the user to enter new cities */
        comboBox.setNewItemsAllowed(true);
        /* We do not want to use null values */
        comboBox.setNullSelectionAllowed(false);
        /* Add an empty city used for selecting no city */
        comboBox.addItem("");
        return comboBox;
    }

    public static Field configureRequieredTextField(TextField field) {
        /*
         * We do not want to display "null" to the user when the
         * field is empty
         */
        field.setNullRepresentation("");

        field.setRequired(true);
        return field;
    }
}
