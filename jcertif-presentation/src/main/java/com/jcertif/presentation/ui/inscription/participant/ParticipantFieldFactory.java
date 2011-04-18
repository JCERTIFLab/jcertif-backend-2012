package com.jcertif.presentation.ui.inscription.participant;

import java.util.List;

import com.jcertif.presentation.data.bo.participant.RoleParticipant;
import com.jcertif.presentation.data.bo.participant.TypeParticipant;
import com.jcertif.presentation.internationalisation.Msg;
import com.jcertif.presentation.ui.util.ComponentFactory;
import com.jcertif.presentation.wsClient.RoleParticipantClient;
import com.jcertif.presentation.wsClient.TypeParticipantClient;
import com.vaadin.data.Item;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.NativeSelect;

/**
 * Factory des champs du formulaire inscription.
 * 
 * @author rossi
 * 
 */
public class ParticipantFieldFactory implements FormFieldFactory {

	private static final String TAILLE_COMBO = "150px";
	private static final long serialVersionUID = 1L;

	/**
	 * @see com.vaadin.ui.FormFieldFactory#createField(com.vaadin.data.Item,
	 *      java.lang.Object, com.vaadin.ui.Component)
	 */
	@Override
	public Field createField(Item item, Object propertyId, Component uiContext) {
		String pid = (String) propertyId;

		if (pid.equals("nom")) {
			return ComponentFactory.createTextField(Msg.get("ui.inscription.participant.lastname"),
					true);
		} else if (pid.equals("prenom")) {
			return ComponentFactory.createTextField(
					Msg.get("ui.inscription.participant.firstname"), true);
		} else if (pid.equals("salutation")) {
			NativeSelect select = new NativeSelect(Msg.get("ui.inscription.participant.civility"));
			select.addItem("Mlle");
			select.addItem("Mme");
			select.addItem("Mr");
			select.setRequired(true);
			select.setRequiredError(Msg.get("ui.inscription.participant.civility.required.error"));
			select.setWidth(TAILLE_COMBO);
			return select;
		} else if (pid.equals("specialite")) {
			return ComponentFactory.createTextField(
					Msg.get("ui.inscription.participant.speciality"), false);
		} else if (pid.equals("compagnie")) {
			return ComponentFactory.createTextField(Msg.get("ui.inscription.participant.company"),
					false);
		} else if (pid.equals("website")) {
			return ComponentFactory.createTextField(Msg.get("ui.inscription.participant.website"),
					false);
		} else if (pid.equals("roleparticipant")) {
			NativeSelect combo = new NativeSelect(Msg.get("ui.inscription.participant.role"));
			initComboRoleParticipant(combo);
			combo.setRequired(true);
			combo.setImmediate(true);
			combo.setRequiredError(String.format(Msg.get("ui.form.required.error"),
					Msg.get("ui.inscription.participant.role")));
			combo.setWidth(TAILLE_COMBO);
			return combo;
		} else if (propertyId.equals("typeParticipant")) {
			NativeSelect combo = new NativeSelect(Msg.get("ui.inscription.participant.type"));
			initComboTypeParticipant(combo);
			combo.setRequired(true);
			combo.setRequiredError(String.format(Msg.get("ui.form.required.error"),
					Msg.get("ui.inscription.participant.type")));
			combo.setWidth(TAILLE_COMBO);
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
