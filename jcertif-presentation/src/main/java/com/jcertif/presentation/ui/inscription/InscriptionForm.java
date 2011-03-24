/**
 * 
 */
package com.jcertif.presentation.ui.inscription;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.conference.Conference;
import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.internationalisation.Messages;
import com.jcertif.presentation.wsClient.ConferenceClient;
import com.jcertif.presentation.wsClient.ParticipantClient;
import com.vaadin.data.util.BeanItem;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Window;

/**
 * Formulation d'inscription d'un participant.
 * 
 * @author rossi
 * 
 */
public class InscriptionForm extends Form {

	private static final Object[] VISIBLE_PROPERTIES = new Object[] { "salutation", "prenom",
			"nom", "email", "roleparticipant", "typeParticipant", "compagnie", "website", "details" };
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(InscriptionForm.class);

	public InscriptionForm() {
		super();
		init();
	}

	private void init() {
		// this.setLayout(new VerticalLayout());
		this.getLayout().setMargin(true);
		setFormFieldFactory(new InscriptionFieldFactory());

		Participant bean = new Participant();

		// Initialisation de la conférence
		List<Conference> conferences = ConferenceClient.getInstance().findAllXML();

		if (conferences == null || conferences.isEmpty()) {
			LOGGER.error("Aucune conférence n'est présente côté facade");
		} else {
			// TODO définir avec Max une clé fonctionnelle pour la conférence à
			// choisir
			bean.setConference(conferences.iterator().next());
		}

		// Init à la date du jour
		bean.setDateInscription(Calendar.getInstance());

		// Mapping BO Bean Form
		BeanItem<Participant> item = new BeanItem<Participant>(bean);
		this.setItemDataSource(item);
		this.setVisibleItemProperties(VISIBLE_PROPERTIES);

		// Footer avec le bouton enregistrer
		Button saveParticipant = new Button(Messages.getString("Presentation.enregistrer",
				Locale.getDefault()), this, "commit");
		HorizontalLayout layoutFooter = new HorizontalLayout();
		layoutFooter.addComponent(saveParticipant);
		this.setFooter(layoutFooter);

		this.setCaption(Messages.getString("Presentation.inscription_caption", Locale.getDefault()));
		this.setDescription(Messages.getString("Presentation.inscription_description",
				Locale.getDefault()));

	}

	/**
	 * @see com.vaadin.ui.Form#commit()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void commit() throws SourceException {
		super.commit();

		ParticipantClient client = ParticipantClient.getInstance();
		Participant bean = ((BeanItem<Participant>) this.getItemDataSource()).getBean();
		
		if (client.isEmailExist(bean.getEmail())) {
			this.setComponentError(new UserError("Cette adresse email est déjà utilisé."));
		} else {
			
			client.create_XML(bean);
			Window main = getApplication().getMainWindow();
			// Create a notification with default settings for a warning.
			ExternalResource res = new ExternalResource("confirmationInscription.jsp");
			main.open(res);
		}

	}

}
