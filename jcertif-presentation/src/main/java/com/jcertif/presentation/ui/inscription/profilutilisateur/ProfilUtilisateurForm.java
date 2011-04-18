/**
 * 
 */
package com.jcertif.presentation.ui.inscription.profilutilisateur;

import com.jcertif.presentation.internationalisation.Msg;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Form;

/**
 * @author rossi
 * 
 */
public class ProfilUtilisateurForm extends Form {

	private static final Object[] VISIBLE_PROPERTIES = new Object[] { "email", "confirmEmail",
			"password", "confirmPassword" };
	private static final long serialVersionUID = 1L;

	public ProfilUtilisateurForm() {
		super();
		init();
	}

	private void init() {
		this.getLayout().setMargin(true);
		setFormFieldFactory(new ProfilUtilisateurFieldFactory());
		reinitProfilBean();
		this.setCaption(Msg.get("ui.inscription.profilutilisateur.title"));
	}

	/**
	 * 
	 */
	public void reinitProfilBean() {
		ProfilUtilisateurBean bean = new ProfilUtilisateurBean();

		// Mapping BO Bean Form
		BeanItem<ProfilUtilisateurBean> item = new BeanItem<ProfilUtilisateurBean>(bean);
		this.setItemDataSource(item);
		this.setVisibleItemProperties(VISIBLE_PROPERTIES);
	}

}
