package com.jcertif.presentation.ui.inscription.adresse;

import com.jcertif.presentation.data.bo.Adresse;
import com.jcertif.presentation.internationalisation.Msg;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Form;

/**
 * Adresse Form.
 * 
 * @author rossi.oddet
 * 
 */
public class AdresseForm extends Form {

	private static final Object[] VISIBLE_PROPERTIES = new Object[] { "telephoneFixe",
			"telephoneMobile", "ville", "pays" };
	private static final long serialVersionUID = 1L;

	public AdresseForm() {
		super();
		init();
	}

	private void init() {
		this.getLayout().setMargin(true);
		setFormFieldFactory(new AdresseFieldFactory());
		reinitAdresseBean();
		this.setCaption(Msg.get("ui.inscription.adresse.title"));
	}

	/**
	 * 
	 */
	public void reinitAdresseBean() {
		Adresse bean = new Adresse();
		// Mapping BO Bean Form
		BeanItem<Adresse> item = new BeanItem<Adresse>(bean);
		this.setItemDataSource(item);
		this.setVisibleItemProperties(VISIBLE_PROPERTIES);
	}

}
