/**
 * 
 */
package com.jcertif.presentation.ui.inscription.profilutilisateur;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.internationalisation.Messages;
import com.jcertif.presentation.ui.inscription.participant.ParticipantForm;
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
	private static final Logger LOGGER = LoggerFactory.getLogger(ParticipantForm.class);

	public ProfilUtilisateurForm() {
		super();
		init();
	}

	private void init() {
		this.getLayout().setMargin(true);
		setFormFieldFactory(new ProfilUtilisateurFieldFactory());

		reinitProfilBean();

		this.setCaption(Messages.getString("Presentation.profil_caption", Locale.getDefault()));
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
