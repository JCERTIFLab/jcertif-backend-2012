package com.jcertif.presentation.ui.inscription.adresse;

import com.jcertif.presentation.internationalisation.Msg;
import com.jcertif.presentation.ui.util.ComponentFactory;
import com.jcertif.presentation.ui.util.PaysUtility;
import com.vaadin.data.Item;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;

/**
 * @author rossi
 * 
 */
public class AdresseFieldFactory implements FormFieldFactory {

	private static final long serialVersionUID = 1L;

	/**
	 * @see com.vaadin.ui.FormFieldFactory#createField(com.vaadin.data.Item,
	 *      java.lang.Object, com.vaadin.ui.Component)
	 */
	@Override
	public Field createField(Item item, Object propertyId, Component uiContext) {

		String pid = (String) propertyId;
		if (pid.equals("telephoneFixe")) {
			TextField tx = ComponentFactory.createTextField(
					Msg.get("ui.inscription.adresse.telephone.fixe"), false);
			tx.setImmediate(true);
			return tx;
		} else if (pid.equals("telephoneMobile")) {
			TextField tx = ComponentFactory.createTextField(
					Msg.get("ui.inscription.adresse.telephone.mobile"), false);
			tx.setImmediate(true);
			return tx;
		} else if (pid.equals("ville")) {
			TextField tx = ComponentFactory.createTextField(
					Msg.get("ui.inscription.adresse.ville"), false);
			tx.setImmediate(true);
			return tx;
		} else if (pid.equals("pays")) {
			NativeSelect select = new NativeSelect(Msg.get("ui.inscription.adresse.pays"),
					PaysUtility.getISO3166Container());
			select.setItemCaptionPropertyId(PaysUtility.iso3166_PROPERTY_NAME);
			select.setItemIconPropertyId(PaysUtility.iso3166_PROPERTY_FLAG);
			select.setWidth("150px");
			select.setImmediate(true);
			return select;
		}
		return null;
	}
}
