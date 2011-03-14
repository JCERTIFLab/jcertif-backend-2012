package com.jcertif.presentation.ui.inscription;

import java.util.List;

import com.jcertif.presentation.data.bo.participant.RoleParticipant;
import com.jcertif.presentation.data.bo.participant.TypeParticipant;
import com.jcertif.presentation.wsClient.RoleParticipantClient;
import com.jcertif.presentation.wsClient.TypeParticipantClient;
import com.vaadin.data.Item;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.TextField;

/**
 * Factory des champs du formulaire inscription.
 * 
 * @author rossi
 * 
 */
public class InscriptionFieldFactory implements FormFieldFactory {

	private static final long serialVersionUID = 1L;

	/**
	 * @see com.vaadin.ui.FormFieldFactory#createField(com.vaadin.data.Item, java.lang.Object, com.vaadin.ui.Component)
	 */
	@Override
	public Field createField(Item item, Object propertyId, Component uiContext) {
		String pid = (String) propertyId;

		if (pid.equals("nom")) {
			return createTextField("Nom", true);
		} else if (pid.equals("prenom")) {
			return createTextField("Prénom", true);
		} else if (pid.equals("salutation")) {
			ComboBox combo = new ComboBox("Civilité");
			combo.addItem("Mlle");
			combo.addItem("Mme");
			combo.addItem("Mr");
			combo.setRequired(true);
			combo.setRequiredError("La Civilité est obligatoire");
			return combo;
		} else if (pid.equals("specialite")) {
			return createTextField("Spécialité", false);
		} else if (pid.equals("compagnie")) {
			return createTextField("Entreprise", false);
		} else if (pid.equals("details")) {
			TextField text = createTextField("Présentation", false);
			text.setRows(5);
			return text;
		} else if (pid.equals("email")) {
			return createTextField("Email", true);
		} else if (pid.equals("website")) {
			return createTextField("Site web", false);
		} else if (pid.equals("roleparticipant")) {
			ComboBox combo = new ComboBox("Rôle");
			initComboRoleParticipant(combo);
			combo.setRequired(true);
			combo.setRequiredError("Le rôle est obligatoire");
			return combo;
		} else if (propertyId.equals("typeParticipant")) {
			ComboBox combo = new ComboBox("Type");
			initComboTypeParticipant(combo);
			combo.setRequired(true);
			combo.setRequiredError("Le type est obligatoire");
			return combo;
		}

		return null;
	}

	private void initComboTypeParticipant(ComboBox combo) {
		List<TypeParticipant> typeParticipantList = TypeParticipantClient.getInstance()
				.findAllXML();
		for (TypeParticipant type : typeParticipantList) {
			combo.addItem(type);
		}
	}

	private void initComboRoleParticipant(ComboBox combo) {
		List<RoleParticipant> roleParticipantList = RoleParticipantClient.getInstance()
				.findAllXML();
		for (RoleParticipant type : roleParticipantList) {
			combo.addItem(type);
		}
	}

	private TextField createTextField(final String caption, final boolean isRequired) {
		TextField textField = new TextField(caption);
		textField.setRequired(isRequired);
		textField.setNullRepresentation("");
		textField.setColumns(12);
		textField.setValidationVisible(true);
		textField.setRequiredError("Le champ " + caption + " est obligatoire");
		return textField;
	}

}
