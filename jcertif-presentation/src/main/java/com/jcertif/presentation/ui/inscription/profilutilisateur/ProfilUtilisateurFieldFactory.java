/**
 * 
 */
package com.jcertif.presentation.ui.inscription.profilutilisateur;

import java.util.Locale;

import com.jcertif.presentation.internationalisation.Messages;
import com.jcertif.presentation.ui.util.ComponentFactory;
import com.vaadin.data.Item;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.TextField;

/**
 * @author rossi
 * 
 */
public class ProfilUtilisateurFieldFactory implements FormFieldFactory {

	private static final long serialVersionUID = 1L;

	/**
	 * @see com.vaadin.ui.FormFieldFactory#createField(com.vaadin.data.Item,
	 *      java.lang.Object, com.vaadin.ui.Component)
	 */
	@Override
	public Field createField(Item item, Object propertyId, Component uiContext) {
		String pid = (String) propertyId;

		if (pid.equals("email")) {
			TextField text = ComponentFactory.createTextField(
					Messages.getString("Presentation.email", Locale.getDefault()), true);
			text.addValidator(new EmailValidator(
					"L'adresse email doit être au format xxxxx@yyyyy.zzz"));
			return text;
		} else if (pid.equals("password")) {
			TextField text = ComponentFactory.createTextField(
					Messages.getString("Presentation.password", Locale.getDefault()), true);
			text.setSecret(true);
			return text;
		} else if (pid.equals("confirmPassword")) {
			TextField text = ComponentFactory.createTextField(
					Messages.getString("Presentation.confirmpassword", Locale.getDefault()), true);
			text.setSecret(true);
			return text;
		} else if (pid.equals("confirmEmail")) {
			TextField text = ComponentFactory.createTextField(
					Messages.getString("Presentation.confirmemail", Locale.getDefault()), true);
			text.addValidator(new EmailValidator(
					"L'adresse email doit être au format xxxxx@yyyyy.zzz"));
			return text;
		}

		return null;
	}

}