package com.jcertif.presentation.ui.inscription.participant;

import java.util.List;

import com.jcertif.presentation.data.bo.participant.RoleParticipant;
import com.jcertif.presentation.data.bo.participant.TypeParticipant;
import com.jcertif.presentation.internationalisation.Messages;
import com.jcertif.presentation.ui.util.ComponentFactory;
import com.jcertif.presentation.wsClient.RoleParticipantClient;
import com.jcertif.presentation.wsClient.TypeParticipantClient;
import com.vaadin.data.Item;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;

/**
 * Factory des champs du formulaire inscription.
 * 
 * @author rossi
 * 
 */
public class ParticipantFieldFactory implements FormFieldFactory {

	private static final long serialVersionUID = 1L;

	/**
	 * @see com.vaadin.ui.FormFieldFactory#createField(com.vaadin.data.Item,
	 *      java.lang.Object, com.vaadin.ui.Component)
	 */
	@Override
	public Field createField(Item item, Object propertyId, Component uiContext) {
		String pid = (String) propertyId;

		if (pid.equals("nom")) {
			return ComponentFactory.createTextField(Messages.getString("Presentation.nom"), true);
		} else if (pid.equals("prenom")) {
			return ComponentFactory
					.createTextField(Messages.getString("Presentation.prenom"), true);
		} else if (pid.equals("salutation")) {
			NativeSelect select = new NativeSelect("Civilité");
			select.addItem("Mlle");
			select.addItem("Mme");
			select.addItem("Mr");
			select.setRequired(true);
			select.setRequiredError("La Civilité est obligatoire");
			return select;
		} else if (pid.equals("specialite")) {
			return ComponentFactory.createTextField(Messages.getString("Presentation.specialite"),
					false);
		} else if (pid.equals("compagnie")) {
			return ComponentFactory.createTextField("Entreprise", false);
		} else if (pid.equals("details")) {
			TextField text = ComponentFactory.createTextField("Présentation", false);
			text.setRows(5);
			return text;
		} else if (pid.equals("website")) {
			return ComponentFactory.createTextField("Site web", false);
		} else if (pid.equals("roleparticipant")) {
			NativeSelect combo = new NativeSelect("Rôle");
			initComboRoleParticipant(combo);
			combo.setRequired(true);
			combo.setRequiredError("Le rôle est obligatoire");
			return combo;
		} else if (propertyId.equals("typeParticipant")) {
			NativeSelect combo = new NativeSelect("Type");
			initComboTypeParticipant(combo);
			combo.setRequired(true);
			combo.setRequiredError("Le type est obligatoire");
			return combo;
		}

		return null;
	}

	private void initComboTypeParticipant(NativeSelect combo) {
		List<TypeParticipant> typeParticipantList = TypeParticipantClient.getInstance()
				.findAllXML();
		for (TypeParticipant type : typeParticipantList) {
			combo.addItem(type);
		}
	}

	private void initComboRoleParticipant(NativeSelect combo) {
		List<RoleParticipant> roleParticipantList = RoleParticipantClient.getInstance()
				.findAllXML();
		for (RoleParticipant type : roleParticipantList) {
			combo.addItem(type);
		}
	}

}
