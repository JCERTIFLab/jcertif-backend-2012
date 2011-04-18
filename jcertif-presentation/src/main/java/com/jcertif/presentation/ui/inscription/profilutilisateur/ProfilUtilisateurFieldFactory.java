/**
 * 
 */
package com.jcertif.presentation.ui.inscription.profilutilisateur;

import com.jcertif.presentation.internationalisation.Msg;
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
					Msg.get("ui.inscription.profilutilisateur.email"), true);
			text.addValidator(new EmailValidator(Msg
					.get("ui.inscription.profilutilisateur.email.invalid.error")));
			return text;
		} else if (pid.equals("password")) {
			TextField text = ComponentFactory.createTextField(
					Msg.get("ui.inscription.profilutilisateur.password"), true);
			text.setSecret(true);
			return text;
		} else if (pid.equals("confirmPassword")) {
			TextField text = ComponentFactory.createTextField(
					Msg.get("ui.inscription.profilutilisateur.confirmpassword"), true);
			text.setSecret(true);
			return text;
		} else if (pid.equals("confirmEmail")) {
			TextField text = ComponentFactory.createTextField(
					Msg.get("ui.inscription.profilutilisateur.confirmemail"), true);
			text.addValidator(new EmailValidator(Msg
					.get("ui.inscription.profilutilisateur.email.invalid.error")));
			return text;
		}

		return null;
	}

}