/**
 * 
 */
package com.jcertif.presentation.ui.util;

import com.vaadin.ui.TextField;

/**
 * @author rossi
 * 
 */
public class ComponentFactory {

	public static TextField createTextField(final String caption, final boolean isRequired) {
		TextField textField = new TextField(caption);
		textField.setRequired(isRequired);
		textField.setNullRepresentation("");
		textField.setColumns(12);
		textField.setValidationVisible(true);
		textField.setRequiredError("Le champ " + caption + " est obligatoire");
		return textField;
	}
}
