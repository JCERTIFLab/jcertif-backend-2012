package com.jcertif.presentation.ui.login;

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
public class LoginFieldFactory implements FormFieldFactory {

	private static final long serialVersionUID = 1L;

	@Override
	public Field createField(Item item, Object propertyId, Component uiContext) {
		String pid = (String) propertyId;
		if (pid.equals("id")) {
			TextField loginTx = ComponentFactory.createTextField(Messages.getString("login.id"),
					true);
			loginTx.addValidator(new EmailValidator(Messages.getString("login.id.wrongformat")));
			return loginTx;
		} else if (pid.equals("password")) {
			TextField passwordTx = ComponentFactory.createTextField(
					Messages.getString("login.password"), true);
			passwordTx.setSecret(true);
			return passwordTx;
		}
		return null;
	}

}
